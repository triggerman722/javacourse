package java9;

import sun.net.ResourceManager;

import javax.microedition.lcdui.*;
import java.awt.*;

public class Hero
{
/*
	I know that my scene is 500px x 500px. I also know that I want to express
	this items coordinates in those terms.
*/
	private vVector vOld=null;
	private vVector vNew=null;//Hero's official center point.
	private int iRes=9;//Resistence
	private int iDiv=10;//Divisor
	private int iStep=20;//The step (if user presses left, right, up, or down)

	private int SCENEX = 500*iDiv;
	private int SCENEY = 500*iDiv;

	public int LifeLevel=1;
	public int Health=100;
	public int Score=0;
	public int Left=0;
	public int Top=0;
	public int Width=16;
	public int Height=16;
	private int iKeyLast=0;
	private boolean bLeft=false;
	private int Speed=0;
	private Canvas mMain=null;
	public vVector vLocation=null;
	private int iWings=12;

	public Hero(Canvas m)
	{
		vOld=new vVector();
		vNew=new vVector();
		vLocation=new vVector();
		vNew.x=iStep;
		vNew.y=iStep;
		mMain=m;
	}
	
	public void paint(Graphics g, int l, int t)
	{
		g.drawImage(ResourceManager.getImage(iWings),l+vLocation.x, t+vLocation.y, Graphics.TOP|Graphics.LEFT);
		iWings++;

		if (bLeft)
		{
			if (iWings>21)
				iWings=12;
		}
		else
		{
			if (iWings>30)
				iWings=22;
		}
	}
	public void collide()
	{
		
	}
	public void motion(int iKeyCode)
	{
		int iDiffx = vNew.x-vOld.x;
		int iDiffy = vNew.y-vOld.y;
		vOld.x=vNew.x;
		vOld.y=vNew.y;

		if (iKeyCode == Canvas.LEFT)
		{
			if (!bLeft)
				iWings=12;
			bLeft=true;
			vNew.x-= iStep;
		}
		if (iKeyCode == Canvas.RIGHT)
		{
			if (bLeft)
				iWings=22;
			bLeft=false;
			vNew.x+=iStep;
		}
		if (iKeyCode == Canvas.UP)
		{
			vNew.y-=iStep;			
		}
		if (iKeyCode == Canvas.DOWN)
		{
			vNew.y+=iStep;
		}
		vNew.x = Math.max(0, vNew.x);
		vNew.x = Math.min(SCENEX, vNew.x);
		vNew.y = Math.max(0, vNew.y);
		vNew.y = Math.min(SCENEY, vNew.y);

		vNew.x+=iDiffx*iRes/iDiv;
		vNew.y+=iDiffy*iRes/iDiv;

		vLocation.x=vNew.x/iDiv;
		vLocation.y=vNew.y/iDiv;
	}
}
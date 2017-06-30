import javax.microedition.lcdui.*;
import java.util.*;

public class Villain
{
	public int LifeLevel=0;
	public Hero mHero=null;
	public int Left=0;
	public int Top=0;
	public int Width=10;
	public int Height=10;
	public int Direction=0; 
	public int Speed=0;
	public int mMoveX=0;
	public int mMoveY=0;
	private int mOffsetX=0;
	private int mOffsetY=0;
	private int mLife = 0;

	private int iWings=22;
	private boolean bLeft=false;

	private Timer aiTimer=null;
	private long TIMER_DELAY = 10;

	private Timer moveTimer=null;

	private boolean bCollided=false;
	
	public Villain(Hero hr)
	{
		mHero = hr;				
	}	
	public void setSpeed(int iSpeed)
	{
		Speed = iSpeed;
		initTimer();
	}
	private void initTimer()
	{
try
{
		if (aiTimer!=null)
	     		aiTimer.cancel();

		if (moveTimer!=null)
	     		moveTimer.cancel();
}
catch(Exception ee){}
	     		
		aiTimer= new Timer();
		aiTimer.schedule(new aiTask(), TIMER_DELAY, TIMER_DELAY); 

		moveTimer= new Timer();
		moveTimer.schedule(new moveTask(), Speed, Speed); 
		bCollided=false;		
		if (LifeLevel==0)
			mLife=0x00FF00;
		else if (LifeLevel==1)
			mLife=0xFFFF00;
		else if (LifeLevel==2)
			mLife=0x00FFFF;
		else if (LifeLevel==3)
			mLife=0xFF0000;
	}
	class aiTask extends TimerTask 
	{
		public void run()
		{
			think();
		}
	}

	class moveTask extends TimerTask 
	{
		public void run()
		{
			move();
		}
	}
	private void think()
	{
		//based on where the Hero is, should I turn around?

		//Am I outside the bounds of the background? If so, change direction
		boolean bChange=false;
		if ((mMoveY+Height)<0)
			bChange=true;
		if ((mMoveX+Width)<0)
			bChange=true;
		if ((mMoveY+Height)>500)
			bChange=true;
		if ((mMoveX+Width)>500)
			bChange=true;
		if (bChange)
		{
			//Go in opposite direction
			Direction = Direction+4;
			if (Direction>7)
				Direction-=8;
			if (Direction<0)
				Direction=0;
		}		
	}
	private void move()
	{
		switch (Direction)
		{
			case 0://N
			{
				mMoveY--;
				break;
			}
			case 1://E
			{
				mMoveX++;
				break;
			}
			case 2://NE
			{
				mMoveX++;
				mMoveY--;
				break;
			}
			case 3://SE
			{				
				mMoveX++;
				mMoveY++;
				break;
			}
			case 4://S
			{
				mMoveY++;
				break;
			}			
			case 5://W
			{				
				mMoveX--;
				break;
			}
			case 6://SW
			{
				mMoveX--;
				mMoveY++;
				break;
			}			
			case 7://NW
			{
				mMoveX--;
				mMoveY--;
				break;
			}
			
		}

	}
	public void paint(Graphics g, int iOffsetX, int iOffsetY)
	{
		mOffsetX=iOffsetX;
		mOffsetY=iOffsetY;
		//Do I collide with a hero?
		if (bCollided)
		{
			g.setColor(55, 55,55);
		}
		else
		{
			//g.setColor(mLife);
			if (ImageHandler.isIntersectingRect(Math.abs(Left+mMoveX+iOffsetX), Math.abs(Top+mMoveY+iOffsetY), Width, Height, Math.abs(mHero.vLocation.x+iOffsetX), Math.abs(mHero.vLocation.y+iOffsetY), mHero.Width, mHero.Height))
			{
				bCollided=true;
				if (LifeLevel>mHero.LifeLevel)
					mHero.Health-=LifeLevel;
				else
					mHero.Score++;
			}
			else
			{				
				g.drawImage(ResourceManager.getImage(iWings),Left+mMoveX+iOffsetX, Top+mMoveY+iOffsetY, Graphics.TOP|Graphics.LEFT);
				iWings++;
				if (Direction<4)
				{
					if (iWings>30)
						iWings=22;
				}
				else
				{
					if (iWings>21)
						iWings=12;
				}
				
			}
		}			
		
	}
}
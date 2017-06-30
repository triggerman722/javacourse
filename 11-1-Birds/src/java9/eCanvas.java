package java9;

import javax.microedition.lcdui.*;
import java.util.*;

public class eCanvas extends Canvas implements Runnable
{
	private boolean running=true;	

	private int m_iKeyCode = 0;
	private int MS_PER_FRAME = 30;

	public static boolean bPauseInput=false;
	public static eCanvas RunningInstance=null;
	private Hero mHero=null;
	private Villain mVillains [];
	private int VILLAINCOUNT=50;

	private Image offscreenBackground=null;

	private Graphics gOffScreen=null;
	private int SCENEX=500;
	private int SCENEY=500;
	private Camera c=null;

	public eCanvas()
	{
		
	}
	public void start()
	{
		mHero=new Hero(this);
		c = new Camera();
		offscreenBackground=Image.createImage(getWidth(), getHeight());
		gOffScreen = offscreenBackground.getGraphics();
		mVillains = new Villain[VILLAINCOUNT];
		Random rd = new Random();
		for (int i=0;i<VILLAINCOUNT;i++)
		{
			mVillains[i] = new Villain(mHero);
			int rStep = Math.abs(rd.nextInt());
			mVillains[i].Direction = (rStep % 7);
			rStep = Math.abs(rd.nextInt());
			mVillains[i].LifeLevel = (rStep % 4);

			rStep = Math.abs(rd.nextInt());
			mVillains[i].mMoveX = (rStep % 500);

			rStep = Math.abs(rd.nextInt());
			mVillains[i].mMoveY = (rStep % 500);

			rStep = Math.abs(rd.nextInt());
			mVillains[i].setSpeed((rStep % (150-1))+1);
		}		


		Thread t = new Thread(this);
		t.start();
	}
	public void stop()
	{
		running=false;
	}
	public void pause()
	{
		stop();
		bPauseInput=true;
	}
	public void resume()
	{
		running=true;
		Thread t = new Thread(this);
		t.start();
		bPauseInput=false;
		Display d = Display.getDisplay(MIDletManager.midlet);
		d.setCurrent(this);
	}	
	protected void paint(Graphics g)
	{	
		drawOffscreenBackground(gOffScreen);
		drawOffscreenScores(gOffScreen);
		drawOffscreenVillains(gOffScreen);
		drawOffscreenPlayers(gOffScreen);
		g.drawImage(offscreenBackground, 0, 0, Graphics.TOP|Graphics.LEFT);
	}
	private void drawOffscreenBackground(Graphics g)
	{
		g.setColor(205,207,247);
		g.fillRect(0,0,getWidth(), getHeight());
		g.drawImage(ResourceManager.getImage(11), -c.vLocation.x+25, -c.vLocation.y+25, Graphics.TOP|Graphics.LEFT);
		g.drawImage(ResourceManager.getImage(10), -c.vLocation.x+293, -c.vLocation.y+38, Graphics.TOP|Graphics.LEFT);

		g.drawImage(ResourceManager.getImage(9),-c.vLocation.x+75, -c.vLocation.y+500, Graphics.BOTTOM|Graphics.LEFT);
		g.drawImage(ResourceManager.getImage(7),-c.vLocation.x+195, -c.vLocation.y+500, Graphics.BOTTOM|Graphics.LEFT);
		g.drawImage(ResourceManager.getImage(6),-c.vLocation.x+120, -c.vLocation.y+500, Graphics.BOTTOM|Graphics.LEFT);

		g.drawImage(ResourceManager.getImage(5),-c.vLocation.x+240, -c.vLocation.y+500, Graphics.BOTTOM|Graphics.LEFT);
		g.drawImage(ResourceManager.getImage(8),-c.vLocation.x+500, -c.vLocation.y+500, Graphics.BOTTOM|Graphics.RIGHT);

		g.drawImage(ResourceManager.getImage(3),-c.vLocation.x+0, -c.vLocation.y+500, Graphics.BOTTOM|Graphics.LEFT);
		g.drawImage(ResourceManager.getImage(4),-c.vLocation.x+450, -c.vLocation.y+500, Graphics.BOTTOM|Graphics.RIGHT);



	}
	private void drawOffscreenVillains(Graphics g)
	{
		for (int i=0;i<VILLAINCOUNT;i++)
				mVillains[i].paint(g, -c.vLocation.x,-c.vLocation.y);
	}
	
	private void drawOffscreenScores(Graphics g)
	{
		g.setColor(0,0,0);
		g.drawString(""+mHero.Score, 1, 1,  Graphics.LEFT | Graphics.TOP);
		g.drawString(""+mHero.LifeLevel, getWidth()-20, 1,  Graphics.LEFT | Graphics.TOP);
		g.drawString(""+mHero.Health, getWidth()-60, 1,  Graphics.LEFT | Graphics.TOP);
	}
	private void drawOffscreenPlayers(Graphics g)
	{
		mHero.paint(g, -c.vLocation.x, -c.vLocation.y);
	}	
	public void run()
	{
		while(running)
		{
			repaint();
			input();
			try
			{
				Thread.sleep(MS_PER_FRAME);
			}
			catch(java.lang.InterruptedException e)
			{
			}
		}
	}
	private void input()
	{
		int iKeyCode=0;
		try
		{
			iKeyCode = getGameAction(m_iKeyCode);
		}
		catch (IllegalArgumentException e){}

		mHero.motion(iKeyCode);
		c.motion(mHero, getWidth(), getHeight());
	
	}
	protected void keyPressed(int keyCode)
	{
		m_iKeyCode = keyCode;
	}
	protected void keyReleased(int keyCode)
	{
		m_iKeyCode = 0;
	}
	
	
	private void gameOver()
	{
		//eScores.addScore(iScore, "player1");
		//Need to show game over
		stop();
		eScores.show();
	}
	public static void show()
	{
		Display d = Display.getDisplay(MIDletManager.midlet);
		eCanvas c = new eCanvas();
		RunningInstance = c;
		c.start();
		d.setCurrent(c);
	}	
}
package java9;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.io.*;
import java.io.*;

public class eMenu extends Canvas implements CommandListener
{
	private static Image [] menuBackground = null;
	private int iSelect = 0;

	private final int CONTINUE_GAME = 0;
	private final int NEW_GAME = 1;
	private final int HIGH_SCORES = 2;
	private final int EASY = 3;
	private final int MEDIUM = 3;
	private final int HARD = 3;
	private final int SOUND_ON=4;
	private final int SOUND_OFF=4;
	private final int VIBRATE_ON=5;
	private final int VIBRATE_OFF=5;
	private final int REPEAT_OFF = 6;
	private final int REPEAT_SLOW = 6;
	private final int REPEAT_MEDIUM = 6;
	private final int REPEAT_FAST = 6;
	private final int HELP = 7;
	private final int ABOUT = 8;
	private final int EXIT = 9;

	private final int NUM_MENUS = 10;
	private final int NUM_IMAGES = 21;

	private final int SKILLBASE=10;
	private final int REPEATBASE=17;
	private final int VIBRATEBASE=15;
	private final int SOUNDBASE=13;

	private static Image backgroundImage = null;
	private static Image backgroundHilite = null;
	private static Image Title = null;

	public eMenu ()
	{
		if (backgroundImage==null)
		{
			PersistenceManager.loadSettings();
			initializeMenu();
		}
		addCommandButtons();
	}
	public static void show()
	{
		Display d = Display.getDisplay(MIDletManager.midlet);
		d.setCurrent(new eMenu());
	}
	private void addCommandButtons()
	{
		Command cmExit = new Command("Exit", Command.EXIT, 1);
		Command cmHelp= new Command("Help", Command.SCREEN, 1);
		addCommand(cmExit);
		addCommand(cmHelp);
		setCommandListener(this);
	}
	private void initializeMenu()
	{
		menuBackground = new Image[NUM_IMAGES];
		try
		{

			backgroundImage = ResourceManager.getImage(500);
			backgroundHilite = ResourceManager.getImage(100);

			if (getWidth()>162)
				Title=ResourceManager.getImage(102);
			else
				Title=ResourceManager.getImage(101);
			
			for(int i=0;i<NUM_IMAGES;i++)
			{
				menuBackground[i] = ResourceManager.getImage(110 + i);
			}
			repaint();
		}
		catch(Exception e){System.out.println("eMenu: " + e);}

	}
	protected void paint(Graphics g)
	{
		drawBackGround(g);
		drawMenu(g);
	}	
	private void drawBackGround(Graphics g)
	{
		//g.drawImage(backgroundImage, 0, 0, Graphics.LEFT | Graphics.TOP);
		g.setColor(205,207,247);
		g.fillRect(0,0,getWidth(), getHeight());

		g.drawImage(Title, (getWidth()-Title.getWidth())/2, ((getHeight()-Title.getHeight())/2)-Title.getHeight(), Graphics.LEFT | Graphics.TOP);
	}
	private void drawMenu(Graphics g)
	{
		int iLeft = (getWidth()-menuBackground[iSelect].getWidth())/2;
		int iTop = (getHeight()+menuBackground[iSelect].getHeight())/2;
		int iHeight = menuBackground[iSelect].getHeight();

		if (iSelect==0)
			if (eCanvas.bPauseInput==false)
				iSelect++;

		if (iSelect>0)
		{
			if ((iSelect-1)==EASY)
				g.drawImage(menuBackground[SKILLBASE+GameSettings.SkillLevel], iLeft, iTop, Graphics.LEFT | Graphics.TOP);
			else if ((iSelect-1)==REPEAT_OFF)
				g.drawImage(menuBackground[REPEATBASE+GameSettings.RepeatLevel], iLeft, iTop, Graphics.LEFT | Graphics.TOP);
			else if ((iSelect-1)==SOUND_ON)
				g.drawImage(menuBackground[SOUNDBASE+GameSettings.SoundLevel], iLeft, iTop, Graphics.LEFT | Graphics.TOP);
			else if ((iSelect-1)==VIBRATE_ON)
				g.drawImage(menuBackground[VIBRATEBASE+GameSettings.VibrateLevel], iLeft, iTop, Graphics.LEFT | Graphics.TOP);
		
			else
			{
				if ((iSelect-1)==CONTINUE_GAME)
				{
					if (eCanvas.bPauseInput==true)
						g.drawImage(menuBackground[iSelect-1], iLeft, iTop, Graphics.LEFT | Graphics.TOP);
					
				}
				else
					g.drawImage(menuBackground[iSelect-1], iLeft, iTop, Graphics.LEFT | Graphics.TOP);
			}
		}
		g.drawImage(backgroundHilite, iLeft, iTop+iHeight, Graphics.LEFT | Graphics.TOP);
		if (iSelect==EASY)
			g.drawImage(menuBackground[SKILLBASE+GameSettings.SkillLevel], iLeft, iTop+iHeight, Graphics.LEFT | Graphics.TOP);
		else if (iSelect==REPEAT_OFF)
			g.drawImage(menuBackground[REPEATBASE+GameSettings.RepeatLevel], iLeft, iTop+iHeight, Graphics.LEFT | Graphics.TOP);
		else if (iSelect==SOUND_ON)
			g.drawImage(menuBackground[SOUNDBASE+GameSettings.SoundLevel], iLeft, iTop+iHeight, Graphics.LEFT | Graphics.TOP);
		else if (iSelect==VIBRATE_ON)
			g.drawImage(menuBackground[VIBRATEBASE+GameSettings.VibrateLevel], iLeft, iTop+iHeight, Graphics.LEFT | Graphics.TOP);


		else
		{
			if ((iSelect)==CONTINUE_GAME)
			{
				if (eCanvas.bPauseInput==true)
					g.drawImage(menuBackground[iSelect], iLeft, iTop+iHeight, Graphics.LEFT | Graphics.TOP);				
			}
			else
				g.drawImage(menuBackground[iSelect], iLeft, iTop+iHeight, Graphics.LEFT | Graphics.TOP);
		}
		
		if (iSelect<(NUM_MENUS-1))
		{
			if ((iSelect+1)==EASY)
				g.drawImage(menuBackground[SKILLBASE+GameSettings.SkillLevel], iLeft, iTop+(iHeight*2), Graphics.LEFT | Graphics.TOP);
			else if ((iSelect+1)==REPEAT_OFF)
				g.drawImage(menuBackground[REPEATBASE+GameSettings.RepeatLevel], iLeft, iTop+(iHeight*2), Graphics.LEFT | Graphics.TOP);
			else if ((iSelect+1)==SOUND_ON)
				g.drawImage(menuBackground[SOUNDBASE+GameSettings.SoundLevel], iLeft, iTop+(iHeight*2), Graphics.LEFT | Graphics.TOP);
			else if ((iSelect+1)==VIBRATE_ON)
				g.drawImage(menuBackground[VIBRATEBASE+GameSettings.VibrateLevel], iLeft, iTop+(iHeight*2), Graphics.LEFT | Graphics.TOP);
			else
			{
				if ((iSelect+1)==CONTINUE_GAME)
				{
					if (eCanvas.bPauseInput==true)
						g.drawImage(menuBackground[iSelect+1], iLeft, iTop+(iHeight*2), Graphics.LEFT | Graphics.TOP);					
				}
				else
					g.drawImage(menuBackground[iSelect+1], iLeft, iTop+(iHeight*2), Graphics.LEFT | Graphics.TOP);
			}

		}
	}

	protected void keyPressed(int keyCode)
	{        	
		int action = getGameAction(keyCode);	    	
	    	switch (action)
	    	{
	    		case Canvas.DOWN:
			{
	    			iSelect++;
	    			if (iSelect>(NUM_MENUS-1))
	    				iSelect=NUM_MENUS-1;
				
	    			break;
			}
	    		case Canvas.UP:
			{
	    			iSelect--;
	    			if (iSelect<0)
	    				iSelect=0;
				

	    			break;
			}
	    		case Canvas.FIRE:
	    		{				
	    			if (iSelect==CONTINUE_GAME)
				{
					try
					{
						eCanvas.RunningInstance.resume();
					}
					catch(Exception e){}
				}		    		
	    			if (iSelect==NEW_GAME)
				{
					eCanvas.show();
				}
	    			if (iSelect==EASY)
				{
					GameSettings.SkillLevel++;
					if (GameSettings.SkillLevel>2)
						GameSettings.SkillLevel=0;
				}
				if (iSelect==REPEAT_OFF)
				{
					GameSettings.RepeatLevel++;
					if (GameSettings.RepeatLevel>3)
						GameSettings.RepeatLevel=0;
				}
	    			if (iSelect==SOUND_ON)
				{
					GameSettings.SoundLevel++;
					if (GameSettings.SoundLevel>1)
						GameSettings.SoundLevel=0;

				}
	    			if (iSelect==VIBRATE_ON)
				{
					GameSettings.VibrateLevel++;
					if (GameSettings.VibrateLevel>1)
						GameSettings.VibrateLevel=0;
				}
		    		if (iSelect==HIGH_SCORES)
		    			eScores.show();
		    		if (iSelect==HELP)
				{
					eHelp.show();
				}
			    	if (iSelect==ABOUT)
				{
					eAbout.show();
				}
				if (iSelect==EXIT)
					MIDletManager.exitMIDlet();
				

	    			break;
	    		}

		    default:
		    	return;
		}
		repaint();
	}
	public void commandAction(Command c, Displayable d)
	{
		if (c.getCommandType() == Command.EXIT)         	
		{			
			MIDletManager.exitMIDlet();
		}
		else if (c.getCommandType() == Command.SCREEN)
			eHelp.show();
	}
}

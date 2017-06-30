package java9;

import sun.net.ResourceManager;

import javax.microedition.lcdui.*;
import java.awt.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class LogoSplashScreen extends Canvas
{
	private Timer		timer = new Timer();
	private Image		logo = null;

	public LogoSplashScreen()
	{		
	}
	protected void paint( Graphics g )
	{
		g.setColor(80,219,61);
		g.fillRect(0,0,getWidth(), getHeight());
		g.drawImage(logo, (getWidth()-logo.getWidth())/2, (getHeight()-logo.getHeight())/2, Graphics.TOP|Graphics.LEFT);
	}	
	protected void showNotify()
	{
		try
		{
			logo = Image.createImage("/1.png" );
		}
		catch( IOException e )
		{
		}
		timer.schedule( new CountDown(), 30 );
	}
	public static void show()
	{
		Display d = Display.getDisplay(MIDletManager.midlet);
		d.setCurrent(new LogoSplashScreen());

	}
	private void dismiss()
	{
		ResourceManager.loadImages();
		eCanvas.show();

	}
	private class CountDown extends TimerTask
	{
		public void run()
		{
			if (timer!=null)
				timer.cancel();
			dismiss();
		}
	}
}


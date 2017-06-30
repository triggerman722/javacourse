import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class phy extends MIDlet
{
	public Display display=null;

	public phy ()
	{	
		MIDletManager.midlet=this;
	}	
	protected void startApp() throws MIDletStateChangeException
	{
		if (display==null)
		{
			LogoSplashScreen.show();
			display = Display.getDisplay(this);
		}
		else
		{
			try
			{
				eCanvas.RunningInstance.resume();
			}
			catch(Exception ex)
			{
			}
		}
	}	
	public void pauseApp()
	{
		try
		{
			eCanvas.RunningInstance.pause();	
		}
		catch(Exception ex)
		{
		}
	}
	public void destroyApp(boolean unconditional) 
	{		
	}
}
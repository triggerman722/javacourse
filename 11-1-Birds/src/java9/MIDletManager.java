package java9;

import javax.microedition.midlet.*;

public class MIDletManager
{
	public MIDletManager(){}
	public static MIDlet midlet=null;
	public static String getAppProperty(String sIn)
	{
		return midlet.getAppProperty(sIn);
	}
	public static void exitMIDlet()
	{	
		PersistenceManager.saveSettings();
		midlet.notifyDestroyed();
	}
}
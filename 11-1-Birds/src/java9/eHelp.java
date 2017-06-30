package java9;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class eHelp
{	
	public eHelp()
	{	
	}
	public final static void show()
	{
		StringBuffer buf = new StringBuffer();
		buf.append(MIDletManager.getAppProperty("Helptext"));
		Alert alert = new Alert(MIDletManager.getAppProperty("Help"));
		alert.setString(buf.toString());
		alert.setTimeout(Alert.FOREVER);
		Display d = Display.getDisplay(MIDletManager.midlet);
		d.setCurrent(alert);
	}	
}
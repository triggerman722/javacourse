package java9;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class eAbout
{
	public eAbout()
	{	
	}
	public final static void show()
	{
		StringBuffer buf = new StringBuffer();
		buf.append(MIDletManager.getAppProperty("Copyright") + " " + MIDletManager.getAppProperty("MIDlet-Vendor") + " " + MIDletManager.getAppProperty("AllRights") + ".\n\n");
		buf.append(MIDletManager.getAppProperty("Vendor") + ": " + MIDletManager.getAppProperty("MIDlet-Vendor") + "\n");
		buf.append(MIDletManager.getAppProperty("MidletName") + ": " + MIDletManager.getAppProperty("MIDlet-Name") + "\n");
		buf.append(MIDletManager.getAppProperty("Version") + ": " + MIDletManager.getAppProperty("MIDlet-Version"));
		Alert alert = new Alert(MIDletManager.getAppProperty("About"));
		alert.setImage(ResourceManager.getImage(2));
		alert.setString(buf.toString());
		alert.setTimeout(Alert.FOREVER);
		Display d = Display.getDisplay(MIDletManager.midlet);
		d.setCurrent(alert);
	}
}
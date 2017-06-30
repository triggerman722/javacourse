package java9;

import java.io.*;
import javax.microedition.rms.*;
public class PersistenceManager
{
	public PersistenceManager()
	{
	}
	public static void loadSettings()
	{
		RecordStore settings = null;
		try
		{
			settings = RecordStore.openRecordStore(MIDletManager.getAppProperty("MIDlet-Name") + "Settings", true);
			ByteArrayInputStream byteInputStream = new ByteArrayInputStream(settings.getRecord(1));
			DataInputStream dataInputStream = new DataInputStream(byteInputStream);
			GameSettings.SkillLevel = dataInputStream.readInt();
			GameSettings.SoundLevel = dataInputStream.readInt();
			GameSettings.VibrateLevel = dataInputStream.readInt();
			GameSettings.RepeatLevel = dataInputStream.readInt();
			dataInputStream.close();
			byteInputStream.close();
			settings.closeRecordStore();
			return;
		}
		catch (IOException io)
		{
			return;
		}
		catch (RecordStoreException rse)
		{
			return;
		}
		finally
		{
			try
			{
				if (settings != null) settings.closeRecordStore();
			}
			catch (RecordStoreNotOpenException e)
			{
			}
			catch (RecordStoreException e)
			{
			}
		}
	}
	public static boolean saveSettings()
	{
		RecordStore settings = null;
		try
		{
			try
			{
				RecordStore.deleteRecordStore(MIDletManager.getAppProperty("MIDlet-Name") + "Settings");
			}
			catch (RecordStoreNotFoundException rse)
			{}
			settings = RecordStore.openRecordStore(MIDletManager.getAppProperty("MIDlet-Name") + "Settings", true);
			ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(byteOutputStream);
			dataOutputStream.writeInt(GameSettings.SkillLevel);
			dataOutputStream.writeInt(GameSettings.SoundLevel);
			dataOutputStream.writeInt(GameSettings.VibrateLevel);
			dataOutputStream.writeInt(GameSettings.RepeatLevel);
			dataOutputStream.flush();
			byte[] recordOut = byteOutputStream.toByteArray();
			try
			{
				settings.setRecord(1, recordOut, 0, recordOut.length);
			}
			catch (InvalidRecordIDException ir)
			{
				settings.addRecord(recordOut, 0, recordOut.length);
			}
			dataOutputStream.close();
			byteOutputStream.close();
			return true;
		}
		catch (IOException io)
		{
			return false;
		}
		catch (RecordStoreException rse)
		{
			return false;
		}
		finally
		{
			try
			{
				if (settings != null) settings.closeRecordStore();
			}
			catch (RecordStoreNotOpenException e)
			{
			}
			catch (RecordStoreException e)
			{
			}
		}
	}

}
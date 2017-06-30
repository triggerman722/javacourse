package java9;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.io.*;
import javax.microedition.rms.*;

public class eScores extends Canvas implements CommandListener,RecordFilter, RecordComparator 
{
	private Command cmBack;
	
	public static final Font font = Font.getFont( Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_SMALL); 
	
	private static final int TL_ANCHOR = Graphics.TOP | Graphics.LEFT;

	static final String RECORD_STORE = MIDletManager.getAppProperty("MIDlet-Name") + "Scores"; 
	public static String playerNameFilter = null;

	private Image iTitle=null; 
	
	public boolean matches(byte[] candidate)
	throws IllegalArgumentException
	{
	
		if (this.playerNameFilter == null)
		{
			return false;
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(candidate);
		DataInputStream inputStream = new DataInputStream(bais);
		String name = null;
		try
		{
			int score = inputStream.readInt();
			name = inputStream.readUTF();
		}
		catch (EOFException eofe)
		{
		}
		catch (IOException eofe)
		{
		}
		return (this.playerNameFilter.equals(name));
	}
	public int compare(byte[] rec1, byte[] rec2)
	{
		ByteArrayInputStream bais1 = new ByteArrayInputStream(rec1);
		DataInputStream inputStream1 = new DataInputStream(bais1);
		ByteArrayInputStream bais2 = new ByteArrayInputStream(rec2);
		DataInputStream inputStream2 = new DataInputStream(bais2);
		int score1 = 0;
		int score2 = 0;
		try
		{
			score1 = inputStream1.readInt();
			score2 = inputStream2.readInt();
		}
		catch (EOFException eofe)
		{
		}
		catch (IOException eofe)
		{
		}
		if (score1 < score2)
		{
			return RecordComparator.FOLLOWS;
		}
		else if (score1 > score2)
		{
			return RecordComparator.PRECEDES;
		}
		else
		{
			return RecordComparator.EQUIVALENT;
		}
	}	
	public eScores ()
	{
		iTitle = ResourceManager.getImage(112);
	
		cmBack= new Command("Back", Command.SCREEN, 1);
		addCommand(cmBack);
		setCommandListener(this);
	}
	public void drawScores(Graphics g)
	{
		RecordStore recordStore=null;
		try
		{
			recordStore = RecordStore.openRecordStore(RECORD_STORE, true);
		}
		catch (RecordStoreException ex)
		{System.out.println("recordstore issue");
		}
		g.setFont(font);
		g.setColor(0,0,0);
		
		try
		{
			RecordEnumeration re = recordStore.enumerateRecords(null, this, true);
			try
			{
				int iTop = 18;
				int iLeft = (getWidth()-16)/3;
				int iCount=0;
				while(re.hasNextElement())
				{
					if(iCount>7)
						return;
					if ((iTop+20)>getHeight())
						return;
					int id = re.nextRecordId();
					ByteArrayInputStream bais = new ByteArrayInputStream(recordStore.getRecord(id));
					DataInputStream inputStream = new DataInputStream(bais); 
					try
					{
						int score = inputStream.readInt();
						String playerName = inputStream.readUTF();
						g.drawString("" + (iCount+1), iLeft, iTop, TL_ANCHOR);
						g.drawString("" + score, iLeft*2, iTop, TL_ANCHOR);

						iTop+=20;
					}
					catch (EOFException eofe)
					{
					}
					iCount++;
				}
			}
			catch(RecordStoreException rse)
			{
			}
			catch(IOException ioe)
			{
			}
		
		}
		catch(RecordStoreException rse)
		{
		}		
	}
	
	public static void addScore(int score, String playerName)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream outputStream = new DataOutputStream(baos);
		try
		{
			outputStream.writeInt(score);
			outputStream.writeUTF(playerName);
		}
		catch (IOException ioe)
		{
		}		
		byte[] b = baos.toByteArray();
		RecordStore recordStore = null;
		try
		{
			recordStore = RecordStore.openRecordStore(RECORD_STORE, true);
		}
		catch (RecordStoreException ex)
		{
		}

		try
		{
			recordStore.addRecord(b, 0, b.length);
		}
		catch (RecordStoreException rse)
		{
		}
	}
	protected void paint(Graphics g)
	{
		g.setColor(0,0,0);
		drawBackGround(g);
		int iLeft = (getWidth()-iTitle.getWidth())/2;
		g.drawImage(iTitle , iLeft, 0, Graphics.LEFT | Graphics.TOP);
		drawScores(g);
	}
	public void drawBackGround(Graphics g)
	{
		g.drawImage(ResourceManager.getImage(500) , 0, 0, Graphics.LEFT | Graphics.TOP);
	}
	public static void show()
	{
		Display d = Display.getDisplay(MIDletManager.midlet);
		d.setCurrent(new eScores());
	}


	public void commandAction(Command c, Displayable d)
	{

		if (c == cmBack)
			eMenu.show();
	}
}
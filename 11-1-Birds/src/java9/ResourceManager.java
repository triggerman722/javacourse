import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import java.io.*;

public class ResourceManager
{
	private static Image mImages[];

	public ResourceManager()
	{
	}
	public static void loadImages()
	{
		mImages = new Image[31];
		for (int i=1;i<31;i++)
		{
			try
			{
				mImages[i] = Image.createImage("/" + i + ".png");
			}
			catch(IOException e )
			{
				mImages[i] = null;
			}

		}
	}
	public void loadSounds()
	{
		//Not Imp
	}
	public static Image getImage(int iImage)
	{
		return mImages[iImage];
	}
	public static void initImages(int iWidth, int iHeight)
	{
		
	}



}
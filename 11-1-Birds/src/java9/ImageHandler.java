package java9;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class ImageHandler
{
	public ImageHandler()
	{
	}
	public final static Image getImageRegion(Image source, int x, int y, int width, int height)
	{
		Image result = Image.createImage(width, height);
		result.getGraphics().drawImage(source, -x, -y, Graphics.TOP|Graphics.LEFT);
		return result;
	}
	public final static Image[] extractFrames(Image sourceImage, int sourceX, int sourceY, int framesWide, int framesHigh, int frameWidth, int frameHeight)
	{
		Image[] frames = new Image[framesWide * framesHigh];
		int frameCount = 0;
		for (int fy = 0; fy < framesHigh; fy++)
			for (int fx = 0; fx < framesWide; fx++)
				frames[frameCount++] = getImageRegion(sourceImage, sourceX + (fx * frameWidth), sourceY + (fy * frameHeight), frameWidth, frameHeight);
		return frames;
	}	
	public final static Image createThumbnail(Image image, int thumbWidth, int thumbHeight)
	{
		int sourceWidth = image.getWidth();
		int sourceHeight = image.getHeight();
		//int thumbWidth = 64;
		//int thumbHeight = -1;
		if (thumbHeight == -1)
			thumbHeight = thumbWidth * sourceHeight / sourceWidth;
		Image thumb = Image.createImage(thumbWidth, thumbHeight);
		Graphics g = thumb.getGraphics();

		for (int y = 0; y < thumbHeight; y++)
		{
			for (int x = 0; x < thumbWidth; x++)
			{
				g.setClip(x, y, 1, 1);
				int dx = x * sourceWidth / thumbWidth;
				int dy = y * sourceHeight / thumbHeight;
				g.drawImage(image, x - dx, y - dy, Graphics.LEFT | Graphics.TOP);
			}
		}
		Image immutableThumb = Image.createImage(thumb);
		return immutableThumb;
	}
	public static final boolean isIntersectingRect(int ax, int ay, int aw, int ah, int bx, int by, int bw, int bh)
	{
		if (by + bh < ay || // is the bottom of b above the top of a?
		    by > ay + ah || // is the top of b below bottom of a? 
		    bx + bw < ax || // is the right of b to the left of a?
		    bx > ax + aw) // is the left of b to the right of a? 
		   return false; 

		return true; 
	}

	
}

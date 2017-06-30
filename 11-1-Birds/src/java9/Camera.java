package java9;

class Camera
{
	public  vVector vLocation=null;
	private vVector vTarget=null;
	public Camera()
	{
		vLocation=new vVector();
	}
	public void motion(Hero mHero, int Width, int Height)
	{
		int iHalfWidth = Width/2;
		int iHalfHeight=Height/2;

		vLocation.x=mHero.vLocation.x-iHalfWidth ;
		vLocation.y=mHero.vLocation.y-iHalfHeight;
		vLocation.x= Math.max(0, vLocation.x);
		vLocation.x = Math.min(500-Width, vLocation.x);
		vLocation.y = Math.max(0, vLocation.y);
		vLocation.y = Math.min(500-Height, vLocation.y);
	}
}
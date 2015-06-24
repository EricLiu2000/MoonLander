package physics;

public class Vector 
{
	private double x;
	private double y;
	
	public Vector()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Vector(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void move(double dx, double dy)
	{
		this.x += dx;
		this.y += dx;
	}
	
	public Vector getVector()
	{
		return this;
	}
	
	public void setVector(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}
	
	public void setX(double x)
	{
		this.x = x;
	}
	
	public void setY(double y)
	{
		this.y = y;
	}

}

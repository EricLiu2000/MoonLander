package physics;

public class Position 
{
	private double x;
	private double y;
	
	public Position()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Position(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setPosition(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Position getPosition()
	{
		return this;
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

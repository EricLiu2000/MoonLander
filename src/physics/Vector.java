package physics;
import constants.*;
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
	
	public void rotateCounterclockwise()
	{
			//tests to see if it is upper quadrant
			if(this.y <= 0 && Math.abs(this.x) <= -this.y)
			{
				this.x = this.x - Constants.ROTATE_CONSTANT;
			}
			
			//tests to see if it is right quadrant
			if(this.x >= 0 && Math.abs(this.y) <= this.x)
			{
				this.y = this.y - Constants.ROTATE_CONSTANT;
			}
			
			//tests to see if it is bottom quadrant
			if(this.y >= 0 && Math.abs(this.x) <= this.y)
			{
				this.x = this.x + Constants.ROTATE_CONSTANT;
			}
			
			//tests to see if it is left quadrant
			if(this.x <= 0 && Math.abs(this.y) <= -this.x)
			{
				this.y = this.y + Constants.ROTATE_CONSTANT;
			}
			
	}
	
	public void rotateClockwise()
	{
			//tests to see if it is upper quadrant
			if(this.y <= 0 && Math.abs(this.x) <= -this.y)
			{
				this.x = this.x + Constants.ROTATE_CONSTANT;
			}
			
			//tests to see if it is right quadrant
			if(this.x >= 0 && Math.abs(this.y) <= this.x)
			{
				this.y = this.y + Constants.ROTATE_CONSTANT;
			}
			
			//tests to see if it is bottom quadrant
			if(this.y >= 0 && Math.abs(this.x) <= this.y)
			{
				this.x = this.x - Constants.ROTATE_CONSTANT;
			}
			
			//tests to see if it is left quadrant
			if(this.x <= 0 && Math.abs(this.y) <= -this.x)
			{
				this.y = this.y - Constants.ROTATE_CONSTANT;
			}

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

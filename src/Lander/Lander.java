package Lander;

import physics.*;

public class Lander 
{
	private Position pos;
	private Vector vec;
	
	
	public Lander()
	{
		pos = new Position(200, 200);
		vec = new Vector(0, 0);
	}
	
	public Lander(Position pos, Vector vec)
	{
		this.pos = pos;
		this.vec = vec;
	}
	
	public Lander getLander()
	{
		return this;
	}
	
	public void update()
	{
		
	}
}

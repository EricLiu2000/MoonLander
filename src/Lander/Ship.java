package lander;

import physics.*;

public class Ship
{
	private Position pos;
	private Vector vec;
	
	
	public Ship()
	{
		pos = new Position(200, 200);
		vec = new Vector(0, 0);
	}
	
	public Ship(Position pos, Vector vec)
	{
		this.pos = pos;
		this.vec = vec;
	}
	
	public Ship getShip()
	{
		return this;
	}
	
	public void update()
	{
		
	}
}

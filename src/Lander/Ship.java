package lander;

import physics.*;

public class Ship
{
    public static double RIGHT_BOUNDS = 500;
    public static double LEFT_BOUNDS = 0;
    public static double GRAVITY = 1;

	private Position pos;
	private Vector vec;
    private int fuel;

	
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
        if(this.pos.getX() > RIGHT_BOUNDS)
        {
            this.pos.setX(LEFT_BOUNDS + 0.25);
        }

        if(this.pos.getX() < LEFT_BOUNDS)
        {
            this.pos.setX(RIGHT_BOUNDS - 0.25);
        }
        if(/*SHIP NOT TOUCH GROUND*/true)
        {
            if(fuel > 0)
            {
                pos.move(0, GRAVITY);

                if(/*RIGHT KEY PRESSED*/true)
                {
                    vec.rotateClockwise();
                }

                if(/*LEFT KEY PRESSED*/true)
                {
                    vec.rotateCounterclockwise();
                }

                if(/*FORWARD KEY PRESSED*/true)
                {
                    this.pos.move(this.vec);
                    fuel -= 1;
                }

            }
            else pos.move(0, GRAVITY);
        }

        else/*GAME OVER*/;

	}
}

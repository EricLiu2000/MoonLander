package lander;

import keyboard.KeyboardListener;
import physics.Position;
import physics.Vector;

public class Ship
{
    public static double RIGHT_BOUNDS = 500;
    public static double LEFT_BOUNDS = 0;
    public static double GRAVITY = 1;

	private Position pos;
	private Vector vec;
    private double width;
    private double height;
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

                if(KeyboardListener.isKeyPressed('d'))
                {
                    vec.rotateClockwise();
                }

                if(KeyboardListener.isKeyPressed('a'))
                {
                    vec.rotateCounterclockwise();
                }

                if(KeyboardListener.isKeyPressed('w'))
                {
                    this.vec.move(this.vec.getX()/(Math.sqrt((this.vec.getX() * this.vec.getX()) + (this.vec.getY() * this.vec.getY()))),
                            this.vec.getY()/(Math.sqrt((this.vec.getX() * this.vec.getX()) + (this.vec.getY() * this.vec.getY()))));

                    this.pos.move(this.vec);
                    fuel -= 1;
                }

            }
            else pos.move(0, GRAVITY);
        }

        else/*GAME OVER*/;

	}
}

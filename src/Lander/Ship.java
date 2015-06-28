package lander;

import keyboard.KeyboardListener;
import physics.Position;
import physics.Vector;
import constants.*;

public class Ship
{

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

    public double getFuel()
    {
        return this.fuel;
    }

	public void update()
	{

        if(this.pos.getX() > Constants.RIGHT_BOUNDS)
        {
            this.pos.setX(Constants.LEFT_BOUNDS + 0.25);
        }

        if(this.pos.getX() < Constants.LEFT_BOUNDS)
        {
            this.pos.setX(Constants.RIGHT_BOUNDS - 0.25);
        }
        if(/*SHIP NOT TOUCH GROUND*/true)
        {
            if(fuel > 0)
            {
                pos.move(0, Constants.GRAVITY);

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
            else pos.move(0, Constants.GRAVITY);
        }

        else/*GAME OVER*/;

	}
}

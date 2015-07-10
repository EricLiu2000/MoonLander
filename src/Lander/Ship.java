package lander;

import constants.Constants;
import keyboard.KeyboardListener;
import physics.Position;
import physics.Vector;
import terrain.Moon;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Ship
{

	private Position pos;
	private Vector vec;
    private double width;
    private double height;
    private double yVelocity;
    private int fuel;
    private Moon moon;

	
	public Ship(Moon moon)
	{
		pos = new Position(0, 0);
		vec = new Vector(0, -1);
        this.moon = moon;
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

    public int getFuel()
    {
        return this.fuel;
    }

    public void setFuel(int newFuel)
    {
        this.fuel = newFuel;
    }

	public void update()
	{
        while(true)
        {
            if(this.pos.getX() > Constants.RIGHT_BOUNDS)
            {
                this.pos.setX(Constants.LEFT_BOUNDS + 0.25);
            }

            if(this.pos.getX() < Constants.LEFT_BOUNDS)
            {
                this.pos.setX(Constants.RIGHT_BOUNDS - 0.25);
            }

            if(!collide())
            {
                if(this.getFuel() > 0)
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
                        this.setFuel(this.fuel - 1);
                    }

                }
                else pos.move(0, Constants.GRAVITY);
            }

            if(collide() && this.pos.getX() > moon.getLeftPlatformSide() && this.pos.getX() < moon.getLeftPlatformSide() + 3
               && (Math.sqrt((this.vec.getX() * this.vec.getX()) + (this.vec.getY() * this.vec.getY()))) < Constants.ACCEPTABLE_LANDING_SPEED)
            {
                /*YOU WIN*/
            }


            else/*GAME OVER*/;

        }
	}

    public boolean collide()
    {
        Rectangle2D a = new Rectangle((int) (this.pos.getX() - this.width/2), (int) (this.pos.getY() + this.height/2), (int) this.width, (int) this.height);
        this.moon = new Moon();
        return this.moon.moonPolygon.intersects(a);
    }

}

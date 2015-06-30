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
    private int fuel;
    private Moon moon;

	
	public Ship(Moon moon)
	{
		pos = new Position(200, 200);
		vec = new Vector(0, 0);
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
        if(collide())
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

    public boolean collide()
    {
        Rectangle2D a = new Rectangle((int) (this.pos.getX() - width/2), (int) (this.pos.getY() + height/2), (int) width, (int) height);
        this.moon = new Moon();
        return this.moon.moonPolygon.intersects(a);
    }

}

package game;

import lander.Ship;
import terrain.Moon;

/**
 *
 */
public class Run
{
    public static void main(String [] args)
    {
        Moon moon = new Moon();
        Ship lander = new Ship(moon);
        lander.update();
    }
}

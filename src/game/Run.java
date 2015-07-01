package game;

import lander.*;
import terrain.*;

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

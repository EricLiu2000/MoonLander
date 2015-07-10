package terrain;

import constants.Constants;

import java.awt.*;

/**
 *
 */
public class Moon
{
	public int leftPlatformSide = (int) (20 * Math.random()) + 1;
	public int platformHeight = (int) (2/3 * Constants.WORLD_HEIGHT * Math.random());
    public Polygon moonPolygon;

    int[] xValues =
    	{
    			0, 20 , 40, 60, 80, 100, 120, 140, 160, 180, 200,
    			220, 240, 260, 280, 300, 320, 340, 360, 380, 400,
                420, 440, 460, 480, 500
    	};

    int[] yValues = new int[26];

    public Moon()
    {
        for(int i = 0; i < leftPlatformSide; i++)
            {
                    yValues[i] = (int) (2/3 * Constants.WORLD_HEIGHT * Math.random());
            }

        for(int i = leftPlatformSide; i < leftPlatformSide + 3; i++)
            {
                yValues[i] = platformHeight;
            }

        for(int i = leftPlatformSide + 3; i < 26; i++)
            {
                yValues[i] = (int) (2/3 * Constants.WORLD_HEIGHT * Math.random());
            }

        moonPolygon = new Polygon(xValues, yValues, xValues.length);
    }

    public int getLeftPlatformSide()
    {
        return leftPlatformSide;
    }

}

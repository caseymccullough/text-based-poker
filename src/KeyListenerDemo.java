import java.awt.*;
import java.awt.event.*;								// #1
import java.util.Random;

import javax.swing.*;   

/******************************************************************************
 * 
 * KeyListenerDemo.java
 * Demonstrates getting keyboard input using the KeyListener interface.
 * 
 * Program 18: Extend this program by adding a few more keystroke commands:
 *		z     (VK_Z) 	- Cause the ball to jump to a random new location.
 *		s     (VK_S) 	- Make the ball smaller - multiply its diameter 1/2.
 *		b	  (VK_B)	- Make the ball bigger - multiply its diameter by 2.
 *		c     (VK_C) 	- Change the color (in any way you'd like).
 *
 *	In addition, modify the program to ensure the following:
 *	- The ball goes all the way to the edge of the screen but stays
 *			completely on the screen. 
 *	- If a doubled diameter doesn't fit, make it as large as possible.
 *  - Be sure the ball never completely disappears.
 * 
 *****************************************************************************/
public class KeyListenerDemo extends JFrame
implements KeyListener		// #2
{
	// Class Scope Finals
	private static final int SCREEN_WIDTH = 600;
	private static final int SCREEN_HEIGHT = 600;
	private static final int BAR_HEIGHT = 22;
	private static final int START_RADIUS = 15;
	private static final int START_X = 50;
	private static final int START_Y = 50;
	private static final int STEP_SIZE = 10;
	
	// Class Scope Variables
	private static int x = START_X;				// x at center of the ball
	private static int y = START_Y;				// y at center of the ball
	private static int radius = START_RADIUS;	// radius of the ball
	private static Color ballColor = Color.BLUE;
	// Methods
	/**
	 * Create the window and register this as a KeyListener
	 * 
	 * @param args
	 */
	public static void main (String[] args)
	{
		// Set up the JFrame window.
		KeyListenerDemo gp = new KeyListenerDemo();
		gp.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		gp.setVisible(true);

		gp.addKeyListener(gp);							// #3
		// If this class had a constructor and you moved this line into
		//   that constructor it could not refer to gp since that variable
		//   is local to this method.  Instead you would write::
		// addKeyListener(this);
	}

	/**
	 * Called when a key is first pressed
	 * Required for any KeyListener
	 * 
	 * @param e		Contains info about the key pressed
	 * 
	 *   Extend this program by adding a few more keystroke commands:
	 *		z     (VK_Z) 	- Cause the ball to jump to a random new location.
	 *		s     (VK_S) 	- Make the ball smaller - multiply its diameter 1/2.
	 *		b	  (VK_B)	- Make the ball bigger - multiply its diameter by 2.
	 *		c     (VK_C) 	- Change the color (in any way you'd like).
	 */
	public void keyPressed(KeyEvent e)					// #4A
	{
		int keyCode = e.getKeyCode();
		Random gen = new Random();

		if (keyCode == KeyEvent.VK_LEFT)
		{
			x = x - STEP_SIZE;
		}
		else if (keyCode == KeyEvent.VK_RIGHT)
		{
			x = x + STEP_SIZE;
		}
		else if (keyCode == KeyEvent.VK_UP)
		{
			y = y - STEP_SIZE;
		}
		else if (keyCode == KeyEvent.VK_DOWN)
		{
			y = y + STEP_SIZE;
		}
		else if (keyCode == KeyEvent.VK_Z)
			// ball jumps to a random new location.
		{
			x = gen.nextInt (SCREEN_WIDTH - 2 * radius) + radius;
			y = gen.nextInt (SCREEN_HEIGHT - 2 * radius - BAR_HEIGHT) + radius + BAR_HEIGHT;
		}
		else if (keyCode == KeyEvent.VK_S)
			// Make the ball smaller - multiply its diameter 1/2.
		{
			if (radius > 1)
				radius /= 2;
		}
		else if (keyCode == KeyEvent.VK_B)
			// Make the ball bigger - multiply its diameter by 2.
		{
			int toRightEdge = SCREEN_WIDTH - (x + radius);
			int toLeftEdge = x - radius;
			int toBottomEdge = SCREEN_HEIGHT - (y +  radius);
			int toTopEdge = y - radius - BAR_HEIGHT;
			
/*			System.out.print ("To top edge: " + toTopEdge + "\t ");
			System.out.println ("To bottom edge: " + toBottomEdge);
			System.out.print ("To left edge: " + toLeftEdge + "\t ");
			System.out.println ("To right edge: " + toRightEdge);
*/
	
			int maxVerticalDistance = Math.min(toTopEdge, toBottomEdge);
			int maxHorizontalDistance = Math.min(toLeftEdge,  toRightEdge);
			int maxGrowth = Math.min(maxVerticalDistance, maxHorizontalDistance);
			//maxGrowth = Math.max (0, maxGrowth); // no negative growth
			System.out.println ("Max Growth: " + maxGrowth);
			
			if (maxGrowth < radius)
				radius += maxGrowth;
			else
				radius += radius;
		}
		else if (keyCode == KeyEvent.VK_Q)
			// prints location of ball
		{
			System.out.println ("x: " + x + " y: " + y);
		}
		else if (keyCode == KeyEvent.VK_C)
			// ball jumps to a random new location.
		{
			Color randomColor = new Color (gen.nextInt(256), gen.nextInt(256), gen.nextInt(256));
			ballColor = randomColor;
		}

		repaint();
	}

	/**
	 * Called when typing of a key is completed
	 * Required for any KeyListener
	 * 
	 * @param e		Contains info about the key typed
	 */
	public void keyTyped(KeyEvent e)					// #4B
	{
	}

	/**
	 * Called when a key is released
	 * Required for any KeyListener
	 * 
	 * @param e		Contains info about the key released
	 */
	public void keyReleased(KeyEvent e)					// #4C
	{
	}

	/**
	 * paint - draw the figure
	 * 
	 * @param g		Graphics object to draw in
	 */
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

		g.setColor(ballColor);
		g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}
}


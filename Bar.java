// Name: Aayush Khanna
// USC NetID: aayushkh@usc.edu
// CS 455 PA1
// Spring 2017

// we included the import statements for you
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Bar class A labeled bar that can serve as a single bar in a bar graph. The
 * text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change the
 * public interface. You can add private instance variables, constants, and
 * private methods to the class. You will also be completing the implementation
 * of the methods given.
 */

public class Bar {

	private double height;
	private final int OFFSET = 20; // Bottom of bar = offset + variable bottom
	private int left;
	private int bottom;
	private int width;
	private Rectangle bar;
	private String label;
	private Color color;

	/**
	 * Creates a labeled bar. You give the height of the bar in application
	 * units (e.g., population of a particular state), and then a scale for how
	 * tall to display it on the screen (parameter scale).
	 * 
	 * @param bottom
	 *            location of the bottom of the label
	 * @param left
	 *            location of the left side of the bar
	 * @param width
	 *            width of the bar (in pixels)
	 * @param barHeight
	 *            height of the bar in application units
	 * @param scale
	 *            how many pixels per application unit
	 * @param color
	 *            the color of the bar
	 * @param label
	 *            the label at the bottom of the bar
	 * @param height
	 *            calculates the height for the bar (scale*barHeight)
	 * @param
	 */
	public Bar(int bottom, int left, int width, int barHeight, double scale, Color color, String label) {

		this.label = label;
		this.width = width;
		this.color = color;
		this.left = left;
		this.bottom = bottom;
		height = scale * barHeight; // barHeight is converted to height
	}

	/**
	 * Draw the labeled bar in the specified color and print the string bellow
	 * it.
	 */
	public void draw(Graphics2D g2) {

		bar = new Rectangle(left, (bottom - OFFSET) - (int) height, width, (int) height);
		g2.setColor(this.color);
		g2.fill(bar);

		g2.setColor(Color.BLACK);
		int strwidth = g2.getFontMetrics().stringWidth(label);
		// strwidth variable to centre the string at the bottom of the bar graph

		g2.drawString(label, (left + (width / 2)) - (strwidth / 2), bottom);

	}

}

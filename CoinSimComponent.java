import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

/**
 * This class takes in the number of tries and frame dimensions from the main
 * class and performs the simulation. It uses the results of the simulation and
 * the frame dimensions to set the Bar parameters. It is only dependent on the
 * CoinTossSimulator and Bar classes.
 */

public class CoinSimComponent extends JComponent {

	/** The bottom of the bar starts from (OFFSET + VERTICAL_BUFFER) */
	private final int OFFSET = 20;
	private final int BAR_WIDTH = 80;
	private final int VERTICAL_BUFFER = 30;
	private int tries, frameheight, framewidth;
	private double scale;
	private double width;
	CoinTossSimulator CTS = new CoinTossSimulator();
	Bar left, right, center;

	public CoinSimComponent(int tries) {
		this.tries = tries;

		CTS.run(this.tries);
		System.out.println("Two Head Tosses: " + CTS.getTwoHeads());
		System.out.println("Two Tail Tosses: " + CTS.getTwoTails());
		System.out.println("One Head - One Tail Tosses: " + CTS.getHeadTails());
	}

	/**
	 * We define a paintComponent function which uses the draw() function from
	 * the Bar class to display the bar.
	 */

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		frameheight = getHeight();
		framewidth = getWidth();

		/**
		 * Calculating the scale and width components for the parameters of the
		 * Bar class
		 */

		scale = ((frameheight - (2 * VERTICAL_BUFFER + OFFSET)) / 100.00);
		width = ((framewidth - (BAR_WIDTH * 3)) / 4);

		/**
		 * Creating 3 bars (left, right, center) by calling the Bar class
		 */

		left = new Bar(frameheight - VERTICAL_BUFFER, (int) width, BAR_WIDTH, CTS.getHHpercent(), scale, Color.RED,
				"Two Heads : " + CTS.getTwoHeads() + "(" + CTS.getHHpercent() + "%)");

		center = new Bar(frameheight - VERTICAL_BUFFER, 2 * (int) width + BAR_WIDTH, BAR_WIDTH, CTS.getHTpercent(),
				scale, Color.GREEN, " One Head One Tail : " + CTS.getHeadTails() + "(" + CTS.getHTpercent() + "%)");

		right = new Bar(frameheight - VERTICAL_BUFFER, 3 * (int) width + 2 * BAR_WIDTH, BAR_WIDTH, CTS.getTTpercent(),
				scale, Color.BLUE, "Two Tails : " + CTS.getTwoTails() + "(" + CTS.getTTpercent() + "%)");

		left.draw(g2);
		center.draw(g2);
		right.draw(g2);
	}
}

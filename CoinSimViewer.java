import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * This is the main class which prompts for the number of trials. It creates the
 * JFrame containing the CoinSimComponent. CoinSimViewer is only dependent on
 * the CoinSimComponent class. The CoinSimComponent calls objects of the
 * CoinTossSimulator and Bar classes. The CoinTossSimulator simulates the tosses
 * and produces the required parameters for the Bar class to display the
 * appropriate Bar on the Frame.
 */
public class CoinSimViewer {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int tries = 0;
		/** Creating a Dimension variable for the Frame dimensions */
		Dimension framedimen = new Dimension(800, 500);

		/**
		 * Running a do-while loop to check for the Validity of the Input Tries
		 */
		do {
			if (tries <= 0) {
				System.out.println("Please Enter a VALID value for the number of Tries ");
			}
			System.out.println("Enter the number of tries : ");
			tries = in.nextInt();
			if (tries > 0) {
				break;
				/** break from do-while if we get a valid input */
			}
		} while (tries <= 0);

		/**
		 * Creating a CoinSimComponent object which also calls the constructor
		 * of the class
		 */
		CoinSimComponent component = new CoinSimComponent(tries);

		JFrame frame = new JFrame();
		frame.setPreferredSize(framedimen);
		frame.setTitle("BarChart");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(component);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		in.close();

	}
}

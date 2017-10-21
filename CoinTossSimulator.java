// Name: Aayush Khanna
// USC NetID: aayushkh@usc.edu
// CS 455 PA1
// Spring 2017

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
import java.util.Random;
import java.lang.Math;

public class CoinTossSimulator {

	private int TwoHeads, TwoTails, HeadTails, NumTrials;
	private Random generator;
	private double number;

	/**
	 * Creates a coin toss simulator with no trials done yet.
	 */
	public CoinTossSimulator() {
		TwoHeads = 0;
		TwoTails = 0;
		HeadTails = 0;
		NumTrials = 0;
		generator = new Random();
	}

	/**
	 * Runs the simulation for numTrials more trials. Multiple calls to this
	 * without a reset() between them add these trials to the simulation already
	 * completed.
	 * 
	 * @param numTrials
	 *            number of trials to for simulation; must be >= 1
	 */
	public void run(int numTrials) {

		for (int i = 0; (i < numTrials) && (numTrials - i > 0); i++) {
			if ((i % 10000 == 0) && (numTrials - i > 0)) {
				System.out.println("Calculating .... Tries left : " + (numTrials - i));
			}
			int n1 = 1 + generator.nextInt(2); // CoinToss 1
			int n2 = 1 + generator.nextInt(2); // CoinToss 2
			if ((n1 == 1) && (n2 == 1)) {
				TwoHeads++;
			} else if ((n1 == 2) && (n2 == 2)) {
				TwoTails++;
			} else {
				HeadTails++;
			}
		}
	}

	/**
	 * Returns the number of trials performed since last reset.
	 */
	public int getNumTrials() {
		NumTrials = TwoHeads + TwoTails + HeadTails;
		return NumTrials;
	}

	/**
	 * Returns the number of trials that came up two heads since last reset.
	 */
	public int getTwoHeads() {
		return TwoHeads;
	}

	/**
	 * Returns the number of trials that came up two tails since last reset.
	 */
	public int getTwoTails() {
		return TwoTails;
	}

	/**
	 * Returns the number of trials that came up one head and one tail since
	 * last reset.
	 */
	public int getHeadTails() {
		return HeadTails;
	}

	/**
	 * Returns the percent of trials that came up two heads since last reset.
	 * Also rounds the percent to the next integer value.
	 */
	public int getHHpercent() {
		number = (getTwoHeads() * 100.00) / getNumTrials();
		number = (int) Math.round(number);
		return (int) number;
	}

	/**
	 * Returns the percent of trials that came up two heads since last reset.
	 * Also rounds the percent to the next integer value.
	 */
	public int getHTpercent() {
		number = (getHeadTails() * 100.00) / getNumTrials();
		number = (int) Math.round(number);
		return (int) number;
	}

	/**
	 * Returns the percent of trials that came up two heads since last reset.
	 * Also rounds the percent to the next integer value.
	 */
	public int getTTpercent() {
		number = (getTwoTails() * 100.00) / getNumTrials();
		number = (int) Math.round(number);
		return (int) number;
	}

	/**
	 * Resets the simulation, so that subsequent runs start from 0 trials done.
	 */
	public void reset() {
		TwoHeads = 0;
		TwoTails = 0;
		HeadTails = 0;
		NumTrials = 0;
	}

}

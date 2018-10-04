/**
 * @date 04/10/2018
 * @author FredHappyface
 *
 */
public class Tariff {

	/**
	 * Integers: rate, inclusiveMins, inclusiveTexts, minsUsed, textsUsed These
	 * identify the base cost of the contract, the included minutes, included
	 * texts, the minutes that the customer has used that month and the number
	 * of texts used
	 * 
	 * Constants: RATE_MINS, RATE_TEXTS These are the costs in pounds sterling
	 * for additional minutes and texts, respectively.
	 */
	private int rate;
	private int inclusiveMins;
	private int inclusiveTexts;
	private int minsUsed;
	private int textsUsed;
	private final static double RATE_MINS = .1;
	private final static double RATE_TEXTS = .05;

	/**
	 * The constructor uses the base cost of the contract, the included minutes
	 * and the included texts to set up the fields
	 * 
	 * @param rate
	 * @param inclusiveMins
	 * @param inclusiveTexts
	 */
	Tariff(int rate, int inclusiveMins, int inclusiveTexts) {
		this.rate = rate;
		this.inclusiveMins = inclusiveMins;
		this.inclusiveTexts = inclusiveTexts;
	}

	/**
	 * This sets the number of minutes used from user input, the number of
	 * minutes used must be a positive integer
	 * 
	 * @param minsUsed
	 */
	public void setMinsUsed(int minsUsed) {
		if (minsUsed >= 0) {
			this.minsUsed = minsUsed;
		}
	}

	/**
	 * This sets the number of texts used from user input, the number of texts
	 * used must be a positive integer
	 * 
	 * @param textsUsed
	 */
	public void setTextsUsed(int textsUsed) {
		if (textsUsed >= 0) {
			this.textsUsed = textsUsed;
		}
	}

	/**
	 * This function uses the class fields to calculate the total bill along
	 * with each component and stores the results in an integer array
	 * 
	 * @return billParts
	 */
	private double[] calcBill() {
		double[] billParts = { 0., 0., 0., 0. };
		// Stores the base cost
		double totalBill = billParts[0] = rate;
		int excessMins = minsUsed - inclusiveMins;
		if (excessMins > 0) {
			// Stores the cost of excess minutes 
			totalBill += billParts[1] = excessMins * RATE_MINS;
		}
		int excessTexts = textsUsed - inclusiveTexts;
		if (excessTexts > 0) {
			// Stores the cost of excess texts 
			totalBill += billParts[2] = excessTexts * RATE_TEXTS;
		}
		// Stores the total cost
		billParts[3] = totalBill;
		return billParts;
	}

	/**
	 * This function acts like a toString function and produces a nice looking output 
	 * 
	 * @return string
	 */
	public String output() {
		double[] billParts = calcBill();
		return String.format(
				"The breakdown for this month is:\nFlat Rate:\t\t£%.2f\nAdditional Mins:\t\t£%.2f\nAdditional Texts:\t\t£%.2f\nTotal:\t\t\t£%.2f",
				billParts[0], billParts[1], billParts[2], billParts[3]);
	}

}

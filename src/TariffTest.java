import java.util.Scanner;

/**
 * @date 04/10/2018
 * @author b7005951
 *
 */
public class TariffTest {

	public static void main(String[] args) {
		// Prints information and instructions
		System.out.println("Tarrif 1:\n" + "rate: £20\n" + "mins: 200\n" + "texts: 150\n" + "Tarrif 2:\n"
				+ "rate: £35\n" + "mins: 400\n" + "texts: 350\n");
		System.out.println("Would you like to use tarrif 1 or tarrif 2? (Input '1' or '2')");
		// Allows the user to input an integer
		Scanner rawInput = new Scanner(System.in);
		int tariff = rawInput.nextInt();
		// Declare variables
		int rate = 0;
		int mins = 0;
		int texts = 0;
		// Switch/ Case statement - sets the variables according to the users
		// selection
		switch (tariff) {
		case 1:
			rate = 20;
			mins = 200;
			texts = 150;
			break;
		case 2:
			rate = 35;
			mins = 400;
			texts = 350;
			break;
		default:
		}
		Tariff myTariff = new Tariff(rate, mins, texts);
		// Prints instructions
		System.out.println("Please enter the number of mins and number of texts used: (Input in the form: mins texts)");
		// Allows the user to input two integers
		int minsUsed = rawInput.nextInt();
		int textsUsed = rawInput.nextInt();
		// Use the object functions to set the number of minutes used and the
		// number of texts used
		myTariff.setMinsUsed(minsUsed);
		myTariff.setTextsUsed(textsUsed);
		// Output the results
		System.out.println(myTariff.output());
		rawInput.close();
	}

}

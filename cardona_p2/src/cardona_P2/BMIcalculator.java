/* 
 * 	Luisa Cardona 
 * 	COP3330
 * 	September 12, 2019
 * 
 * 	Problem 2: Create a BMI calculator that reads the user’s weight and height 
 * 	(providing an option for the user to select which formula to use), and then 
 * 	calculates and displays the user’s body mass index. Also, display the BMI 
 * 	categories and their values from the National Heart Lung and Blood Institute 
 * 	so the user can evaluate his/her BMI.
 * 
 */

package cardona_P2;
import java.util.Scanner;

public class BMIcalculator {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		double userWeight, userHeight, totalBMI = 0;
		int userChoice;
		
		System.out.println("Please select from the following:\n"
				+ "1. Calculate BMI in pounds and inches.\n"
				+ "2. Calculate BMI in kilograms and meters.");
		userChoice = scnr.nextInt();
		
		if (userChoice == 1) {
			System.out.println("Enter weight(lb): ");
			userWeight = scnr.nextDouble();
			System.out.println("Enter height(in): ");
			userHeight = scnr.nextDouble();
			totalBMI = (703 * userWeight) / (userHeight * userHeight);
		} else if (userChoice == 2) {
			System.out.println("Enter weight(kg): ");
			userWeight = scnr.nextDouble();
			System.out.println("Enter height(m): ");
			userHeight = scnr.nextDouble();
			totalBMI = userWeight / (userHeight * userHeight);
		}
		
		System.out.printf("\nBMI: %.1f\n", totalBMI);
		System.out.println("\nBMI Categories:\n"
				+ "Underweight = < 18.5\n"
				+ "Normal weight = 18.5 - 24.9\n"
				+ "Overweight = 25 - 29.9\n"
				+ "Obesity = BMI of 30 and greater");
		
		scnr.close();
	}
}
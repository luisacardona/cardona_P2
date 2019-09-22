/* 
 * 	Luisa Cardona 
 * 	COP3330
 * 	September 12, 2019
 * 
 * 	Problem 1: A company that wants to send data over the Internet has asked you to write a program 
 * 	that will encrypt it so that it may be transmitted more securely. All the data is transmitted as
 * 	four-digit integers. Your application should read a four-digit integer entered by the user and 
 * 	encrypt it as follows: Replace each digit with the result of adding 7 to the digit and getting 
 * 	the remainder after dividing the new value by 10. Then swap the first digit with the third, and 
 * 	swap the second digit with the fourth. Then print the encrypted integer. Write a separate 
 * 	application that inputs an encrypted four-digit integer and decrypts it (by reversing the encryption 
 * 	scheme) to form the original number.
 * 
 */

package cardona_P1;
import java.util.Scanner;

public class Decryption {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int userInput;
		int digit1, digit2, digit3, digit4;
		
		System.out.println("Enter 4-digit number to decrypt:");
		userInput = scnr.nextInt();
		
		digit1 = userInput / 1000;
		digit2 = (userInput % 1000) / 100;
		digit3 = (userInput % 100) / 10;
		digit4 = userInput % 10;

		digit1 = (digit1 + 3) % 10;
		digit2 = (digit2 + 3) % 10;
		digit3 = (digit3 + 3) % 10;
		digit4 = (digit4 + 3) % 10;
		
		System.out.println("Decrypted number: " + digit3 + digit4 + digit1 + digit2);
		scnr.close();
	}
}

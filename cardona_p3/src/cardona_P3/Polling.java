/* 
 * 	Luisa Cardona 
 * 	COP3330
 * 	September 12, 2019
 * 
 * 	Problem 3: Write a simple polling program that allows users to rate five 
 * 	topics from 1 (least important) to 10 (most important). Pick five topics 
 * 	that are important to you (e.g., political issues, global environmental 
 * 	issues, food, video games). Use a one-dimensional array topics (of type 
 * 	String) to store the five issues. To summarize the survey responses, use 
 * 	a 5-row, 10-column two-dimensional array responses (of type int), each row
 * 	corresponding to an element in the topics array. When the program runs, it
 * 	should ask the user to rate each issue. Multiple people should be able to 
 * 	respond to the survey while the program is running. Once all responses have 
 * 	been logged, have the program display a summary of the results
 * 
 */

package cardona_P3;
import java.util.Scanner;

public class Polling {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String[] topics = {"Harry Potter Movies", "Star Wars Movies", "Tarantino Movies", "Marvel Movies", "DC Movies"};
		int[][] responses = new int[5][10];
		int[] avg = new int[5];
		int numPeople, rating, i, j, max = 0, min = 0;
		String maxTopic = "", minTopic = "";
		
		
		System.out.print("Enter the number of peole rating: ");
		numPeople = scnr.nextInt();
		
		for (i = 0; i < 5; i++)
			for (j = 0; j < 10; j++)
				responses[i][j] = 0;
				
		for (i = 0; i < numPeople; i++) {
			System.out.println("\nRate each of the following topics from 1 (least important) to 10 (most important)");
			for (j = 0; j < 5; j++) {
				System.out.print(topics[j] + ": ");
				rating = scnr.nextInt();
				
				if (rating < 1 || rating > 10) {
					System.out.println("Enter a rating from 1 (least important) to 10 (most important)");
					System.out.print(topics[j] + ": ");
					rating = scnr.nextInt();
				}
				responses[j][rating - 1]++; 
			}
		}
		
		for (i = 0; i < 5; i ++) {
			for (j = 0; j < 10; j++) {
				avg[i] += responses[i][j] * (j + 1);
				
				if (i == 0) {
					min = avg[i];
					max = avg[i];
					minTopic = topics[i];
					maxTopic = topics[i];
				} if (avg[i] > min) {
					max = avg[i];
					maxTopic = topics[i];
				} if (avg[i] < min) {
					min = avg[i];
					minTopic= topics[i];
				}	
			}
			
			avg[i] = avg[i] / numPeople;
		}
		
		
		
		System.out.println("\n\t\t\t 1\t 2\t 3\t 4\t 5\t 6\t 7\t 8\t 9\t10\t Avg. Rating");
		
		for (i = 0; i < 5; i++) {
			if (i == 3 || i == 4)
				System.out.print(topics[i] + "\t");
			else 	
				System.out.print(topics[i]);
			
			for (j = 0; j < 10; j++) {
				System.out.print("\t " + responses[i][j]);
				
				if (j == 9)
					System.out.print("\t     " + avg[i]);
			}
			System.out.println("");
		}
		
		System.out.println("\nHighest point total: " + max);
		System.out.println("Highest rated topic: " + maxTopic);
		System.out.println("Lowest point total: " + min);
		System.out.println("Lowest rated topic: " + minTopic);
		
		scnr.close();
	}
}
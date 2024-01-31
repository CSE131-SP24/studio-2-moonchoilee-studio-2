package studio2;
import java.util.Scanner;
public class Ruin {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How much do you want to start with?");
		int amount = in.nextInt();
		System.out.println("What is the win percentage?");
		double win = in.nextDouble();
		System.out.println("What is the win limit");
		int limit = in.nextInt();
		int ruin = 0;
		System.out.println("Total simulations: ");
		int sim = in.nextInt();
		int losses = 0;
		double alpha = ((double)(1 - win)/win);
		double expectedRuin;
		if (win == 0.5) {
			expectedRuin = (1- ((double)amount/limit));
		}
		else
			expectedRuin = (Math.pow(alpha, amount) - Math.pow(alpha, limit))/(1-(Math.pow(alpha, limit)));
		for(int a = 1; a <= sim; a++) {
			int plays = 0;
			int namount = amount;
			while (namount < limit && namount > ruin) {
				double x = Math.random();
				if (x < win) {
					namount++; 
				} 
				else { 
					namount--;
				}
				plays++;
			}
			if (namount == limit)  {
				System.out.println("Simulation " + a + ": " + plays + " WIN");
			}
			else {
				System.out.println("Simulation " + a + ": " + plays + " LOSE");	
				losses++;
			}
			
	}
	double ruinRate = ((double)losses/sim);
	System.out.println("Losses: " + losses + " Simulation: " + sim );	
	System.out.println("Ruin Rate from Simulation: " + ruinRate);
	System.out.println("Expected Ruin Rate: " + expectedRuin);
}
}

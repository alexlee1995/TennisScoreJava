import java.util.Scanner;

class tennisScore {
	public static void main(String args[]) {
		// Get input
		System.out.print("Input number of matches to track: ");
		Scanner userIn = new Scanner(System.in);
		int numMatches = userIn.nextInt();

		// Initialize array of Match objects
		Match[] matches = new Match[numMatches];
		for (int i = 0; i < numMatches; i++) {
			matches[i] = new Match();
		}
		System.out.println("Set up " + numMatches + " matches.");

		// Enter input loop for user
		while (true) {
			// Get user input for the court that won a game and who won it
			System.out.println("Enter the court # and then a 1 if your team");
			System.out.println("won the game and a 0 if their team won the");
			System.out.println("game, separated by a space.");
			System.out.print("(Type 0 to quit, type -1 to print scores): ");
			//userIn = new Scanner(System.in);

			// Get court number
			int courtNo = userIn.nextInt() - 1;		// -1 for indexing

			// Break if user enters 0
			if (courtNo == -1) {
				break;
			}

			// Print all scores if user enters -1
			if (courtNo == -2) {
				for (int i = 0; i < numMatches; i++) {
					matches[i].printScore();
				}
				continue;
			}

			// Otherwise, get the result of that court
			int gameRes = userIn.nextInt();

			// If your team won the game
			if (gameRes == 1) {
				matches[courtNo].addGame(true, userIn);
			}
			// If their team won the game
			else {
				matches[courtNo].addGame(false, userIn);
			}
		}
	}
}

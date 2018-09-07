/*
Add games one at a time. When a game reaches the end of a set, update
ourSet/theirSet, update toPrint, then reset ourGames/theirGames to zero.
If ourSet/theirSet == 2, one team has won. Change ourWin accordingly.
*/

import java.util.Scanner;

public class Score {

	// Relevant information for score
	int ourSets;
	int theirSets;
	int ourGames;
	int theirGames;
	String toPrint;
	// ourWin is either -1, 0, or 1. If -1, other team won. If 0, match is in
	// progress. If 1, we won.
	int ourWin;

	// Constructor
	public Score() {
		ourSets = 0;
		theirSets = 0;
		ourGames = 0;
		theirGames = 0;
		toPrint = "";
		ourWin = 0;
	}

	// printScore() method for toPrint
	// Takes the historical score and adds the current active set score if
	// match is still in progress (ourWin == 0)
	public void printScore() {
		String tempScore = toPrint;
		if (ourWin == 0) {
			tempScore += (" " + ourGames + "-" + theirGames);
		}
		System.out.println(tempScore);
	}

	// addGame() method to add a game and count sets as necessary
	public void addGame(boolean isOurs, Scanner userIn) {
		// If the match is over, do nothing
		if (ourWin == 1 || ourWin == -1) {

		}
		// Otherwise, update the correct games and check if the sets
		// need to be updated.
		else {
			if (isOurs) {
				ourGames += 1;
				// If set is over (6-* or 7-5, ignore 6-6)
				if ((ourGames == 6 && theirGames != 5 && theirGames != 6) || 
					ourGames == 7 && theirGames == 5) {
					toPrint += (" " + ourGames + "-" + theirGames);
					ourSets += 1;
					ourGames = 0;
					theirGames = 0;
				}
				// If set is over from tiebreak
				else if (ourGames == 7 && theirGames == 6) {
					System.out.print("Tiebreak loser's points: ");
					//Scanner userIn = new Scanner(System.in);
					int tiebreakPts = userIn.nextInt();
					toPrint += " " + ourGames + "-" + theirGames + "(" + tiebreakPts + ")";
					ourSets += 1;
					ourGames = 0;
					theirGames = 0;
				}
			}
			else {
				theirGames += 1;
				// If set is over (*-6 or 5-7, ignore 6-6)
				if ((theirGames == 6 && ourGames != 5 && ourGames != 6) || 
					theirGames == 7 && theirGames == 5) {
					toPrint += (" " + ourGames + "-" + theirGames);
					theirSets += 1;
					ourGames = 0;
					theirGames = 0;
				}
				// If set is over from tiebreak
				else if (theirGames == 7 && ourGames == 6) {
					System.out.print("Tiebreak loser's points: ");
					//Scanner userIn = new Scanner(System.in);
					int tiebreakPts = userIn.nextInt();
					toPrint += " " + ourGames + "-" + theirGames + "(" + tiebreakPts + ")";
					theirSets += 1;
					ourGames = 0;
					theirGames = 0;
				}
			}
			// If we have 2 sets, match is over
			if (ourSets == 2) {
				ourWin = 1;
			}
			// If they have 2 sets, match is over
			else if (theirSets == 2) {
				ourWin = -1;
			}
			// Otherwise, match continues (ourWin = 0)
		}
	}
}

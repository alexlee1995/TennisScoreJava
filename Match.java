import java.util.Scanner;

public class Match {
	// Store names of players
	String ourName;
	String theirName;
	// Store scores
	Score score;

	// Constructor
	public Match() {
		this.ourName = "";
		this.theirName = "";
		// Score will always initialize at 0-0
		score = new Score();
	}

	// Add ourName 
	public void setOur(String ourNameIn) {
		ourName = ourNameIn;
	}

	// Add theirName
	public void setTheir(String theirNameIn) {
		theirName = theirNameIn;
	}

	// Print score of match
	public void printScore() {
		score.printScore();
	}

	// Update score
	public void addGame(boolean isOurs, Scanner userIn) {
		score.addGame(isOurs, userIn);
	}
}

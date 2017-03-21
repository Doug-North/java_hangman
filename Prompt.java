import java.util.Scanner;

public class Prompt {
	private Game game;
	
	public Prompt(Game game) {
		this.game = game;
	}
	public boolean promptForGuess() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a letter: ");
		String guessInput = scanner.nextLine();
		char guess = guessInput.charAt(0);
		guess = Character.toUpperCase(guess);
		boolean isHit = false;
		try{
			isHit = game.applyGuess(guess);
		} catch (IllegalArgumentException iae) {
			System.out.print(iae.getMessage());
		}
		return isHit;
	}
	public void displayOutcome(){
		if (game.isWon()){
			System.out.println("You won!");
		} else {
			System.out.println("You lost!");
		}
	}
	public void displayProgress(){
		System.out.printf("%n You have %d chances left to solve %s%n",game.getRemainingTries(), game.getCurrentProgress());
	}
}
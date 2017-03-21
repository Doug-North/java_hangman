public class Hangman {
	
	public static void main(String[] args) {
		// code goes here
		if (args.length == 0) {
			System.out.println("Usage: java Hangman <word>");
			System.out.println("To play, you must include a word");
		}
		Game game = new Game(args[0]);
		Prompt prompt = new Prompt(game);
		while (game.getRemainingTries() >= 1 && !game.isWon()) {
			prompt.displayProgress();
			prompt.promptForGuess();
		}
		prompt.displayOutcome();
	}
}
public class Game {
	public static int MAX_MISSES = 7;
	private String answer;
	private String misses = "";
	private String hits = "";
	
	public Game(String answer){
		this.answer = answer.toUpperCase();
	}
	
	public boolean applyGuess(char letter){
		if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1){
			throw new IllegalArgumentException(letter + " has already been guessed!");
		}
		boolean isHit = answer.indexOf(letter) != -1;
		if (isHit){
			hits += letter;
		} else {
			misses += letter;
		}
		return isHit;	
	}
	public int getRemainingTries(){
		return MAX_MISSES - misses.length();
	}
	public boolean isWon() {
		return getCurrentProgress().indexOf('_') == -1;
	}
	
	public String getCurrentProgress() {
		String progress = "";
		for(char letter : answer.toCharArray()){
			char display = '_';
			if (hits.indexOf(letter)!= -1) {
				display = letter;
			}
			progress += display;
		}
		return progress;
	}
}
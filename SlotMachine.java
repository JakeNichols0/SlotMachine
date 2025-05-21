public class SlotMachine {
	private String[] options = {"\033[1;36m Bell \033[0m", "\033[1;34m Bar  \033[0m", "\033[1;31mCherry\033[0m", "\033[1;32mApple \033[0m", "\033[1;33mLemon \033[0m", "\033[1;35m  $   \033[0m"};
	private String[] slots;
	private double winnings;
	private int match;
	
	public SlotMachine() {
		slots = new String[3];
		winnings = 0.0;
		match = 0;
	}

	public double getWinnings() {
		return winnings;
	}

	public int getMatches() {
		return match;
	}

	public void pull() {
		for(int i=0; i<slots.length; i++) {
			slots[i] = options[(int) (Math.random() * options.length)];
		}
		calc();
	}

	public void calc() { //If you're just tuning in, calc is slang for calculator
		//two match 1/2 of in; 3 match 2x in
		int[] matches = new int[6]; //Ordered the same as options
		for(String s : slots) {
			for(int i=0; i < options.length; i++) {
				if(s.equals(options[i])) {
					matches[i]++;
					break;
				}
			}
		}
		for(int j=0; j < matches.length - 1; j++) {
			if(matches[j] > 1) {
				match = matches[j];
				winnings = ((0.2 * factorial(matches[j])) - 0.2);
				return;
			}
		}
		if(matches[matches.length - 1] > 1) {
			match = matches[matches.length - 1];
			winnings = ((0.2 * factorial(matches[matches.length - 1])) - 0.2) * 2;
			return;
		}
		match = 0;
		winnings = 0.0;
	}

	private int factorial(int n) {
		if(n == 0) {
			return 1;
		}
		return factorial(n-1) * n;
	}

	public String toString() {
		return slots[0] + " | " + slots[1] + " | " + slots[2];
	}
}
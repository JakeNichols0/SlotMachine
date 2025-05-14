public class SlotMachine {
	private String[] options = {" Bell ", " Bar  ", "Cherry", "Apple ", "Lemon ", "  $   "};
	private String[] slots;
	private int moneyIn;
	private int winnings;
	private int match;
	
	public SlotMachine() {
		slots = new String[3];
		moneyIn = 0;
	}

	public int getWinnings() {
		return winnings;
	}

	public int getMaches() {
		return match;
	}

	public void pull(int m) {
		moneyIn = m;
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
		for(int j=0; j < matches.length; j++) {
			if(matches[j] > 1) {
				match = matches[j];
				winnings += ((0.2 * factorial(matches[j])) - 0.2) * moneyIn;
				return;
			}
		}
		match = 0;
	}

	private int factorial(int n) {
		if(n == 0) {
			return 1;
		}
		return factorial(n-1) * n;
	}

	public String toString() {
		return slots[0] + " | " + slots[1] + " | " + slots[2] + " - You won $" + winnings;
	}
}
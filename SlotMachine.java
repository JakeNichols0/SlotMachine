import java.util.ArrayList;

public class SlotMachine {
	private String[] options = {" Bell ", " Bar  ", "Cherry", "Apple ", "Lemon ", "  $   "};
	private String[] slots;
	private int moneyIn;
	
	public SlotMachine() {
		slots = new String[3];
		moneyIn = 0;
	}

	public void pull(int m) {
		moneyIn = m;
		for(int i=0; i<slots.length; i++) {
			slots[i] = options[(int) (Math.random() * options.length)];
		}
	}

	public int calc() { //If you're just tuning in, calc is slang for calculator
		//two match 1/2 of in; 3 match 2x in
	}

	public String toString() {
		return slots[0] + " | " + slots[1] + " | " + slots[2];
	}
}
public class Item {
	private String name;
	private int value;

	public Item(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void changeValue(double profit) {
		value *= (Math.random() * 0.5) + 0.8;
	}

	public String normalize() {
		String a = "";
		if(!name.substring(name.length() -1).equals("s")) {
			a = "a ";
		}
		return a + name.toLowerCase() + " worth $" + value;
	}

	@Override
	public String toString() {
		return name + " - $" + value;
	}
}
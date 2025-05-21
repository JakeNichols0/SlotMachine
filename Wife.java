public class Wife extends Item {
	private double love;

	public Wife() {
		super("Wife", (int) (Math.random() * 4500) + 500);
		love = 1.0;
	}

	public int calculateSalary(int salary) {
		return (int) (salary * 0.8);
	}

	@Override
	public void changeValue(double profit) {
		super.setValue((int) (super.getValue() * love));
		love = profit;
		
	}

	public String toString() {
		return super.toString() + " - She loves you " + (love * 100) + "%";
	}
}
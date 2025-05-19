public class Wife extends Item {
	private int love;

	public Wife() {
		super("wife", (int) (Math.random() * 4500) + 500);
		love = 100;
	}

	public int calculateSalary(int salary) {
		return (int) (salary * 0.8);
	}
}
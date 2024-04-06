package Practice;

public class Account {

	private int accno;
	private String name;
	private double balance;

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	void deposit(double amount) {
		balance = balance + amount;
	}

	void withdraw(double amount) {
		balance = balance - amount;
	}

	public int getAccno() {
		return accno;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;

	}
}

package Practice;

class Bank {

	public static void main(String[] args) {
		

		Account acc1 = new Account();
		
		acc1.setAccno(10010);
		acc1.setName("Aman");
		acc1.setBalance(190000);
		
		acc1.withdraw(90000);
		acc1.withdraw(20000);
		acc1.deposit(50000);
		
		System.out.println("Current Balance : "+acc1.getBalance());
	}
}
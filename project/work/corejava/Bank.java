class Bank{
   public static void main(String[] args){
   
Account acc1 = new Account();

acc1.setAccount(100,"Aman",75000);
acc1.withdrawl(1000);

Account acc2 = new Account();

acc2.setAccount(15,"Aman",75000);
acc2.deposit(10000);

System.out.println("Current balance: "+acc1.getBalance());
}
}
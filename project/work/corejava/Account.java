class Account{
  
private int accno;
private String name;
private double balance;

void setAccount(int ano, String aname, double abal) {
  accno = ano;
  name = aname;
  balance = abal;
}

void deposit(double amount){
     balance = balance + amount;
}

void withdrawl(double amount){
     balance = balance - amount;
}

double getBalance() {
return balance;
}
}

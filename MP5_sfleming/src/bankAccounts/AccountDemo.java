package bankAccounts;

public class AccountDemo {

	public static void main(String[] args) {
		// 
		Account acct1 = new SavingAccount("00001", 5000, 50);
		System.out.println(acct1);
		System.out.println("--Attempting to deposit $30--");
		acct1.deposit(30);
		System.out.println("--Attempting to deposit $200--");
		acct1.deposit(200);
		System.out.println("--Attempting to withdraw $5300--");
		acct1.withdraw(5300);
		System.out.println("--Attempting to withdraw $500--");
		acct1.withdraw(500);
		System.out.println(acct1);
		Account acct2 = new SavingAccount("00002", 500, 50);
		System.out.println(acct2);
		Account acct3 = new CheckingAccount("00003", 500, 50);
		System.out.println(acct3);
		System.out.println("--Attempting to withdraw $540--");
		acct3.withdraw(540);
		System.out.println(acct3);
		System.out.println("--Attempting to deposit $50--");
		acct3.deposit(50);
		System.out.println("--Attempting to withdraw $70--");
		acct3.withdraw(70);
		System.out.println(acct3);
		
		
	}

}

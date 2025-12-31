package bankAccounts;

class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() - amount >= -overdraftLimit) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Transaction rejected: Withdrawal exceeds overdraft limit.");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
        } else {
            System.out.println("Transaction rejected: Deposit amount must be positive.");
        }
    }

    @Override
    public String toString() {
        return String.format("Checking Account\nAccount No: %s\nAccount Balance: $%.2f\nDate Created: %s\nOverdraft Limit: $%.2f",
                getAccountNumber(), getBalance(), getDateCreated(), overdraftLimit);
    }
}
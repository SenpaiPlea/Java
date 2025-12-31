package bankAccounts;

class SavingAccount extends Account {
    private static final double annualInterestRate = 0.02; // 2%
    private static final double monthlyFee = 10.00; // $10
    private double minDeposit;

    public SavingAccount(String accountNumber, double balance, double minDeposit) {
        super(accountNumber, balance);
        this.minDeposit = minDeposit;
    }

    public double getMinDeposit() {
        return minDeposit;
    }

    public void setMinDeposit(double minDeposit) {
        this.minDeposit = minDeposit;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static double getMonthlyFee() {
        return monthlyFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() - amount >= 0) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Transaction rejected: Cannot overdraft a savings account.");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount >= minDeposit) {
            setBalance(getBalance() + amount);
        } else {
            System.out.println("Transaction rejected: Deposit amount is less than minimum deposit of $" + minDeposit);
        }
    }

    private double calculateNewBalance() {
        double monthlyInterestRate = annualInterestRate / 12;
        double interest = getBalance() * monthlyInterestRate;
        double newBalance = getBalance() + interest;
        if (newBalance <= 1000) {
            newBalance -= monthlyFee;
        }
        return newBalance;
    }

    @Override
    public String toString() {
        return String.format("Saving Account\nAccount No: %s\nAccount Balance: $%.2f\nDate Created: %s\nAnnual Interest Rate: %.2f%%\nMonthly Fee: $%.2f\nMinimum Deposit Amount: $%.2f\nNew Balance will be: $%.2f",
                getAccountNumber(), getBalance(), getDateCreated(), annualInterestRate * 100, monthlyFee, minDeposit, calculateNewBalance());
    }
}
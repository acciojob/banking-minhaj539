package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
         setName(name);
         setBalance(balance);
         setMinBalance(minBalance);
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception


        int temp=digits,total=0;
        while(temp>0){
            int dig=temp%10;
            total=total+dig;
            temp=temp/10;
        }
          if(total!=sum) throw new Exception("Account Number can not be generated");
          return Integer.toString(digits);

       // return null;
    }

    public void deposit(double amount) {
        //add amount to balance
      double bal=getBalance();
      bal+=amount;
      setMinBalance(bal);
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

            double bal=getBalance();
            if(bal<amount) throw new Exception("Insufficient Balance");
            else {
                 bal=bal-amount;
                 setBalance(bal);

            }

    }

}
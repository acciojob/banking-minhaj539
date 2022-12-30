package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name,balance,0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate=rate;
        // minimum balance is 0 by default

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        double bal=getBalance();
        if(bal<amount) throw new Exception("Insufficient Balance");
        else if(maxWithdrawalLimit<=0) throw new Exception("Maximum Withdraw Limit Exceed");
        else{
            bal=bal-amount;
            setBalance(bal);
            maxWithdrawalLimit-=amount;
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
                double bal=getBalance();
                double interest=(bal*years*rate)/100;
               return interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
            double bal=getBalance();
            double coumpoundInterest=bal*(Math.pow((1+rate/100),times));
            return coumpoundInterest;
    }

}

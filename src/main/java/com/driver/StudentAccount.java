package com.driver;
import java.lang.*;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public StudentAccount(String name, double balance, String  institutionName) {
        super(name,balance,0);
        setInstitutionName(institutionName);
        //minimum balance is 0 by default

    }

}

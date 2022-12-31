package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance,5000);
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
         if(this.getBalance()<this.getMinBalance()) throw new Exception("Insufficient Balance");
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
      /*  int n=tradeLicenseId.length();
        boolean con=false;
        for(int i=0;i<n-1;i++){
            char ch=tradeLicenseId.charAt(i);
            if(ch==tradeLicenseId.charAt(i+1)) con=true;
        }
        if(con==false) return;

        if(!isPossible(tradeLicenseId.toCharArray())) throw new Exception("Valid License can not be generated");
        else return;*/

    }
    static boolean isPossible(char[] str)
    {
        HashMap<Character, Integer> freq = new HashMap<>();
        int max_freq = 0;
        for (int j = 0; j < (str.length); j++) {
            if (freq.containsKey(str[j])) {
                freq.put(str[j], freq.get(str[j]) + 1);
                if (freq.get(str[j]) > max_freq)
                    max_freq = freq.get(str[j]);
            }
            else {
                freq.put(str[j], 1);
                if (freq.get(str[j]) > max_freq)
                    max_freq = freq.get(str[j]);
            }
        }

        // If possible
        if (max_freq <= (str.length - max_freq + 1))
            return true;
        return false;


    }

}

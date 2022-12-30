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

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int n=tradeLicenseId.length();
        boolean con=false;
        for(int i=0;i<n-1;i++){
            char ch=tradeLicenseId.charAt(i);
            if(ch==tradeLicenseId.charAt(i+1)) con=true;
        }
        if(con==false) return;

        if(!isPossible(tradeLicenseId.toCharArray())) throw new Exception("Valid License can not be generated");

    }
    public boolean isPossible(char[] s){
        int max_freq=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        int n=s.length;
        for(int i=0;i<n;i++){
            char ch=s[i];
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
                if(max_freq<hm.get(ch)){
                    max_freq=hm.get(ch);
                }
            }
            else{
                hm.put(ch,1);
                if(max_freq<hm.get(ch)){
                    max_freq=hm.get(ch);
                }
            }
        }
        if(max_freq<=s.length-max_freq+1) return true;
        return false;

        // else throw new Exception("Valid License can not be generated");
    }

}

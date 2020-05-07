package com.example.ht;

import java.util.ArrayList;

public class AccountList {
    private AccountList() {
        UserSave newacc = new UserSave("employee1", "!Aa4567891011", "","");
        UserSave newacc2 = new UserSave("employee2", "!Ab1111111111","", "");
        accounts.add(newacc);
        accounts.add(newacc2);
    }


    private static AccountList instance = new AccountList();
    private ArrayList<UserSave> accounts = new ArrayList<>();

    public static AccountList getInstance() {
        return instance;
    }

    public void CreateAc(String name, String password, String email, String phone) {
        UserSave newaccount = new UserSave(name, password, email, phone);
        accounts.add(newaccount);
    }

    public UserSave getUser(int i) {
        return accounts.get(i);
    }

    public int getAllUsers() {
        return accounts.size();
    }
    public void printAccounts() {
        for (int i = 0; i < accounts.size(); i++) {
            UserSave u = accounts.get(i);
            System.out.println("Account " + i + ": " + u.getAccName()+ " " + u.getAccPassword());
        }

    }
}

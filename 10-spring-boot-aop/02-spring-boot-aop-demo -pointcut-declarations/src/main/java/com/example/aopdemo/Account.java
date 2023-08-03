package com.example.aopdemo;

public class Account {

    public Account() {};

    private String name;
    private String level;
    
 
    public String getName() {
        return name;
    }

       public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    
    public void setName(String name) {
        this.name = name;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Account [name=" + name + ", level=" + level + "]";
    }
    
}

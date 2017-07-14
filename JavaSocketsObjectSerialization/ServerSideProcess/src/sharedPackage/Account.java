/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharedPackage;

import java.io.Serializable;

/**
 *
 * @author Ben
 */
public class Account implements Serializable{
    
    public int totalHP;
    public int currentHP;
    public String userName;
    
    public Account(int totalHP, int currentHP, String userName){
        this.totalHP = totalHP;
        this.currentHP = currentHP;
        this.userName = userName;
        System.out.println("In constructor");
    }
    
    public void display(){
        System.out.println(userName + " HP:" + currentHP + "/" + totalHP);
    }
    
    public void updateCurrentHP(int currentHP){
        this.currentHP = currentHP;
    }
    
}

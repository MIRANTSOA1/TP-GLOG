/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.emse.test;

interface IMoney {
    IMoney add(IMoney m);
    IMoney addMoney(Money m);
    IMoney addMoneyBag(MoneyBag mb);
    MoneyBag simplify();
}
/**
 *
 * @author Virabot
 */
/*public class Money implements IMoney{
    private int fAmount ;
    private String fCurrency;
    
    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }
    public int amount() {
        return fAmount;
    }
    public String currency() {
        return fCurrency;
    }
    /*
        public Money add(Money m) {
        return new Money(amount() + m.amount(), currency());
    }*/
/*  public Money add(Money m) {
        if (m.currency().equals(currency()))
            return new Money(amount() + m.amount(), currency());
        return new MoneyBag(this, m);
    }
    interface IMoney {
        public interface IMoney {
            IMoney addMoney(Money m);
            IMoney addMoneyBag(MoneyBag mb);
        }
    }
    public IMoney add(IMoney m) {
        return m.addMoney(this);
    }
    
    // question 6 : surcharge de la methode equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Money money = (Money) obj;
        return fAmount == money.fAmount && (fCurrency != null ? fCurrency.equals(money.fCurrency) : money.fCurrency == null);
    }
}
*/

public class Money implements IMoney {
    private int fAmount;
    private String fCurrency;
    
    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }
    
    public int amount() {
        return fAmount;
    }
    
    public String currency() {
        return fCurrency;
    }
    
    public IMoney addMoney(Money m) {
        if (m.currency().equals(currency()))
            return new Money(amount() + m.amount(), currency());
        return new MoneyBag(this, m);
    }
    
    public IMoney addMoneyBag(MoneyBag mb) {
        return mb.addMoney(this);
    }

    @Override
    public IMoney add(IMoney m) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MoneyBag simplify() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

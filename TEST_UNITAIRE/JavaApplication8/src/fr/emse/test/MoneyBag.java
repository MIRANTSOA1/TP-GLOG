/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.emse.test;

import java.util.Vector;

/**
 *
 * @author Virabot
 */
/* public class MoneyBag implements IMoney{
    private Vector<Money> fMonies = new Vector<Money>();
    MoneyBag(Money m1, Money m2) {
            appendMoney(m1);
            appendMoney(m2);
    }
    MoneyBag(Money bag[]) {
        for (int i = 0; i < bag.length; i++)
            appendMoney(bag[i]);
    }
    private void appendMoney(Money m) {
        if (fMonies.isEmpty()) {
            fMonies.add(m);
        } else {
            int i = 0;
            while ((i < fMonies.size())
            && (!(fMonies.get(i).currency().equals(m.currency()))))
            i++;
            if (i >= fMonies.size()) {
            fMonies.add(m);
            } else {
            fMonies.set(i, new Money(fMonies.get(i).amount() +
            m.amount(),
            m.currency()));
            }
        }
    }
    
    // question 8 :  ajout de la méthode equal
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MoneyBag)) return false;
        MoneyBag that = (MoneyBag) obj;

        if (this.fMonies.size() != that.fMonies.size()) return false;

        for (Money money : this.fMonies) {
            boolean found = false;
            for (Money thatMoney : that.fMonies) {
                if (money.currency().equals(thatMoney.currency()) && money.amount() == thatMoney.amount()) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    @Override
    public IMoney add(IMoney aMoney) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public IMoney add(IMoney m) {
        return m.addMoneyBag(this);
    }
} */
public class MoneyBag implements IMoney {
    private Vector<Money> fMonies = new Vector<Money>();
    
    public MoneyBag(Money m1, Money m2) {
        appendMoney(m1);
        appendMoney(m2);
    }
    
    public MoneyBag(Money bag[]) {
        for (int i = 0; i < bag.length; i++)
            appendMoney(bag[i]);
    }
    
    private void appendMoney(Money m) {
        if (fMonies.isEmpty()) {
            fMonies.add(m);
        } else {
            int i = 0;
            while ((i < fMonies.size())
            && (!(fMonies.get(i).currency().equals(m.currency()))))
            i++;
            if (i >= fMonies.size()) {
                fMonies.add(m);
            } else {
                fMonies.set(i, new Money(fMonies.get(i).amount() +
                m.amount(),
                m.currency()));
            }
        }
    }
    
    public IMoney addMoney(Money m) {
        return new MoneyBag(m, this);
    }
    
    public IMoney addMoneyBag(MoneyBag mb) {
        Vector<Money> newMonies = new Vector<Money>(fMonies);
        for (Money money : mb.fMonies) {
            boolean found = false;
            for (int i = 0; i < newMonies.size(); i++) {
                if (newMonies.get(i).currency().equals(money.currency())) {
                    newMonies.set(i, new Money(newMonies.get(i).amount() + money.amount(), money.currency()));
                    found = true;
                    break;
                }
            }
            if (!found) {
                newMonies.add(money);
            }
        }
        return new MoneyBag(newMonies.toArray(new Money[newMonies.size()]));
    }
}

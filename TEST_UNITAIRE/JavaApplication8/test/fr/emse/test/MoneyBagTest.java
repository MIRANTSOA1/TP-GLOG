/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.emse.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Virabot
 */
public class MoneyBagTest {
    
    private Money f12CHF;
    private Money f14CHF;
    private Money f7USD;
    private Money f21USD;
    private MoneyBag fMB1;
    private MoneyBag fMB2;
    
    @Before
    public void setUp() {
        f12CHF= new Money(12, "CHF");
        f14CHF= new Money(14, "CHF");
        f7USD= new Money( 7, "USD");
        f21USD= new Money(21, "USD");
        fMB1= new MoneyBag(f12CHF, f7USD);
        fMB2= new MoneyBag(f14CHF, f21USD);
    }
    @Test
    public void testBagEquals() {
        assertTrue(!fMB1.equals(null));
        assertEquals(fMB1, fMB1);
        assertTrue(!fMB1.equals(f12CHF));
        assertTrue(!f12CHF.equals(fMB1));
        assertTrue(!fMB1.equals(fMB2));
    }
    // question 10 : test avec succès
    
    @Test
    public void testMixedSimpleAdd() {
    // [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
        Money bag[] = { f12CHF, f7USD };
        MoneyBag expected = new MoneyBag(bag);
        assertEquals(expected, f12CHF.add(f7USD));
    }
    
    @Test
    public void testBagSimpleAdd() {
        // [12 CHF] + [14 CHF] == [26 CHF]
        Money expected = new Money(26, "CHF");
        assertEquals(expected, f12CHF.add(f14CHF));
    }

    @Test
    public void testSimpleBagAdd() {
        // [12 CHF] + {[7 USD][21 USD]} == {[12 CHF][7 USD][21 USD]}
        Money[] bag = { f7USD, f21USD };
        MoneyBag expected = new MoneyBag(f12CHF, new MoneyBag(bag));
        assertEquals(expected, f12CHF.add(fMB2));
    }

    @Test
    public void testBagBagAdd() {
        // {[12 CHF][7 USD]} + {[14 CHF][21 USD]} == {[26 CHF][28 USD]}
        Money[] bag1 = { f12CHF, f7USD };
        Money[] bag2 = { f14CHF, f21USD };
        MoneyBag expected = new MoneyBag(new MoneyBag(bag1), new MoneyBag(bag2));
        assertEquals(expected, fMB1.add(fMB2));
    }
    
    // question 14 : Définir un jeu de test pour vérifier la simplification des MoneyBag en Money lorsque cela est nécessaire. 
    
    @Test
    public void testSimplifyMoneyBag() {
        Money m1 = new Money(10, "USD");
        Money m2 = new Money(20, "USD");
        MoneyBag moneyBag1 = new MoneyBag(m1, m2);
        assertEquals(new Money(30, "USD"), moneyBag1.simplify());

        Money m3 = new Money(15, "EUR");
        MoneyBag moneyBag2 = new MoneyBag(m1, m3);
        assertEquals(moneyBag2, moneyBag2.simplify());

        MoneyBag moneyBag3 = new MoneyBag(m1);
        assertEquals(m1, moneyBag3.simplify());

        Money m4 = new Money(0, "USD");
        MoneyBag moneyBag4 = new MoneyBag(m1, m4);
        assertEquals(m1, moneyBag4.simplify());

        Money m5 = new Money(-10, "USD");
        MoneyBag moneyBag5 = new MoneyBag(m1, m5);
        assertEquals(new Money(0, "USD"), moneyBag5.simplify());

        Money m6 = new Money(30, "USD");
        Money m7 = new Money(-15, "USD");
        MoneyBag moneyBag6 = new MoneyBag(m6, m7);
        assertEquals(new Money(15, "USD"), moneyBag6.simplify());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.emse.test;

/*
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
*/
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Virabot
 */
 // public class MoneyTest {
    
/*  public MoneyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
*/
/*    @Test
    public void testSimpleAdd() {
        Money m12CHF = new Money(12, "CHF"); // création de données
        Money m14CHF = new Money(14, "CHF");
        Money expected = new Money(26, "CHF");
        Money result = m12CHF.add(m14CHF); // exécution de la méthode testée
        assertTrue(expected.equals(result)); // comparaison
        
        //  question 3 : resultat : le test jUnit echoue parceque la methode equals n'est redefini dans la classe 'Money'
    }
    @Test
    public void testEquals() {
        Money m12CHF= new Money(12, "CHF");
        Money m14CHF= new Money(14, "CHF");
        assertTrue(!m12CHF.equals(null));
        assertEquals(m12CHF, m12CHF);
        assertEquals(m12CHF, new Money(12, "CHF"));
        assertTrue(!m12CHF.equals(m14CHF));
        
        // question 5 : le test jUnit echoue encore
    }
}
*/

// question 7 : 
public class MoneyTest {
    
    private Money m12CHF;
    private Money m14CHF;
    private Money expected26CHF;
    private Money expectedSameAsM12CHF;

    @Before
    public void setUp() {
        m12CHF = new Money(12, "CHF");
        m14CHF = new Money(14, "CHF");
        expected26CHF = new Money(26, "CHF");
        expectedSameAsM12CHF = new Money(12, "CHF");
    }

    @Test
    public void testSimpleAdd() {
        Money result = (Money) m12CHF.add(m14CHF);
        assertTrue("Result should be equal to expected26CHF", expected26CHF.equals(result));
    }

    @Test
    public void testEquals() {
        assertTrue( m12CHF.equals(expectedSameAsM12CHF));
        assertFalse( m12CHF.equals(m14CHF));
    }
}
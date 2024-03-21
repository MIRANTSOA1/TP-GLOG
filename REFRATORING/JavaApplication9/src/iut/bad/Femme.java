/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iut.bad;

/**
 *
 * @author Virabot
 */
public class Femme extends Humain{
    
    
    public Femme(){
        super();
    }
    public Femme(String nom, String prenom, int age) {
        super(nom, prenom, age);
    }
    public static void main(String[] args) {
        Homme homme = new Homme("Jean", "Dupont", 30);
        Femme femme = new Femme("Marie", "Dubois", 28);

        homme.ami(femme);
    }
}

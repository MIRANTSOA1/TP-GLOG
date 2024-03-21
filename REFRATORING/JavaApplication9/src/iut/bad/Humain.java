/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iut.bad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Virabot
 */
public class Humain implements Consommation{

    private String nom;
    private String prenom;
    private int age;
    private List<Humain> amis = new ArrayList<>();
    
    public Humain(){}
    
    public Humain(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void details() {
        System.out.println("Nom: " + nom + ", Prénom: " + prenom + ", Âge: " + age);
    }
    @Override
    public String toString() {
        return "Humain{" + "nom=" + nom + ", prenom=" + prenom + ", age=" + age + '}';
    }
    
    // Réponse de la question 9 : Cela nous permet d'avoir une représentation différente
    //de chaque sous-classe lors de l'appel de la méthode toString() sur une instance de la sous-classe.
    
    @Override
    public void manger() {
        System.out.println("L'humain mange.");
    }

    @Override
    public void boire() {
        System.out.println("L'humain boit.");
    }
    public void ami(Humain ami, int dureeAmitie) {
        System.out.println(this.nom + " est ami avec " + ami.nom + " depuis " + dureeAmitie + " jours.");
    }
    /*public void ami(Humain ami) {
        amis.add(ami);
        ami.amis.add(this);
    }*/
    public void ami(Humain ami) {
        ami(ami, 100);
    }
    
}

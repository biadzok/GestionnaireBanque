package com.example.model;

public class Taux {
    private String Nom;

    private int inferieur;

    private int superieur;

    private double taux;

    public String getNom() {
        return Nom;
    }

    public double getTaux() {
        return taux;
    }

    public int getInferieur() {
        return inferieur;
    }

    public int getSuperieur() {
        return superieur;
    }

    public void setInferieur(int inferieur) {
        this.inferieur = inferieur;
    }

    public void setSuperieur(int superieur) {
        this.superieur = superieur;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public Taux(String nom, int inferieur, int superieur, double taux) {
        this.taux = taux;
        this.Nom = nom;
        this.superieur = superieur;
        this.inferieur = inferieur;
    }
}

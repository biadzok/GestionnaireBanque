package com.example.model;

public class Taux {
    private String Nom;

    private double taux;

    public String getNom() {
        return Nom;
    }

    public double getTaux() {
        return taux;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public Taux(String nom, double taux) {
        this.taux = taux;
        this.Nom = nom;
    }
}

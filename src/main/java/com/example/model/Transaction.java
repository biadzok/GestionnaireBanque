package com.example.model;

import java.io.*;

public class Transaction implements Serializable {
    private String Nom;
    private char type;
    private double Montant;

    public char getType() {
        return type;
    }

    public double getMontant() {
        return Montant;
    }

    public String getNom() {
        return Nom;
    }

    public void setMontant(double montant) {
        Montant = montant;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Transaction(String nom, char type, double montant) {
        this.Nom = nom;
        this.type = type;
        this.Montant = montant;
    }

    public Transaction(String path) {
    }

    public void saveTransaction(String path) {
    }
}

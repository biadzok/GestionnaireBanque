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
        ObjectInputStream ois = null;

        try {
            final FileInputStream fichier = new FileInputStream(path);
            ois = new ObjectInputStream(fichier);
            Transaction temp = (Transaction) ois.readObject();
            this.Nom = temp.getNom();
            this.type = temp.getType();
            this.Montant = temp.getMontant();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void saveTransaction(String path) {
        ObjectOutputStream oos = null;

        try {
            final FileOutputStream fichier = new FileOutputStream(path);
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(this);
            oos.flush();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

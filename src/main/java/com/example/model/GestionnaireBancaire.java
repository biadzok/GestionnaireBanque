package com.example.model;

import java.io.*;
import java.util.ArrayList;

public class GestionnaireBancaire {

    private ArrayList<Transaction> listeTransaction;

    private ArrayList<Taux> listeTaux;

    private double solde;

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public ArrayList<Transaction> getListeTransaction() {
        return listeTransaction;
    }

    public void setListeTransaction(ArrayList<Transaction> listeTransaction) {
        this.listeTransaction = listeTransaction;
    }

    public ArrayList<Taux> getListeTaux() {
        return listeTaux;
    }

    public void setListeTaux(ArrayList<Taux> listeTaux) {
        this.listeTaux = listeTaux;
    }

    public GestionnaireBancaire() {
        listeTransaction = recupererTransactions("src/main/Data/saveList");
        try {
            listeTaux = recupererTaux("src/main/Data/taux.txt");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private ArrayList<Taux> recupererTaux(String path) throws IOException {
        ArrayList<Taux> res = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            String line = br.readLine();

            while (line != null) {
                String[] results = line.split(" ");
                String nom = results[0];
                int inferieur = Integer.parseInt(results[1]);
                int superieur = Integer.parseInt(results[2]);
                double taux = Double.parseDouble(results[3]);
                res.add(new Taux(nom, inferieur, superieur, taux));
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            br.close();
        }

        return res;
    }



    private ArrayList<Transaction> recupererTransactions(String path) {
        ArrayList<Transaction> res = new ArrayList<>();
        File dossier =new File(path);

        if (dossier.isDirectory()) {
            File[] files = dossier.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    Transaction transaction = new Transaction(file.getPath());
                    res.add(transaction);
                }
            }
            return res;
        }
        else
            return null;
    }

    public void SaveList() {
        for (Transaction transaction : listeTransaction) {
            transaction.saveTransaction("src/main/Data/saveList/" + transaction.getNom());
        }
    }
}

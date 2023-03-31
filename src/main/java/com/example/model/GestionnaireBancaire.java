package com.example.model;

import java.io.File;
import java.util.ArrayList;

public class GestionnaireBancaire {

    private ArrayList<Transaction> listeTransaction;

    public ArrayList<Transaction> getListeTransaction() {
        return listeTransaction;
    }

    public void setListeTransaction(ArrayList<Transaction> listeTransaction) {
        this.listeTransaction = listeTransaction;
    }

    public GestionnaireBancaire() {
        listeTransaction = recupererTransactions("src/main/Data");
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

    public void sauvegarderTransactions() {
        for (Transaction transaction : listeTransaction) {
            transaction.saveTransaction("src/main/Data/" + transaction.getNom());
        }
    }
}

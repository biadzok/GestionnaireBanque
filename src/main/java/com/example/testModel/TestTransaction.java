package com.example.testModel;

import com.example.model.Transaction;

public class TestTransaction {
    private static Transaction testConstructeur() {
        return new Transaction("test", 'c', 2.23);
    }

    public static void main(String[] args) {
        Transaction test = testConstructeur();
        System.out.println(test.getNom() + " ; type : " + test.getType() + " ; montant : " + test.getMontant());
    }
}

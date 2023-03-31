package com.example.testModel;

import com.example.model.Transaction;

public class TestTransaction {
    private static Transaction testConstructeur() {
        return new Transaction("test", 'c', 2.23);
    }

    private static Transaction testConstructeurDepuisFichier(String path) {
        return new Transaction(path);
    }

    private static void testEnregistrement(String path, Transaction transaction) {
        transaction.saveTransaction(path);
    }

    private static void printTransaction(Transaction transaction) {
        System.out.println(transaction.getNom() + " ; type : " + transaction.getType() + " ; montant : " + transaction.getMontant());
    }

    public static void main(String[] args) {
        Transaction test = testConstructeur();
        printTransaction(test);

        testEnregistrement("src/main/Data", test);
        Transaction test2 = testConstructeurDepuisFichier("src/main/Data");
        printTransaction(test2);
    }
}

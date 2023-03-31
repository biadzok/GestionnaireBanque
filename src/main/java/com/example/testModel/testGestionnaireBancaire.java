package com.example.testModel;

import com.example.model.GestionnaireBancaire;
import com.example.model.Taux;
import com.example.model.Transaction;

public class testGestionnaireBancaire {

    private static GestionnaireBancaire testConstructeur() {
        return new GestionnaireBancaire();
    }

    private static void testEnregistrement(GestionnaireBancaire g) {
        g.SaveList();
    }
    private static void printTransaction(Transaction transaction) {
        System.out.println(transaction.getNom() + " ; type : " + transaction.getType() + " ; montant : " + transaction.getMontant());
    }

    private static void printTaux(Taux t) {
        System.out.println(t.getNom() + " ; inferieur : " + t.getInferieur() + " ; superieur : " + t.getSuperieur() + " ; taux : " + t.getTaux());
    }

    public static void main(String[] args) {
        GestionnaireBancaire test = testConstructeur();
        System.out.println("test 1 :");
        for (Transaction t : test.getListeTransaction()) {
            printTransaction(t);
        }

        test.getListeTransaction().add(new Transaction("test2", 'c', 3.32));

        test.SaveList();

        GestionnaireBancaire testSauvegarde = testConstructeur();
        System.out.println("test 2 :");
        for (Transaction t : test.getListeTransaction()) {
            printTransaction(t);
        }
        for (Taux t : test.getListeTaux()) {
            printTaux(t);
        }
    }
}

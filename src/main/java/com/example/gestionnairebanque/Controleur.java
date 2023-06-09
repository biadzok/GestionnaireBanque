package com.example.gestionnairebanque;

import com.example.model.GestionnaireBancaire;
import com.example.model.Transaction;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Controleur extends Application {

    private GestionnaireBancaire gestionnaireBancaire;

    @FXML
    private TextField Nom;

    @FXML
    private TextField Montant;

    @FXML
    private Label solde;

    @FXML
    private Button save;

    @FXML
    ListView<Transaction> listeTransactions;

    @FXML
    ObservableList<Transaction> observableList;

    @Override
    public void start(Stage stage) throws IOException {
        this.gestionnaireBancaire = new GestionnaireBancaire();
        observableList = FXCollections.observableArrayList(gestionnaireBancaire.getListeTransaction());
        listeTransactions = new ListView<>(observableList);
        for (Transaction t : gestionnaireBancaire.getListeTransaction()) {
            System.out.println(t);
            // bug sur l'affichage de la liste des transactions
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Controleur.class.getResource("IHM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 200, Color.LIGHTGRAY);
        stage.getIcons().add(new Image(Controleur.class.getResourceAsStream("/3il_logo.jpg")));
        stage.setTitle("Gestion banquaire");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
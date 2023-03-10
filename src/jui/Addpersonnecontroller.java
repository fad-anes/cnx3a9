/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jui;

import entite.Personne;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.servicepersonne;

/**
 * FXML Controller class
 *
 * @author fad anes
 */
public class Addpersonnecontroller implements Initializable {

    @FXML
    private TextField txtn;
    @FXML
    private TextField txtp;
    @FXML
    private TextField txtage;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouterPersonne(ActionEvent event) throws IOException {
        Personne p=new Personne(txtn.getText(),
                txtp.getText(), Integer.parseInt(txtage.getText()));

        servicepersonne ps=new servicepersonne();
        ps.insert(p);


        FXMLLoader loader=new FXMLLoader(getClass().getResource("afficherpersonne.fxml"));
        Parent root=loader.load();

        Afficherpersonne dc=loader.getController();
        txtn.getScene().setRoot(root);


    }

}

package jui;
import entite.Personne;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import service.servicepersonne;
public class Afficherpersonne implements Initializable  {
    @FXML
    private ListView<Personne> listview;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Personne> list=new ArrayList<>();
        servicepersonne ps=new servicepersonne();
        list=ps.readall();
        ObservableList<Personne> obs=FXCollections.observableArrayList(list);

        listview.setItems(obs);
    }
    @FXML
    private void retouradd(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Addpersonne.fxml"));
        Parent root=loader.load();
        Addpersonnecontroller dc=loader.getController();
        listview.getScene().setRoot(root);
    }
}

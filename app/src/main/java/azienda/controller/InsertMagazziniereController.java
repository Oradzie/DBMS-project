package azienda.controller;

import azienda.App;
import azienda.data.Magazziniere;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class InsertMagazziniereController {

    private static final Controller controller = App.CONTROLLER;

    @FXML
    private TextField codiceFiscale;
    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private TextField telefono;
    @FXML
    private TextField codiceDipendente;
    @FXML
    private TextField password;
    @FXML
    private TextField datiFatturazione;

    @FXML
    public void toggleSalvaMagazziniere() {

        controller.getView()
                .showError(Magazziniere.DAO.addMagazziniere(controller.getModel().getConnection(),
                        this.codiceFiscale.getText(),
                        this.nome.getText(), this.cognome.getText(), this.telefono.getText(),
                        this.codiceDipendente.getText(),
                        App.CONTROLLER.getModel().getCurrentCodiceMagazzino(), this.password.getText(),
                        this.datiFatturazione.getText()));
    }
}

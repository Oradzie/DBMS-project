package azienda.controller;

import azienda.commons.DAOException;
import azienda.data.Prodotto;
import azienda.model.Model;
import azienda.view.MainView;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import java.io.IOException;

import javafx.scene.layout.VBox;
import org.mindrot.jbcrypt.BCrypt;

public final class Controller implements Initializable {

    private Model model;
    private MainView view;

    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private RadioButton utenteOnlineRadio;
    @FXML
    private RadioButton dipendenteRadio;
    @FXML
    private ToggleGroup accessToggle;
    @FXML
    private Button loginButton;
    @FXML
    private VBox inserimentoMagazzinierePane;
    @FXML
    private VBox categoriaPiuVendutaPane;
    @FXML
    private VBox inserimentoProdottoPane;
    @FXML
    private VBox eliminazioneProdottoPane;
    @FXML
    private VBox VisualizzaQuantitaPane;
    @FXML
    private Pane rightPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accessToggle = new ToggleGroup();
        utenteOnlineRadio.setToggleGroup(accessToggle);
        dipendenteRadio.setToggleGroup(accessToggle);
        dipendenteRadio.setSelected(true);
    }

    public final void setModel(final Model model) {
        this.model = model;
    }

    public final void setView(final MainView view) {
        this.view = view;
    }

    public void userRequestedInitialPage() {
        Application.launch(MainView.class);
    }

    public void login() {
        try {
            if (this.model != null) {
                if (utenteOnlineRadio.isSelected()) {
                    this.access(this.emailField, this.passwordField, false);
                } else if (dipendenteRadio.isSelected()) {
                    this.access(this.usernameField, this.passwordField, true);
                } else {
                    this.view.showError("No option selected");
                }
            } else {
                this.view.showError("The Model is null");
            }
        } catch (DAOException e) {
            this.view.showError("Error while loading products: " + e.getMessage());
        }
    }

    private void access(final TextField field, final PasswordField passwordField, final boolean isDipendente) {
        final String userID = field.getText();
        final String password = this.model.getPassword(userID, isDipendente);
        if (!Objects.isNull(password) && password.equals(passwordField.getText())) {
            System.out.println("Login successful");
            this.view.closeStartView();
            this.view.showMagazziniereDashboard();
        } else {
            this.view.showError("Login failed! Invalid credentials.");
        }
    }

    @FXML
    public void handleOptionSelection() {
        final RadioButton selectedRadioButton = (RadioButton) accessToggle.getSelectedToggle();
        if (utenteOnlineRadio.isSelected()) {
            emailField.setVisible(true);
            usernameField.setVisible(false);
        } else if (dipendenteRadio.isSelected()) {
            emailField.setVisible(false);
            usernameField.setVisible(true);
        } else {
            emailField.setDisable(true);
            usernameField.setDisable(true);
        }
    }

    @FXML
    public void toggleInserimentoMagazziniere() {
        this.rightPane.getChildren().forEach(node -> {
            if (node.equals(this.inserimentoMagazzinierePane)) {
                this.inserimentoMagazzinierePane.setDisable(false);
                this.inserimentoMagazzinierePane.setVisible(true);
            } else {
                node.setDisable(true);
                node.setDisable(false);
            }
        });
    }

    @FXML
    public void toggleCategoriaVenduta() {
        this.rightPane.getChildren().forEach(node -> {
            if (node.equals(this.categoriaPiuVendutaPane)) {
                this.categoriaPiuVendutaPane.setDisable(false);
                this.categoriaPiuVendutaPane.setVisible(true);
            } else {
                node.setDisable(true);
                node.setDisable(false);
            }
        });
    }

    @FXML
    public void toggleInserimentoProdotto() {
        this.inserimentoProdottoPane.setDisable(false);
        this.inserimentoProdottoPane.setVisible(!this.inserimentoProdottoPane.isVisible());
        this.eliminazioneProdottoPane.setVisible(false);
        this.VisualizzaQuantitaPane.setVisible(false);
    }

    @FXML
    public void toggleEliminazioneProdotto() {
        this.eliminazioneProdottoPane.setDisable(false);
        this.eliminazioneProdottoPane.setVisible(!this.eliminazioneProdottoPane.isVisible());
        this.inserimentoProdottoPane.setVisible(false);
        this.VisualizzaQuantitaPane.setVisible(false);
    }

    @FXML
    public void toggleVisualizzaQuantita() {
        this.VisualizzaQuantitaPane.setDisable(false);
        this.VisualizzaQuantitaPane.setVisible(!this.VisualizzaQuantitaPane.isVisible());
        this.inserimentoProdottoPane.setVisible(false);
        this.eliminazioneProdottoPane.setVisible(false);
    }

}

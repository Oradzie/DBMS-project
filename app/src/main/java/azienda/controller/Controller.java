package azienda.controller;

import azienda.commons.DAOException;
import azienda.data.Persona;
import azienda.data.Prodotto;
import azienda.model.Model;
import azienda.view.MainView;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    private VBox andamentoVenditePane;
    @FXML
    private VBox inserimentoProdottoPane;
    @FXML
    private VBox eliminazioneProdottoPane;
    @FXML
    private VBox VisualizzaQuantitaPane;
    @FXML
    private VBox inserimentoIndirizzoPane;
    @FXML
    private Pane rightPane;
    @FXML
    private TextField NumeroSeriale;
    @FXML
    private TextField CodiceLotto;
    @FXML
    private TextField CodiceProdotto;
    @FXML
    private TextField CodRipiano;
    @FXML
    private Pane statisticheMagazzinieriPane;
    @FXML
    private VBox istogrammaVenditePane;
    @FXML
    private Pane visualizzaDatiMagazzinieriPane;
    @FXML
    private VBox rifornimentoPane;

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

    public final Model getModel() {
        return this.model;
    }

    public final MainView getView() {
        return this.view;
    }

    public void userRequestedInitialPage() {
        Application.launch(MainView.class);
    }

    public void login() {
        try {
            if (this.model != null) {
                final Optional<Integer> result = this.model.handleLogin(
                        this.usernameField.getText() + this.emailField.getText(),
                        this.passwordField.getText(), this.dipendenteRadio.isSelected());
                if (result.isPresent()) {
                    System.out.println("Login successful!");
                    if (result.get() == 0) {
                        this.view.showAmministratorDashboard();
                    } else if (result.get() == 1) {
                        this.view.showMagazziniereDashboard();
                    } else {
                        this.view.showUtenteDashboard();
                    }
                    this.view.closeStartView();
                } else {
                    this.view.showError("Login failed! Invalid credentials.");
                }
            } else {
                this.view.showError("The Model is null");
            }
        } catch (DAOException e) {
            this.view.showError("Error while loading products: " + e.getMessage());
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
                node.setVisible(false);
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
                node.setVisible(false);
            }
        });
    }

    @FXML
    public void toggleSalesChertPane() {
        this.rightPane.getChildren().forEach(node -> {
            if (node.equals(this.andamentoVenditePane)) {
                this.andamentoVenditePane.setDisable(false);
                this.andamentoVenditePane.setVisible(true);
            } else {
                node.setDisable(true);
                node.setVisible(false);
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

    @FXML
    public void toggleInserimentoIndirizzo() {
        this.inserimentoIndirizzoPane.setDisable(false);
        this.inserimentoIndirizzoPane.setVisible(!this.inserimentoIndirizzoPane.isVisible());

    }

    @FXML
    public void toggleSalvaProdotto() {
        this.view.showError(Prodotto.DAO.addProduct(model.getConnection(), this.NumeroSeriale.getText(),
                this.CodiceLotto.getText(), this.CodiceProdotto.getText(),
                this.CodRipiano.getText()));
    }

    @FXML
    public void toggleStatisticheMagazzinieri() {
        this.rightPane.getChildren().forEach(node -> {
            if (node.equals(this.statisticheMagazzinieriPane)) {
                this.statisticheMagazzinieriPane.setDisable(false);
                this.statisticheMagazzinieriPane.setVisible(true);
            } else {
                node.setDisable(true);
                node.setVisible(false);
            }
        });
    }

    @FXML
    public void toggleIstogrammaChartPane() {
        this.rightPane.getChildren().forEach(node -> {
            if (node.equals(this.istogrammaVenditePane)) {
                this.istogrammaVenditePane.setDisable(false);
                this.istogrammaVenditePane.setVisible(true);
            } else {
                node.setDisable(true);
                node.setVisible(false);
            }
        });
    }

    @FXML
    public void toggleDatiMagazzinieri() {
        this.rightPane.getChildren().forEach(node -> {
            if (node.equals(this.visualizzaDatiMagazzinieriPane)) {
                this.visualizzaDatiMagazzinieriPane.setDisable(false);
                this.visualizzaDatiMagazzinieriPane.setVisible(true);
            } else {
                node.setDisable(true);
                node.setVisible(false);
            }
        });
    }

    @FXML
    public void toggleRichiestaRifornimentoPage() {
        this.rightPane.getChildren().forEach(node -> {
            if (node.equals(this.rifornimentoPane)) {
                this.rifornimentoPane.setDisable(false);
                this.rifornimentoPane.setVisible(true);
            } else {
                node.setDisable(true);
                node.setVisible(false);
            }
        });
    }
}

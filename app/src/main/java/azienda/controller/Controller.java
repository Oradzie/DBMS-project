package azienda.controller;

import azienda.commons.DAOException;
import azienda.data.Prodotto;
import azienda.model.Model;
import azienda.view.MainView;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;

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
    private VBox rifornimentoPane;
    @FXML
    private VBox visualizzaProdottiDispPane;
    @FXML
    private VBox visualizzaPromozioniPane;
    @FXML
    private VBox visualizzaStoricoOrdiniPane;

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
                final Optional<Integer> result = this.model.handleLogin(dipendenteRadio.isSelected() ? this.usernameField.getText() :
                        this.emailField.getText(), this.passwordField.getText(), this.dipendenteRadio.isSelected());
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
            usernameField.clear();
            passwordField.clear();
        } else if (dipendenteRadio.isSelected()) {
            emailField.setVisible(false);
            emailField.clear();
            usernameField.setVisible(true);
            passwordField.clear();
        } else {
            emailField.setDisable(false);
            usernameField.setDisable(false);
            passwordField.clear();
        }
    }

    @FXML
    public void toggleInserimentoMagazziniere() {
        if (!this.rightPane.getChildren().isEmpty()) {
            this.rightPane.getChildren().clear();
        }
        try {
            final VBox inserimentoMagazzinierePane = new FXMLLoader(getClass().getResource("/azienda/view/inserimentoMagazziniere.fxml")).load();
            this.rightPane.getChildren().add(inserimentoMagazzinierePane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleCategoriaVenduta() {
        if (!this.rightPane.getChildren().isEmpty()) {
            this.rightPane.getChildren().clear();
        }
        try {
            final VBox categoriaPiuVendutaPane = new FXMLLoader(getClass().getResource("/azienda/view/categoria-piu-venduta.fxml")).load();
            this.rightPane.getChildren().add(categoriaPiuVendutaPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleSalesChartPane() {
        if (!this.rightPane.getChildren().isEmpty()) {
            this.rightPane.getChildren().clear();
        }
        try {
            final VBox salesChartPane = new FXMLLoader(getClass().getResource("/azienda/view/andamento-vendite.fxml")).load();
            this.rightPane.getChildren().add(salesChartPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }


    @FXML
    public void toggleStatisticheMagazzinieri() {
        if (!this.rightPane.getChildren().isEmpty()) {
            this.rightPane.getChildren().clear();
        }
        try {
            final VBox statisticheMagazzinieriPane = new FXMLLoader(getClass().getResource("/azienda/view/visualizzaStatistichemagazzinieri.fxml")).load();
            this.rightPane.getChildren().add(statisticheMagazzinieriPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleIstogrammaChartPane() {
        if (!this.rightPane.getChildren().isEmpty()) {
            this.rightPane.getChildren().clear();
        }
        try {
            final VBox istogrammaVenditePane = new FXMLLoader(getClass().getResource("/azienda/view/istogramma-vendite.fxml")).load();
            this.rightPane.getChildren().add(istogrammaVenditePane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleDatiMagazzinieri() {
        if (!this.rightPane.getChildren().isEmpty()) {
            this.rightPane.getChildren().clear();
        }
        try {
            final VBox visualizzaDatiMagazzinieriPane = new FXMLLoader(getClass().getResource("/azienda/view/visualizzaDatiMagazzinieri.fxml")).load();
            this.rightPane.getChildren().add(visualizzaDatiMagazzinieriPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleRichiestaRifornimentoPage() {
        if (!this.rightPane.getChildren().isEmpty()) {
            this.rightPane.getChildren().clear();
        }
        try {
            final VBox visualizzaDatiMagazzinieriPane = new FXMLLoader(getClass().getResource("/azienda/view/richiesta-rifornimento.fxml")).load();
            this.rightPane.getChildren().add(visualizzaDatiMagazzinieriPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
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
    public void toggleVisualizzaProdottiDisponibili() {
        this.visualizzaProdottiDispPane.setDisable(false);
        this.visualizzaProdottiDispPane.setVisible(!this.visualizzaProdottiDispPane.isVisible());
    }

    @FXML
    public void toggleVisualizzaPromozioni() {
        this.visualizzaPromozioniPane.setDisable(false);
        this.visualizzaPromozioniPane.setVisible(!this.visualizzaPromozioniPane.isVisible());
    }

    @FXML
    public void toggleVisualizzaStoricoOrdini(){
        this.visualizzaStoricoOrdiniPane.setDisable(false);
        this.visualizzaStoricoOrdiniPane.setVisible(!this.visualizzaStoricoOrdiniPane.isVisible());
    }
}

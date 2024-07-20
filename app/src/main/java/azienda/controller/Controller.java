package azienda.controller;

import azienda.commons.DAOException;
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
    private Pane rightPaneAdmin;
    @FXML
    private Pane rightPaneMag;
    @FXML
    private Pane rightPaneUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accessToggle = new ToggleGroup();
        utenteOnlineRadio.setToggleGroup(accessToggle);
        dipendenteRadio.setToggleGroup(accessToggle);
        dipendenteRadio.setSelected(true);
        emailField.setOnAction(event -> login());
        usernameField.setOnAction(event -> login());
        passwordField.setOnAction(event -> login());
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
                        dipendenteRadio.isSelected() ? this.usernameField.getText() : this.emailField.getText(),
                        this.passwordField.getText(), this.dipendenteRadio.isSelected());
                if (result.isPresent()) {
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
        if (!this.rightPaneAdmin.getChildren().isEmpty()) {
            this.rightPaneAdmin.getChildren().clear();
        }
        try {
            final VBox inserimentoMagazzinierePane = new FXMLLoader(
                    getClass().getResource("/azienda/view/inserimentoMagazziniere.fxml")).load();
            this.rightPaneAdmin.getChildren().add(inserimentoMagazzinierePane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleCategoriaVenduta() {
        if (!this.rightPaneAdmin.getChildren().isEmpty()) {
            this.rightPaneAdmin.getChildren().clear();
        }
        try {
            final VBox categoriaPiuVendutaPane = new FXMLLoader(
                    getClass().getResource("/azienda/view/categoria-piu-venduta.fxml")).load();
            this.rightPaneAdmin.getChildren().add(categoriaPiuVendutaPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleSalesChartPane() {
        if (!this.rightPaneAdmin.getChildren().isEmpty()) {
            this.rightPaneAdmin.getChildren().clear();
        }
        try {
            final VBox salesChartPane = new FXMLLoader(getClass().getResource("/azienda/view/andamento-vendite.fxml"))
                    .load();
            this.rightPaneAdmin.getChildren().add(salesChartPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleStatisticheMagazzinieri() {
        if (!this.rightPaneAdmin.getChildren().isEmpty()) {
            this.rightPaneAdmin.getChildren().clear();
        }
        try {
            final VBox statisticheMagazzinieriPane = new FXMLLoader(
                    getClass().getResource("/azienda/view/visualizzaStatistichemagazzinieri.fxml")).load();
            this.rightPaneAdmin.getChildren().add(statisticheMagazzinieriPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleIstogrammaChartPane() {
        if (!this.rightPaneAdmin.getChildren().isEmpty()) {
            this.rightPaneAdmin.getChildren().clear();
        }
        try {
            final VBox istogrammaVenditePane = new FXMLLoader(
                    getClass().getResource("/azienda/view/istogramma-vendite.fxml")).load();
            this.rightPaneAdmin.getChildren().add(istogrammaVenditePane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleRichiestaRifornimentoPage() {
        if (!this.rightPaneAdmin.getChildren().isEmpty()) {
            this.rightPaneAdmin.getChildren().clear();
        }
        try {
            final VBox visualizzaDatiMagazzinieriPane = new FXMLLoader(
                    getClass().getResource("/azienda/view/richiesta-rifornimento.fxml")).load();
            this.rightPaneAdmin.getChildren().add(visualizzaDatiMagazzinieriPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleInserimentoProdotto() {
        if (!this.rightPaneMag.getChildren().isEmpty()) {
            this.rightPaneMag.getChildren().clear();
        }
        try {
            final VBox inserimentoProdottoPane = new FXMLLoader(
                    getClass().getResource("/azienda/view/inserimentoProdotto.fxml")).load();
            this.rightPaneMag.getChildren().add(inserimentoProdottoPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleEliminazioneProdotto() {
        if (!this.rightPaneMag.getChildren().isEmpty()) {
            this.rightPaneMag.getChildren().clear();
        }
        try {
            final VBox eliminazioneProdottoPane = new FXMLLoader(
                    getClass().getResource("/azienda/view/eliminazioneProdotto.fxml")).load();
            this.rightPaneMag.getChildren().add(eliminazioneProdottoPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleVisualizzaQuantita() {
        if (!this.rightPaneMag.getChildren().isEmpty()) {
            this.rightPaneMag.getChildren().clear();
        }
        try {
            final VBox visualizzaQuantitaPane = new FXMLLoader(
                    getClass().getResource("/azienda/view/visualizzaQuantitaProdotto.fxml")).load();
            this.rightPaneMag.getChildren().add(visualizzaQuantitaPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleInserimentoIndirizzo() {
        if (!this.rightPaneUser.getChildren().isEmpty()) {
            this.rightPaneUser.getChildren().clear();
        }
        try {
            final VBox inserimentoIndirizzoPane = new FXMLLoader(
                    getClass().getResource("/azienda/view/inserimentoIndirizzo.fxml")).load();
            this.rightPaneUser.getChildren().add(inserimentoIndirizzoPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleVisualizzaProdottiDisponibili() {
        if (!this.rightPaneUser.getChildren().isEmpty()) {
            this.rightPaneUser.getChildren().clear();
        }
        try {
            final VBox visualizzaProdottiDispPane = new FXMLLoader(
                    getClass().getResource("/azienda/view/visualizzaProdottiDisponibili.fxml")).load();
            this.rightPaneUser.getChildren().add(visualizzaProdottiDispPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleVisualizzaPromozioni() {
        if (!this.rightPaneUser.getChildren().isEmpty()) {
            this.rightPaneUser.getChildren().clear();
        }
        try {
            final VBox visualizzaPromozioniPane = new FXMLLoader(
                    getClass().getResource("/azienda/view/visualizzaPromozioni.fxml")).load();
            this.rightPaneUser.getChildren().add(visualizzaPromozioniPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleVisualizzaStoricoOrdini() {
        if (!this.rightPaneUser.getChildren().isEmpty()) {
            this.rightPaneUser.getChildren().clear();
        }
        try {
            final VBox visualizzaStoricoOrdiniPane = new FXMLLoader(
                    getClass().getResource("/azienda/view/visualizzaStoricoOrdini.fxml")).load();
            this.rightPaneUser.getChildren().add(visualizzaStoricoOrdiniPane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    @FXML
    public void toggleAggiungiOrdine() {
        if (!this.rightPaneUser.getChildren().isEmpty()) {
            this.rightPaneUser.getChildren().clear();
        }
        try {
            final VBox aggiuntaOrdinePane = new FXMLLoader(
                    getClass().getResource("/azienda/view/aggiungiOrdine.fxml")).load();
            this.rightPaneUser.getChildren().add(aggiuntaOrdinePane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }

    public void toggleConcludiOrdine() {
        if (!this.rightPaneUser.getChildren().isEmpty()) {
            this.rightPaneUser.getChildren().clear();
        }
        try {
            final VBox aggiuntaOrdinePane = new FXMLLoader(
                    getClass().getResource("/azienda/view/iniziaOrdine.fxml")).load();
            this.rightPaneUser.getChildren().add(aggiuntaOrdinePane);
        } catch (Exception e) {
            this.view.showError(e.getMessage());
        }
    }
}

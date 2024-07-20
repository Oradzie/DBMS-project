package azienda.view;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import azienda.App;

import java.util.Objects;

public class MainView extends Application {

    private StartStage startStage;
    private AdminStage adminStage;
    private MagazziniereStage magazziniereStage;
    private UtenteStage utenteStage;

    public MainView() {
        this.startStage = null;
        this.adminStage = null;
        this.magazziniereStage = null;
        this.utenteStage = null;
    }

    @Override
    public void start(final Stage unusedStage) {
        App.CONTROLLER.setView(this);
        showStartView();
    }

    public void showError(final String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("An error happened");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public void showStartView() {
        this.startStage = new StartStage();
    }

    public void closeStartView() {
        if (!Objects.isNull(this.startStage)) {
            this.startStage.closeStage();
        } else {
            System.err.println("Start view is null");
        }

    }

    public void showAmministratorDashboard() {
        this.adminStage = new AdminStage();
    }

    public void showMagazziniereDashboard() {
        this.magazziniereStage = new MagazziniereStage();
    }

    public void showUtenteDashboard() {
        this.utenteStage = new UtenteStage();
    }

    public void closeAdminDashboard() {
        if (!Objects.isNull(this.adminStage)) {
            this.adminStage.closeStage();
        } else {
            System.err.println("Admin dashboard is null");
        }
    }

    public void closeMagazziniereDashboard() {
        if (!Objects.isNull(this.magazziniereStage)) {
            this.magazziniereStage.closeStage();
        } else {
            System.err.println("Magazziniere dashboard is null");
        }
    }

    public void closeUtenteDashboard() {
        if (!Objects.isNull(this.utenteStage)) {
            this.utenteStage.closeStage();
        } else {
            System.err.println("Utente dashboard is null");
        }
    }
}
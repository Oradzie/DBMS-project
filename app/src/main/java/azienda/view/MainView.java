package azienda.view;

import azienda.data.Prodotto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import azienda.App;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import azienda.controller.Controller;

public class MainView extends Application {

    private StartStage startStage;
    private AdminStage adminStage;

    public MainView() {
        this.startStage = null;
        this.adminStage = null;
    }

    @Override
    public void start(final Stage unusedStage) {
        App.CONTROLLER.setView(this);
        showStartView();
    }

    public void showError(String s) {
        System.err.println(s);
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

    public void showAmministratorDashboard(){
        this.adminStage = new AdminStage();
    }

    public void closeAdminBashboard() {
        if (!Objects.isNull(this.adminStage)) {
            this.adminStage.closeStage();
        } else {
            System.err.println("Admin dashboard is null");
        }
    }
}
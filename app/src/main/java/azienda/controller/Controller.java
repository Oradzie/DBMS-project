package azienda.controller;

import azienda.commons.DAOException;
import azienda.model.Model;
import azienda.view.MainView;

import java.util.Objects;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import org.mindrot.jbcrypt.BCrypt;

public final class Controller {

    private final Model model;
    private final MainView view;

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public Controller() {
        this.model = null;
        this.view = null;
    }

    public Controller(Model model, MainView view) {
        Objects.requireNonNull(model, "Controller created with null model");
        Objects.requireNonNull(view, "Controller created with null view");
        this.view = view;
        this.model = model;
    }

    public void userRequestedInitialPage() {
        Application.launch(MainView.class);
    }


}

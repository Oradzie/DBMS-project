package azienda.controller;

import azienda.commons.DAOException;
import azienda.data.Prodotto;
import azienda.model.DBModel;
import azienda.model.Model;
import azienda.view.MainView;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import org.mindrot.jbcrypt.BCrypt;

public final class Controller implements Initializable {

    private Model model;
    private MainView view;

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public void userRequestedInitialPage() {
        Application.launch(MainView.class);
    }

    public void userClickedPreview() {
        try {
            if (this.model != null) {
                final List<Prodotto> products = this.model.getProducts();
                this.view.showProducts(products);
            } else {
                this.view.showError("Model is null");

            }
        } catch (DAOException e) {
            this.view.showError("Error while loading products: " + e.getMessage());
        }
    }

    public final void setModel(final Model model) {
        this.model = model;
    }

    public final void setView(final MainView view) {
        this.view = view;
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

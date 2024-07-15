package azienda.controller;

import azienda.commons.DAOException;
import azienda.model.Model;
import java.util.Objects;
import azienda.view.MainView;
import javafx.application.Application;

public final class Controller {

    private final Model model;
    private final MainView view;

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

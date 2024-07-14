package azienda.controller;

import azienda.commons.DAOException;
import azienda.model.Model;
import java.util.Objects;
import azienda.view.MainView;

public final class Controller {

    private final Model model;
    private final MainView view;

    public Controller(Model model, MainView view) {
        Objects.requireNonNull(model, "Controller created with null model");
        Objects.requireNonNull(view, "Controller created with null view");
        this.view = view;
        this.model = model;
    }

    public void userRequestedInitialPage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userRequestedInitialPage'");
    }

}

package azienda.controller;

import db_lab.data.DAOException;
import db_lab.data.ProductPreview;
import db_lab.model.Model;
import java.util.Objects;

public final class Controller {

    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        Objects.requireNonNull(model, "Controller created with null model");
        Objects.requireNonNull(view, "Controller created with null view");
        this.view = view;
        this.model = model;
    }

}

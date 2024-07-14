package azienda;

import azienda.commons.DAOException;
import azienda.commons.DAOUtils;
import azienda.controller.Controller;
import azienda.model.Model;
import azienda.view.MainView;

import java.sql.SQLException;

public final class App {

    public static void main(String[] args) throws SQLException {
        var password = "cynryZ-9sydda-juzped";
        var connection = DAOUtils.localMySQLConnection("azienda", "root", password);
        var model = Model.fromConnection(connection);
        var view = new MainView(args);
        var controller = new Controller(model,view);
        view.setController(controller);
        controller.userRequestedInitialPage();
    }
}
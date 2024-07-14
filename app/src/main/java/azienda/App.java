package azienda;

import io.github.cdimascio.dotenv.Dotenv;
import azienda.commons.DAOException;
import azienda.commons.DAOUtils;
import azienda.controller.Controller;
import azienda.model.Model;
import azienda.view.MainView;

import java.sql.SQLException;

public final class App {

    public static void main(String[] args) throws SQLException {
        Dotenv dotenv = Dotenv.load();
        var password = dotenv.get("DB_PASSWORD");
        var database = dotenv.get("DB_NAME");
        var username = dotenv.get("DB_USERNAME");
        var connection = DAOUtils.localMySQLConnection(database, username, password);
        var model = Model.fromConnection(connection);
        var view = new MainView();
        var controller = new Controller(model,view);
        view.setController(controller);
        controller.userRequestedInitialPage();
    }
}

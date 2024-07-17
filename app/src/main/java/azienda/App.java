package azienda;

import io.github.cdimascio.dotenv.Dotenv;
import azienda.commons.DAOUtils;
import azienda.controller.Controller;
import azienda.model.Model;
import azienda.view.MainView;

import java.sql.Connection;
import java.sql.SQLException;

public final class App {

    public static final Controller CONTROLLER = new Controller();

    public static void main(String[] args) throws SQLException {
        Dotenv dotenv = Dotenv.load();
        final String password = dotenv.get("DB_PASSWORD");
        final String database = dotenv.get("DB_NAME");
        final String username = dotenv.get("DB_USERNAME");
        final Connection connection = DAOUtils.localMySQLConnection(database, username, password);
        final Model model = Model.fromConnection(connection);
        final MainView view = new MainView();
        CONTROLLER.setModel(model);
        CONTROLLER.setView(view);
        CONTROLLER.userRequestedInitialPage();
    }
}

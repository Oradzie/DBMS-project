package azienda;

import azienda.data.DAOException;
import azienda.data.DAOUtils;
import azienda.model.Model;
import java.sql.SQLException;

public final class App {

    public static void main(String[] args) throws SQLException {
        var password = "cynryZ-9sydda-juzped";
        var connection = DAOUtils.localMySQLConnection("azienda", "root", password);
        var model = Model.fromConnection(connection);
        var view = new View(() -> {
            try {
                connection.close();
            } catch (Exception e) {}
        });
        var controller = new Controller(model, view);
        view.setController(controller);
        controller.userRequestedInitialPage();
    }
}
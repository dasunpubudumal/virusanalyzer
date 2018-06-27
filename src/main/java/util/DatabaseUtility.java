package util;

import beans.VirusBean;
import config.DatabaseConfiguration;

import javax.swing.*;
import java.sql.*;

public class DatabaseUtility {

    public VirusBean getData(String hash) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

        VirusBean vb = new VirusBean();
        String query = "SELECT * FROM vx WHERE vx.vxMD5 = ?";

        Class.forName("org.h2.Driver");

        try {

            Connection connection = DriverManager.getConnection(DatabaseConfiguration.URL, DatabaseConfiguration.USERNAME, DatabaseConfiguration.PASSWORD);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, hash);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                JOptionPane.showInternalMessageDialog(null, "Virus Name: " + resultSet.getString("vxVirusName") + ".\nVirus Engine: "
                        + resultSet.getString("vxEngine") + ".\nVirus Type: " + resultSet.getString("vxType"));

            } else {
                JOptionPane.showMessageDialog(null, "Not found in the Database", "Not Found"
                , JOptionPane.WARNING_MESSAGE);
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return vb;
    }

}

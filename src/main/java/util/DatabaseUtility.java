package util;

import beans.VirusBean;
import config.DatabaseConfiguration;

import java.sql.*;

public class DatabaseUtility {

    public VirusBean getData(String hash) throws ClassNotFoundException {

        VirusBean vb = new VirusBean();
        String query = "SELECT * FROM vx WHERE vx.vxMD5 = ?";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try {

            Connection connection = DriverManager.getConnection(DatabaseConfiguration.URL, DatabaseConfiguration.USERNAME, DatabaseConfiguration.PASSWORD);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, hash);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            System.out.println("Virus Name: " + resultSet.getString("vxVirusName") + ".\nVirus Engine: "
            + resultSet.getString("vxEngine") + ".\nVirus Type: " + resultSet.getString("vxType"));

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return vb;
    }

}

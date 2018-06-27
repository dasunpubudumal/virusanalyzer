package util;
import com.kanishka.virustotal.dto.FileScanReport;
import com.kanishka.virustotal.dto.ScanInfo;
import com.kanishka.virustotal.dto.VirusScanInfo;
import com.kanishka.virustotal.exception.APIKeyNotFoundException;
import com.kanishka.virustotal.exception.QuotaExceededException;
import com.kanishka.virustotal.exception.UnauthorizedAccessException;
import com.kanishka.virustotalv2.VirusTotalConfig;
import com.kanishka.virustotalv2.VirustotalPublicV2;
import com.kanishka.virustotalv2.VirustotalPublicV2Impl;
import com.sun.deploy.net.BasicHttpRequest;
import com.sun.deploy.net.HttpRequest;
import config.DatabaseConfiguration;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseUtility {

    public void getData(String hash, File file) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException, APIKeyNotFoundException, UnauthorizedAccessException, IOException, QuotaExceededException {

        String query = "SELECT * FROM vx WHERE vx.vxSHA256 = ?";

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        try {

            Connection connection = DriverManager.getConnection(DatabaseConfiguration.URL, DatabaseConfiguration.USERNAME, DatabaseConfiguration.PASSWORD);

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, hash);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Virus Name: " + resultSet.getString("vxVirusName") + ".\nVirus Engine: "
                        + resultSet.getString("vxEngine") + ".\nVirus Type: " + resultSet.getString("vxType"));

            } else {

                System.out.println("Please wait while the API gathers your results....");

                VirusTotalConfig.getConfigInstance().setVirusTotalAPIKey(DatabaseConfiguration.API_KEY);
                VirustotalPublicV2 virusTotalRef = new VirustotalPublicV2Impl();

                ScanInfo scanInformation = virusTotalRef.scanFile(file);

                String resource = scanInformation.getResource();

                FileScanReport report = virusTotalRef.getScanReport(resource);

                Map<String, VirusScanInfo> scans = report.getScans();
                for (String key: scans.keySet()) {
                    VirusScanInfo virusInfo = scans.get(key);
                    System.out.println("Scanner : " + key);
                    System.out.println("\t\t Result : " + virusInfo.getResult());
                    System.out.println("\t\t Update : " + virusInfo.getUpdate());
                    System.out.println("\t\t Version :" + virusInfo.getVersion());
                }
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

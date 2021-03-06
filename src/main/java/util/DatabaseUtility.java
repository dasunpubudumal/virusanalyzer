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
                String result = "";
                int i = 0;

                JOptionPane.showMessageDialog(null, "Submitted file was not detected in our database. Let us check the VirusTotal API. Please wait a little while.");

                VirusTotalConfig.getConfigInstance().setVirusTotalAPIKey(DatabaseConfiguration.API_KEY);
                VirustotalPublicV2 virusTotalRef = new VirustotalPublicV2Impl();

                ScanInfo scanInformation = virusTotalRef.scanFile(file);

                String resource = scanInformation.getResource();

                FileScanReport report = virusTotalRef.getScanReport(resource);

                Map<String, VirusScanInfo> scans = report.getScans();

                for (String key: scans.keySet()) {
                    if(i < 5) {
                        VirusScanInfo virusInfo = scans.get(key);

                        result = result.concat("Scanner: " + key + "\n\t\t Result: " + virusInfo.getResult() + "\n\t\tUpdate: " + virusInfo.getUpdate() + "\n\t\tVersion: " + virusInfo.getVersion() + "\n");
                        i++;
                    } else {
                        break;
                    }
                }
                JOptionPane.showMessageDialog(null, result);

                result = "";
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

import com.kanishka.virustotal.exception.APIKeyNotFoundException;
import com.kanishka.virustotal.exception.QuotaExceededException;
import com.kanishka.virustotal.exception.UnauthorizedAccessException;
import com.mysql.cj.conf.DatabaseUrlContainer;
import util.DatabaseUtility;
import util.HashUtility;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class VirusAnalyzer {

    public static void main(String[] args) throws IOException, IllegalAccessException, SQLException, InstantiationException, APIKeyNotFoundException {

        HashUtility hashUtility = new HashUtility();

        DatabaseUtility databaseUtility = new DatabaseUtility();

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showDialog(null, "Choose File");
        File file = jFileChooser.getSelectedFile();

        try {
            databaseUtility.getData(hashUtility.hashFile(file), file);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (UnauthorizedAccessException e) {
            e.printStackTrace();
        } catch (QuotaExceededException e) {
            e.printStackTrace();
        }
    }

}

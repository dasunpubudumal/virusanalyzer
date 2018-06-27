import com.mysql.cj.conf.DatabaseUrlContainer;
import util.DatabaseUtility;
import util.HashUtility;

import java.io.IOException;

public class VirusAnalyzer {

    public static void main(String[] args) {

        HashUtility hashUtility = new HashUtility();
        try {
            hashUtility.hashFile("sample.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        DatabaseUtility databaseUtility = new DatabaseUtility();

        try {
            databaseUtility.getData("00f538c3d410822e241486ca061a57ee");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

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


    }

}

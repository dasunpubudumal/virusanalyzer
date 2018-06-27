package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class HashUtility {

    public String hashFile(String filename) throws IOException {

        String md5 = "";

        FileInputStream fis = new FileInputStream(new File(filename));

        try {
            md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fis.close();

        System.out.println("File hash: " + md5);

        return md5;
    }

}

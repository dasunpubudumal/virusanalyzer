package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class HashUtility {

    public String hashFile(File file) throws IOException {

        String md5 = "";

        FileInputStream fis = new FileInputStream(file);

        try {
            md5 = org.apache.commons.codec.digest.DigestUtils.sha256Hex(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fis.close();

        System.out.println("File hash: " + md5);

        return md5;
    }

}

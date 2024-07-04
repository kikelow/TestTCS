package org.testtcs.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PropertiesUtil {

    public static void salvarToken(String token){
        File file = new File("src/test/resources/token.txt");
        try (FileWriter fileWriter = new FileWriter(file)){

        fileWriter.write("TOKEN = " + token);
        fileWriter.flush();

            if (file.createNewFile()) {
                System.out.println("File created");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

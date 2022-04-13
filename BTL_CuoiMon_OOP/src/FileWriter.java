

import java.io.File;
import java.io.PrintWriter;

public class FileWriter {
    public static void write(String fileName, String s){
        File file = new File(fileName);
        try {
            PrintWriter out = new PrintWriter(file);
            out.println(file);
            out.close();
        } catch (Exception e) {
            System.out.println("File Không Hợp Lệ!!!");
        }
    }
}

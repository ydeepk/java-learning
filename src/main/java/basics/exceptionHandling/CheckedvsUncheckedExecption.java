package basics.exceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedvsUncheckedExecption {

    public static void main(String[] args) {

        readFile("MyFile.txt");

    }

    public static void readFile(String fileNameWithPath)  {

        try {
            FileReader reader = new FileReader(fileNameWithPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

package Catalog;
import Catalog.Exceptions.FileWritingException;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void writeUsingFileOutputStream(String text, String path) throws FileWritingException {
        try (FileOutputStream out = new FileOutputStream(path)) {
            out.write(text.getBytes());
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingFileOutputStream method", e);
        }
    }

    public static void writeUsingFileWriter(String text, String path) throws FileWritingException {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.append(text);
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingFileWriter method", e);
        }
    }


    public static void writeUsingBufferedOutputStream(String text, String path) throws FileWritingException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream(path))) {
            bufferedOutputStream.write(text.getBytes());
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingBufferedOutputStream method", e);
        }
    }
}

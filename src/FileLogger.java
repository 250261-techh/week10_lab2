
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger {
    public static void writeLog(String filename, String message) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(filename, true));
            writer.println(new Date() + ": " + message);
            System.out.println("Message written to buffer.");
            throw new RuntimeException("error");

        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
                System.out.println("Logger closed.");
            }
        }
    }

    public static void main(String[] args) {
        try {
            writeLog("log.txt", "Test");
        } catch (RuntimeException e) {
            System.out.println("Caught in main: " + e.getMessage());
        }
    }
}
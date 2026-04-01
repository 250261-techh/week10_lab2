import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentFileWriter {
    public static void main(String[] args) throws IOException {
        try(FileWriter writer = new FileWriter("students.txt")){

            writer.write("Ali Karimov 3.95 ComputerScience\n");
            writer.write("Vali Karimov 3.85 Economics\n");
            writer.write("Raxim Karimov 3.45 Mechatronics\n");
            writer.write("Jasur Karimov 3.35 CyberSecurity\n");
            writer.write("Botir Karimov 3.15 ComputerScience");
            System.out.println("File written succesfully");

    } catch (IOException e){
            System.out.println("Error occured");
        }
        File students = new File("students.txt");
        try(Scanner reader = new Scanner(students)){
            System.out.println("Name GPA Major");
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                System.out.println(line);
            }


        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}

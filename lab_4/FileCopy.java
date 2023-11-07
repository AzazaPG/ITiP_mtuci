import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "lab_4/source.txt";
        String destinationFile = "lab_4/destination.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Содержимое файла успешно скопировано.");
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}

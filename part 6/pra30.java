import java.io.*;

public class pra30 {
    public static void main(String[] args) {
        File sourceFile = new File("source.txt");
        File destinationFile = new File("destination.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Data copied successfully from source.txt to destination.txt");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

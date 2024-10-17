import java.io.*;

public class pra31 {

    public static void main(String[] args) {
        // Using BufferedReader and BufferedWriter for character stream
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            System.out.println("Enter some text (type 'exit' to finish):");
            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line);
                writer.newLine();  // Add a new line after each input
            }

            System.out.println("Data written to output.txt using character stream!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        // Using byte stream to read from the file
        try (FileInputStream fileInputStream = new FileInputStream("output.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("output_copy.txt")) {

            int byteData;
            while ((byteData = fileInputStream.read()) != -1) {
                fileOutputStream.write(byteData);  // Copying byte-by-byte from one file to another
            }

            System.out.println("Data copied to output_copy.txt using byte stream!");

        } catch (IOException e) {
            System.out.println("An error occurred during byte stream operations: " + e.getMessage());
        }
    }
}

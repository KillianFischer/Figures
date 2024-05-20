import java.io.*;
import java.util.Scanner;

public class PriceCalculation {
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

/*         File folder = new File("figures/CSV");
        File[] listOfFiles = folder.listFiles();
        

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        } */

        System.out.println("Do you want to [1]'view', [2]'change', or [3]'delete' the CSV data?");
        String action = scanner.nextLine();

        switch (action) {
            case "1":
                System.out.println("Which file do you want to view?");
                String viewFilename = scanner.nextLine();
                readCSV(viewFilename);
                break;
            case "2":
                System.out.println("Which file do you want to modify?");
                String changeFilename = scanner.nextLine();
                modifyCSV(changeFilename);
                break;
            case "3":
                System.out.println("Which file do you want to delete from?");
                String deleteFilename = scanner.nextLine();
                deleteMaterial(deleteFilename);
                break;
            default:
            System.out.println("Invalid input. Please enter '[1]view', '[2]change', or '[3]delete'.");
        }
    }
    

    public static void readCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error while reading the file: " + e.getMessage());
        }
    }

    public static void modifyCSV(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {  
            System.out.println("Enter the material and price to add (format: material;price):");
            String newEntry = scanner.nextLine();
            bw.newLine();  
            bw.write(newEntry);
            bw.flush();
            System.out.println("New entry added successfully.");
        } catch (IOException e) {
            System.err.println("Error while writing to the file: " + e.getMessage());
        }
    }

    public static void deleteMaterial(String filename) {
        try {
            System.out.println("Enter the material name to delete:");
            String materialToDelete = scanner.nextLine().trim().toLowerCase();

            File inputFile = new File(filename);
            File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String line;
                boolean found = false;

                while ((line = reader.readLine()) != null) {
                    
                    if (!line.trim().toLowerCase().startsWith(materialToDelete + ";")) {
                        writer.write(line + System.lineSeparator());
                    } else {
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Material not found.");
                } else {
                    System.out.println("Material deleted successfully.");
                }

                
                if (!inputFile.delete()) {
                    System.out.println("Could not delete the original file.");
                    return;
                }
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println("Could not rename the temp file.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error while modifying the file: " + e.getMessage());
        }
    }
}
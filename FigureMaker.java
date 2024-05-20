import java.io.*;
import java.util.Scanner;

public class FigureMaker {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        File filename = new File("CSV/figures.csv");

        System.out.println("Do you want to [1]'view', [2]'delete', or [3]'create' a new figure?");
        String action = scanner.nextLine();

        switch (action) {
            case "1":
                readCSV(filename);
                break;
            case "2":
                System.out.println("Which figure do you want to delete?");
                String figureToDelete = scanner.nextLine();
                deleteFigure(filename, figureToDelete);
                break;
            case "3":
                System.out.println("What type of figure do you want to create? [1] Circle, [2] Triangle, [3] Rectangle");
                String figureType = scanner.nextLine();
                createFigure(filename, figureType);
                break;
        }
    }

    private static void readCSV(File filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteFigure(File filename, String figureToDelete) {
        File tempFile = new File("CSV/temp.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(filename));
             PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().equals(figureToDelete)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            filename.delete();
            tempFile.renameTo(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFigure(File filename, String figureType) {
        String newFigure;
        switch (figureType) {
            case "1":
                System.out.println("Enter the radius of the circle:");
                double radius = scanner.nextDouble();
                scanner.nextLine(); // consume newline left-over
                newFigure = "Circle, " + radius;
                break;
            case "2":
                System.out.println("Enter the lengths of the sides of the triangle:");
                double side1 = scanner.nextDouble();
                double side2 = scanner.nextDouble();
                double side3 = scanner.nextDouble();
                scanner.nextLine(); // consume newline left-over
                newFigure = "Triangle, " + side1 + ", " + side2 + ", " + side3;
                break;
            case "3":
                System.out.println("Enter the height and width of the rectangle:");
                double height = scanner.nextDouble();
                double width = scanner.nextDouble();
                scanner.nextLine(); // consume newline left-over
                newFigure = "Rectangle, " + height + ", " + width;
                break;
            default:
                System.out.println("Invalid figure type.");
                return;
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
            pw.println(newFigure);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
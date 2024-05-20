import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import TwoDFigure.Circle;
import TwoDFigure.Rectangle;
import TwoDFigure.Triangle;
import Error.NegativeValueException;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        File filename = new File("CSV/figures.csv");

        boolean running = true;
        while (running) {
            System.out.println("Do you want to [1]'view', [2]'delete', [3]'create' a new figure, or [4]'end' the program?");
            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    List<String> figures = readCSV(filename);
                    System.out.println("Which figure do you want to calculate? Enter the number:");
                    int figureIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (figureIndex > 0 && figureIndex <= figures.size()) {
                        calculateFigure(figures.get(figureIndex - 1));
                    } else {
                        System.out.println("Invalid figure number.");
                    }
                    break;
                case "2":
                    figures = readCSV(filename);
                    System.out.println("Which figure do you want to delete? Enter the number:");
                    figureIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (figureIndex > 0 && figureIndex <= figures.size()) {
                        deleteFigure(filename, figures.get(figureIndex - 1));
                    } else {
                        System.out.println("Invalid figure number.");
                    }
                    break;
                case "3":
                    System.out.println("What type of figure do you want to create? [1] Circle, [2] Triangle, [3] Rectangle");
                    String figureType = scanner.nextLine();
                    createFigure(filename, figureType);
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid action.");
                    break;
            }
        }
    }

    private static void calculateFigure(String figureLine) {
        String[] figure = figureLine.split(",");
        switch (figure[0].trim()) {
            case "Circle":
                try {
                    Circle circle = new Circle(Double.parseDouble(figure[1].trim()));
                    System.out.println("The surface area of the circle is: " + circle.getSurface());
                } catch (NegativeValueException e) {
                    System.out.println("Invalid circle radius: " + e.getMessage());
                }
                break;
            case "Triangle":
                Triangle triangle = new Triangle(
                    Double.parseDouble(figure[1].trim()),
                    Double.parseDouble(figure[2].trim()),
                    Double.parseDouble(figure[3].trim())
                );
                System.out.println("The surface area of the triangle is: " + triangle.getSurface());
                break;
            case "Rectangle":
                Rectangle rectangle = new Rectangle(
                    Double.parseDouble(figure[1].trim()),
                    Double.parseDouble(figure[2].trim())
                );
                System.out.println("The surface area of the rectangle is: " + rectangle.getSurface());
                break;
            default:
                System.out.println("Unknown figure type.");
                break;
        }
    }

    public static List<String> readCSV(File filename) {
        List<String> figures = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                figures.add(line);
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return figures;
    }

    private static void deleteFigure(File filename, String figureLine) {
        File tempFile = new File("CSV/temp.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(filename));
             PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().equals(figureLine.trim())) {
                    pw.println(line);
                    pw.flush();
                }
            }
            if (filename.delete()) {
                tempFile.renameTo(filename);
                System.out.println("Figure deleted successfully.");
            } else {
                System.out.println("Failed to delete the figure.");
            }
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
                scanner.nextLine();
                newFigure = "Circle, " + radius;
                break;
            case "2":
                System.out.println("Enter the lengths of the sides of the triangle:");
                double side1 = scanner.nextDouble();
                double side2 = scanner.nextDouble();
                double side3 = scanner.nextDouble();
                scanner.nextLine();
                newFigure = "Triangle, " + side1 + ", " + side2 + ", " + side3;
                break;
            case "3":
                System.out.println("Enter the height and width of the rectangle:");
                double height = scanner.nextDouble();
                double width = scanner.nextDouble();
                scanner.nextLine();
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

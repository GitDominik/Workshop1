package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;

public class TaskManager {
    static final String FILE_NAME = "tasks.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        printOptions(OPTIONS);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            switch (input) {
                case "exit":
                    break;
                case "add":
                    break;
                case "remove":
                    break;
                case "list":
                    printUpload(upload(FILE_NAME));
                    break;
                default:
                    System.out.println("Please select a correct option.");
            }
            printOptions(OPTIONS);
        }
    }

    public static void printOptions(String[] options) throws IOException {
        System.out.println(ConsoleColors.BLUE);
        System.out.println("Please select an option from list:" + ConsoleColors.RESET);


        for (String s : options) {
            System.out.println(s);

        }
    }

    public static String[][] upload(String fileName) throws IOException {
        Path pathFileTasks = Paths.get(fileName);

        Scanner scan = new Scanner(pathFileTasks);

        if (!Files.exists(pathFileTasks)) {
            System.out.println("File does not exist");
        }
        long rows = Files.lines(pathFileTasks).count();
        String[][] tab = new String[(int) rows][3];

        while (scan.hasNextLine()) {
            for (int i = 0; i < tab.length; i++) {
                String[] line = scan.nextLine().trim().split(",");
                for (int j = 0; j < line.length; j++) {
                    tab[i][j] = line[j];

                }
            }
        }
        return tab;
    }

    public static void printUpload(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
package org.example;

import org.example.mp3manager.Mp3File;
import org.example.mp3manager.SimpleArrayList;

import java.io.File;
import java.util.Scanner;

public class MyMP3Files {

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.println("Enter the directory name of the MP3 files:");
        String directory = key.nextLine().trim();

        File folder = new File(directory);
        File[] list = folder.listFiles();

        if (list == null) {
            System.out.println("Directory not found or not accessible.");
            return;
        }

        SimpleArrayList<Mp3File> mp3List = new SimpleArrayList<>();

        for (File f : list) {
            if (f.getAbsolutePath().toLowerCase().endsWith(".mp3")) {
                mp3List.add(new Mp3File(f.getAbsolutePath()));
            }
        }

        if (mp3List.isEmpty()) {
            System.out.println("No mp3 files found in this directory.");
            return;
        }

        System.out.println("Found " + mp3List.size() + " mp3 files.\n");
        printHelp();

        int index = 0;

        while (true) {
            Mp3File current = mp3List.get(index);
            System.out.println();
            System.out.println("Current file (" + (index + 1) + "/" + mp3List.size() + "):");
            System.out.println(current.toString());
            System.out.println();

            System.out.println("Enter command:");
            String input = key.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            char letter = Character.toLowerCase(input.charAt(0));

            switch (letter) {
                case 'n':
                    if (index == mp3List.size() - 1) {
                        System.out.println("end of the list");
                    } else {
                        index++;
                    }
                    break;

                case 'b':
                    if (index == 0) {
                        System.out.println("top of the list");
                    } else {
                        index--;
                    }
                    break;

                case 'i':
                    System.out.println(current.toString());
                    System.out.println(current.getPath());
                    break;

                case 'p':
                    current.play();
                    break;

                case 'h':
                    printHelp();
                    break;

                case 'q':
                    System.out.println("Quitting.");
                    return;

                default:
                    System.out.println("Unknown command. Enter 'h' for help.");
            }
        }
    }

    private static void printHelp() {
        System.out.println("Enter n to move to the next file");
        System.out.println("Enter b to move to the previous file");
        System.out.println("Enter i to print information about the current file");
        System.out.println("Enter p to play the current file");
        System.out.println("Enter h for help");
        System.out.println("Enter q to quit the program");
        System.out.println();
    }
}

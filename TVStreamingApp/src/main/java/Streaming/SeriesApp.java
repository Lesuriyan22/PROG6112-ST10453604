/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Streaming;

import java.util.Scanner;

public class SeriesApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Series seriesManager = new Series();
        boolean exit = false;

        while (!exit) {
            System.out.println("LATEST SERIES - 2025");
            System.out.println("*********");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String choice = sc.nextLine();

            if (!choice.equals("1")) {
                System.out.println("Exiting application...");
                break;
            }

            boolean backToMenu = false;

            while (!backToMenu) {
                System.out.println("\nPlease select one of the following menu items:");
                System.out.println("(1) Capture a new series.");
                System.out.println("(2) Search for a series.");
                System.out.println("(3) Update series age restriction.");
                System.out.println("(4) Delete a series.");
                System.out.println("(5) Print series report - 2025");
                System.out.println("(6) Exit Application.");
                System.out.print("Enter your choice: ");
                String menuChoice = sc.nextLine();

                switch (menuChoice) {
                    case "1": // Capture a new series
                        System.out.print("Enter the series id: ");
                        String id = sc.nextLine();
                        System.out.print("Enter the series name: ");
                        String name = sc.nextLine();

                        String age;
                        while (true) {
                            System.out.print("Enter the series age restriction (2-18): ");
                            age = sc.nextLine();
                            if (seriesManager.isNumeric(age)) break;
                            System.out.println("You have entered an incorrect series age! Please re-enter.");
                        }

                        System.out.print("Enter the number of episodes: ");
                        String episodes = sc.nextLine();

                        seriesManager.addSeriesModel(new SeriesModel(id, name, age, episodes));
                        System.out.println("Series processed successfully!!!");
                        break;

                    case "2": // Search for a series
                        System.out.print("Enter the series id to search: ");
                        String searchId = sc.nextLine();
                        SeriesModel found = seriesManager.findById(searchId);
                        if (found != null) {
                            System.out.println("SERIES ID: " + found.SeriesId);
                            System.out.println("SERIES NAME: " + found.SeriesName);
                            System.out.println("SERIES AGE RESTRICTION: " + found.SeriesAge);
                            System.out.println("SERIES NUMBER OF EPISODES: " + found.SeriesNumberOfEpisodes);
                        } else {
                            System.out.println("Series with Series Id: " + searchId + " was not found!");
                        }
                        break;

                    case "3": // Update series
                        System.out.print("Enter the series id to update: ");
                        String updateId = sc.nextLine();
                        SeriesModel updateSeries = seriesManager.findById(updateId);
                        if (updateSeries != null) {
                            System.out.print("Enter the new series name: ");
                            String newName = sc.nextLine();

                            String newAge;
                            while (true) {
                                System.out.print("Enter the new age restriction (2-18): ");
                                newAge = sc.nextLine();
                                if (seriesManager.isNumeric(newAge)) break;
                                System.out.println("You have entered an incorrect series age! Please re-enter.");
                            }

                            System.out.print("Enter the new number of episodes: ");
                            String newEpisodes = sc.nextLine();

                            seriesManager.updateSeries(updateId, newName, newAge, newEpisodes);
                            System.out.println("Series updated successfully!");
                        } else {
                            System.out.println("Series with Series Id: " + updateId + " was not found!");
                        }
                        break;

                    case "4": // Delete series
                        System.out.print("Enter the series id to delete: ");
                        String deleteId = sc.nextLine();
                        SeriesModel delSeries = seriesManager.findById(deleteId);
                        if (delSeries != null) {
                            System.out.print("Are you sure you want to delete series " + deleteId + " from the system? Yes (y) to delete: ");
                            String confirm = sc.nextLine();
                            if (confirm.equalsIgnoreCase("y")) {
                                seriesManager.deleteById(deleteId);
                                System.out.println("Series with Series Id: " + deleteId + " WAS deleted!");
                            } else {
                                System.out.println("Deletion cancelled.");
                            }
                        } else {
                            System.out.println("Series with Series Id: " + deleteId + " was not found!");
                        }
                        break;

                    case "5": // Print series report
                        seriesManager.printSeriesReport();
                        break;

                    case "6": // Exit
                        backToMenu = true;
                        exit = true;
                        System.out.println("Exiting application...");
                        break;

                    default:
                        System.out.println("Invalid option, please try again.");
                }

                if (!menuChoice.equals("6")) {
                    System.out.println("\nEnter (1) to launch menu or any other key to exit.");
                    String continueChoice = sc.nextLine();
                    if (!continueChoice.equals("1")) {
                        backToMenu = true;
                        exit = true;
                        System.out.println("Exiting application...");
                    }
                }
            }
        }

        sc.close();
    }
}
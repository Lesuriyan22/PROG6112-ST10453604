/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Streaming;

import java.util.ArrayList;

public class Series {

    private ArrayList<SeriesModel> seriesList;

    public Series() {
        seriesList = new ArrayList<>();
    }

    // Add a new series
    public void addSeriesModel(SeriesModel s) {
        seriesList.add(s);
    }

    // Find a series by ID
    public SeriesModel findById(String seriesId) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(seriesId)) {
                return s;
            }
        }
        return null;
    }

    // Update a series by ID
    public boolean updateSeries(String seriesId, String newName, String newAge, String newEpisodes) {
        SeriesModel s = findById(seriesId);
        if (s != null) {
            s.SeriesName = newName;
            s.SeriesAge = newAge;
            s.SeriesNumberOfEpisodes = newEpisodes;
            return true;
        }
        return false;
    }

    // Delete a series by ID
    public boolean deleteById(String seriesId) {
        SeriesModel s = findById(seriesId);
        if (s != null) {
            seriesList.remove(s);
            return true;
        }
        return false;
    }

    // Print all series
    public void printSeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
            return;
        }
        int count = 1;
        for (SeriesModel s : seriesList) {
            System.out.println("Series " + count);
            System.out.println("SERIES ID: " + s.SeriesId);
            System.out.println("SERIES NAME: " + s.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + s.SeriesAge);
            System.out.println("NUMBER OF EPISODES: " + s.SeriesNumberOfEpisodes);
            System.out.println();
            count++;
        }
    }

    // Check if age input is numeric and valid (2-18)
    public boolean isNumeric(String str) {
        try {
            int age = Integer.parseInt(str);
            return age >= 2 && age <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CSVDataProcessor {
    private String[][] data;

    public void loadData(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            // Count the number of lines in the file
            long lineCount = br.lines().count();
            data = new String[(int) lineCount][];

            // Read and process each line of the CSV file
            String line;
            int rowIndex = 0;

            br.close(); // Automatically closed by try-with-resources

            BufferedReader br2 = new BufferedReader(new FileReader(filepath)); // Create a new reader

            while ((line = br2.readLine()) != null) {
                String[] fields = line.split(",");
                data[rowIndex] = fields;
                rowIndex++;
            }
            System.out.println("CSV data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    public void calculateMonthlyTotal(String month, String year) {
        System.out.println("Calculating monthly total for month: " + month + ", year: " + year);
        double exportTotal = 0.0;
        double importTotal = 0.0;

        for (String[] row : data) {
            String rowMonth = row[2]; // Month is at index 2
            String rowYear = row[1]; // Year is at index 1
            double exportValue = Double.parseDouble(row[8]); // Export value is at index 8
            double importValue = Double.parseDouble(row[9]); // Import value is at index 9

            if (rowMonth.equalsIgnoreCase(month) && rowYear.equalsIgnoreCase(year)) {
                exportTotal += exportValue;
                importTotal += importValue;
            }
        }

        System.out.println("Monthly Total for " + month + " " + year);
        System.out.println("Exports: " + exportTotal);
        System.out.println("Imports: " + importTotal);
    }

    public void calculateMonthlyAverage(String month, String year) {
        int count = 0;
        double exportTotal = 0.0;
        double importTotal = 0.0;

        for (String[] row : data) {
            String rowMonth = row[2]; // Month is at index 2
            String rowYear = row[1]; // Year is at index 1
            double exportValue = Double.parseDouble(row[8]); // Export value is at index 8
            double importValue = Double.parseDouble(row[9]); // Import value is at index 9

            if (rowMonth.equalsIgnoreCase(month) && rowYear.equalsIgnoreCase(year)) {
                count++;
                exportTotal += exportValue;
                importTotal += importValue;
            }
        }
        double exportAverage = count > 0 ? exportTotal / count : 0.0;
        double importAverage = count > 0 ? importTotal / count : 0.0;

        System.out.println("Monthly Average for " + month + " " + year);
        System.out.println("Exports: " + exportAverage);
        System.out.println("Imports: " + importAverage);
    }

    public void calculateYearlyTotal(String year) {
        double[] monthlyExportTotals = new double[12];
        double[] monthlyImportTotals = new double[12];

        for (String[] row : data) {
            String rowYear = row[1]; // Year is at index 1
            double exportValue = Double.parseDouble(row[8]); // Export value is at index 8
            double importValue = Double.parseDouble(row[9]); // Import value is at index 9

            if (rowYear.equalsIgnoreCase(year)) {
                int monthIndex = Integer.parseInt(row[2]) - 1; // Month is at index 2
                monthlyExportTotals[monthIndex] += exportValue;
                monthlyImportTotals[monthIndex] += importValue;
            }
        }

        double yearlyExportTotal = 0.0;
        double yearlyImportTotal = 0.0;

        for (int i = 0; i < 12; i++) {
            yearlyExportTotal += monthlyExportTotals[i];
            yearlyImportTotal += monthlyImportTotals[i];
        }

        System.out.println("Yearly Total for " + year);

        for (int i = 0; i < 12; i++) {
            String month = getMonthName(i + 1);
            System.out.println(month + ":");
            System.out.println("Exports: " + monthlyExportTotals[i]);
            System.out.println("Imports: " + monthlyImportTotals[i]);
            System.out.println();
        }

        System.out.println("Yearly Total:");
        System.out.println("Exports: " + yearlyExportTotal);
        System.out.println("Imports: " + yearlyImportTotal);
    }

    public void calculateYearlyAverage(String year) {
        double[] monthlyExportTotals = new double[12];
        double[] monthlyImportTotals = new double[12];
        double yearlyExportTotal = 0.0;
        double yearlyImportTotal = 0.0;
        int[] monthlyCounts = new int[12];
        int yearlyCount = 0;

        for (String[] row : data) {
            String rowYear = row[1]; // Year is at index 1
            double exportValue = Double.parseDouble(row[8]); // Export value is at index 8
            double importValue = Double.parseDouble(row[9]); // Import value is at index 9

            if (rowYear.equalsIgnoreCase(year)) {
                int monthIndex = Integer.parseInt(row[2]) - 1; // Month is at index 2
                monthlyExportTotals[monthIndex] += exportValue;
                monthlyImportTotals[monthIndex] += importValue;
                yearlyExportTotal += exportValue;
                yearlyImportTotal += importValue;
                monthlyCounts[monthIndex]++;
                yearlyCount++;
            }
        }
        System.out.println("Yearly Average for " + year);

        for (int i = 0; i < 12; i++) {
            String month = getMonthName(i + 1);
            double monthlyExportAverage = monthlyCounts[i] > 0 ? monthlyExportTotals[i] / monthlyCounts[i] : 0.0;
            double monthlyImportAverage = monthlyCounts[i] > 0 ? monthlyImportTotals[i] / monthlyCounts[i] : 0.0;

            System.out.println(month + ":");
            System.out.println("Exports: " + monthlyExportAverage);
            System.out.println("Imports: " + monthlyImportAverage);
            System.out.println();
        }
        double yearlyExportAverage = yearlyCount > 0 ? yearlyExportTotal / yearlyCount : 0.0;
        double yearlyImportAverage = yearlyCount > 0 ? yearlyImportTotal / yearlyCount : 0.0;

        System.out.println("Yearly Average: ");
        System.out.println("Exports: " + yearlyExportAverage);
        System.out.println("Imports: " + yearlyImportAverage);
    }

    public void displayOverview() {
        Set<String> uniqueYears = new HashSet<>();
        Set<String> uniqueCountries = new HashSet<>();
        Set<String> uniqueCommodities = new HashSet<>();
        Set<String> uniqueTransportModes = new HashSet<>();
        Set<String> uniqueMeasures = new HashSet<>();

        for (String[] row : data) {
            uniqueYears.add(row[1]); // Year is at index 1
            uniqueCountries.add(row[4]); // Country is at index 4
            uniqueCommodities.add(row[5]); // Commodity is at index 5
            uniqueTransportModes.add(row[6]); // Transport mode is at index 6
            uniqueMeasures.add(row[7]); // Measure is at index 7
        }
        System.out.println("Overview");
        System.out.println("Years: " + uniqueYears);
        System.out.println("Countries: " + uniqueCountries);
        System.out.println("Commodities: " + uniqueCommodities);
        System.out.println("Transport Modes: " + uniqueTransportModes);
        System.out.println("Measures: " + uniqueMeasures);
    }

    private String getMonthName(int month) {
        // Adjust month name based on your requirements
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }
}

package org.example;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private final Map<String, String> commandDescriptions;

    public CommandHandler() {
        commandDescriptions = new HashMap<>();
        commandDescriptions.put("help", "Displays a list of available commands with a small description.");
        commandDescriptions.put("help <command>", "Returns a full explanation of the specified command and its parameters.");
        commandDescriptions.put("monthly_total", "Returns the sum of exports and imports for a specified month and year.");
        commandDescriptions.put("monthly_average", "Returns the average of exports and imports for a specified month and year.");
        commandDescriptions.put("yearly_total", "Returns an overview of monthly totals for a particular year.");
        commandDescriptions.put("yearly_average", "Returns an overview of monthly averages for a particular year.");
        commandDescriptions.put("overview", "Returns all unique values in the dataset: years, countries, commodities, transportation modes, and measures.");
    }

    public void executeCommand(String command, String[] parameters, CSVDataProcessor dataProcessor) {
        switch (command) {
            case "help":
                displayHelp();
                break;
            case "monthly_total":
                String monthMT = parameters[0];
                String yearMT = parameters[1];
                dataProcessor.calculateMonthlyTotal(monthMT, yearMT);
                break;
            case "monthly_average":
                String monthMA = parameters[0];
                String yearMA = parameters[1];
                dataProcessor.calculateMonthlyAverage(monthMA, yearMA);
                break;
            case "yearly_total":
                String yearYT = parameters[0];
                dataProcessor.calculateYearlyTotal(yearYT);
                break;
            case "yearly_average":
                String yearYA = parameters[0];
                dataProcessor.calculateYearlyAverage(yearYA);
                break;
            case "overview":
                dataProcessor.displayOverview();
                break;
            default:
                if (command.startsWith("help ")) {
                    String specificCommand = command.substring(5);
                    displayCommandExplanation(specificCommand);
                } else {
                    System.out.println("Command not found: " + command);
                }
        }
    }

    private void displayHelp() {
        for (String command : commandDescriptions.keySet()) {
            System.out.println(command + ": " + commandDescriptions.get(command));
        }
    }

    private void displayCommandExplanation(String command) {
        String description = commandDescriptions.get(command);
        if (description != null) {
            System.out.println(command + ": " + description);
        } else {
            System.out.println("Command not found: " + command);
        }
    }
}

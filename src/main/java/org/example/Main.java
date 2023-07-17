package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        CSVDataProcessor dataProcessor = new CSVDataProcessor();
        CommandHandler commandHandler = new CommandHandler();
        Scanner scanner = new Scanner(System.in);

        //Load CSV data
        System.out.print("Enter the path to the CSV file: ");
        String filePath = scanner.nextLine();
        dataProcessor.loadData(filePath);

        //Command loop
        while (true){
            System.out.print("Enter a command (or 'exit' to quit): ");
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("exit")){
                break;
            }
            String[] parts = input.split(" ",2);
            String command = parts[0];
            String[] parameters = parts.length > 1 ? parts[1].split(" "): new String[0];

            commandHandler.executeCommand(command, parameters, dataProcessor);
        }

        scanner.close();
    }
}

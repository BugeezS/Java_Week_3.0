package org.example;

class CSVDataAnalyzer {
    private CommandHandler commandHandler;
    private CSVDataProcessor dataProcessor;

    public CSVDataAnalyzer(){
        commandHandler = new CommandHandler();
        dataProcessor = new CSVDataProcessor();
    }
    public void processCommand(String command, String[] parameters){
        commandHandler.executeCommand(command, parameters, dataProcessor);
    }
    public void loadCSVData(String filepath) {
        dataProcessor.loadData(filepath);
    }
    public static void  main(String[] args){
        if(args.length > 0){
            String filePath = args[0];
            CSVDataAnalyzer dataAnalyzer = new CSVDataAnalyzer();
            dataAnalyzer.loadCSVData(filePath);

            String command = "monthly_total";
            String[] parameters = {"July","2021"};

            dataAnalyzer.processCommand(command, parameters);
        }else {
            System.out.println("Please provide the path to the CSV file as a command-line argument");
        }
    }
}

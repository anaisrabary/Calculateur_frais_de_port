package com.fredericboisguerin.insa;

import java.util.Scanner;

public class ShippingConsoleUI {
    private PackageFactory factory ;
    private ShippingCostsCalculator costsCalculator;
    private Scanner scan ;


    public ShippingConsoleUI(PackageFactory factory, ShippingCostsCalculator costsCalculator){
        this.factory = factory;
        this.costsCalculator = costsCalculator;
    }


    public void run(){
        System.out.println("******************************************************");
        System.out.println("****** WELCOME IN THE SHIPPING COST CALCULATOR********");
        System.out.println("******************************************************");
        System.out.println();

        scan = new Scanner(System.in);
        String command;

        printTexteWelcome();


        do {
            System.out.print("=>");
            command= scan.nextLine().toLowerCase().trim();
            executeCommande(command);
        }while (!command.toLowerCase().trim().equals("exit"));


        scan.close();

        System.out.println("******************************************************");
        System.out.println("******                 BYE                    ********");
        System.out.println("******************************************************");
        System.out.println();

    }

    private void  printTexteWelcome(){
        System.out.println(
                " Please tell me what you want to do : \n" +
                        "1. Evaluate the shipping cost of a package you want to send (cost)\n" +
                        "2. Exit the shipping calculator (exit)\n");
        System.out.println("Authorized Command : cost | exit \n");
    }


    private void executeCommande(String commande){
        //Commandes : cost | exit
        switch (commande){
            case "cost":
                Package pack = evaluatePackageDescription();
                System.out.println("\n That is the pack information you gave.");
                System.out.println(pack);
                System.out.println("Enter the Shipping destination : FR for France, MC for Monaco, DT for DOM/TOM");
                String dest = scan.nextLine();
                double calculatedcost = costsCalculator.calculateShippingCost(pack, Destination.valueOf(dest));
                System.out.printf("This is the shipping cost you will have to pay :  %.2f € \n", calculatedcost);
                break;
            case "exit":
                break;
            default:
                System.out.printf("ERROR : Command not found (\"%s\")", commande);
                System.out.println("Commands : cost | exit \n");
        }
    }

    private Package evaluatePackageDescription(){
        System.out.println("Enter the package height (X.X)");
        int height = Integer.parseInt(scan.nextLine());

        System.out.println("Enter the package width (X.X)");
        int width = Integer.parseInt(scan.nextLine());

        System.out.println("Enter the package depth (X.X)");
        int depth = Integer.parseInt(scan.nextLine());

        System.out.println("Enter the package weight (X.X)");
        double weight = Double.parseDouble(scan.nextLine());

        return factory.createPackage(height,width,depth,weight);

    }

}

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
        boolean exit= false ;

        switch (commande){
            case "cost":
                String check ;
                String dest = "";
                Package pack= null;
                do {
                    System.out.println("Enter the package height (X.X)");
                    String sheight = scan.nextLine();
                    if (sheight.equals("exit")) {
                        exit = true;
                        break ;
                    }
                    int height = Integer.parseInt(sheight);

                    System.out.println("Enter the package width (X.X)");
                    String swidth = scan.nextLine();
                    if (swidth.equals("exit")) {
                        exit = true;
                        break;
                    }
                    int width = Integer.parseInt(swidth);

                    System.out.println("Enter the package depth (X.X)");
                    String sdepth = scan.nextLine();
                    if (sdepth.equals("exit")) {
                        exit = true;
                        break;
                    }
                    int depth = Integer.parseInt(sdepth);

                    System.out.println("Enter the package weight (X.X)");
                    String sweight = scan.nextLine();
                    if (sheight.equals("exit")) {
                        exit = true;
                        break ;
                    }
                    double weight = Double.parseDouble(sweight);
                    pack = factory.createPackage(height,width,depth,weight);

                    System.out.println("Enter the Shipping destination : FR for France, MC for Monaco, DT for DOM/TOM");
                    dest = scan.nextLine();
                    if (dest.equals("exit")) {
                        exit = true;
                        break;
                    }
                    System.out.println("\n That is the pack information you gave.");
                    System.out.println(pack);
                    System.out.println(dest);
                    System.out.println("Are those information correct ? (yes|no|exit)");
                    check = scan.nextLine().toLowerCase().trim();
                } while(!check.equals("yes"));
                if (exit) break ;
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

}

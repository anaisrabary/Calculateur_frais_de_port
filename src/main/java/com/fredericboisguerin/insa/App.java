package com.fredericboisguerin.insa;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        new ShippingConsoleUI(PackageFactory.createInstance(), ShippingCostsCalculator.createInstance()).run();
    }
}

package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.MathContext;

import static com.fredericboisguerin.insa.Destination.MC;
import static java.math.RoundingMode.HALF_EVEN;


public class ShippingCostsCalculator {

 private static final double PERCENTAGE_INCREASE_MONACO = 0.087 ;
 private static ShippingCostsCalculator instance;

 private ShippingCostsCalculator() {
 }

 public static ShippingCostsCalculator Create_Instance(){
     if (instance == null)
         instance = new ShippingCostsCalculator();
     return instance;
 }

 public double calculateShippingCost (Package pack, Destination dest){
     return new BigDecimal(pack.calculateLocalShippingCost())
                .add(calculate_Increase_Cost_Destination(dest,pack.calculateLocalShippingCost()))
                .setScale(2,HALF_EVEN).doubleValue();
    }

    public BigDecimal calculate_Increase_Cost_Destination (Destination dest, double cost){
        if (dest == MC)
            return new BigDecimal(PERCENTAGE_INCREASE_MONACO*cost,new MathContext(4,HALF_EVEN) ) ;

        return BigDecimal.ZERO ;

    }


}

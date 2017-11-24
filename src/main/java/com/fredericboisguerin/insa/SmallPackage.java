package com.fredericboisguerin.insa;

import static com.fredericboisguerin.insa.ShippingCostsCalculator.COST_SMALL_PACKAGE;

public class SmallPackage extends Package{


    public SmallPackage(int height, int width, int depth, double weight ){
        super(height,width,depth,weight);
    }

    public double calculateLocalShippingCost(){
        return COST_SMALL_PACKAGE;
    }

}

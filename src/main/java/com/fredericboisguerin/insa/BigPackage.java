package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.MathContext;

import static com.fredericboisguerin.insa.ShippingCostsCalculator.UNIT_COST_BIG_VOLUM;
import static com.fredericboisguerin.insa.ShippingCostsCalculator.UNIT_COST_BIG_WEIGHT;
import static java.math.RoundingMode.HALF_EVEN;

public class BigPackage extends Package {

    private double weightRate;
    private double volumeRate;

    public BigPackage(int height, int width, int depth, double weight ){
        super(height,width,depth,weight);
        weightRate = weight*UNIT_COST_BIG_WEIGHT ;
        volumeRate = calculateVolume()*UNIT_COST_BIG_VOLUM/ Math.pow(10.0,6.0) ;
    }
    public double calculateLocalShippingCost(){
        return new BigDecimal(
                Math.max(this.weightRate,this.volumeRate)).setScale(4,HALF_EVEN)
                .doubleValue();

    }
}

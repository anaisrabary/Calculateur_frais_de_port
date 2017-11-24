package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.MathContext;

import static com.fredericboisguerin.insa.ShippingCostsCalculator.STATIC_FEE_MEDIUM_WEIGHT;
import static com.fredericboisguerin.insa.ShippingCostsCalculator.UNIT_COST_MIDIUM_WEIGHT;
import static java.math.RoundingMode.HALF_EVEN;

public class MediumPackage extends Package{

    private double weightRate;

    public MediumPackage(int height, int width, int depth, double weight ){
        super(height,width,depth,weight);
        this.weightRate = weight*UNIT_COST_MIDIUM_WEIGHT;
    }

    public double calculateLocalShippingCost(){
        return new BigDecimal(
                this.weightRate+ STATIC_FEE_MEDIUM_WEIGHT,
                new MathContext(4,HALF_EVEN))
                .doubleValue();

    }
}

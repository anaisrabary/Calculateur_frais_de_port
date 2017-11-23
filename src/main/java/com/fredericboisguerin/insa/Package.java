package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.RoundingMode.HALF_EVEN;

public class Package {
    public static final double COST_SMALL_PACKAGE = 12 ;
    public static final double UNIT_COST_MIDIUM_WEIGHT = 17.59;
    public static final double STATIC_FEE_MEDIUM_WEIGHT = 2.86;
    public static final double UNIT_COST_BIG_WEIGHT =21.62;
    public static final double UNIT_COST_BIG_VOLUM= 1.43;

    private int height ;
    private int width ;
    private int depth ;
    private double weight;

    public Package(int height, int width, int depth, double weight) {
        this.height = height;
        this.width = width;
        this.depth = depth ;
        this.weight = weight;

    }

    public double calculateLocalShippingCost(){

        double result ;
        if ((height <= 229 && width <= 162) || (width <= 229 && height <= 162) && depth <= 25)
           return COST_SMALL_PACKAGE;
        else
        {
            if (weight <= 1.8)
                return new BigDecimal(
                        (weight*UNIT_COST_MIDIUM_WEIGHT)+ STATIC_FEE_MEDIUM_WEIGHT,
                        new MathContext(4,HALF_EVEN))
                        .doubleValue();
            else
                return new BigDecimal(
                        Math.max((weight*UNIT_COST_BIG_WEIGHT) ,
                                (calculateVolum()*UNIT_COST_BIG_VOLUM / Math.pow(10.0,6.0))),
                        new MathContext(4,HALF_EVEN))
                        .doubleValue();
        }

    }


    private double calculateVolum(){
        return height*width*depth ;
    }

}
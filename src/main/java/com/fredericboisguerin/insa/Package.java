package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.RoundingMode.HALF_EVEN;

public class Package {
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
            result = 12.00 ;
        else
        {
            if (weight <= 1.8)
                result= (weight*17.59)+2.86 ;
            else result = ((weight*21.62) + (calculateVolum()*1.43 / Math.pow(10.0,6.0))) ;
        }
        return new BigDecimal(result,new MathContext(4,HALF_EVEN)).doubleValue();

    }


    private double calculateVolum(){
        return height*width*depth ;
    }

}
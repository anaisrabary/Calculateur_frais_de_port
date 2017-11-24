package com.fredericboisguerin.insa;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.RoundingMode.HALF_EVEN;

public abstract class Package {



    private int height ;
    private int width ;
    private int depth ;
    private double weight;

    public Package(int height, int width, int depth, double weight) {
        System.out.println("Constructing a package");
        this.height = height;
        this.width = width;
        this.depth = depth ;
        this.weight = weight;

    }

    public abstract double calculateLocalShippingCost();


    public double calculateVolume(){
        return height*width*depth ;
    }

    private double getWeight(){ return this.weight; }

}
package com.fredericboisguerin.insa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PackageFactory {
    private static final int DEPTH_LIMIT = 25;
    private static final int LIMIT_1 = 162;
    private static final int LIMIT_2 = 229;
    private static final double WEIGHT_LIMIT = 1.8;

    private static PackageFactory instance;

    private PackageFactory() {
    }

    public static PackageFactory createInstance(){
        if (instance == null)
            instance = new PackageFactory();
        return instance;
    }

    public Package createPackage(int height, int width, int depth, double weight) {
        if (hasLittleDimension(height, width,depth)) {
            return new SmallPackage(height, width, depth, weight);
        } else if (weight <= 1.8) {
            return new MediumPackage(height, width, depth, weight);
        } else {
            return new BigPackage(height, width, depth, weight);
        }
    }

    private boolean hasLittleDimension(int height, int width, int depth){
        List<Integer> dim = new ArrayList<Integer>() ;
        dim.add(height);
        dim.add(width);
        dim.add(depth);
        Collections.sort(dim);
        return dim.get(0)<= DEPTH_LIMIT && dim.get(1)<= LIMIT_1 && dim.get(2)<= LIMIT_2 ;
    }
}
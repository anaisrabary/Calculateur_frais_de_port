package com.fredericboisguerin.insa;

import org.junit.Test;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(Parameterized.class)
public class ShippingToDestinationMust
    extends TestCase
{
    private final int height ;
    private final int width ;
    private final int depth ;
    private final double weight;
    private final String dest ;
    private final String shippingcost ;

    public ShippingToDestinationMust(final int height, final int width, final int depth,
                                     final double weight, final String dest, final String shippingcost)
    {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.dest = dest;
        this.shippingcost = shippingcost;
    }

    private static final Object[][] testParameters = new Object[][]{
// TODO : voir comment réussir avec des virgules et pas des points .. (12,00)
            { 191, 123, 18,  2.354d, "FR", "12.00" },

            { 253, 215, 164, 1.565d, "FR", "30.39" },

            { 653, 133, 271, 2.132d, "FR", "46.09" },

            { 653, 331, 271, 3.650d, "FR", "83.76" },

            { 123, 191, 18,  2.354d, "MC", "13.04" },

            { 253, 215, 164, 1.565d, "MC", "33.03" },

            { 653, 133, 271, 2.132d, "MC", "50.10" },

            { 653, 331, 271, 3.650d, "MC", "91.05" },

            { 191, 123,  18, 2.354d, "DT", "13.91" },

            { 253, 215, 164, 1.565d, "DT", "33.29" },

            { 653, 133, 271, 2.132d, "DT", "49.84" },

            { 653, 331, 271, 3.650d, "DT", "89.54"},

    };


    @Parameterized.Parameters
    public static Collection<Object[]> parametre(){
        return Arrays.asList(testParameters);
    }


    @Test
    public void Must_Calculate_the_exact_price_for_a_given_package_to_a_given_Destination()
    {
        PackageFactory factory = PackageFactory.createInstance();
        Package pack = factory.createPackage(height,width,depth,weight);

        final double result = ShippingCostsCalculator.createInstance().calculateShippingCost(pack, Destination.valueOf(dest));
        assertThat(result).isEqualTo(Double.parseDouble(shippingcost));
    }



}

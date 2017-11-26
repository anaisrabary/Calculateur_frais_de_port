package com.fredericboisguerin.insa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShipingUITest {

    // Données tests
    private static final int HEIGHT_PCK_MONACO_1 = 653;
    private static final int WIDTH_PCK_MONACO_1 = 331;
    private static final int DEPTH_PCK_MONACO_1 = 271;
    private static final double WEIGHT_PCK_MONACO_1 = 3.650;
    private static final String DEST_PCK_MONACO_1 = "MC";

    @Mock
    private Package packMock ;
    @Mock
    private PackageFactory factoryMock ;
    @Mock
    private ShippingCostsCalculator costcalculatorMock;

    @Test
    public void When_calculate_shipping_cost(){

        String clavier = "cost\n"+HEIGHT_PCK_MONACO_1+"\n"+WIDTH_PCK_MONACO_1+"\n"
                +DEPTH_PCK_MONACO_1+"\n"+WEIGHT_PCK_MONACO_1+"\n"+DEST_PCK_MONACO_1+"\n"+"exit\n";
        System.setIn(new ByteArrayInputStream(clavier.getBytes()));

        when(factoryMock.createPackage(HEIGHT_PCK_MONACO_1,WIDTH_PCK_MONACO_1,DEPTH_PCK_MONACO_1,WEIGHT_PCK_MONACO_1))
                .thenReturn(packMock);

        new ShippingConsoleUI(factoryMock, costcalculatorMock).run();

        //inOrder
        InOrder inOrder = inOrder(factoryMock, costcalculatorMock);

        inOrder.verify(factoryMock).createPackage(HEIGHT_PCK_MONACO_1,WIDTH_PCK_MONACO_1,DEPTH_PCK_MONACO_1,WEIGHT_PCK_MONACO_1);
        inOrder.verify(costcalculatorMock).calculateShippingCost(packMock,Destination.valueOf(DEST_PCK_MONACO_1));
        inOrder.verifyNoMoreInteractions();


    }
    /*
    @Test
    public void When_calculate_shipping_cost_quit(){

    }

    @Test
    public void When_calculate_shipping_cost_with_unvalid_information(){

    }
    */

}

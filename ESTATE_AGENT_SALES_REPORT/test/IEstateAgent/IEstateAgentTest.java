/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package IEstateAgent;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author ibrah
 */
public class IEstateAgentTest {
    
    public IEstateAgentTest() {
    }

    @Test
    public void testEstateAgentSales() {
        EstateAgent estateAgent = new EstateAgent(){};
        double[] propertySales = {800000, 1500000, 2000000};
        
        //Test data
        double result = estateAgent.estateAgentSales(propertySales);
        //calling the method that will check the result and determine wheather its correct 
        assertEquals(4300000, result);
}
    

    @Test
    public void testEstateAgentCommission() {
         EstateAgent estateAgent = new EstateAgent(){};
        
        //Test data
        double result = estateAgent.estateAgentCommission(4300000);
        
        //calling the method that will check the result and determine wheather its correct 
        assertEquals(86000, result);
    }

    @Test
    public void testTopEstateAgent() {
          EstateAgent estateAgent = new EstateAgent(){};
        
        //Test data
        double[] totalSales = {4300000, 3000000};
        
        //calling the method that will check the result and determine wheather its correct 
        int result = estateAgent.topEstateAgent(totalSales);
        assertEquals(0, result);
    }

    public class IEstateAgentImpl implements IEstateAgent {

        public double estateAgentSales(double[] propertySales) {
            return 0.0;
        }

        public double estateAgentCommission(double propertySales) {
            return 0.0;
        }

        public int topEstateAgent(double[] totalSales) {
            return 0;
        }
    }
    
}



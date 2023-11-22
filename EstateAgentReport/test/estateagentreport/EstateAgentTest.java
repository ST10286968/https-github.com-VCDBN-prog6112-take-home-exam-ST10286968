
package estateagentreport;

import org.junit.Test;
import static org.junit.Assert.*;
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
public class EstateAgentTest {
    
    public EstateAgentTest() {
         
    }

    @Test
    public void testCalculateCommission() {
        IEstateAgent estateAgent = new EstateAgent(){};

        double commission = estateAgent.calculateCommission("100000", "5");
        assertEquals(5000.0, commission); // 5% of 100000 should be 5000

        commission = estateAgent.calculateCommission("150000", "7.5");
        assertEquals(11250.0, commission); // 7.5% of 150000 should be 11250
    }
    @Test
    public void testCalculateCommissionUnSuccessfully() {
        IEstateAgent estateAgent = new EstateAgent(){};

        double commission = estateAgent.calculateCommission("100000", "5");
        assertNotEquals(6000.0, commission); // 5% of 100000 should be 5000

        commission = estateAgent.calculateCommission("150000", "7.5");
        assertNotEquals(12000.0, commission); // 7.5% of 150000 should be 11250
    }
    
    @Test
    public void testValidateData() {
        IEstateAgent estateAgent = new EstateAgent(){};

        Data validData = new Data("Cape Town", "John Doe") {};
        validData.setPropertyPrice("100000");
        validData.setCommissionPercentage("5");

        assertTrue(estateAgent.validateData(validData));

        Data invalidData = new Data("", "John Doe") {}; // Empty location
        invalidData.setPropertyPrice("100000");
        invalidData.setCommissionPercentage("5");

        assertFalse(estateAgent.validateData(invalidData));
    }

    public class EstateAgentImpl extends EstateAgent {
    }
    
}

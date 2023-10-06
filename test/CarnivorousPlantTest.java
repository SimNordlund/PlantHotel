import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarnivorousPlantTest {

    CarnivorousPlant testCarnivorousPlant = new CarnivorousPlant();

    @Test
    void getLiquidVolume() {
        testCarnivorousPlant.setPlantLength("70");
        assertEquals(0.24, testCarnivorousPlant.getLiquidVolume());
        testCarnivorousPlant.setPlantLength("210");
        assertEquals(0.52, testCarnivorousPlant.getLiquidVolume());
    }
}
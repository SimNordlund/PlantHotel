import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalmTest {

    Palm testPalm = new Palm();

    //Testar så att beräkningen blir rätt i litermått. Gör om till centiliter senare i main.
    @Test
    void getLiquidVolume() {
        testPalm.setPlantLength("500");
        assertEquals(2.5, testPalm.getLiquidVolume());
        testPalm.setPlantLength("850");
        assertEquals(4.25, testPalm.getLiquidVolume());
        testPalm.setPlantLength("100");
        assertEquals(0.5, testPalm.getLiquidVolume());
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CactusTest {

    Cactus testCactus = new Cactus();

    @Test
    void getLiquidVolume() {
        assertEquals(0.02, testCactus.getLiquidVolume());
    }
}
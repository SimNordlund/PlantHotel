public class Cactus extends Plants { //Subklass. Ärver ifrån Plants.
    //Privata variabler för inkapsling.
    private final double mineralWaterAmount = 0.02;
    private final WaterType mineral = WaterType.MINERALVATTEN; ////Tilldelar mineralvatten med hjälp av ett enum.

    //Konstruktorer
    public Cactus() {
    }

    public Cactus(double plantLength, String plantName) {
        super(plantLength, plantName);
    }

    //Instansmetoder.
    protected WaterType getMineral() {
        return this.mineral;
    }

    @Override //Polymorfism
    public double getLiquidVolume() {
        return this.mineralWaterAmount;
    }
}

public class Palm extends Plants { //Subklass. Ärver ifrån Plants.
    //Privata variabler för inkapsling.
    private double tapWaterAmount;
    private final WaterType tapWater = WaterType.KRANVATTEN; //Tilldelar kranvatten med hjälp av ett enum.

    //Konstruktorer
    public Palm() {
    }

    public Palm(double plantLength, String plantName) {
        super(plantLength, plantName);
    }

    //Instansmetoder.
    protected WaterType getTapWater() {
        return tapWater;
    }

    @Override //Polymorfism
    public double getLiquidVolume() {
        tapWaterAmount = 0.5 * (getPlantLength() / 100);
        return tapWaterAmount;
    }
}


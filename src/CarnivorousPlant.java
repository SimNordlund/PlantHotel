public class CarnivorousPlant extends Plants { //Subklass. Ärver ifrån Plants.
    //Privata variabler för inkapsling.
    private double proteinDrinkAmount;
    private final WaterType proteinDrink = WaterType.PROTEINDRYCK; //Tilldelar proteindryck med hjälp av ett enum.

    //Konstruktorer
    public CarnivorousPlant() {
    }

    public CarnivorousPlant(double plantLength, String plantName) {
        super(plantLength, plantName);
    }

    //Instansmetoder.
    protected WaterType getProteinDrink() {
        return proteinDrink;
    }

    @Override //Polymorfism
    public double getLiquidVolume() {
        proteinDrinkAmount = 0.1 + (0.2 * (getPlantLength() / 100));
        return proteinDrinkAmount;
    }

}

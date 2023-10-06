import javax.swing.*;

public class Plants implements PlantsLiquid { //Superklass. Implements PlantLiquid (Interface)
    //Privata variabler för inkapsling.
    private double plantLength;
    private String plantName;
    private String plantSpecies; //Används i min static-metod för att lägga till växter.

    //Konstruktorer
    public Plants() {
    }

    public Plants(double plantLength, String plantName) {
        this.plantLength = plantLength;
        this.plantName = plantName;
    }

    //Instansmetoder, getters & setters, inkapsling.
    public double getLiquidVolume() { //Metod ifrån interfacet PlantsLiquid.
        return 0;
    }

    protected String getPlantName() {
        return plantName;
    }

    protected void setPlantName(String plantName) {
        if (plantName == null) {
            System.out.println("Programmet avslutas");
            System.exit(1);
        }
        plantName = plantName.trim();
        this.plantName = plantName;
    }

    protected double getPlantLength() {
        return plantLength;
    }

    protected void setPlantLength(String plantLength) {
        if (plantLength == null) {
            System.out.println("Programmet avslutas");
            System.exit(1);
        }
        try {
            this.plantLength = Double.parseDouble(plantLength);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Du måste ange längden i siffror. Vänligen starta om programmet");
            System.exit(1);
        }
        if (this.plantLength <= 0) {
            JOptionPane.showMessageDialog(null, "Du måste ange en positiv längd. Vänligen starta om programmet");
            System.exit(1);
        }
    }

    protected String getPlantSpecies() {
        return plantSpecies;
    }

    protected void setPlantSpecies(String plantSpecies) {
        if (plantSpecies == null) {
            System.out.println("Programmet avslutas");
            System.exit(1);
        }
        plantSpecies = plantSpecies.trim();
        this.plantSpecies = plantSpecies;
    }
    //Hämtar rätt vätsketyp ifrån respektive subklass.
    protected String getWaterType(Plants plantVisitor) {
        String waterType = null;
        if (plantVisitor instanceof Cactus) {
            Cactus temp = new Cactus();
            waterType = String.valueOf(temp.getMineral().Type);
        } else if (plantVisitor instanceof Palm) {
            Palm temp = new Palm();
            waterType = String.valueOf(temp.getTapWater().Type);
        } else if (plantVisitor instanceof CarnivorousPlant) {
            CarnivorousPlant temp = new CarnivorousPlant();
            waterType = String.valueOf(temp.getProteinDrink().Type);
        }
        return waterType;
    }
    //Frågar om användaren vill kolla upp någon till växt/gäst.
    protected boolean searchOtherPlant() {
        boolean searchAgain;
        while (true) {
            String userAnswer = JOptionPane.showInputDialog(null, "Vill du kolla upp en till växt/gäst?\nSvara med Ja/Nej");
            if (userAnswer == null) {
                System.out.println("Programmet avslutas");
                System.exit(1);
            }
            else if (userAnswer.equalsIgnoreCase("Ja")) {
                searchAgain = true;
                break;
            } else if (userAnswer.equalsIgnoreCase("Nej")) {
                JOptionPane.showMessageDialog(null, "Hejdå! Programmet avslutas");
                searchAgain = false;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Du måste svara Ja/Nej");
            }
        }
        return searchAgain;
    }
    //Frågar om användaren vill lägga till en ytterligare gäst.
    protected String askAddPlant() {
        String inputAnswer = JOptionPane.showInputDialog(null, "Vill du lägga till en gäst?" +
                "\nSvara med: Ja/Nej");
        if (inputAnswer == null) {
            System.out.println("Programmet avslutas");
            System.exit(1);
        }
        inputAnswer = inputAnswer.trim();
        return inputAnswer;
    }
}


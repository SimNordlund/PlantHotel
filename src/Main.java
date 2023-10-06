import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String plantName = null;
        int roundedLiquidVolume = 0;
        Plants plantVisitor = new Plants();
        int setCl = 100;

        ///Lista med växter/gäster på hotellet.
        List<Plants> plantVisitorList = new ArrayList<>();
        plantVisitorList.add(new Cactus(20, "Igge"));
        plantVisitorList.add(new Palm(500, "Laura"));
        plantVisitorList.add(new CarnivorousPlant(70, "Meatloaf"));
        plantVisitorList.add(new Palm(100, "Olof"));

        addPlant(plantVisitorList, plantVisitor); //Användaren kan lägga till en ny gäst i listan via en static metod.

        //Tar fram hur mycket vätska och vilken vätska som växten ska ha.
        while (true) {
            String userInput = JOptionPane.showInputDialog(null, "Vilken växt ska få vätska?");
            if (userInput == null) {
                System.out.println("Programmet avslutas");
                System.exit(1);
            }
            for (Plants plants : plantVisitorList) {
                plantVisitor = plants;
                if (userInput.equals(plantVisitor.getPlantName())) {
                    plantName = plantVisitor.getPlantName();
                    double liquidVolume = plantVisitor.getLiquidVolume() * setCl; //Polymorfism. *100 för att få ut cl.
                    roundedLiquidVolume = (int) (liquidVolume + 0.5); //Avrundar till heltal.
                    break;
                }
            }
            //Skriver ut hur mycket vätska och vilken typ av vätska växten ska ha.
            if (plantName != null) {
                JOptionPane.showMessageDialog(null, plantName + " behöver " + (roundedLiquidVolume) +
                        " cl " + plantVisitor.getWaterType(plantVisitor));
                boolean searchAgain = plantVisitor.searchOtherPlant(); //Frågar om användaren vill kolla upp någon mer växt.
                if (!searchAgain) {
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Det du har skrivit in matchar inte med någon växtgäst på hotellet" +
                        "\nVänligen skriv in en gäst eller tryck på cancel/krysset för att avsluta");
            }
        }
        writePlantGuestList(plantVisitorList); //Skriver ut namnet på växtgäster till filen plantsGuestsList.
    }

    //Statisk metod som kallas på om användaren vill lägga till en ny gäst.
    private static void addPlant(List<Plants> plantVisitorList, Plants newPlant) {
        while (true) {
            String userAnswer = newPlant.askAddPlant();
            if (userAnswer.equalsIgnoreCase("Nej")) {
                break;
            } else if (userAnswer.equalsIgnoreCase("Ja")) {
                newPlant.setPlantSpecies(JOptionPane.showInputDialog(null, "Vilken typ av växt?"));
                newPlant.setPlantName(JOptionPane.showInputDialog(null, "Vad heter växten?"));
                newPlant.setPlantLength(JOptionPane.showInputDialog(null, "Hur lång är växten? Ange i cm"));

                if (newPlant.getPlantSpecies().equalsIgnoreCase("Kaktus")) {
                    Cactus newCactus = new Cactus(newPlant.getPlantLength(), newPlant.getPlantName());
                    plantVisitorList.add(newCactus);
                    JOptionPane.showMessageDialog(null, newPlant.getPlantName() + " är tillagd");
                } else if (newPlant.getPlantSpecies().equalsIgnoreCase("Palm")) {
                    Palm newPalm = new Palm(newPlant.getPlantLength(), newPlant.getPlantName());
                    plantVisitorList.add(newPalm);
                    JOptionPane.showMessageDialog(null, newPlant.getPlantName() + " är tillagd");
                } else if (newPlant.getPlantSpecies().equalsIgnoreCase("Köttätande växt")) {
                    CarnivorousPlant newCarnivorousPlant = new CarnivorousPlant(newPlant.getPlantLength(), newPlant.getPlantName());
                    plantVisitorList.add(newCarnivorousPlant);
                    JOptionPane.showMessageDialog(null, newPlant.getPlantName() + " är tillagd");
                } else {
                    JOptionPane.showMessageDialog(null, "Något verkar ha blivit fel.\n" +
                            "Du kan bara lägga till följande gäster: Kaktus, Palm, Köttätande växt");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Du måste svara Ja/Nej");
            }
        }
    }

    //Statisk metod som skriver över alla gäster till en text-fil.
    private static void writePlantGuestList(List<Plants> plantVisitorList) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("plantsGuestList.txt"));
        for (Plants plant : plantVisitorList) {
            writer.write("Namn: " + plant.getPlantName() + " Längd: " + plant.getPlantLength() + " cm.");
            writer.newLine();
        }
        writer.close();
        JOptionPane.showMessageDialog(null, "Namn på gäster finns i filen plantsGuestsList");
    }
}


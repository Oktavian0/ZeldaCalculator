import java.util.ArrayList;

/**
 * Created by Pero on 04.03.2018.
 */
public class MajorasMask extends Game {

    public MajorasMask()
    {
        Name = "Majora's Mask";
        Initialization[0] = true;
        Initialization[1] = true;
        Initialization[2] = false;

        monstersExist = false;
        initializeGameData();
    }



    // Majora's Mask Races
    ///////////////////////////

    public void initializeMainRaces() {

        // initializing main races
        mainRaces.add(new Race("(Terminian) Hylians", 64.0f));
        mainRaces.add(new Race("Deku", 70.0f));
        mainRaces.add(new Race("Gorons", 30.0f));
        mainRaces.add(new Race("Zoras", 20.0f));
        mainRaces.add(new Race("Gerudo", 26.0f));
        mainRaces.add(new Race("Ikanans", 47.0f));
        mainRaces.add(new Race("Garo", 14.0f));
    }

    public void initializeOtherRaces() {

        // initializing other races
        otherRaces.add(new Race("Great Fairies", 5.0f));
        otherRaces.add(new Race("Beavers", 2.0f));
        otherRaces.add(new Race("Monkeys", 4.0f));
        otherRaces.add(new Race("Gabora's Race", 1.0f));
        otherRaces.add(new Race("Ghost Hunter's Race", 1.0f));
        otherRaces.add(new Race("Seahorses", 2.0f));
        otherRaces.add(new Race("Owls", 1.0f));
        otherRaces.add(new Race("Foxes", 1.0f));
        otherRaces.add(new Race("Scarecrows", 1.0f));
    }



    // Majora's Mask Labour
    ///////////////////////////

    public void initializeLabour() {

        //initializing labour categories
        allLabourCategories.add(new LabourCategory("Agriculture", 3.0f));
        allLabourCategories.add(new LabourCategory("Industry", 11.0f));
        allLabourCategories.add(new LabourCategory("(Public or Private) Service", 123.0f));
        allLabourCategories.add(new LabourCategory("Merchants and Traders", 6.0f));
        allLabourCategories.add(new LabourCategory("Political Positions", 9.0f));
        allLabourCategories.add(new LabourCategory("Nonemployed Civilians", 44.0f));
        allLabourCategories.add(new LabourCategory("Ambiguous", 3.0f));
    }



    // Majora's Mask Exceptions
    ///////////////////////////

    public void initializeMonsterRaces()
    {
        System.out.println("No counting Monsters in Majora's Mask!");
        ArrayList<Race> monsterRaces = new ArrayList<>();
    }

    public void initializeMainReligions() {

        //initializing religions
        System.out.println("No Religions in Majora's Mask!");
        ArrayList<Religion> mainReligions = new ArrayList<>();
    }

    public void initializeOtherReligions(float totalPopulation, float totalPopulationOfMainReligions) {

        System.out.println("No Religions in Majora's Mask!");
        ArrayList<Religion> otherReligions = new ArrayList<>();
    }

    public void initializeAllReligions() {

        System.out.println("No Religions in Majora's Mask!");
        ArrayList<Religion> allReligions = new ArrayList<>();
    }

}

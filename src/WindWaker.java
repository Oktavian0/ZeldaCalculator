import java.util.ArrayList;

/**
 * Created by Pero on 17.08.2019.
 */
public class WindWaker extends Game {

    public WindWaker()
    {
        Name = "Wind Waker";
        Initialization[0] = true;
        Initialization[1] = true;
        Initialization[2] = false;

        monstersExist = true;
        initializeGameData();
    }



    // Wind Waker Races
    ///////////////////////////

    public void initializeMainRaces() {

        // initializing main races
        mainRaces.add(new Race("Hylians", 60.0f));
        mainRaces.add(new Race("Humans", 9.0f));
        mainRaces.add(new Race("Rito", 16.0f));
        mainRaces.add(new Race("Koroks", 10.0f));
        mainRaces.add(new Race("Great Fairies", 8.0f));
    }

    public void initializeMonsterRaces() {

        // initializing monster races
        monsterRaces.add(new Race("Bokoblins", 96.0f));
        monsterRaces.add(new Race("Moblins", 17.0f));
        monsterRaces.add(new Race("Miniblins", 43.0f));
        monsterRaces.add(new Race("Wizzrobes", 13.0f));
    }

    public void initializeOtherRaces() {

        // initializing other races
        otherRaces.add(new Race("Divine Frogs", 2.0f));
        otherRaces.add(new Race("Dragons", 1.0f));
        otherRaces.add(new Race("Magical Fish", 1.0f));
        otherRaces.add(new Race("Gorons", 3.0f));
        otherRaces.add(new Race("Gerudo", 1.0f));
        otherRaces.add(new Race("Magical Trees", 1.0f));
    }



    // Wind Waker Labour
    ///////////////////////////

    public void initializeLabour() {

        //initializing labour categories
        allLabourCategories.add(new LabourCategory("Agriculture", 28.0f));
        allLabourCategories.add(new LabourCategory("Industry", 1.0f));
        allLabourCategories.add(new LabourCategory("(Public or Private) Service", 196.0f));
        allLabourCategories.add(new LabourCategory("Merchants and Traders", 0.0f));
        allLabourCategories.add(new LabourCategory("Political Positions", 4.0f));
        allLabourCategories.add(new LabourCategory("Nonemployed Civilians", 18.0f));
        allLabourCategories.add(new LabourCategory("Ambiguous", 6.0f));
    }



    // Wind Waker Exceptions
    ///////////////////////////

    public void initializeMainReligions() {

        System.out.println("No Religions in Wind Waker!");
        //initializing religions
        ArrayList<Religion> mainReligions = new ArrayList<>();
    }

    public void initializeOtherReligions(float totalPopulation, float totalPopulationOfMainReligions) {

        System.out.println("No Religions in Wind Waker!");
        ArrayList<Religion> otherReligions = new ArrayList<>();
    }

    public void initializeAllReligions() {

        System.out.println("No Religions in Wind Waker!");
        ArrayList<Religion> allReligions = new ArrayList<>();
    }

}

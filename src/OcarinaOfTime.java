import java.util.ArrayList;

/**
 * Created by Pero on 04.03.2018.
 */
public class OcarinaOfTime extends Game {

    public OcarinaOfTime()
    {
        Name = "Ocarina of Time";
        Initialization[0] = false;
        Initialization[1] = true;
        Initialization[2] = true;

        monstersExist = false;
        initializeGameData();
    }



    // Ocarina of Time Races
    ///////////////////////////

    public void initializeMainRaces() {

        // initializing main races
        mainRaces.add(new Race("Hylians", 107.0f));
        mainRaces.add(new Race("Gorons", 14.0f));
        mainRaces.add(new Race("Zoras", 12.0f));
        mainRaces.add(new Race("Gerudo", 24.0f));
        mainRaces.add(new Race("Kokiri", 16.0f));
        mainRaces.add(new Race("Deku", 39.0f));
    }

    public void initializeOtherRaces() {

        // initializing other races
        otherRaces.add(new Race("Magical Fish", 1.0f));
        otherRaces.add(new Race("Great Fairies", 6.0f));
        otherRaces.add(new Race("Magical Owls", 1.0f));
        otherRaces.add(new Race("Scarecrows", 2.0f));
        otherRaces.add(new Race("Sheikah", 1.0f));
        otherRaces.add(new Race("Skull Kids", 3.0f));
        otherRaces.add(new Race("Magical Trees", 1.0f));
    }



    // Ocarina of Time Religions
    ///////////////////////////

    public void initializeMainReligions() {

        //initializing religions
        mainReligions.add(new Religion("Faith of the Three Goddesses", 107.0f));
        mainReligions.add(new Religion("Faith of the Sand Goddess", 24.0f));
        mainReligions.add(new Religion("Zora Faith", 13.0f));
        mainReligions.add(new Religion("Kokiri Faith", 16.0f));
        mainReligions.add(new Religion("Goron Faith", 14.0f));
    }

    public void initializeOtherReligions(float totalPopulation, float totalPopulationOfMainReligions) {
        //initializing religions
        otherReligions.add(new Religion("Other/Unknown Faiths", totalPopulation-totalPopulationOfMainReligions));
    }

    public void initializeAllReligions() {

        allReligions.addAll(mainReligions);
        allReligions.addAll(otherReligions);
    }



    // Ocarina of Time Exceptions
    ///////////////////////////

    public void initializeMonsterRaces()
    {
        System.out.println("No counting Monsters in Ocarina of Time!");
        ArrayList<Race> monsterRaces = new ArrayList<>();
    }

    public void initializeLabour() {

        System.out.println("No Labour Categories in Ocarina of Time!");
        ArrayList<LabourCategory> allLabourCategories = new ArrayList<>();
    }

}

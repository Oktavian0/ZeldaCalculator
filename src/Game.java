import java.util.ArrayList;

/**
 * Created by Pero on 11.03.2018.
 */
public abstract class Game {

    // Test
    // Test 2

    String Name;
    boolean[] Initialization = new boolean[3];
    boolean monstersExist;
    boolean humansExist;
    int i = 0;

    //main ArrayLists
    ArrayList<Race> mainRaces = new ArrayList<Race>();
    ArrayList<Race> monsterRaces = new ArrayList<Race>();
    ArrayList<Race> otherRaces = new ArrayList<Race>();
    ArrayList<Race> allRaces = new ArrayList<Race>();
    ArrayList<LabourCategory> allLabourCategories = new ArrayList<LabourCategory>();
    ArrayList<Religion> mainReligions = new ArrayList<Religion>();
    ArrayList<Religion> otherReligions = new ArrayList<Religion>();
    ArrayList<Religion> allReligions = new ArrayList<Religion>();

    //special ArrayLists
    ArrayList<Race> otherRacesTotal = new ArrayList<Race>();
    ArrayList<Race> hyliansAndHumans = new ArrayList<Race>();
    ArrayList<Race> mainAndOtherRaces = new ArrayList<Race>();
    ArrayList<Race> monsterRacesOnlyMonsters = new ArrayList<Race>();
    ArrayList<Race> hyliansAndHumansOfMainAndOther = new ArrayList<Race>();
    ArrayList<Race> otherRacesTotalOfMainAndOther = new ArrayList<Race>();

    public Game()
    {

    }

    public void initializeGameData()
    {
        initializeMainRaces();
        if (monstersExist == true) {
            initializeMonsterRaces();
        }
        initializeOtherRaces();
        initializeAllRaces();
        if ( Initialization[0]==true )
        {
            initializeLabour();
        }
        if ( Initialization[2]==true )
        {
            initializeMainReligions();
        }

        humansExist = checkIfHumansExist(allRaces);
    }

    public abstract void initializeMainRaces();

    public abstract void initializeMonsterRaces();

    public abstract void initializeOtherRaces();

    public void initializeAllRaces() {

        allRaces.addAll(mainRaces);
        if (monstersExist==true)
        {
            allRaces.addAll(monsterRaces);
        }
        allRaces.addAll(otherRaces);
    }

    public void initializeOtherRacesTotal(float totalPopulationOfOtherRaces, float totalPopulation)
    {
        otherRacesTotal.add(new Race("Other Races", totalPopulationOfOtherRaces));
        otherRacesTotal.get(0).calculatePopulationShare(totalPopulation);
    }

    public void initializeHyliansAndHumans(float totalPopulation)
    {
        hyliansAndHumans.add(new Race("Hylians and Humans", mainRaces.get(0).getPopulation() + mainRaces.get(1).getPopulation()));
        hyliansAndHumans.get(0).calculatePopulationShare(totalPopulation);
    }

    public void initializeMainAndOtherRaces()
    {
        mainAndOtherRaces.addAll(mainRaces);
        mainAndOtherRaces.addAll(otherRaces);
    }

    public void initializeMonsterRacesOnlyMonsters()
    {
        monsterRacesOnlyMonsters = monsterRaces;
    }

    public void initializeHyliansAndHumansOfMainAndOther(float totalPopulationOfMainAndOtherRaces)
    {
        hyliansAndHumansOfMainAndOther.add( new Race("Hylians and Humans", mainAndOtherRaces.get(0).getPopulation()+mainAndOtherRaces.get(1).getPopulation()) );
        hyliansAndHumansOfMainAndOther.get(0).calculatePopulationShare(totalPopulationOfMainAndOtherRaces);
    }

    public void initializeOtherRacesTotalOfMainAndOther(float totalPopulationOfOtherRaces, float totalPopulationOfMainAndOtherRaces)
    {
        otherRacesTotalOfMainAndOther.add(new Race("Other Races", totalPopulationOfOtherRaces));
        otherRacesTotalOfMainAndOther.get(0).calculatePopulationShare(totalPopulationOfMainAndOtherRaces);
    }

    public abstract void initializeLabour();

    public abstract void initializeMainReligions();

    public abstract void initializeOtherReligions(float totalPopulation, float totalPopulationOfMainReligions);

    public abstract void initializeAllReligions();

    public boolean checkIfHumansExist(ArrayList<Race> arrayListRace)
    {
        boolean humansExist = false;
        for (int i = 0; i<arrayListRace.size(); i++)
        {
            if ( arrayListRace.get(i).getName().equals("Humans") )
            {
                humansExist=true;
            }
        }
        return humansExist;
    }

}

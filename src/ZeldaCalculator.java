import java.util.ArrayList;

/**
 * Created by Pero on 30.10.2017.
 */
public class ZeldaCalculator
{

    char choice = 'M';
    Game majorasmask = new MajorasMask();
    Game ocarinaoftime = new OcarinaOfTime();
    Game windwaker = new WindWaker();

    public ZeldaCalculator()
    {

    }

    public void start()
    {

        if ( choice == 'O')
        {
            calculateGame(ocarinaoftime);
        }
        if ( choice == 'M')
        {
            calculateGame(majorasmask);
        }
        if ( choice == 'W')
        {
            calculateGame(windwaker);
        }

    }

    public void calculateGame(Game game) {
        System.out.println(game.Name);
        System.out.println();
        if ( game.Initialization[0]==true )
        {
            calculateLabour(game);
        }
        if ( game.Initialization[1]==true )
        {
            calculateRaces(game);
        }
        if ( game.Initialization[2]==true )
        {
            calculateReligions(game);
        }
    }

    public void calculateRaces(Game game) {

        //Calculate

        //setting additional parameters


        //declare variables for total population
        float totalPopulationOfMainRaces = 0.0f;
        float totalPopulationOfMonsterRaces = 0.0f;
        float totalPopulationOfOtherRaces = 0.0f;
        float totalPopulation = 0.0f;

        //calculate total population
        totalPopulationOfMainRaces = calculateTotalPopulationRace(game.mainRaces);
        if (game.monstersExist == true) {
            totalPopulationOfMonsterRaces = calculateTotalPopulationRace(game.monsterRaces);
        }
        totalPopulationOfOtherRaces = calculateTotalPopulationRace(game.otherRaces);
        totalPopulation = calculateTotalPopulationRace(game.allRaces);

        //calculate total population share
        for (int i = 0; i < game.mainRaces.size(); i++) {
            game.mainRaces.get(i).calculatePopulationShare(totalPopulation);
        }
        if (game.monstersExist == true) {
            for (int i = 0; i < game.monsterRaces.size(); i++) {
                game.monsterRaces.get(i).calculatePopulationShare(totalPopulation);
            }
        }
        for (int i = 0; i < game.otherRaces.size(); i++) {
            game.otherRaces.get(i).calculatePopulationShare(totalPopulation);
        }
        for (int i = 0; i < game.allRaces.size(); i++) {
            game.allRaces.get(i).calculatePopulationShare(totalPopulation);
        }

        //Hylians+Humans combined and other races single entry
        if (game.humansExist==true) {
            game.initializeHyliansAndHumans(totalPopulation);
        }
        game.initializeOtherRacesTotal(totalPopulationOfOtherRaces, totalPopulation);

        //calculate sum of total population shares
        float populationShareSum = 0.0f;
        for (int i = 0; i < game.mainRaces.size(); i++) {
            populationShareSum = populationShareSum + game.mainRaces.get(i).getPopulationShare();
        }
        if (game.monstersExist == true) {
            for (int i = 0; i < game.monsterRaces.size(); i++) {
                populationShareSum = populationShareSum + game.monsterRaces.get(i).getPopulationShare();
            }
        }
        populationShareSum = populationShareSum + game.otherRacesTotal.get(0).getPopulationShare();

        float populationShareSumIndividually = 0.0f;
        for (int i = 0; i < game.mainRaces.size(); i++) {
            populationShareSumIndividually = populationShareSumIndividually + game.mainRaces.get(i).getPopulationShare();
        }
        if (game.monstersExist == true) {
            for (int i = 0; i < game.monsterRaces.size(); i++) {
                populationShareSumIndividually = populationShareSumIndividually + game.monsterRaces.get(i).getPopulationShare();
            }
        }
        for (int i = 0; i < game.otherRaces.size(); i++) {
            populationShareSumIndividually = populationShareSumIndividually + game.otherRaces.get(i).getPopulationShare();
        }


        //Print

        System.out.println("----------Races----------");
        System.out.println();
        System.out.println("Total Population Main: " + totalPopulationOfMainRaces);
        if (game.monstersExist == true) {
            System.out.println("Total Population Monsters: " + totalPopulationOfMonsterRaces);
        }
        System.out.println("Total Population Others: " + totalPopulationOfOtherRaces);
        System.out.println("Total Population: " + totalPopulation);
        System.out.println();

        printRace(game.allRaces);

        if (game.humansExist==true) {
            printRace(game.hyliansAndHumans);
        }

        printRace(game.otherRacesTotal);

        System.out.println("Sum of population share: " + populationShareSum + "%");
        System.out.println();

        System.out.println("Sum of population share (individually): " + populationShareSumIndividually + "%");
        System.out.println();

        System.out.println();
        System.out.println();

        if (game.monstersExist == true) {

            //Calculating it all for Main+Other Races again (Monsters separate)

            //initialize races
            game.initializeMainAndOtherRaces();
            game.initializeMonsterRacesOnlyMonsters();

            //declare variables for total population
            float totalPopulationOfMainAndOtherRaces = 0.0f;

            //calculate total population
            totalPopulationOfMainAndOtherRaces = calculateTotalPopulationRace(game.mainAndOtherRaces);

            //calculate total population share
            for (int i = 0; i < game.mainAndOtherRaces.size(); i++)
            {
                game.mainAndOtherRaces.get(i).calculatePopulationShare(totalPopulationOfMainAndOtherRaces);
            }
            for (int i = 0; i < game.monsterRacesOnlyMonsters.size(); i++)
            {
                game.monsterRacesOnlyMonsters.get(i).calculatePopulationShare(totalPopulationOfMonsterRaces);
            }

            //Hylians+Humans and other races single entry
            if (game.humansExist==true) {
                game.initializeHyliansAndHumansOfMainAndOther(totalPopulationOfMainAndOtherRaces);
            }
            game.initializeOtherRacesTotalOfMainAndOther(totalPopulationOfOtherRaces, totalPopulationOfMainAndOtherRaces);

            //calculate sum of total population shares
            float populationShareSumOfMainAndOther = 0.0f;
            for (int i = 0; i < game.mainRaces.size(); i++)
            {
                populationShareSumOfMainAndOther = populationShareSumOfMainAndOther + game.mainAndOtherRaces.get(i).getPopulationShare();
            }
            populationShareSumOfMainAndOther = populationShareSumOfMainAndOther + game.otherRacesTotalOfMainAndOther.get(0).getPopulationShare();

            float populationShareSumOfMainAndOtherIndividually = 0.0f;
            for (int i = 0; i < game.mainAndOtherRaces.size(); i++)
            {
                populationShareSumOfMainAndOtherIndividually = populationShareSumOfMainAndOtherIndividually + game.mainAndOtherRaces.get(i).getPopulationShare();
            }

            float populationShareSumOfMonsters = 0.0f;
            for (int i = 0; i < game.monsterRacesOnlyMonsters.size(); i++)
            {
                populationShareSumOfMonsters = populationShareSumOfMonsters + game.monsterRacesOnlyMonsters.get(i).getPopulationShare();
            }



            //Print

            System.out.println("----------Races----------");
            System.out.println();
            System.out.println("Total Population Main: " + totalPopulationOfMainRaces);
            System.out.println("Total Population Others: " + totalPopulationOfOtherRaces);
            System.out.println("Total Population: " + totalPopulationOfMainAndOtherRaces);
            System.out.println();

            printRace(game.mainAndOtherRaces);

            if (game.humansExist==true) {
                printRace(game.hyliansAndHumansOfMainAndOther);
            }

            printRace(game.otherRacesTotalOfMainAndOther);

            System.out.println("Sum of population share: " + populationShareSumOfMainAndOther + "%");
            System.out.println();

            System.out.println("Sum of population share (individually): " + populationShareSumOfMainAndOtherIndividually + "%");
            System.out.println();

            System.out.println();
            System.out.println();

            System.out.println("----------Races----------");
            System.out.println();
            System.out.println("Total Population Monsters: " + totalPopulationOfMonsterRaces);
            System.out.println();

            printRace(game.monsterRacesOnlyMonsters);

            System.out.println("Sum of population share: " + populationShareSumOfMonsters + "%");
            System.out.println();

            System.out.println();
            System.out.println();
        }

    }

    public void calculateLabour(Game game) {

        //Calculate

        //setting additional parameters

        //declare variables for total population
        float totalPopulation = 0.0f;

        //calculate total population
        totalPopulation = calculateTotalPopulationLabour(game.allLabourCategories);

        //calculate total population share
        for (int i = 0; i < game.allLabourCategories.size(); i++)
        {
            game.allLabourCategories.get(i).calculatePopulationShare(totalPopulation);
        }

        //calculate sum of total population shares
        float populationShareSum = 0.0f;
        for (int i = 0; i < game.allLabourCategories.size(); i++)
        {
            populationShareSum = populationShareSum + game.allLabourCategories.get(i).getPopulationShare();
        }



        //Print

        System.out.println("----------Labour Categories----------");
        System.out.println();
        System.out.println("Total Population: "+totalPopulation);
        System.out.println("");

        printLabour(game.allLabourCategories);

        System.out.println("Sum of population share: " + populationShareSum + "%");
        System.out.println();

        System.out.println();
        System.out.println();

    }

    public void calculateReligions(Game game) {

        //Calculate

        //setting additional parameters

        //declare variables for total population
        float totalPopulationOfMainReligions = 0.0f;
        float totalPopulationOfOtherReligions = 0.0f;
        float totalPopulation = 0.0f;

        //calculate total population
        totalPopulation = calculateTotalPopulationRace(game.allRaces);
        totalPopulationOfMainReligions = calculateTotalPopulationReligion(game.mainReligions);
        game.initializeOtherReligions(totalPopulation, totalPopulationOfMainReligions);
        totalPopulationOfOtherReligions = calculateTotalPopulationReligion(game.otherReligions);
        game.initializeAllReligions();

        //calculate total population share
        for (int i = 0; i < game.mainReligions.size(); i++)
        {
            game.mainReligions.get(i).calculatePopulationShare(totalPopulation);
        }
        for (int i = 0; i < game.otherReligions.size(); i++)
        {
            game.otherReligions.get(i).calculatePopulationShare(totalPopulation);
        }
        for (int i = 0; i < game.allReligions.size(); i++)
        {
            game.allReligions.get(i).calculatePopulationShare(totalPopulation);
        }

        //calculate sum of total population shares
        float populationShareSum = 0.0f;
        for (int i = 0; i < game.allReligions.size(); i++)
        {
            populationShareSum = populationShareSum + game.allReligions.get(i).getPopulationShare();
        }



        //Print

        System.out.println("----------Religions----------");
        System.out.println();
        System.out.println("Total Population Main: " + totalPopulationOfMainReligions);
        System.out.println("Total Population Others: " + totalPopulationOfOtherReligions);
        System.out.println("Total Population: " + totalPopulation);
        System.out.println();

        printReligion(game.allReligions);

        System.out.println("Sum of population share: " + populationShareSum + "%");
        System.out.println();

        System.out.println();
        System.out.println();
    }


    //Helper Methods

    float calculateTotalPopulationRace(ArrayList<Race> arrayList)
    {
        float totalPopulation = 0.0f;

        for (int i = 0; i < arrayList.size(); i++)
        {
            totalPopulation += arrayList.get(i).getPopulation();
        }

        return totalPopulation;
    }

    float calculateTotalPopulationLabour(ArrayList<LabourCategory> arrayList)
    {
        float totalPopulation = 0.0f;

        for (int i = 0; i < arrayList.size(); i++)
        {
            totalPopulation += arrayList.get(i).getPopulation();
        }

        return totalPopulation;
    }

    float calculateTotalPopulationReligion(ArrayList<Religion> arrayList)
    {
        float totalPopulation = 0.0f;

        for (int i = 0; i < arrayList.size(); i++)
        {
            totalPopulation += arrayList.get(i).getPopulation();
        }

        return totalPopulation;
    }

    void printRace(ArrayList<Race> arrayList)
    {
        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.println("Race: " + arrayList.get(i).getName());
            System.out.println("****************************");
            System.out.println("Population: " + arrayList.get(i).getPopulation());
            System.out.println("Share of total population: " + arrayList.get(i).getPopulationShare() + "%");
            System.out.println("Population share rounded? " + arrayList.get(i).getPopulationShareIsRounded());
            System.out.println();
        }
    }

    void printLabour(ArrayList<LabourCategory> arrayList)
    {
        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.println("Labour Category: " + arrayList.get(i).getName());
            System.out.println("****************************");
            System.out.println("Population: "+arrayList.get(i).getPopulation());
            System.out.println("Share of total population: " + arrayList.get(i).getPopulationShare() + "%");
            System.out.println("Population share rounded? " + arrayList.get(i).getPopulationShareIsRounded());
            System.out.println("");
        }
    }

    void printReligion(ArrayList<Religion> arrayList)
    {
        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.println("Religion: " + arrayList.get(i).getName());
            System.out.println("****************************");
            System.out.println("Population: " + arrayList.get(i).getPopulation());
            System.out.println("Share of total population: " + arrayList.get(i).getPopulationShare() + "%");
            System.out.println("Population share rounded? " + arrayList.get(i).getPopulationShareIsRounded());
            System.out.println();
        }
    }

    //boolean test = allRaces.contains(new Race("Test", 0.0f));

}

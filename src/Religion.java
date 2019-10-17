/**
 * Created by Pero on 04.03.2018.
 */
public class Religion
{
    private String name;
    private float population;
    private float populationShare;
    private boolean populationShareIsRounded;

    public Religion(String name, float population)
    {
        this.name = name;
        this.population = population;
    }

    // Getter
    //
    public String getName()
    {
        return this.name;
    }

    public float getPopulation()
    {
        return this.population;
    }

    public float getPopulationShare()
    {
        return this.populationShare;
    }

    public boolean getPopulationShareIsRounded()
    {
        return this.populationShareIsRounded;
    }

    // Setter
    //
    public void calculatePopulationShare(float totalPopulation)
    {
        float unRounded = (this.population / totalPopulation) * 100.0f;
        float rounded = Math.round( Math.round(unRounded * 100.0f) / 100.0f * 10.0f) / 10.0f;
        //round to 2 decimal places, then to 1

        this.populationShare = rounded;

        if (unRounded != rounded)
        {
            this.populationShareIsRounded = true;
        }
    }


}

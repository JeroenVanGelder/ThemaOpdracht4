package nl.hu.to4.groep1.domain;

/**
 * Created by jeroenvangelder on 20-2-17.
 */
public class PlanningDatum
{
    private int weekNummer;
    private int dagInDeWeek;
    private int uurOpDeDag;

    public PlanningDatum(int weekNummer, int dagInDeWeek, int uurOpDeDag){
        this.weekNummer = weekNummer;
        this.dagInDeWeek = dagInDeWeek;
        this.uurOpDeDag = uurOpDeDag;
    }

    public int getWeeknummer()
    {
        return this.weekNummer;
    }

    public int getDagInDeWeek()
    {
        return this.dagInDeWeek;
    }

    public int getUurOpDeDag()
    {
        return this.uurOpDeDag;
    }
}

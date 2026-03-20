package Team;

public class BattingScoreCard {

    public int totalRuns;
    public int totalBallsPlayed;
    public int totalFours;
    public int totalSix;
    public double strikeRate;
    public Wicket wicketDetails;

    public BattingScoreCard() {
        this.totalRuns = 0;
        this.totalBallsPlayed = 0;
        this.totalFours = 0;
        this.totalSix = 0;
        this.strikeRate = 0;
        this.wicketDetails=null;
    }
}

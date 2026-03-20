package Innings;

import Team.Over;
import Team.Team;
import Team.Player;

import java.util.ArrayList;
import java.util.List;

public class Inning {
    Team battingTeam;
    Team bowlerTeam;
    List<Over> overs;
    MatchType matchType;

    public Inning(Team battingTeam, Team bowlerTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlerTeam = bowlerTeam;
        this.matchType = matchType;
        this.overs=new ArrayList<>();
    }

    public void start(int runsToWin) throws Exception {

        battingTeam.chooseNextBatsMan();

        int overCount=matchType.noOfOvers();
        for(int i=1;i<=overCount;i++)
        {
            bowlerTeam.chooseNextBowler(matchType.maxOverCountBowlers());
            Over over = new Over(i,bowlerTeam.getCurrentBowler());
            overs.add(over);
            try{
                boolean won = over.startOver(battingTeam, bowlerTeam, runsToWin);
                if (won == true) {
                    break;
                }
            }catch(Exception e)
            {
                break;
            }

            //swap striket and non striker
            Player temp = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);

        }
    }

    public int getTotalRuns() {
        return battingTeam.getTotalRuns();
    }

}

package Innings;

import Team.Team;

import java.util.Date;

public class Match {

    Team teamA;
    Team teamB;
    Date matchDate;
    Inning innings[];
    String venue;
    MatchType matchType;
    Team wonToss;

    public Match(Team a, Team b, Date matchDate, String venue, MatchType matchType) {
        teamA = a;
        teamB = b;
        this.matchDate = matchDate;
        this.innings = new Inning[2];
        this.venue = venue;
        this.matchType = matchType;
        this.wonToss = wonToss;
    }

    public void startMatch() throws Exception {
        wonToss=toss(teamA,teamB);
        for(int i=1;i<=2;i++)
        {

            Inning inningDetails;
            Team bowlingTeam;
            Team battingTeam;

            boolean isChasing = false;
            if(i==1)
            {
                battingTeam = wonToss;
                bowlingTeam = wonToss.teamName.equals(teamA.teamName) ? teamB : teamA;
                inningDetails=new Inning(battingTeam,bowlingTeam,matchType);
                inningDetails.start(-1);
            }else {
                bowlingTeam = wonToss;
                battingTeam = wonToss.teamName.equals(teamA.teamName) ? teamB : teamA;
                inningDetails = new Inning(battingTeam, bowlingTeam, matchType);
                inningDetails.start(innings[0].getTotalRuns());
                if (bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()) {
                    bowlingTeam.isWinner = true;
                }

            }

            innings[i - 1] = inningDetails;

            //print inning details
            System.out.println();
            System.out.println("INNING " + i + " -- total Run: " + battingTeam.getTotalRuns());
            System.out.println("---Batting ScoreCard : " + battingTeam.teamName + "---");

            battingTeam.printBattingScoreCard();

            System.out.println();
            System.out.println("---Bowling ScoreCard : " + bowlingTeam.teamName + "---");
            bowlingTeam.printBowlingScoreCard();
        }

        System.out.println();
        if (teamA.isWinner) {
            System.out.println("---WINNER---" + teamA.teamName);

        } else {
            System.out.println("---WINNER---" + teamB.teamName);

        }
    }

    public Team toss(Team a,Team b)
    {
        if(Math.random()<0.5)
            return teamA;
        else
            return teamB;
    }
}

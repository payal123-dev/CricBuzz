package ScoreUpdater;


import Team.RunType;
import Innings.Ball;

public class BattingScoreUpdater implements ScoreUpdaterObserver {


    @Override
    public void update(Ball ball) {

        int run = 0;
        if (RunType.ONE == ball.runType) {
            run = 1;
        } else if (RunType.TWO == ball.runType) {
            run = 2;
        } else if (RunType.FOUR == ball.runType) {
            run = 4;
            ball.playerBy.battingScoreCard.totalFours++;
        } else if (RunType.SIX == ball.runType) {
            run = 6;
            ball.playerBy.battingScoreCard.totalSix++;
        }
        ball.playerBy.battingScoreCard.totalRuns += run;

        ball.playerBy.battingScoreCard.totalBallsPlayed++;

        if (ball.wicket != null) {
            ball.playerBy.battingScoreCard.wicketDetails = ball.wicket;
        }

    }
}


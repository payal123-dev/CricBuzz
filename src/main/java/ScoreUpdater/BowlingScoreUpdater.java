package ScoreUpdater;

import Innings.Ball;
import Innings.BallType;
import Team.RunType;

public class BowlingScoreUpdater implements ScoreUpdaterObserver{
    @Override
    public void update(Ball ball) {
        if (ball.ballNo == 6 && ball.ballType == BallType.NORMAL) {
            ball.bowledby.bowlingScoreCard.totalOversCount++;
        }

        if (RunType.ONE == ball.runType) {
            ball.bowledby.bowlingScoreCard.runsGiven += 1;
        } else if (RunType.TWO == ball.runType) {
            ball.bowledby.bowlingScoreCard.runsGiven += 2;
        } else if (RunType.FOUR == ball.runType) {
            ball.bowledby.bowlingScoreCard.runsGiven += 4;
        } else if (RunType.SIX == ball.runType) {
            ball.bowledby.bowlingScoreCard.runsGiven += 6;
        }

        if (ball.wicket != null) {
            ball.bowledby.bowlingScoreCard.wicketsTaken++;
        }

        if (ball.ballType == BallType.NOBALL) {
            ball.bowledby.bowlingScoreCard.noBallCount++;
        }

        if (ball.ballType == BallType.WIDEBALL) {
            ball.bowledby.bowlingScoreCard.wideBallCount++;
        }




    }
}

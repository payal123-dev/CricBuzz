package Team;

import Innings.Ball;
import Innings.BallType;

import java.util.ArrayList;
import java.util.List;

public class Over {

    public int overNo;
    public Player bowlerName;
    public int extraBallCount;
    public List<Ball> balls;

    public Over(int overNo, Player bowlerName) {
        this.overNo = overNo;
        this.bowlerName = bowlerName;
        this.balls = new ArrayList<>();
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception {
        int ballCount=1;
        while(ballCount<=6)
        {
            Ball ball=new Ball(ballCount);
            ball.startBallDelivery(battingTeam,bowlingTeam,this);
            if(ball.ballType== BallType.NORMAL)
            {
                balls.add(ball);
                ballCount++;

                if (ball.wicket != null) {
                    battingTeam.chooseNextBatsMan();
                }

                if (runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin) {
                    battingTeam.isWinner = true;
                    return true;
                }

            }
            else {
                extraBallCount++;
            }
        }

        return false;
    }
}

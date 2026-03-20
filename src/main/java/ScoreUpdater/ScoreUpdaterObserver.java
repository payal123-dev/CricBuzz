package ScoreUpdater;

import Innings.Ball;

public interface ScoreUpdaterObserver {

    void update(Ball ball);
}

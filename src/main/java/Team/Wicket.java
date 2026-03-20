package Team;

import Innings.Ball;

public class Wicket {

    public WicketType wicketType;
    public Player takenBy;
    public Over overDetail;
    public Ball ballDetail;

    public Wicket(WicketType wicketType, Player takenBy, Over overDetail, Ball ballDetail) {
        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.overDetail = overDetail;
        this.ballDetail = ballDetail;
    }
}

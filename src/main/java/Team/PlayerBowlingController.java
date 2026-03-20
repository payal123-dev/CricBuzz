package Team;

import java.util.*;

public class PlayerBowlingController {

    Deque<Player> bowlersList;
    Map<Player,Integer> bowlerVsOverCount;
    Player currentBowler;
    public PlayerBowlingController(List<Player> bowlersList) {
        setBowlersList(bowlersList);
    }

    public void setBowlersList(List<Player> bowlersList) {
        this.bowlersList = new LinkedList<>();
        bowlerVsOverCount=new HashMap<>();
        for(Player player:bowlersList)
        {
            this.bowlersList.addLast(player);
            bowlerVsOverCount.put(player, 0);

        }

    }

    public void getNextBowler(int maxOverCountBowler)
    {
        Player nextBowler=bowlersList.poll();
        if(bowlerVsOverCount.get(nextBowler)+1==maxOverCountBowler)
        {
            currentBowler=nextBowler;
        }
        else
        {
            currentBowler=nextBowler;
            bowlersList.add(nextBowler);
            bowlerVsOverCount.put(nextBowler,bowlerVsOverCount.get(nextBowler)+1);
        }

    }

    public Player getCurrentBowler() {
        return currentBowler;
    }
}

package org.CricBuzz;
import Innings.Match;
import Innings.MatchType;
import Innings.T20Match;
import Team.Team;
import Team.Player;
import Team.PlayerType;
import Team.Person;

import java.util.*;

public class CricBuzzDemo {
    public static void main(String[] args) throws Exception {
        CricBuzzDemo demoObj = new CricBuzzDemo();

        Team teamA = demoObj.addTeam("India");
        Team teamB = demoObj.addTeam("SriLanka");

        MatchType matchType = new T20Match();
        Match match=new Match(teamA,teamB,null,"SS STADIUM",matchType);
        match.startMatch();

    }

    private Team addTeam(String name) {
        Queue<Player> playerDetails  = new LinkedList<>();

        Player p1 = addPlayer(name + "1", PlayerType.ALLROUNDER);
        Player p2 = addPlayer(name + "2", PlayerType.ALLROUNDER);
        Player p3 = addPlayer(name + "3", PlayerType.ALLROUNDER);
        Player p4 = addPlayer(name + "4", PlayerType.ALLROUNDER);
        Player p5 = addPlayer(name + "5", PlayerType.ALLROUNDER);
        Player p6 = addPlayer(name + "6", PlayerType.ALLROUNDER);
        Player p7 = addPlayer(name + "7", PlayerType.ALLROUNDER);
        Player p8 = addPlayer(name + "8", PlayerType.ALLROUNDER);
        Player p9 = addPlayer(name + "9", PlayerType.ALLROUNDER);
        Player p10 = addPlayer(name + "10", PlayerType.ALLROUNDER);
        Player p11 = addPlayer(name + "11", PlayerType.ALLROUNDER);

        playerDetails.add(p1);
        playerDetails.add(p2);
        playerDetails.add(p3);
        playerDetails.add(p4);
        playerDetails.add(p5);
        playerDetails.add(p6);
        playerDetails.add(p7);
        playerDetails.add(p8);
        playerDetails.add(p9);
        playerDetails.add(p10);
        playerDetails.add(p11);

        List<Player> bowlers = new ArrayList<>();
        bowlers.add(p8);
        bowlers.add(p9);
        bowlers.add(p10);
        bowlers.add(p11);

        Team team = new Team(name, playerDetails , new ArrayList<>(), bowlers);
        return team;

    }

    private Player addPlayer(String name, PlayerType playerType) {

        Person person = new Person();
        person.name = name;
        Player playerDetails = new Player(person, playerType);
        return playerDetails;
    }
}

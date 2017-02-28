package ex6;

import java.util.HashMap;

public class Team {
    private String name;
    private HashMap<String,Player> players;

    public Team(String name) {
        this.setName(name);
        players = new HashMap<>();
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double calcRating() {
        if (players.size() > 0) {
            double rating = 0;
            for (String s : players.keySet()) {
                rating += players.get(s).getSkill();
            }
            return rating / players.keySet().size();
        }else {
            return 0;
        }
    }

    public void addPlayer(Player player){
        players.put(player.getName(), player);
    }

    public void removePlayer(String playerName){
        if (players.containsKey(playerName)) {
            players.remove(playerName);
        }else {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.",
                                        playerName, this.getName()));
        }
    }


}

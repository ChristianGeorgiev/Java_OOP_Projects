package ex8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer {
    private String name;
    private int badgesCount;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.setName(name);
        this.setBadgesCount(0);
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadgesCount() {
        return this.badgesCount;
    }

    public void setBadgesCount(int badgesCount) {
        this.badgesCount = badgesCount;
    }

    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(this.pokemons);
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon){
        this.pokemons.remove(pokemon);
    }

    public void elementarize(String element){
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)){
                this.setBadgesCount(this.getBadgesCount()+1);
                return;
            }
        }

        for (int i = 0; i < this.pokemons.size(); i++) {
            this.pokemons.get(i).setHealth(this.pokemons.get(i).getHealth() - 10);
            if (this.pokemons.get(i).getHealth() <= 0){
                this.removePokemon(this.pokemons.get(i));
            }
        }
    }

}

package ex9;


import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(this.pokemons);
    }

    public List<Parent> getParents() {
        return Collections.unmodifiableList(this.parents);
    }

    public List<Child> getChildren() {
        return Collections.unmodifiableList(this.children);
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent){
        this.parents.add(parent);
    }

    public void addChild(Child child){
        this.children.add(child);
    }
}

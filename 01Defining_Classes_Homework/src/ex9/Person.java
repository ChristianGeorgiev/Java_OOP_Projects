package ex9;


import java.util.ArrayList;
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
        this.setName(name);
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%n", this.getName()));
        sb.append(String.format("%s%n", "Company:"));
        if (this.getCompany() != null){
            sb.append(this.getCompany().toString());
        }
        sb.append(String.format("%s%n", "Car:"));
        if (this.getCar() != null){
            sb.append(this.getCar().toString());
        }
        sb.append(String.format("%s%n", "Pokemon:"));
        if (this.getPokemons().size() > 0){
            for (Pokemon pokemon : pokemons) {
                sb.append(pokemon.toString());
            }
        }
        sb.append(String.format("%s%n", "Parents:"));
        if (this.getParents().size() > 0){
            for (Parent parent : parents) {
                sb.append(parent.toString());
            }
        }
        sb.append(String.format("%s%n", "Children:"));
        if (this.getChildren().size() > 0){
            for (Child child : children) {
                sb.append(child.toString());
            }
        }
        return sb.toString();
    }
}

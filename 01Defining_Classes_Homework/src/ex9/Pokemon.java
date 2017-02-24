package ex9;

public class Pokemon {
    private String name;
    private String element;

    public Pokemon(String name, String element) {
        this.name = name;
        this.element = element;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return this.element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}

package ex5;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    public Object getRandomElement(){
        Random rand = new Random(this.size());
        Object currentObject = this.get(rand.nextInt());
        this.remove(rand.nextInt());
        return currentObject;
    }

}

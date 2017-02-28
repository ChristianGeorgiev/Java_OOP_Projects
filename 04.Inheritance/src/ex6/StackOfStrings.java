package ex6;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings(){
        data = new ArrayList<>();
    }

    public void push(String item){
        data.add(0, item);
    }

    public String pop(){
        String element = data.get(0);
        data.remove(0);
        return element;
    }

    public String peek(){
        return data.get(0);
    }

    public boolean isEmpty(){
        return (data.size() == 0 || data == null);
    }


}

package Paw_Inc;

import java.util.*;

public abstract class Center {
    private String name;

    protected Center(String name){
        this.setName(name);
    }

    protected String getName(){
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

}

package by.gorbov.space.lab;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Singleton {

    private static Singleton singleton;

    public Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    

    public Singleton() {}

    private String name;

    private static String staticName;


    public String getStaticName() {
        return staticName;
    }

    public void setStaticName(String staticName) {
        Singleton.staticName = staticName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

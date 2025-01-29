package by.gorbov.space.lab;

import by.gorbov.space.lab.composit.Brunch;
import by.gorbov.space.lab.composit.Composit;
import by.gorbov.space.lab.composit.Leaf;
import org.apache.tomcat.util.digester.ArrayStack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Client {
    public static void main(String[] args) {


        Brunch root = new Brunch();

        Brunch child = new Brunch();
        Brunch child2 = new Brunch();
        List<Composit> composits = new ArrayList<>();
        composits.add(child);
        composits.add(child2);

        Composit leaf = new Leaf();
        Composit leaf2 = new Leaf();
        List<Composit> leafs = new ArrayList<>();
        leafs.add(leaf);
        leafs.add(leaf2);


        Leaf leaf3 = new Leaf();
        Leaf leaf4 = new Leaf();
        List<Composit> leafs2 = new ArrayList<>();
        leafs2.add(leaf3);
        leafs2.add(leaf4);

        root.setComposits(composits);

        child.setComposits(leafs);
        child2.setComposits(leafs2);




    }

}

package by.gorbov.space.entity;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class    LambdaExample {



    public static void main(String[] args) {

        // создаю лист целых чисел
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            integerList.add(i);
        }

        // фильтрую лист
        List<Integer> filtredList = integerList
                .stream()
                .filter((I)->I%2==0)
                .filter((I)->I%3==0)
                .toList();



        // Comparator - указывает как сранить объкты
        Comparator<Galaxy> comparator =
                Comparator.comparing(galaxy->galaxy
                        .getStarSystems()
                        .size());

        // создаю две галактики
        Galaxy galaxy = new Galaxy();
        galaxy.setId(1L);
        galaxy.setName("9809");
        galaxy.setStarSystems(new ArrayList<>());

        Galaxy galaxy1  = new Galaxy();
        galaxy1.setName("123");
        List<StarSystem> starSystemList = new ArrayList<>();
        starSystemList.add(new StarSystem());
        starSystemList.add(new StarSystem());
        starSystemList.add(new StarSystem());
        galaxy1.setStarSystems(starSystemList);



        List<Galaxy> galaxyList = new ArrayList<>();
        galaxyList.add(galaxy1);
        galaxyList.add(galaxy);

        //превращаю галктики в системы
        List<StarSystem> mapStarSystemList = galaxyList.stream()
                .flatMap(g->g.getStarSystems().stream()).toList();


       for (StarSystem s : mapStarSystemList){
           System.out.println(s);
       }
    }

}

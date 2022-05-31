package bf.java.ex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        GameMaster gm = new GameMaster();

//        int val = 15;
//        String res = switch (val) { //switch expression since java 14
//            case 1,4 -> "UN";
//            case 2 -> "DEUX";
//            default -> "BLOP";
//        };
//
//        var test = ""; //type inféré compilation pas modifiable utile si type complexe liste de liste
//        List<Integer> ints = List.of(1,2,3,4,5,6,7);
//        //ints.forEach(System.out::println);
//        ints.forEach(Main::display);
//        int[] ints1 = {1,2,3,4,5};
//        Arrays.stream(ints1).forEach(Main::display);
//
//        Map<String,Integer> map  = new HashMap<>();
//        map.put("ol",12);
//        map.forEach(Main::display);
//        map.forEach((key,value) -> System.out.printf("%s : %d",key,value) );
    }

    public static void display(int it) {
        System.out.println("it : "+it);
    }

    public static void display(String key,int it) {
        System.out.printf("%s : %d",key,it);
    }

}

package bf.java.ex;

import bf.java.ex.delegate.Action;

public class Main {
    public static void main(String[] args) {
        GameMaster gm = new GameMaster();
        //Spell s = new Spell(2,5);

        //demo(Map::Deplacer)
        //demo(pos -> map.deplacer);
        //demo(System.out::println);
    }

    public static void demo(Action<Integer> action) {
        action.execute(42);
    }
}

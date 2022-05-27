package bf.java.ex.map;

public class PlainSquare extends MapSquare{
    @Override
    public String toString() {
        if(character==null) {
            return ".";
        }else {
            return character.toString();
        }
    }
}

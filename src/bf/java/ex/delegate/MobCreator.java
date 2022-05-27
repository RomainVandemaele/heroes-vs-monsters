package bf.java.ex.delegate;

import java.util.ArrayList;

public interface MobCreator<T> {
    public T createMobs(int posX,int posY);
}

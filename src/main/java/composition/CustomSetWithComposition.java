package composition;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CustomSetWithComposition<E> {
    private Set<E> set;
    private int addCount=0;

    public CustomSetWithComposition(Set<E> set) {
        this.set = set;
    }

    public boolean add(E e) {
        addCount++;
        return set.add(e);
    }

    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return set.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public int getSize(){
        return set.size();
    }
    public void getThree(){

    }
}

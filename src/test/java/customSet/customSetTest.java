package customSet;

import composition.CustomSet;
import composition.CustomSetWithComposition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class customSetTest {

    @Test
    @DisplayName("상속한 경우 추가된 원소 개수를 확인한다")
    void testAddAll() {
        CustomSet<String> mySet = new CustomSet<>();
        mySet.addAll(Arrays.asList("a","b","c"));

        assertEquals(mySet.size(), mySet.getAddCount());
    }

    @Test
    @DisplayName("클래스가 구현에 의존한다")
    void testDependency(){
        CustomSet<String> mySet = new CustomSet<>();
    }

    @Test
    @DisplayName("합성한 경우 추가원소 개수를 확인한다")
    void testComposition(){
        CustomSetWithComposition<String> mySet = new CustomSetWithComposition(new HashSet());
        mySet.addAll(Arrays.asList("a","b","c"));

        assertEquals(mySet.getSize(), mySet.getAddCount());

        CustomSetWithComposition<String> mySet2 = new CustomSetWithComposition(new TreeSet());
        mySet2.addAll(Arrays.asList("a","b","c"));

        assertEquals(mySet2.getSize(), mySet2.getAddCount());

    }

}

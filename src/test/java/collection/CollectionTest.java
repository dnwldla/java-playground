package collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CollectionTest{

    @Test
    @DisplayName("hashMap에 null이 가능한지 확인")
    void testNull(){
        Map<Integer,Integer> map = new HashMap<>();

        map.put(null,1);
        map.put(null,2);
        map.put(null,null);
        System.out.println(map.get(null));
    }

    @Test
    @DisplayName("treeMap 정렬 기준을 확인한다")
    void testTreeMap(){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(1,1);
        map.put(3,3);
        map.put(2,2);

        System.out.println(map);
    }

    @Test
    @DisplayName("Comparable을 구현하지 않은 경우를 관챃한다")
    void testComparable(){
        TreeMap<Person, String> map = new TreeMap<>();

        Person p1 = new Person(20);
        Person p2 = new Person(30);

        assertThrows(ClassCastException.class, () -> {
            map.put(p1, "hello");
            map.put(p2, "world");
        });

    }

    @Test
    @DisplayName("Comparable을 구현한 경우를 관챃한다")
    void testComparable2(){
        TreeMap<Person2, String> map = new TreeMap<>();

        Person2 p1 = new Person2(30);
        Person2 p2 = new Person2(20);

        map.put(p1, "hello");
        map.put(p2, "world");

        System.out.println(map);

    }

    static class Person{
        int age;

        public Person(int age) {
            this.age = age;
        }
    }

    static class Person2 implements Comparable<Person2>{
        int age;

        public Person2(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Person2 o) {
            return this.age - o.age;
        }

        int getAge(){
            return age;
        }
    }



}
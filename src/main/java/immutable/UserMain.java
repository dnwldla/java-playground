package immutable;

import java.util.ArrayList;
import java.util.List;


/**
 * 불변객체여도 필드가 바뀔 수 있음-> Final 조합
 */
public class UserMain {
    public static void main(String[] args) {
        List<User> originalList = new ArrayList<>();
        originalList.add(new User("Alice", 20));
        originalList.add(new User("Bob", 25));
        originalList.add(new User("Charlie", 30));

        //originalList와 독립적인 분변리스트
        List<User> immutableList = originalList.stream()
                .map(user -> new User(user.name(), user.age()))
                .toList();

        //불변이므로 ide warning
        //immutableList.set(0,new User("Alice", 20));

        //final을 붙이지 않으면 불변객체여도 나이가 바뀐다
        //immutableList.setAge(30);
        System.out.println(immutableList.getFirst().age());


    }
}

package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static stream.FilteringApple.Color.GREEN;

public class FilteringApple {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));

        //1. 동적 파라미터화
        filterGreenApple(inventory,GREEN);
        filterByWeight(inventory,100);

        //2. 전략패턴으로 추상화
        filterApple(inventory,new ColorPredicate());

        //3. 익명클래스로 클래스 선언, 인스턴스화를 동시에
        filterApple(inventory, new Predicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == GREEN;

            }
        });

        //4.  람다로 리팩토링
        filterApple(inventory,(Apple apple) -> apple.getColor() == GREEN);

        /**
         * 인터페이스 구현
         */
        inventory.sort(new AppleWeightComparator());

        /**
         * 익명클래스 구현
         */
        inventory.sort(new Comparator<Apple>() {

            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        /**
         * 람다
         */
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight());
    }

    public static class AppleWeightComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }

    public static List<Apple> filterApple(List<Apple> inventory, Predicate predicate) {
        List<Apple> result=new ArrayList<>();

        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    interface Predicate{
        boolean test(Apple apple);
    }

    static class ColorPredicate implements Predicate{

        @Override
        public boolean test(Apple apple) {
            return apple.getColor() == GREEN;
        }
    }

    static class WeightPredicate implements Predicate{

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight()>=150;
        }
    }

    public static List<Apple> filterGreenApple(List<Apple> inventory,Color color){
        List<Apple> result=new ArrayList<>();

        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterByWeight(List<Apple> inventory,int weight){
        List<Apple> result=new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getWeight()>weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {

        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color=%s, weight=%d}", color, weight);
        }

    }

    enum Color {
        RED,
        GREEN
    }

}

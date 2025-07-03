package immutable;

public class User {
    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() { return name; }
    public int age() { return age; }

    //final을 붙였기 때문에 컴파일 오류
//    public void setAge(int age){
//        this.age = age;
//    }

}

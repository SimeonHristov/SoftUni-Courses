package _04_Interfaces_And_Abstraction.P03_SayHello;

public interface Person {
    String getName();
    default String sayHello(){
        return "Hello";
    }
}

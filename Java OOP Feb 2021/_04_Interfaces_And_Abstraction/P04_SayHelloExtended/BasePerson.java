package _04_Interfaces_And_Abstraction.P04_SayHelloExtended;

public abstract class BasePerson implements Person {
    private String name;

    protected
    BasePerson (String name) {
        this.name = name;
    }

    private
    void setName (String name) {
        this.name = name;
    }

    @Override
    public
    String getName () {
        return name;
    }

    public String sayHello(){
        return "Hello";
    }
}
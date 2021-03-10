package _04_Interfaces_And_Abstraction.P03_SayHello;

public class Bulgarian implements Person{
    private String name;

    public
    Bulgarian (String name) {
        this.name = name;
    }

    @Override
    public
    String getName () {
        return this.name;
    }

    @Override
    public
    String sayHello () {
        return "Здравей";
    }
}

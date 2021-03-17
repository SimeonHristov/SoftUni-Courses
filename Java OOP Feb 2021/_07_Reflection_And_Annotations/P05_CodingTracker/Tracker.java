package _07_Reflection_And_Annotations.P05_CodingTracker;

public class Tracker {
    @Author(name = "Pesho")
    public void test(){

    }

    @Author(name = "Gosho")
    private static void methodByGosho(){

    }

    @Author(name = "Gosho")
    public String tester(){
        return "Test";
    }
}
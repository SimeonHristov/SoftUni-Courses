package com.company.Exercise02;

import java.awt.*;
import java.util.*;
public class Hal{


    //AUTO MOUSE MOVER

    public static void main(String[] args) throws Exception{
        Robot hal = new Robot();
        Random random = new Random();
        while(true){
            hal.delay(1000 * 60);//timer
            int x = random.nextInt() % 640;
            int y = random.nextInt() % 480;
            hal.mouseMove(x,y);
        }
    }
}





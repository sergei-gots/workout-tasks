package org.example;


import java.lang.annotation.Annotation;
import java.util.*;
import java.util.function.Function;

import static java.lang.System.out;

class MyStringBuilder  {
    static int counter = 0;
    public MyStringBuilder () {
        out.println("I am a StringBuilder number "  + ++counter);
    }

    String startsWithT(String source) {
        return source + "!)";
    }
}

public class StreamWorkout {

    public static boolean filter1(String x) {
        out.println("filter1: x = " + x);
        return x.length()==3;
    }

    public static boolean filter2(String x) {
        out.println("filter2: x = " + x);
        return x.startsWith("t");
    }


    public static String map1(String x) {
        out.println("map1: x = " + x);
        return new StringBuilder().append(x).reverse().toString();
    }
    public static String map2(String x) {
        out.println("map2: x = " + x);
        return new MyStringBuilder().startsWithT(x);
    }

    public static void foreach(String x) {
        out.println("forEach: x = " + x);
    }

    public static String orElse() {
        out.println("orElse()-method is invoked");
        return "There isn't any matched string in the result";
    }

    public static void main(String [] args) {
              List<String> stringList = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        String result =
                stringList.stream()

                .filter(StreamWorkout::filter1)

                .map(StreamWorkout::map1)
                        .peek(x ->out.println("Peek after map1: " + x))
                .filter(StreamWorkout::filter2)
                .map(StreamWorkout::map2)
                        .reduce("result=", (acc, s) -> acc + ", " + s);

          //      .findAny().orElse("There is no matched string");
         //    .forEach(StreamWorkout::foreach);
        //out.println("found by findAny: result = " + result);

    }
}

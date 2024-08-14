package de.ait;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("jack","ann","bill","lena");

        List<String> res = stringListHandler(list, new Transformer1());
        System.out.println(res);

        List<String> res2 = stringListHandler(list, new Transformer2());
        System.out.println(res2);

        List<String> res3 = stringListHandler(list,  s  -> s +"_qwert !" );
        System.out.println(res3);

        List<String> res4 = stringListHandler(list,  s  -> "{"+ s +"}", s -> s.startsWith("a") );
        System.out.println(res4);


    }
    public static List<String> stringListHandler (List<String> list, StringTransformer transformer) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            element = transformer.transform(element);
            result.add(element);
        }
        return result;
    }
    public static List<String> stringListHandler (List<String> list,
                                                  StringTransformer transformer,
                                                  Predicate<String> predicate ) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            if (predicate.test(element)) {
            element = transformer.transform(element);
            result.add(element);
        }
        }
        return result;
    }
}

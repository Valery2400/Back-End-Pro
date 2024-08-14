package de.ait;

public class Transformer1 implements StringTransformer {
@Override
    public String transform(String str) {
        return "(" + str + ")";
    }
}

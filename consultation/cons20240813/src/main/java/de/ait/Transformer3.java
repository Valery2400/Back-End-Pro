package de.ait;

public class Transformer3 implements StringTransformer {
@Override
    public String transform(String str) {
        return str.toUpperCase();
    }
}

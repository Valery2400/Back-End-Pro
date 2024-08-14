package de.ait;

public class Transformer2 implements StringTransformer {
@Override
    public String transform(String str) {
        return str.toUpperCase();
    }
}

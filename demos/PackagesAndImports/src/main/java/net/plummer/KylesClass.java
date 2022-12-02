package net.plummer;

import java.util.Objects;

public class KylesClass {
    private int a = 5;
    private String str = "Hello";

    public KylesClass(int a, String str) {
        this.a = a;
        this.str = str;
    }

    public KylesClass() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

}

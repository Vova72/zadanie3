package com.company;

public class Tester {
    @Save private int a;
    @Save public String b;

    public Tester() {
        super();
    }
    public Tester(int a, String b) {
        super();
        this.a = a;
        this.b = b;
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Tester{ a=" + a + ", b=" + b + '}';
    }
}

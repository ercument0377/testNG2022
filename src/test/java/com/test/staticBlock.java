package com.test;

public class staticBlock {
    public static void main(String[] args){
        System.out.println("main method çalisti");
        a1();
        a2();
    }

    private static void a1() {
        System.out.println("a1 method çalisti");
    }
    static {
        System.out.println("static 2");
    }

    private static void a2() {
        System.out.println("a2 method çalisti");

    }
    static {
        System.out.println("static 1");
    }
}

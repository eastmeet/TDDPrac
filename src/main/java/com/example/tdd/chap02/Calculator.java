package com.example.tdd.chap02;

public class Calculator {

    /**
     * src/test/java 소스 폴더는 배포 대상이 아니므로 src/test/java 폴더에 코드를 만들면
     * 완성되지 않은 코드가 배포되는 것을 방지하는 효과가 있다.
     */
//    public static int plus(int a, int b) {
//        return 0;
//    }

    public static int plus(int a, int b) {
        return a + b;
    }

}

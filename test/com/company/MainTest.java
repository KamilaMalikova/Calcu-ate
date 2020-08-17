package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void operationTest() {
        assertEquals("3", Main.operation("1 + 2"));
    }
    @Test
    void operationTest1() {
        assertEquals("II", Main.operation("VI / III"));
    }
    @Test
    void operationTest2() {
        assertEquals("C", Main.operation("X * X"));
    }

    @Test
    void operationTest3() {
        assertEquals("0", Main.operation("5 - 5"));
    }

    @Test
    void operationTest4() {
        assertEquals("N", Main.operation("V - V"));
    }
    @Test
    void operationTest5() {
        assertEquals("X", Main.operation("V+V"));
    }
    @Test
    void operationTest6() {
        assertEquals("-1", Main.operation("9-10"));
    }
    @Test
    void operationTest7() {
        assertEquals("-IX", Main.operation("I-X"));
    }

}
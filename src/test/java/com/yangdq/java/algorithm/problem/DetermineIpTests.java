package com.yangdq.java.algorithm.problem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("判断字符串是否是IP")
public class DetermineIpTests {

    @Test
    @DisplayName("空字符串")
    void test1() {
        assertFalse(DetermineIp.isIp(""));
    }

    @Test
    @DisplayName(".")
    void test2() {
        assertFalse(DetermineIp.isIp("."));
    }

    @Test
    @DisplayName("..")
    void test3() {
        assertFalse(DetermineIp.isIp(".."));
    }

    @Test
    @DisplayName("...")
    void test4() {
        assertFalse(DetermineIp.isIp("..."));
    }

    @Test
    @DisplayName("....")
    void test5() {
        assertFalse(DetermineIp.isIp("...."));
    }

    @Test
    @DisplayName("-200")
    void test6() {
        assertFalse(DetermineIp.isIp("-200"));
    }

    @Test
    @DisplayName("-200.")
    void test7() {
        assertFalse(DetermineIp.isIp("-200."));
    }

    @Test
    @DisplayName("-200.200.200.200")
    void test8() {
        assertFalse(DetermineIp.isIp("-200.200.200.200"));
    }

    @Test
    @DisplayName("-200.-200.200.200")
    void test9() {
        assertFalse(DetermineIp.isIp("-200.-200.200.200"));
    }

    @Test
    @DisplayName("-200.-200.-200.200")
    void test10() {
        assertFalse(DetermineIp.isIp("-200.-200.-200.200"));
    }

    @Test
    @DisplayName("-200.-200.-200.-200")
    void test11() {
        assertFalse(DetermineIp.isIp("-200.-200.-200.200"));
    }

    @Test
    @DisplayName("-200.-200.-200.-200")
    void test12() {
        assertFalse(DetermineIp.isIp("-200.-200.-200.-200"));
    }

    @Test
    @DisplayName("-2000.-200.-200.-200")
    void test13() {
        assertFalse(DetermineIp.isIp("-200.200.200.200"));
    }

    @Test
    @DisplayName("200.200.200.200")
    void test14() {
        assertTrue(DetermineIp.isIp("200.200.200.200"));
    }

    @Test
    @DisplayName("300.200.200.200")
    void test15() {
        assertFalse(DetermineIp.isIp("300.200.200.200"));
    }

    @Test
    @DisplayName("300.200.200")
    void test16() {
        assertFalse(DetermineIp.isIp("300.200.200"));
    }

    @Test
    @DisplayName("200.200..")
    void test17() {
        assertFalse(DetermineIp.isIp("200.200.."));
    }

    @Test
    @DisplayName("200...")
    void test18() {
        assertFalse(DetermineIp.isIp("200..."));
    }

    @Test
    @DisplayName(".200..")
    void test19() {
        assertFalse(DetermineIp.isIp(".200.."));
    }

    @Test
    @DisplayName("..200.")
    void test20() {
        assertFalse(DetermineIp.isIp("..200."));
    }

    @Test
    @DisplayName("...200")
    void test21() {
        assertFalse(DetermineIp.isIp("...200"));
    }

    @Test
    @DisplayName("200.200.200.200.200")
    void test22() {
        assertFalse(DetermineIp.isIp("200.200.200.200.200"));
    }

    @Test
    @DisplayName("200.200.200.200.")
    void test23() {
        assertFalse(DetermineIp.isIp("200.200.200.200."));
    }
}

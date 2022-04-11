package com.home.testapplication;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriceTest {

    @Test
    public void fiveElementPrice() {
        int[] price = {5, 100, 20, 66, 16};
        int discount = 50;
        int offset = 1;
        int readLength = 3;
        int[] verificationResult = {50, 10, 33};
        int[] actualResult = Price.decryptData(price, discount, offset, readLength);
        assertArrayEquals(actualResult, verificationResult);
    }

    @Test
    public void zeroSizePrice() {
        int[] price = {};
        int discount = 50;
        int offset = 1;
        int readLength = 3;
        int[] verificationResult = null;
        int[] actualResult = Price.decryptData(price, discount, offset, readLength);
        assertArrayEquals(actualResult, verificationResult);
    }

    @Test
    public void lengthOversize() {
        int[] price = {5, 100, 20, 66, 16};
        int discount = 50;
        int offset = 1;
        int readLength = 5;
        int[] verificationResult = null;
        int[] actualResult = Price.decryptData(price, discount, offset, readLength);
        assertArrayEquals(actualResult, verificationResult);
    }

    @Test
    public void incorrectOffset() {
        int[] price = {5, 100, 20, 66, 16};
        int discount = 50;
        int offset = -1;
        int readLength = 3;
        int[] verificationResult = null;
        int[] actualResult = Price.decryptData(price, discount, offset, readLength);
        assertArrayEquals(actualResult, verificationResult);
    }

    @Test
    public void zeroReadLength() {
        int[] price = {5, 100, 20, 66, 16};
        int discount = 50;
        int offset = 5;
        int readLength = 0;
        int[] verificationResult = null;
        int[] actualResult = Price.decryptData(price, discount, offset, readLength);
        assertArrayEquals(actualResult, verificationResult);
    }
}
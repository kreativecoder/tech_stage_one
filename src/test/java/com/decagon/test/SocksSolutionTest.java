package com.decagon.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SocksSolutionTest {


    @Test
    void testGetMaximumPair() {
        assertEquals(3, SocksSolution.getMaximumPair(2,
            new int[]{1, 2, 1, 1},
            new int[]{1, 4, 3, 2, 4}));

        assertEquals(1, SocksSolution.getMaximumPair(0,
            new int[]{1, 2, 1, 1},
            new int[]{1, 4, 3, 2, 4}));


        assertEquals(1, SocksSolution.getMaximumPair(2,
            new int[]{1, 2, 1, 1},
            new int[]{}));


        assertEquals(4, SocksSolution.getMaximumPair(5,
            new int[]{1, 2, 1, 1},
            new int[]{1, 4, 3, 2, 4}));
    }
}
package com.endava.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void heartPrintsHeart() {
//        assertEquals("\u2665", Suit.HEARTS.toString());
        assertEquals("heart", Suit.HEARTS.toString());
    }

    @Test
    void diamondsPrintsDiamonds() {
//        assertEquals("\u2665", Suit.HEARTS.toString());
        assertEquals("diamonds", Suit.DIAMONDS.toString());
    }
}
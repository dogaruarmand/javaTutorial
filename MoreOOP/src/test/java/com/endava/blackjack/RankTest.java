package com.endava.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    void getValueOfKing() {
//        Rnk KING = new Rank("KING"); equivalent with bellow
        assertEquals(10, Rank.KING.getValue());
    }
}
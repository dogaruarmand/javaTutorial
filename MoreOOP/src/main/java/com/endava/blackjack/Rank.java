package com.endava.blackjack;

public enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    // Rnk KING = new Rank("KING"); equivalent with bellow
    public int getValue() {
        return switch(this) {
            case JACK, QUEEN, KING -> 10;
            default -> ordinal() + 1;
        };
    }
}

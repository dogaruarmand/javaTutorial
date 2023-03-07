package com.endava.blackjack;

public enum Suit {
    /**
     * This is an enum that models the suits / color/type of a card
     */
    CLUBS('\u2663'),
    DIAMONDS('\u2666'),
    HEARTS('\u2665'),
    SPADES('\u2660');

    private char symbol;


    Suit(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return Character.toString(this.symbol);
    }
}

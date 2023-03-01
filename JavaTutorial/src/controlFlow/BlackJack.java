package controlFlow;

public class BlackJack {
    public static void main(String[] args) {
        String card = "ace";
        int currentTotalValue = 10;

        int currentValue = switch (card) {
            case "king", "queen", "jack" -> 10;
            case "ace" -> {
                if (currentTotalValue < 11) {
                    yield 11;
                } else {
                    yield 1;
                }
            }
            default -> Integer.parseInt(card);
        };
        System.out.printf("Current card value: %d%n", currentValue);
        System.out.printf("Total value %d%n", currentTotalValue + currentValue);
    }
}

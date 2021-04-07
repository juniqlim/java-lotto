package im.juniq.lotto.domain;

public class Price {

    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public Price(int price) {
        this.price = price;
    }

    public static Price of(String price) {
        return of(Integer.parseInt(price));
    }

    public static Price of(int price) {
        checkPrice(price);
        return new Price(price);
    }

    private static void checkPrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new RuntimeException("금액은 " + LOTTO_PRICE + "원 단위로 입력해주세요.");
        }
    }

    public int numberOfLottoPurchased() {
        return price / LOTTO_PRICE;
    }

    public double yield(Double winningAmount) {
        return winningAmount / price;
    }
}

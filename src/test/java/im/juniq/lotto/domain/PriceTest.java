package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriceTest {
    @Test
    void create() {
        assertThatCode(() -> new Price(1000)).doesNotThrowAnyException();
    }

    @Test
    void checkPrice() {
        assertThatThrownBy(() -> new Price(1100)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void numberOfLottoPurchased() {
        assertThat(new Price(1000).numberOfLottoPurchased()).isEqualTo(1);
    }

    @Test
    void yield() {
        assertThat(new Price(10000).yield(5000D)).isEqualTo(0.5);
    }
}
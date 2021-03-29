package im.juniq.lotto;

import java.util.HashMap;
import java.util.Map;

public enum Winning {
	FIRST(6, 2000000000L),
	SECOND(5, 15000000L),
	THIRD(4, 50000L),
	FOURTH(3, 5000L),
	LOSING(2, 0L);

	private int matchedCount;
	private Long amount;

	Winning(int matchedCount, Long amount) {
		this.matchedCount = matchedCount;
		this.amount = amount;
	}

	public static Winning findByMatchedCount(int numberOfMatchedWinningNumber) {
		Map<Integer, Winning> map = new HashMap<>();
		for (Winning winning : Winning.values()) {
			map.put(winning.matchedCount, winning);
		}
		return getWinning(numberOfMatchedWinningNumber, map);
	}

	private static Winning getWinning(int numberOfMatchedWinningNumber, Map<Integer, Winning> map) {
		Winning gottenWinning = map.get(numberOfMatchedWinningNumber);
		if (gottenWinning == null) {
			return LOSING;
		}
		return gottenWinning;
	}

	public Long amount() {
		return amount;
	}

	public int matchedCount() {
		return matchedCount;
	}
}

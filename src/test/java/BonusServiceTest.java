import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit () {
        BonusService bonusService = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = bonusService.calculate(amount, registered);

        assertEquals(expected,actual);

    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit () {
        BonusService bonusService = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = bonusService.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndOverLimit () {
        BonusService bonusService = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = bonusService.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndUnderLimit () {
        BonusService bonusService = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;

        long actual = bonusService.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ThirdTask_UnitTest {

    private static final double DELTA = 1e-9;

    // ---------- nextBalance: один шаг ----------

    @Test
    @DisplayName("Пример из условия: 1000, 10%, премия 50 → 1150")
    void exampleFromTask() {
        assertEquals(1150.0, ThirdTask.nextBalance(1000, 10, 50), DELTA);
    }

    @Test
    @DisplayName("Нулевой процент — только премия")
    void zeroPercent() {
        assertEquals(1050.0, ThirdTask.nextBalance(1000, 0, 50), DELTA);
    }

    @Test
    @DisplayName("Нулевая премия — только процент")
    void zeroBonus() {
        assertEquals(1100.0, ThirdTask.nextBalance(1000, 10, 0), DELTA);
    }

    @Test
    @DisplayName("Нулевой процент и нулевая премия — баланс не меняется")
    void zeroPercentAndBonus() {
        assertEquals(1000.0, ThirdTask.nextBalance(1000, 0, 0), DELTA);
    }

    @Test
    @DisplayName("Нулевой стартовый баланс — остаётся только премия")
    void zeroBalance() {
        assertEquals(50.0, ThirdTask.nextBalance(0, 10, 50), DELTA);
    }

    @Test
    @DisplayName("Дробный процент: 1000, 5.5%, премия 0 → 1055")
    void fractionalPercent() {
        assertEquals(1055.0, ThirdTask.nextBalance(1000, 5.5, 0), DELTA);
    }

    @Test
    @DisplayName("Отрицательная премия (штраф)")
    void negativeBonus() {
        assertEquals(1050.0, ThirdTask.nextBalance(1000, 10, -50), DELTA);
    }

    // ---------- balances: массив по месяцам ----------

    @Test
    @DisplayName("Три месяца: 1000, 10%, 50 → [1150, 1315, 1496.5]")
    void threeMonths() {
        double[] expected = {1150.0, 1315.0, 1496.5};
        assertArrayEquals(expected, ThirdTask.balances(1000, 10, 50, 3), DELTA);
    }

    @Test
    @DisplayName("Один месяц — массив из одного элемента")
    void oneMonth() {
        assertArrayEquals(new double[]{1150.0},
                ThirdTask.balances(1000, 10, 50, 1), DELTA);
    }

    @Test
    @DisplayName("Ноль месяцев — пустой массив")
    void zeroMonths() {
        assertArrayEquals(new double[]{},
                ThirdTask.balances(1000, 10, 50, 0), DELTA);
    }

    @Test
    @DisplayName("Каждый месяц растёт относительно предыдущего")
    void balanceGrows() {
        double[] result = ThirdTask.balances(1000, 10, 50, 5);
        for (int i = 1; i < result.length; i++) {
            org.junit.jupiter.api.Assertions.assertTrue(
                    result[i] > result[i - 1],
                    "баланс должен расти: месяц " + (i + 1));
        }
    }

    @Test
    @DisplayName("Баланс за n месяцев совпадает с ручным расчётом")
    void matchesManualCalculation() {
        double[] result = ThirdTask.balances(1000, 10, 50, 3);

        double b1 = 1000 + 1000 * 10 / 100.0 + 50;   // 1150
        double b2 = b1   + b1   * 10 / 100.0 + 50;   // 1315
        double b3 = b2   + b2   * 10 / 100.0 + 50;   // 1496.5

        assertArrayEquals(new double[]{b1, b2, b3}, result, DELTA);
    }

    @Test
    @DisplayName("Рекурсивное совпадение: balances[n] == nextBalance(balances[n-1])")
    void consistentWithNextBalance() {
        double[] result = ThirdTask.balances(1000, 10, 50, 4);
        double prev = 1000;
        for (double current : result) {
            assertEquals(ThirdTask.nextBalance(prev, 10, 50), current, DELTA);
            prev = current;
        }
    }
}
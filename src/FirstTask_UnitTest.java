import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstTask_UnitTest {

    @Test
    @DisplayName("Пример из условия: [1,2,7,9] и [2,4,7] → 2")
    void exampleFromTask() {
        assertEquals(2, FirstTask.countMatches(
                new int[]{1, 2, 7, 9},
                new int[]{2, 4, 7}));
    }

    @Test
    @DisplayName("Полностью одинаковые массивы")
    void identicalArrays() {
        assertEquals(3, FirstTask.countMatches(
                new int[]{1, 2, 3},
                new int[]{1, 2, 3}));
    }

    @Test
    @DisplayName("Нет общих элементов")
    void noMatches() {
        assertEquals(0, FirstTask.countMatches(
                new int[]{1, 2, 3},
                new int[]{4, 5, 6}));
    }

    @Test
    @DisplayName("Первый массив пустой")
    void firstEmpty() {
        assertEquals(0, FirstTask.countMatches(
                new int[]{},
                new int[]{1, 2, 3}));
    }

    @Test
    @DisplayName("Второй массив пустой")
    void secondEmpty() {
        assertEquals(0, FirstTask.countMatches(
                new int[]{1, 2, 3},
                new int[]{}));
    }

    @Test
    @DisplayName("Оба массива пустые")
    void bothEmpty() {
        assertEquals(0, FirstTask.countMatches(
                new int[]{},
                new int[]{}));
    }

    @Test
    @DisplayName("Один общий элемент")
    void singleMatch() {
        assertEquals(1, FirstTask.countMatches(
                new int[]{5},
                new int[]{5}));
    }

    @Test
    @DisplayName("Один элемент, но разные")
    void singleNoMatch() {
        assertEquals(0, FirstTask.countMatches(
                new int[]{5},
                new int[]{6}));
    }

    @Test
    @DisplayName("Отрицательные числа")
    void negativeNumbers() {
        assertEquals(2, FirstTask.countMatches(
                new int[]{-1, -2, 3},
                new int[]{-1, 0, -2}));
    }

    @Test
    @DisplayName("Порядок элементов не важен")
    void orderDoesNotMatter() {
        assertEquals(2, FirstTask.countMatches(
                new int[]{7, 2, 1, 9},
                new int[]{7, 4, 2}));
    }

    @Test
    @DisplayName("Совпадение только в конце первого массива")
    void matchAtEndOfFirst() {
        assertEquals(1, FirstTask.countMatches(
                new int[]{1, 2, 3, 9},
                new int[]{9}));
    }

    @Test
    @DisplayName("Нули как обычные элементы")
    void zeros() {
        assertEquals(2, FirstTask.countMatches(
                new int[]{0, 5, 0},
                new int[]{0, 7}));
    }
}
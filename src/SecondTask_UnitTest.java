import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SecondTask_UnitTest {

    @Test
    @DisplayName("Пример из условия: h8 и f6 → один цвет")
    void exampleSameColor() {
        assertTrue(SecondTask.isSameColor("h8", "f6"));
    }

    @Test
    @DisplayName("Пример из условия: h8 и g8 → разные цвета")
    void exampleDifferentColor() {
        assertFalse(SecondTask.isSameColor("h8", "g8"));
    }

    @Test
    @DisplayName("Одна и та же клетка — всегда один цвет")
    void sameCell() {
        assertTrue(SecondTask.isSameColor("d4", "d4"));
    }

    @Test
    @DisplayName("Углы a1 и h8 — один цвет (диагональ)")
    void cornersA1H8() {
        assertTrue(SecondTask.isSameColor("a1", "h8"));
    }

    @Test
    @DisplayName("Углы a8 и h1 — один цвет (диагональ)")
    void cornersA8H1() {
        assertTrue(SecondTask.isSameColor("a8", "h1"));
    }

    @Test
    @DisplayName("Углы a1 и a8 — разные цвета")
    void cornersA1A8() {
        assertFalse(SecondTask.isSameColor("a1", "a8"));
    }

    @Test
    @DisplayName("Соседние по горизонтали — разные цвета")
    void horizontalNeighbours() {
        assertFalse(SecondTask.isSameColor("a1", "b1"));
    }

    @Test
    @DisplayName("Соседние по вертикали — разные цвета")
    void verticalNeighbours() {
        assertFalse(SecondTask.isSameColor("a1", "a2"));
    }

    @Test
    @DisplayName("Соседние по диагонали — один цвет")
    void diagonalNeighbours() {
        assertTrue(SecondTask.isSameColor("a1", "b2"));
    }

    @Test
    @DisplayName("Симметрия: порядок аргументов не важен")
    void orderDoesNotMatter() {
        assertTrue(SecondTask.isSameColor("h8", "f6"));
        assertTrue(SecondTask.isSameColor("f6", "h8"));

        assertFalse(SecondTask.isSameColor("h8", "g8"));
        assertFalse(SecondTask.isSameColor("g8", "h8"));
    }

    @Test
    @DisplayName("Клетки на одной горизонтали через одну — один цвет")
    void sameRowEveryOther() {
        assertTrue(SecondTask.isSameColor("a4", "c4"));
    }

    @Test
    @DisplayName("Клетки на одной вертикали через одну — один цвет")
    void sameColumnEveryOther() {
        assertTrue(SecondTask.isSameColor("d1", "d3"));
    }

    @Test
    @DisplayName("a1 — тёмная, b1 — светлая (эталонная проверка)")
    void referenceSquares() {
        // a1 и b1 — соседи, значит разного цвета
        assertFalse(SecondTask.isSameColor("a1", "b1"));
        // a1 и c1 — через одну, значит одного цвета
        assertTrue(SecondTask.isSameColor("a1", "c1"));
    }
}
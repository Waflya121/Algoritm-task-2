public class SecondTask {

    public static boolean isSameColor(String cell1, String cell2) {
        return squareColor(cell1) == squareColor(cell2);
    }

    private static int squareColor(String cell) {
        char col = cell.charAt(0);          // 'a'..'h'
        int row = cell.charAt(1) - '0';     // '1'..'8'

        int colNumber = col - 'a' + 1;      // 'a' -> 1, ..., 'h' -> 8
        return (colNumber + row) % 2;       // 0 или 1 — «цвет»
    }

    public static void main(String[] args) {
        System.out.println("h8 и f6: " + isSameColor("h8", "f6")); // true
        System.out.println("h8 и g8: " + isSameColor("h8", "g8")); // false
    }
}
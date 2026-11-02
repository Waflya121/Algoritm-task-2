public class FirstTask {

    public static int countMatches(int[] first, int[] second) {
        int count = 0;
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i] == second[j]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 7, 9};
        int[] b = {2, 4, 7};

        System.out.println("Совпадений: " + countMatches(a, b));
    }
}
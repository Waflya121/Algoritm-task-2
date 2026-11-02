public class ThirdTask {

    public static double nextBalance(double balance, double percent, double bonus) {
        return balance + balance * percent / 100.0 + bonus;
    }

    public static double[] balances(double startBalance, double percent, double bonus, int months) {
        double[] result = new double[months];
        double balance = startBalance;
        for (int i = 0; i < months; i++) {
            balance = nextBalance(balance, percent, bonus);
            result[i] = balance;
        }
        return result;
    }

    public static void printBalances(double startBalance, double percent, double bonus, int months) {
        double[] result = balances(startBalance, percent, bonus, months);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("Месяц %d: %.2f%n", i + 1, result[i]);
        }
    }

    public static void main(String[] args) {
        printBalances(1000, 10, 50, 3);
    }
}
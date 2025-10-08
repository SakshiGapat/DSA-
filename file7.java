//Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

class file7 {
    public int divide(int dividend, int divisor) {
        // Handle overflow case explicitly:
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // 2^31 - 1
        }

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;

        for (int i = 31; i >= 0; i--) {
            if ((dvd >> i) >= dvs) {
                result += 1 << i;
                dvd -= dvs << i;
            }
        }

        return (dividend > 0) == (divisor > 0) ? result : -result;
    }

    // Main method to test the divide function
    public static void main(String[] args) {
        file7 sol = new file7();

        int dividend1 = 10, divisor1 = 3;
        System.out.println("Result of " + dividend1 + " / " + divisor1 + " = " + sol.divide(dividend1, divisor1));
        // Expected output: 3

        int dividend2 = 7, divisor2 = -3;
        System.out.println("Result of " + dividend2 + " / " + divisor2 + " = " + sol.divide(dividend2, divisor2));
        // Expected output: -2

        int dividend3 = Integer.MIN_VALUE, divisor3 = -1;
        System.out.println("Result of " + dividend3 + " / " + divisor3 + " = " + sol.divide(dividend3, divisor3));
        // Expected output: 2147483647 (Integer.MAX_VALUE)
    }
}

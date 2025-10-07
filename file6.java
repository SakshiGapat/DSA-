//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

class file6 {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        // If needle is empty, return 0 (optional depending on interpretation)
        if (nLen == 0) return 0;

        // Loop through haystack up to the point where needle could still fit
        for (int i = 0; i <= hLen - nLen; i++) {
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        file6 solution = new file6();

        // Example 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        int result1 = solution.strStr(haystack1, needle1);
        System.out.println("Index of first occurrence (Example 1): " + result1); // Output: 0

        // Example 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        int result2 = solution.strStr(haystack2, needle2);
        System.out.println("Index of first occurrence (Example 2): " + result2); // Output: -1

        // Additional test case
        String haystack3 = "hello";
        String needle3 = "ll";
        int result3 = solution.strStr(haystack3, needle3);
        System.out.println("Index of first occurrence (Additional test): " + result3); // Output: 2
    }
}


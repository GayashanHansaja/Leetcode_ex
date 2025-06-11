import java.util.*;

class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int maxDiff = -1;

        // Try all pairs of characters (a and b)
        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) continue;

                // Map to store the earliest index where a given state occurred
                // State is encoded as: (odd/even of freqA, odd/even of freqB)
                Map<String, Integer> stateIndexMap = new HashMap<>();
                int freqA = 0, freqB = 0;

                // Initial state (0 parity for both), before string starts
                stateIndexMap.put("0_0", -1);

                for (int i = 0; i < n; i++) {
                    char ch = s.charAt(i);
                    if (ch == a) freqA++;
                    if (ch == b) freqB++;

                    int parityA = freqA % 2;
                    int parityB = freqB % 2;
                    String state = parityA + "_" + parityB;

                    if (!stateIndexMap.containsKey(state)) {
                        stateIndexMap.put(state, i);
                    }

                    int j = stateIndexMap.get(state);
                    if (i - j >= k) {
                        maxDiff = Math.max(maxDiff, freqA - freqB);
                    }
                }
            }
        }

        return maxDiff;
    }
}



class Solution {

    public int minimumCost(String target, String[] words, int[] costs) {
        int n = target.length();

        int base = 13331;
        int mod = 998244353;
        int INF = Integer.MAX_VALUE / 2;

        long[] hash = new long[n + 1];
        long[] power = new long[n + 1];

        power[0] = 1;

        for (int i = 1; i <= n; i++) {
            hash[i] = (hash[i - 1] * base + target.charAt(i - 1)) % mod;
            power[i] = (power[i - 1] * base) % mod;
        }

        TreeSet<Integer> lengths = new TreeSet<>();

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            lengths.add(words[i].length());

            long h = 0;

            for (char c : words[i].toCharArray()) {
                h = (h * base + c) % mod;
            }

            map.put(h, Math.min(
                map.getOrDefault(h, INF),
                costs[i]
            ));
        }

        int[] dp = new int[n + 1];

        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int len : lengths) {

                if (len > i) {
                    break;
                }

                long currentHash =
                    (hash[i] - hash[i - len] * power[len] % mod + mod) % mod;

                if (map.containsKey(currentHash)) {

                    dp[i] = Math.min(
                        dp[i],
                        dp[i - len] + map.get(currentHash)
                    );
                }
            }
        }

        return dp[n] == INF ? -1 : dp[n];
    }
}
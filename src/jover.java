public class jover {
    public int minCost(int[] cuts, int n) {
        int[] dp = new int[n + 1];

        for(int i = 1 ; i < dp.length ; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 0 ; j < cuts.length ; j++){
                if(i >= cuts[j]){
                    int val = dp[i - cuts[j]];
                    if(val != Integer.MAX_VALUE && val + 1 < dp[i]){
                        dp[i] = val + 1;
                    }
                }
            }
        }
        if(dp[n] == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dp[n];
        }


    }
}

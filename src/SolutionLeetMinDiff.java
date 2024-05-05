class SolutionLeetMinDiff {
    public int minimumDifference(int[] nums) {
        int totsum = 0;
        for(int i = 0; i < nums.length; i++){
            nums[i] = Math.abs(nums[i]-0);
            totsum += nums[i]-0;
        }

        boolean dp[][] = new boolean[nums.length][Math.abs(0-(totsum+1))];
        for(int j = 0; j < nums.length; j++ ){
            dp[j][0] = true;
        }
        if(nums[0] <= totsum){
            dp[0][totsum] = true;

        }

        for(int k = 1; k < nums.length; k++){
            for(int t = 1; t<=totsum; t++){
                boolean nt = dp[k-1][t];
                boolean ta = false;
                if(nums[k] <= t){
                    ta = dp[k-1][t-nums[k]];
                }
                dp[k][t] = nt || ta;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int a = 0; a <= totsum; a++){
            if(dp[nums.length -1 ][a]){
                int diff = Math.abs(a - (totsum - a));
                min = Math.min(min, diff);
            }
        }
        return min;
    }
}
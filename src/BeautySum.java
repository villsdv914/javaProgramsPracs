
class BeautySum {
    public static int beautySum(String s) {
        int total = 0;
        for(int i = 0; i < s.length(); i++){
            int[] frq = new int[26];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j = i; j < s.length(); j++){
                frq[s.charAt(j) - 'a'] +=1;
                total += getMax(frq) - getMin(frq);
                }
        }
        return total ;

    }

    public static int getMin(int[] frq){
        int min = Integer.MAX_VALUE;
        for(int k = 0; k < frq.length; k++){

                if(frq[k] > 0){
                    min = Math.min(min, frq[k]);
                }

        }
        return min;
    }

    public static int getMax(int[] frq){
        int max = Integer.MIN_VALUE;
        for(int k = 0; k < frq.length; k++){
            if(frq[k] > 0) {

                max = Math.max(max, frq[k]);
            }
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(beautySum("aabcb"));
    }
}
public class LongestPrefix {

    public static void main(String[] args){
        String[] strArrray = {"flower", "flow", "flight"};
        String pre = strArrray[0];
        for(int i = 1; i < strArrray.length; i ++){
            System.out.print(strArrray[i].indexOf(pre));
            while(strArrray[i].indexOf(pre) != 0){
                pre = pre.substring(0, pre.length()-1);
            }

        }
        System.out.print(pre);
        System.out.print(largestOddNumber("10133890"));
    }


    public static String largestOddNumber(String num) {
        String ans ="";
        if ( (num.charAt(num.length()-1) - '0') > 0 && (num.charAt(num.length()-1) - '0') % 2 == 1){
            return num;
        }
        for(int i = num.length()-1; i >=0; i--){
            if( (num.charAt(i) - '0') > 0 && (num.charAt(i) - '0') % 2 == 1){
                num = num.substring(0, i+1);
                ans += num;
            }

        }
        return ans;
    }
}

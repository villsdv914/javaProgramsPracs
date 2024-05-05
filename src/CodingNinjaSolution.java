
public class CodingNinjaSolution {
    public static int countSubStrings(String str, int k) {
        // Write your code here.
        int n=str.length();
        int res=0;
        for(int i=0;i<n;i++){
            int dis_count=0;
            int[] cnt=new int[26];
            for(int j=i;j<n;j++){
                if(cnt[str.charAt(j)-'a']==0){
                    dis_count++;
                    cnt[str.charAt(j)-'a']++;
                }
                if(dis_count==k){
                    res++;
                }
                if(dis_count>k){
                    break;
                }
            }
        }
        return res;
    }

    public  static void main(String[] args){

        System.out.print(countSubStrings("qffds", 4));

    }
}


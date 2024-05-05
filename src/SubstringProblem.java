import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SubstringProblem {


    public static void main(String[] args ){
        String[] s = {"hackerearth",
                "earth",
                "contests",
                "zzzz",
                "string"};

        int n = 5;
//
        HashMap<String, Set<Integer>> mp = new HashMap<String, Set<Integer>>();
        for(int k = 0; k < n; k++){
            String val = s[k];
             int length = val.length();
                for(int i = 0; i < length; i++){
                for(int j = i +1; j < length; j++ ){
                    String sub = val.substring(i, j);
                    if(mp.containsKey(sub) ){
                        mp.get(sub).add(k);
                    }else{
                        Set<Integer> st = new HashSet<>();
                        st.add(k);
                        mp.put(sub, st);
                    }
                }
            }
        }
        int max = 0;
        for(Set<Integer> intval : mp.values()){
            max = Math.max(intval.size(), max);
        }

        int ans = (n - max)+1;
        System.out.print("Value ");
        System.out.print(ans);


    }

}

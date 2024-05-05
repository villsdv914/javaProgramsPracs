package mock;

import javax.sql.rowset.spi.SyncResolver;
import java.util.HashSet;
import java.util.Set;

public class TestPrep {

    public static void main(String args[]){
        String s = "catsandog";
        int n = 4;
        Set<String> testSet = new HashSet<String>();
        testSet.add("cats");
        testSet.add("dog");
        testSet.add("sand");
        testSet.add("and");
        testSet.add("cat");
//        System.out.println(validString(s, testSet));
        System.out.println(wordbreak(s, testSet));

    }

    public static boolean validString(String s, Set<String> st){

        int stlen = st.size();
        int count = 0;
        String k = "";
            for(int j = 0; j< s.length();j++){
                k +=Character.toString(s.charAt(j));
                if(st.contains(k)){
                    count++;
                    k = "";
                }
            }
        return count >= stlen;

    }

    public static boolean wordbreak(String s, Set<String> st){
        if (st.contains(s)){
            return true;
        }
        for(int i = 1; i<= s.length(); i++){
            if(st.contains(s.substring(0,i)) && wordbreak(s.substring(i), st)){
                return true;
            }
        }
        return false;
    }

}

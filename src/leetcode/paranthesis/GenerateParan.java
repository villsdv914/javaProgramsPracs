package leetcode.paranthesis;

import java.util.ArrayList;
import java.util.List;

public class GenerateParan {
    public static void main(String[] args){
    System.out.println("Values "+ generateParan(3));
    }
    public static List<String> generateParan(int num){
        ArrayList<String> ls = new ArrayList<String>() ;
        backtrack(0,0, num, ls, "" );
        return ls;
    }

    public static void backtrack(int open, int close, int len, ArrayList<String> ls, String s){

        if (open == len && close == open) {
            ls.add(s);
        }
        if (open < len){
            backtrack(open +1, close, len, ls, s+"(");
        }
        if (close < open){
            backtrack(open, close+1, len, ls, s+")");
        }
    }
}

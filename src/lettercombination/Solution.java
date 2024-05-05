package lettercombination;
import java.util.*;
class Solution {
    private static final Map<Character, String> digitToLetters = new HashMap<>();
    private static final List<String> ans = new ArrayList<String>();

    public static void main(String[] args){
        System.out.println(letterCombinations(""));
        System.out.println(1);
    }
    public static List<String> letterCombinations(String digits) {
    if (digits == null || digits.isEmpty()){
        return ans;
    }
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        bt(0,new StringBuilder(), digits);
        return ans;

    }

    public static void bt(int index, StringBuilder st, String digits){

        if (index > digits.length()){
            ans.add((st.toString()));
            return;
        }

        String lc = digitToLetters.get(digits.charAt(index));
        if (lc!=null){
            for (int i = 0; i<lc.length(); i++) {
                st.append(lc.charAt(i));
                bt(index + 1, st, digits);
                st.deleteCharAt(st.length() - 1);
            }
        }



    }
}
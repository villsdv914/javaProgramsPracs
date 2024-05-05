package combination;
import java.util.*;
public class CombinationSum2 {

        public static void main(String[] args) {
                int v[]={10,1,2,7,6,1,5};
                List < List < Integer >> comb = combinationSum2(v, 8);
                List < List < Integer >> comb3 = combinationSum3(v, 8);
                System.out.println(comb.toString().replace(",", " "));
                System.out.println(comb3.toString().replace(",", " "));
        }
public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        List<Integer> ns = new ArrayList<Integer>();
        backtrack(candidates, 0, target, ls, ns);
        return ls;
        }
public static List < List < Integer >> combinationSum3(int[] candidates, int target) {
                List < List < Integer >> ans = new ArrayList < > ();
                Arrays.sort(candidates);
                findCombinations(0, candidates, target, ans, new ArrayList < > ());
                return ans;
        }
public static void backtrack(int[] candidates,int ind, int target, List<List<Integer>> ls , List<Integer> ns){

        if (target ==0){
        ls.add(new ArrayList<>(ns));
        return;
        }
        for(int i = ind; i<candidates.length; i++){
                if (i > ind && candidates[i] == candidates[i-1]){
                                continue;
                }
                if(candidates[i] > target){
                        break;
                }
                ns.add(candidates[i]);
                backtrack(candidates, i+1,target-candidates[i],ls,ns);
                ns.remove(ns.size()-1);
        }
        }

        public static void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
                if (target == 0) {
                        ans.add(new ArrayList < > (ds));
                        return;
                }

                for (int i = ind; i < arr.length; i++) {
                        if (i > ind && arr[i] == arr[i - 1]) continue;
                        if (arr[i] > target) break;

                        ds.add(arr[i]);
                        findCombinations(i + 1, arr, target - arr[i], ans, ds);
                        ds.remove(ds.size() - 1);
                }
        }
}
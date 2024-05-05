package arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergeinter {

    public static void main(String[] args){
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int[][] ans = mergeOverlappingIntervals(arr);
        System.out.print(Arrays.deepToString(ans));

    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals){
        List<int []> ans = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]){
                return -1;}
                else{

                    return 1;
                }
            }

        });

        for(int i = 0 ; i<intervals.length; i++){
            if(ans.isEmpty() || ans.get(ans.size() - 1)[1] < intervals[i][0]){
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
            }else{
                ans.get(ans.size()-1)[1]= Math.max(ans.get(ans.size()-1)[1], intervals[i][1]);
            }
        }
        return  ans.toArray(new int[ans.size()][]);
//
    }
}

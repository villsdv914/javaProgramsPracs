import java.util.Arrays;
import java.util.Scanner;

public class CowBales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a, 1, n + 1);
        int l = 1;
        int r = 25;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(a, n, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    private static boolean check(int[] a, int n, int k, int mid) {
        int cnt = 0;
        for (int i = 1, j = 1; i <= n; i++) {
            if (a[i] - a[j] > 2 * mid) {
                cnt++;
                j = i;
            }
        }
        return cnt + 1 <= k;
    }
}


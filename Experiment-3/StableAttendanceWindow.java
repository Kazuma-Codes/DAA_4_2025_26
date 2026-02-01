import java.util.*;

public class StableAttendanceWindow {

    public static int maxStableWindow(int n, char[] records) {
        int prefixSum = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> firstIndex = new HashMap<>();
        firstIndex.put(0, -1); 

        for (int i = 0; i < n; i++) {
            if (records[i] == 'P') {
                prefixSum += 1;
            } else { 
                prefixSum -= 1;
            }

            if (firstIndex.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - firstIndex.get(prefixSum));
            } else {
                firstIndex.put(prefixSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] records = new char[n];

        for (int i = 0; i < n; i++) {
            records[i] = sc.next().charAt(0);
        }

        System.out.println(maxStableWindow(n, records));
        sc.close();
    }
}

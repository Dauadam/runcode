import java.util.ArrayList;

public class RunCode {

    public static int[] sortByPerformanceBand(
            int[] scores) {

        if (scores == null || scores.length == 0) {
            return new int[0];
        }
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int score : scores) {
            int band = score / 10;
            buckets[band].add(score);
        }
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> bucket = buckets[i];
            for (int j = 1; j < bucket.size(); j++) {
                int key = bucket.get(j);
                int k = j - 1;
                while (k >= 0 && bucket.get(k) < key) {
                    bucket.set(k + 1, bucket.get(k));
                    k--;
                }
                bucket.set(k + 1, key);
            }
        }
        int[] result = new int[scores.length];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int score : buckets[i]) {
                result[index++] = score;
            }
        }
        return result;
    }
}
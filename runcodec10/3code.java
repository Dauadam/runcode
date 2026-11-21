public class RunCode {

    public static long countOutOfOrderPairs(
            int[] scores) {

        if (scores == null || scores.length < 2) {
            return 0L;
        }
        int[] temp = new int[scores.length];
        return mergeSort(scores, temp, 0, scores.length - 1);
    }

    public static long mergeSort(int[] scores, int[] temp, int left, int right) {
        if (left >= right) {
            return 0L;
        }
        int mid = left + (right - left) / 2;
        long count = 0L;
        count += mergeSort(scores, temp, left, mid);
        count += mergeSort(scores, temp, mid + 1, right);
        count += merge(scores, temp, left, mid, right);
        return count;
    }

    public static long merge(int[] scores, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long count = 0L;

        while (i <= mid && j <= right) {
            if (scores[i] <= scores[j]) {
                temp[k++] = scores[i++]; 
            } else {
                temp[k++] = scores[j++];
                count += (mid - i + 1);
            }
        } 

      
        while (i <= mid) {
            temp[k++] = scores[i++];
        }

        
        while (j <= right) {
            temp[k++] = scores[j++];
        }
        for (int idx = left; idx <= right; idx++) {
            scores[idx] = temp[idx];
        }

        return count; 
    }
}
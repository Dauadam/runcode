public class RunCode {

    public static int[] topKScores(
            int[] scores, int k) {
        if (k <= 0 || scores == null || scores.length == 0) {
            return new int[0];
        }
        int n = scores.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(scores, n, i);
        }

        int[] result = new int[k];
        int heapSize = n;

        for (int i = 0; i < k; i++) {
            result[i] = scores[0];
            scores[0] = scores[heapSize - 1];
            heapSize--;
            heapify(scores, heapSize, 0);
        }

        return result;
    }

    public static void heapify(int[] arr, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, heapSize, largest);
        }
    }
}
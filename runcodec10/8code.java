public class RunCode {

    public static int[] mergeSortedRuns(
            int[] data, int runSize) {

        if (data == null || data.length == 0) {
            return new int[0];
        }

        int n = data.length;
        int[] current = new int[n];
        for (int i = 0; i < n; i++) {
            current[i] = data[i];
        }
        if (runSize >= n) {
            return current;
        }

        int[] temp = new int[n];
        for (int size = runSize; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = Math.min(left + size - 1, n - 1);
                int right = Math.min(left + 2 * size - 1, n - 1);

                if (mid < right) {
                    merge(current, temp, left, mid, right);
                } else {
                    for (int i = left; i <= right; i++) {
                        temp[i] = current[i];
                    }
                }
            }
            int[] swap = current;
            current = temp;
            temp = swap;
        }

        return current;
    }

    private static void merge(int[] src, int[] dst, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (src[i] <= src[j]) {
                dst[k++] = src[i++];
            } else {
                dst[k++] = src[j++];
            }
        }

        while (i <= mid) {
            dst[k++] = src[i++];
        }

        while (j <= right) {
            dst[k++] = src[j++];
        }
    }
}
public class RunCode {

    public static int[] sortByTrackingCode(
            int[] ids) {

        if (ids == null || ids.length == 0) {
            return new int[0];
        }
        int[] result = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            result[i] = ids[i];
        }
        for (int exp = 1; exp <= 100; exp *= 10) {
            result = countingSortByDigit(result, exp);
        }

        return result;
    }
    private static int[] countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        return output;
    }
}
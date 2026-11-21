public class RunCode {

    public static int countInsertionShifts(
            int[] registrations) {

        int shifts = 0;
        for(int i = 1; i < registrations.length; i++)
        {
            int key = registrations[i];
            int j = i - 1;
            while (j >= 0 && registrations[j] > key)
            {
                registrations[j + 1] = registrations[j];
                shifts++;
                j--;
            }
            registrations[j + 1] = key;
        }

        return shifts;
    }
}
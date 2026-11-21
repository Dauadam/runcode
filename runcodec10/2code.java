public class RunCode {

    public static int countBubblePasses(
            int[] readings) {

        int passes = 0;
        boolean swapped = true;
        while (swapped)
        {
            swapped = false;
            passes++;
            for (int i = 0; i < readings.length - 1;i++)
            {
                if (readings[i] > readings[i + 1])
                {
                    int temp = readings[i];
                    readings[i] = readings[i + 1];
                    readings[i + 1] = temp;
                    swapped = true;
                }
                
            } 
        }

        return passes;
    }
}
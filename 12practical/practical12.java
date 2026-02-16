import java.util.Random;

public class practical12 {


    public static int mcs0n3(int[] X) {
        int n = X.length;
        int maxsofar = 0;
        for (int low = 0; low < n ; low++){
            for (int high = low; high <n; high++) {
                int sum = 0;
                for (int r = low; r < high; r++) {
                    sum += X[r];
                }
                if (sum > maxsofar){
                    maxsofar = sum;
                }
            }
        }
        return maxsofar;
    }

    public static int mcs0n2A(int[] X) {
        int n = X.length;
        int maxsofar = 0;
        for (int low = 0; low < n ; low++){
            int sum = 0;
            for (int r = low; r < n; r++) {
                sum += X[r];
                if (sum > maxsofar) {
                    maxsofar = sum;

                }
            }
        }
        return maxsofar;
    }

    public static int mcs0n2B(int[] X) {
        int n = X.length;
        int[] sumTo = new int[n + 1];
        sumTo[0] = 0;
        for (int i = 0 ; i < n; i++) {
            sumTo[i+1] = sumTo[i] + X[i];
        }
        int maxsofar = 0;
        for (int low = 0; low < n ; low++){
            for (int high = low; high < n; high++) {
                int sum = sumTo[high +1] - sumTo[low];
                if (sum > maxsofar){
                    maxsofar = sum;
                }
            }
        }
        return maxsofar;
    }

}
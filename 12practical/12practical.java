import java.util.Random;

public class 12practical {


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
    }
}
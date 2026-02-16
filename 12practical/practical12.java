import java.util.Random;

public class practical12 {


    public static int mcs0n3(int[] X) {
        int n = X.length;
        int maxsofar = 0;
        long count = 0;
        for (int low = 0; low < n ; low++){
            for (int high = low; high <n; high++) {
                int sum = 0;
                for (int r = low; r <= high; r++) {
                    sum += X[r];
                    count++; //core 
                }
                if (sum > maxsofar){
                    maxsofar = sum;
                }
            }
        }
         System.out.println("O(n^3) count: " + count);
        return maxsofar;
    }

    public static int mcs0n2A(int[] X) {
        int n = X.length;
        int maxsofar = 0;
        long count = 0;
        for (int low = 0; low < n ; low++){
            int sum = 0;
            for (int r = low; r < n; r++) {
                sum += X[r];
                count++; //core
                if (sum > maxsofar) {
                    maxsofar = sum;

                }
            }
        }
         System.out.println("O(n^2 A) count: " +count);
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
        long count = 0;
        for (int low = 0; low < n ; low++){
            for (int high = low; high < n; high++) {
                int sum = sumTo[high +1] - sumTo[low];
                count++; //core
                if (sum > maxsofar){
                    maxsofar = sum;
                }
            }
        }
         System.out.println("O(n^2 B) count: " +count);
        return maxsofar;
    }

    public static int mcs0n(int[] X) {
        int n = X.length;
        int maxsofar = 0;
        int maxtohere = 0;
        long count = 0;
        for (int i = 0; i < n; i++) {
            maxtohere = Math.max(maxtohere+ X[i], 0);
            count++; //core
            maxsofar = Math.max(maxsofar, maxtohere);
        }
         System.out.println("O(n) count: " +count);
        return maxsofar;
    }
    public static int[] createArray(int n) {
        Random rand = new Random();
        int[] X = new int[n];
        for (int k = 0; k < n; k++) {
            int sgn = (rand.nextInt(3) == 0) ? -1 : 1;
            X[k] = sgn * (rand.nextInt(n) + 1);
        }
        return X;
    }

    public static void main(String[] args) {
        int[] ns = {100, 1000, 10000, 100000, 1000000};
        for (int n : ns) {
            int[] X = createArray(n);
            mcs0n3(X);
            mcs0n2A(X);
            mcs0n2B(X);
            mcs0n(X);
        }

  
      

    }
}
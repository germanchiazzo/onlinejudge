import java.math.BigInteger;
import java.util.Scanner;

/*
 * 2084 - Game of Connections
 * 1- Note that when a segment is added the number of points in both sides must be even
 * 1-a)Then for each point I can add n segments
 * - Starting from a fixed vertex, add a segment, which divides the polygon in two areas of less size,
 * - Instead of using a recursive approach calculate the result using an array (dynamic approach)
 */
public class Main {

    private static BigInteger[] array = new BigInteger[101];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        array[0] = BigInteger.ONE;
        array[1] = BigInteger.ONE;
        int n = in.nextInt();
        while (n != -1) {
            for (int m = 2; m <= n; m++) {
                BigInteger ret = BigInteger.ZERO;
                for (int ady = 1; ady <= m; ady++) {
                    int cant1 = ady - 1;
                    int cant2 = m - ady;
                    ret = ret.add(array[cant1].multiply(array[cant2]));//ret += array[cant1] * array[cant2];
                }
                array[m] = ret;
            }
            System.out.println(array[n]);
            n=in.nextInt();
        }
    }
}

import java.math.BigInteger;
import java.util.Scanner;

/* 2084 - Game of Connections
 * First Time solved*:219ms, dp approach
 * Math Solution: Catalan Numbers (number of ways to connect 2n points in a circle without intersections).
 * Co=1;
 * C(n+1)=2*(2n+1)*Cn/(n+2)
 * 
 * Time: 141 ms   (With catalan's recurrence).
 */
public class Main {

    private static BigInteger[] array = new BigInteger[101];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        array[0] = BigInteger.ONE;
        array[1] = BigInteger.ONE;
        int n = in.nextInt();
        for(int i=2;i<=100;i++){
            BigInteger a=new BigInteger(Integer.toString(4*i-2));//2*(2(n-1)+2)
            BigInteger b=new BigInteger(Integer.toString(i+1));//(n-1)+2
            array[i]=array[i-1].multiply(a).divide(b);
        }
        while (n != -1) {
            System.out.println(array[n]);
            n=in.nextInt();
        }
    }
}
/*  g(n,k)=g(n-1,k)+k   mod n 
    g(1,k)=0
 * Joseph recurrence rotated m-k positions
 */
public class Main {
   
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        while (n != 0) {
            int ret = 0;
            for (int i = 2; i <= n; i++) {
                ret = (ret + k) % i;
            }
            System.out.println(((ret + (m-k)%n + n)%n) + 1);            
            n = in.nextInt();
            k = in.nextInt();
            m = in.nextInt();
        }
    }
}
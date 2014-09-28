package dp;

import java.util.Scanner;

/**
 * 2719 - Faulty Odometer
 * 
 */
public class Base9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dato = in.nextInt();
        while (dato != 0) {
            String num=Integer.toString(dato);
            int suma=0;
            int pot9=1;
            for(int i=num.length()-1;i>=0;i--){
                int digito = Integer.parseInt(num.charAt(i)+"");
                if(digito>3)digito--;
                suma+=digito*pot9;
                pot9*=9;
            }
            System.out.println(dato+": "+suma);
            dato=in.nextInt();
        }
    }
}

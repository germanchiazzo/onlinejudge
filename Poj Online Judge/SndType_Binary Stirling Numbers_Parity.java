import java.util.Scanner;

/*Note:
 * 1) Partitions(n,k)%2 = Combinations(z,w)%^2 with z and w such as:
 *    z = n - ceil((k + 1) / 2);
 *    w = floor((k - 1) / 2);
 * 2) Fast way to calculate parity(combinations(z, w));
 * 	  - Convert z and w to binary. Compare 1's of z with 1's of w 
 * Si todo 1 en la posicion i de w esta en la posicion i de z(comenzando desde el final) es impar
 * si hay alguno que no lo cumple, es par
 * http://es.wikipedia.org/wiki/N%C3%BAmeros_de_Stirling_de_segunda_especie
 * http://campusvirtual.unex.es/cala/epistemowikia/index.php?title=Teor%C3%ADa_Informaci%C3%B3n_Algor%C3%ADtmica
 */

public class Main {

public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        for (int i = 0; i < casos; i++) {
            int n = in.nextInt();
            double k = in.nextDouble();
            int z = n - (int)Math.ceil((k + 1) / 2);
            int w = (int)Math.floor((k - 1) / 2);
            System.out.println(paridadCombinacion(z, w));
        }
    }
    public static int paridadCombinacion(int z,int w){
        String binZ=Integer.toBinaryString(z);
        String binW=Integer.toBinaryString(w);
        int j = binZ.length()-1;
        for(int i=binW.length()-1;i>=0;i--){
            if(binW.charAt(i)=='1'&& binZ.charAt(j)=='0'){
                return 0;
            }
            j--;
        }
        return 1;
    }


}
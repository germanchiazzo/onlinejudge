import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /**
	 * 2295 - A DP Problem
	 * Pattern and Matcher :)
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        in.nextLine();
        for (int i = 0; i < casos; i++) {
            String linea = in.nextLine().replace("+x", "+1x").replace("-x", "-1x").replace("=x", "=1x");
            if (linea.charAt(0) == 'x') {
                linea = linea.replaceFirst("x", "1x");
            }
            String[] miembros = linea.split("=");
            int[] res1 = evaluar(miembros[0]);
            int[] res2 = evaluar(miembros[1]);
            if (res1[0] == res2[0]) {
                if (res1[1] != res2[1]) {
                    System.out.println("IMPOSSIBLE");
                } else {
                    System.out.println("IDENTITY");
                }
            } else {
            double numerador=(res2[1] - res1[1]) ;
            double divisor=(res1[0] - res2[0]);
                System.out.println((int)Math.floor(numerador/divisor));
            }
        }
    }

    private static int[] evaluar(String linea) {
        Pattern p = Pattern.compile("([\\+\\-]*[0-9]+x)");
        int[] valores = new int[2];
        Matcher matcher = p.matcher(linea);
        while (matcher.find()) {
            //copiandole al cosito jaja
            int num = linea.substring(matcher.start(), matcher.end()).contains("-") ? -1 : 1;
            int inicio = (num == -1 || linea.substring(matcher.start(), matcher.end()).contains("+")) ? matcher.start() + 1 : matcher.start();
            int valor = num * Integer.parseInt(linea.substring(inicio, matcher.end() - 1));
            valores[0] += valor;
            if(matcher.start()>0&&(linea.charAt(matcher.start()-1)=='+'||linea.charAt(matcher.start()-1)=='-')){
                inicio=matcher.start()-1;
            }else{
                inicio=matcher.start();
            }
            linea = linea.substring(0,matcher.start())+linea.substring(matcher.end());
            matcher = p.matcher(linea);
        }

        Pattern p2 = Pattern.compile("([\\+\\-]*[0-9]+)");

        Matcher matcher2 = p2.matcher(linea);
        while (matcher2.find()) {
            int num = linea.substring(matcher2.start(), matcher2.end()).contains("-") ? -1 : 1;
            int inicio = (num == -1 || linea.substring(matcher2.start(), matcher2.end()).contains("+")) ? matcher2.start() + 1 : matcher2.start();
            int valor = num * Integer.parseInt(linea.substring(inicio, matcher2.end()));
            valores[1] += valor;
            if(matcher2.start()>0&&(linea.charAt(matcher2.start()-1)=='+'||linea.charAt(matcher2.start()-1)=='-')){
                inicio=matcher2.start()-1;
            }else{
                inicio=matcher2.start();
            }
            linea = linea.substring(0,matcher2.start())+linea.substring(matcher2.end());
            matcher2 = p2.matcher(linea);
        }
        return valores;
    }
}
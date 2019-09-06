package loteria;

// Gervásio
import java.util.*;

public class Loteria {

    public static void main(String[] args) {

        int[] valores = new int[]{0, 0, 0, 0, 0, 0};
        imprimeVetor(valores);

        Scanner in = new Scanner(System.in);
        System.out.println("Digite 6 números");
        for (int i = 0; i < 6; i++) {
            int num = -1;
            while (num == -1) {
                num = capNum(in, i);
                for (int j = 0; j < i; j++) {
                    if (valores[j] == num) {
                        num = -1;
                    }
                }
            }
            valores[i] = num;
        }
        imprimeVetor(valores);
        
        Random r = new Random();

        int[] bolas = new int[]{0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 6; i++) {
            int bola = -1;
            do {
                bola = (r.nextInt(60) + 1);
                for (int j = 0; j < i; j++) {
                    if (bolas[j] == bola) {
                        bola = -1;
                        break;
                    }
                }
            } while (bola == -1);
            
            bolas[i] = bola;
        }
        imprimeVetor(bolas);

        
        int[] acertos = new int[6];
        int contador = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (valores[i] == bolas[j]){
                    acertos[i] = bolas[j];
                    contador++;
                }
            }
        }
        
        System.out.println("Você teve um total de "+contador+" acertos.");
        if (contador >0) {
            System.out.println("Números acertados:");
            imprimeVetor(acertos);
        }
        
        
    }

    public static int capNum(Scanner in, int i) {
        System.out.println("Digite o " + (i + 1) + "º número");
        int num = in.nextInt();

        if (num >= 1 && num <= 60) {
            return num;
        } else {
            return -1;
        }
    }

    public static void imprimeVetor(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }
        System.out.println("");
    }
}


/*import java.util.Arrays;
import java.util.Scanner;

class Main{
    
    public static void comparaSequencias(int S, int Q, int seqS[], int seqQ[]) {

        int aux1, aux2, quantidade=0;
        int resultado[];
        for (aux1 = 0; aux1 < S; aux1++) {
            boolean numeros = false;
            for (aux2 = 0; aux2 < Q; aux2++) {
                if (seqS[aux1] == seqQ[aux2]) {
                    numeros = true;
                    break;
                }
            }
            if (numeros == false) {
                //System.err.print(seqS[aux1] + " ");
                quantidade=quantidade+1;
                //System.err.println("\nO numero (" + seqS[aux1] + ") e diferente");
            }
        }
        resultado=new int[quantidade];
        int posicao = 0;
        for (aux1 = 0; aux1 < S; aux1++) {
            boolean numeros = false;
            for (aux2 = 0; aux2 < Q; aux2++) {
                if (seqS[aux1] == seqQ[aux2]) {
                    numeros = true;
                    break;
                }
            }
            if (numeros == false) {
                
                resultado[posicao]=seqS[aux1];
                posicao=posicao+1;
            }
        }
        Arrays.sort(resultado);
        for (int i = 0; i < resultado.length; i++) {
            System.err.print(resultado[i]+" ");
        }
    }

    public static void main(String[] args) {

        int S, Q, seqS[], seqQ[];

        Scanner entrada = new Scanner(System.in);

        //System.out.print("Digite o tamanho da sequencia S: ");
        S = entrada.nextInt();
        seqS = new int[S];

        for (int posicao = 0; posicao < S; posicao++) {
           //System.out.print("Informe o valor da posicao (" + posicao + ") para S: "); 
            seqS[posicao] = entrada.nextInt();
        }
       // System.out.print("\n");

       // System.out.print("Digite o tamanho da sequencia Q: ");
        Q = entrada.nextInt();
        seqQ = new int[Q];

        for (int posicao = 0; posicao < Q; posicao++) {
           // System.out.print("Informe o valor da posicao (" + posicao + ") para Q: ");
            seqQ[posicao] = entrada.nextInt();
        }
        comparaSequencias(S, Q, seqS, seqQ);
    }
    
}*/

import java.util.Arrays;
import java.util.Scanner;

class Main{
    
    public static void comparaSequencias(int S, int Q, int seqS[], int seqQ[]) {

        int aux1, aux2, quantidade=0;
        int resultado[];
        for (aux1 = 0; aux1 < S; aux1++) {
            boolean numeros = false;
            for (aux2 = 0; aux2 < Q; aux2++) {
                if (seqS[aux1] == seqQ[aux2]) {
                    numeros = true;
                    break;
                }
            }
            if (numeros == false) {
                quantidade=quantidade+1;
            }
        }
        resultado=new int[quantidade];
        int posicao = 0;
        for (aux1 = 0; aux1 < S; aux1++) {
            boolean numeros = false;
            for (aux2 = 0; aux2 < Q; aux2++) {
                if (seqS[aux1] == seqQ[aux2]) {
                    numeros = true;
                    break;
                }
            }
            if (numeros == false) {
                
                resultado[posicao]=seqS[aux1];
                posicao=posicao+1;
            }
        }
        Arrays.sort(resultado);
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]+" ");
        }
    }

    public static void main(String[] args) {

        int S, Q, seqS[], seqQ[];

        Scanner entrada = new Scanner(System.in);

        S = entrada.nextInt();
        seqS = new int[S];

        for (int posicao = 0; posicao < S; posicao++) {
            seqS[posicao] = entrada.nextInt();
        }
        Q = entrada.nextInt();
        seqQ = new int[Q];

        for (int posicao = 0; posicao < Q; posicao++) {
            seqQ[posicao] = entrada.nextInt();
        }
        comparaSequencias(S, Q, seqS, seqQ);
    }
    
}

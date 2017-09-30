/*Ada the Ladybug tem muitas coisas a fazer e quase nenhum tempo. Ela quer 
ganhar tempo enquanto procura por algo, então ela decidiu fazer um mecanismo de 
busca.Ela tem muitas palavras na lista de TODO. Custa o seu precioso tempo para
descobrir, se uma palavra está nele, então ela procura sua ajuda. Você receberá 
lista e algumas consultas. Você será solicitado a descobrir quantas palavras na 
lista TODO têm uma palavra como prefixo .    

Entrada
A primeira linha contém N, Q : as palavras numéricas na lista TODO e o número de consultas.
Seguem-se linhas N, com palavras (da lista TODO) consistindo de letras minúsculas. 
A soma dos seus comprimentos não será superior a 10a6
Seguem-se linhas Q, com palavras (consultas) consistindo de letras minúsculas. 
A soma dos seus comprimentos não será superior a 10 6

Saída
Para cada consulta, imprima o número de palavras na lista TODO, que tem palavra 
real como prefixo. */
package spoj2;

import java.util.Scanner;

public class SPOJ2 {
    //corpo princial
   public static void main(String args[]) {
        Scanner entrada = new Scanner(System.in);
        int PalavrasN, PrefixosQ;
        No aux1, aux2;

        PalavrasN = entrada.nextInt();
        PrefixosQ = entrada.nextInt();

        for (int i = 0; i < PalavrasN + PrefixosQ; i++) {
            inserirNomes(entrada.next());
        }

        aux1 = cabeca;

        for (int i = PalavrasN; i > 0; i--) { 
            aux1 = aux1.getProx();
        }

        aux2 = aux1;
        int contador;
        for (int i = PrefixosQ; i > 0; i--) {
            aux1 = cabeca;
            contador = 0;
            for (int j = PalavrasN; j > 0; j--) {
                if (aux1.getConteudo().startsWith(aux2.getConteudo(), 0)) { //verificar se a string comeca com o valor dado
                    contador++;
                }
                aux1 = aux1.getProx();
            }
            System.out.print(contador+ " ");
            aux2 = aux2.getProx();
        }
    } 

    //criacao da classe, métodos e construtores
    public static class No { //classe NO (Toda a lista a qual se refere)

        private String conteudo; //nela temos conteudos 
        private No prox; //e o proximo que referencia o outro no (outra lista)

        public No() { //construtor
            setProx(null); //por enquanto prox esta nulo
        }

        public String getConteudo() { //metodo (acessa o conteúdo)
            return conteudo;
        }

        public void setConteudo(String conteudo) { //nao retornar a nada. Alterar conteudo
            this.conteudo = conteudo;
        }

        public No getProx() {
            return prox;
        }

        public void setProx(No prox) {
            this.prox = prox;
        }
    }
    
    private static No cabeca;
    private static int N;
    

    public SPOJ2() { //construtor
        cabeca = null;
        N = 0;
    }

    public static boolean vazia() { //saber se a lista ta vazia
        if (N == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean inserirNomes(String nomes) {

        No aux = cabeca;
        No no = new No();
        no.setConteudo(nomes); //acessar dentro de nó, os nomes

        if (vazia()) {
            cabeca = no;

        } else {
            while (aux.getProx() != null) {
                aux = aux.getProx(); //atualiza aux
            }
            no.setProx(null);
            aux.setProx(no);
        }

        N++;
        return true;

    }
  
}

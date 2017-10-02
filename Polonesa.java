            package Polonesa;

            import java.util.Scanner;

            public class Polonesa {

                private static char dados[]; // Vetor que contÃ©m os dados da lista 
                private static int topo;

                private static int tamMax;

                /**
                 * Verifica se a Pilha estÃ¡ vazia
                 */
                public static boolean vazia() {
                    if (topo == -1) {
                        return true;
                    } else {
                        return false;
                    }
                }

                /**
                 * Verifica se a Pilha estÃ¡ cheia
                 */
                public static boolean cheia() {
                    if (topo == (tamMax - 1)) {
                        return true;
                    } else {
                        return false;
                    }
                }

                /**
                 * ObtÃ©m o tamanho da Pilha
                 */
                public static int tamanho() {
                    return topo + 1;
                }

                /**
                 * Consulta o elemento do topo da Pilha. Retorna -1 se a pilha estiver
                 * vazia, caso contrÃ¡rio retorna o valor que estÃ¡ no topo da pilha.
                 */
                public static char top() {
                    if (vazia()) {
                        return ' '; // pilha vazia
                    }
                    return dados[topo];
                }

                /**
                 * Insere um elemento no topo da pilha. Retorna false se a pilha estiver
                 * cheia. Caso contrÃ¡rio retorna true
                 */
                public static boolean push(char valor) {
                    if (cheia()) {
                        return false;  // err: pilha cheia 
                    }
                    topo++;
                    dados[topo] = valor;
                    return true;
                }

                /**
                 * Retira o elemento do topo da pilha. Retorna -1 se a pilha estiver vazia.
                 */
                public static char pop() {
                    if (vazia()) {
                        return ' '; // Pilha vazia
                    }
                    char valor = dados[topo];
                    topo--;
                    return valor;
                }



                public static void main(String[] args) {

                    tamMax = 100;
                    dados = new char[tamMax];
                    topo = -1;

                    Scanner entrada = new Scanner (System.in);
                    int quantidade = entrada.nextInt();
                    String expressao[] = new String[quantidade];

                    for (int i = 0; i < quantidade; i++) {
                        expressao[i] = entrada.next();

                    }
                    for (int i = 0; i < quantidade; i++) {
                        char[] letras = expressao[i].toCharArray();
                        poli(letras);
                    }

                }
                public static void poli(char[] letras){
                    for (int i = 0; i < letras.length; i++) {
                        if (letras[i] == '+' || letras[i] == '-' || letras[i] == '*' || letras[i] == '/' || letras[i] == '^') {
                            push(letras[i]);
                        }else if(letras[i]==')'){
                            System.out.print(pop());
                        } else if(letras[i]!='('){
                            System.out.print(letras[i]);
                        }
                    }
                    System.out.println();
                }


            }

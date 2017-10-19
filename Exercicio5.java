package exercicio5;

import java.util.Scanner;

public class Exercicio5 {
    
    public static class No { //classe no
	private int conteudo; 
	private No prox; //variavel proximo do tipo no
        private No ant; //variavel anterior do tipo no
	
	public No() //metodo no
            {
		setProx(null); //proximo esta vazio
                setAnt(null); //anterior esta vazio
            }

	public int getConteudo() //metodo que dá acesso ao conteudo
            {
		return conteudo;
            }

	public void setConteudo(int conteudo) //metodo que permite alterar o conteudo
            {
		this.conteudo = conteudo;
            }

	public No getProx() //metodo que dá acesso a proximo 
            {
		return prox;
            }

	public void setProx(No prox) //metodo que permite modificar proximo
            {
		this.prox = prox;
            }
       
        public No getAnt() 
            {
		return ant;
            }

	public void setAnt(No ant)
            {
		this.ant = ant;
            }
    }
    
    public static class FilaEnc 
    {
	private static No inicio;  // aponta para o inicio da fila 
	private static No fim;    // aponta para o fim da fila  
	private static int nElementos;
        private static boolean rev = true;
	
	public FilaEnc()//Cria uma Fila encadeada
            {
		inicio = null;
		fim = null;
		nElementos = 0;
            }

	
	public static boolean vazia () //Verifica se a Fila está vazia 
            {
		if (nElementos == 0)
                {
			return true;
                }else{
			return false;
                }
            }

	public static int primeiro() //Consulta o elemento do início da fila e retorna -1 se a fila estiver vazia
            {
		if (vazia())
                {
                    System.out.println("Nenhum trabalho para Ada?");
                    return 0; // Erro: Fila vazia 
                }
                return inicio.getConteudo();
            }
        
        public static int ultimo()  //Consulta o ultimo elemento da fila 
        {
		if (vazia())
                {
                    System.out.println("Nenhum trabalho para Ada?");
                    return 0; // Erro: Fila vazia 
                }
		return fim.getConteudo();
	}

	public static boolean insereI (int valor) //Insere um elemento no fim de uma fila e retorna falso se nao houver mais memoria, verdadeiro se houver
        { 
		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setProx(null);

	    if (vazia())//Inserção na fila vazia 
            {    
	        inicio = novoNo;
                fim = novoNo;
                novoNo.setProx(inicio);
                novoNo.setAnt(fim);
	    }
            else if(vazia()){
                novoNo.setAnt(fim);
                fim.setProx(novoNo);
                fim = novoNo;
            }
	    else {
                novoNo.setAnt(inicio);
                inicio.setProx(novoNo);
                inicio = novoNo; //liga com a fila 
		}
             nElementos++;
	    return true;
	}
        
        public static boolean insereF (int valor) 
        {
		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setProx(null);

	    if (vazia())//Inserção na fila vazia 
            { 
                inicio = novoNo;
                fim = novoNo;
                novoNo.setProx(inicio);
                novoNo.setAnt(fim);
	    }
            else if(vazia()){
                novoNo.setAnt(inicio);
                inicio.setProx(novoNo);
                inicio = novoNo;
            }
	    else {
                novoNo.setAnt(fim);
                fim.setProx(novoNo); //liga com a fila 
                fim = novoNo;
            }
            
	    nElementos++; //atualiza o novo fim 
	    return true;
	}

	/**Retira o elemento do início da fila e retorna o seu valor
	    Retorna -1 se a fila estiver vazia. */
	public static int removeI() 
        {
            if(rev == false)
            {
                if (vazia()) 
                {
                    return 0; // Erro: Fila vazia 
                }

                    int valor = primeiro();
                    No p = inicio;
                    if (inicio == fim)// Fila com 1 elemento 
                    { 
                            fim = null;
                            inicio = null;
                    }
                    else{
                            inicio = p.getAnt();
                            p= null;
                            nElementos--;
                            return valor;
                    }	
                    /* sugere ao garbage collector que libere a memoria
                 *  da regiao apontada por p*/
            }
            
            else{
                System.out.print("esta reverso");
                if (vazia()) {
                    return 0; // Erro: Fila vazia 
                }

                    int valor = ultimo();
                    No p = fim;
                    if (inicio == fim){ // Fila com 1 elemento 
                            fim = null;
                            inicio = null;
                    }
                    else{
                            fim = p.getProx();
                            return valor;
                    }	
                    /* sugere ao garbage collector que libere a memoria
                 *  da regiao apontada por p*/
                p= null;
                nElementos--;
            }
            return 0;
	}
        
        public static int removeF() 
        {
             if(rev == true)
             {
                if (vazia()) 
                {
                    return 0; // Erro: Fila vazia 
                }

                    int valor = primeiro();
                    No p = inicio;
                    if (inicio == fim)// Fila com 1 elemento 
                    { 
                            fim = null;
                            inicio = null;
                    }
                    else{
                            inicio = p.getAnt();
                    }	
                    /* sugere ao garbage collector que libere a memoria
                 *  da regiao apontada por p*/
                p= null;

                nElementos--;
                return valor;
            }
            else{
                if (vazia()) {
                    return 0; // Erro: Fila vazia 
                }

                    int valor = ultimo();
                    No p = fim;
                    if (inicio == fim){ // Fila com 1 elemento 
                            fim = null;
                            inicio = null;
                    }
                    else{
                            fim = p.getProx();
                    }	
                    /* sugere ao garbage collector que libere a memoria
                 *  da regiao apontada por p*/
                p= null;
                nElementos--;
                return valor;
            }
	}

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner (System.in);
        String cons;
        int aux2;
        
        int con = sc.nextInt();

        for (int i = 0; i<con; i++)
        {
            cons = sc.next();
                if(cons.equals("back"))
                {
                        System.out.println(ultimo());
                        removeF();
                }
                else if(cons.equals("front"))
                {
                        System.out.println(primeiro());
                        removeI();
                }
                else if(cons.equals("push_back"))
                {
                        aux2 = sc.nextInt();
                        insereF(aux2);
                }
                else if(cons.equals("toFront"))
                {
                        aux2 = sc.nextInt();
                        insereI(aux2);
                }
                else if(cons.equals("reverse"))
                {
                        rev = !rev;
                }
                else{
                    System.out.println("Nenhum trabalho para Ada?");
                }
        }
    }
  }
}
    

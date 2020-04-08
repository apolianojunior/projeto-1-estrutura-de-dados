public class Main {
    public static void main(String[] args){
        //Variáveis auxiliares
        int[] vetor = new int[2];
        vetor[0] = 0; vetor[1] = 1;

        //Testando os Construtores
        Lista lista1 = new Lista(-1); //Construtor para um número inteiro
        Lista lista2 = new Lista(lista1); //Construtor para uma lista
        Lista lista3 = new Lista(vetor); //Construtor para um vetor
        System.out.println("**** Testando Construtores ****");
        System.out.println("Lista1:");
        lista1.imprime(); //Valor esperado: -1
        System.out.println("Lista2:");
        lista2.imprime(); //Valor esperado: -1
        System.out.println("Lista3:");
        lista3.imprime(); //Valor esperado: 0, 1

        //Testando método append
        lista1.append(0);
        System.out.println("**** Testando Append ****");
        System.out.println("Lista1: ");
        lista1.imprime(); //Valor esperado: -1, 0

        //Testando método prepend
        lista2.prepend(-3);
        System.out.println("**** Testando prepend ****");
        System.out.println("Lista2: ");
        lista2.imprime(); //Valor esperado: -3, -1

        //Testando inserir Posição
        System.out.println("**** Testando InserirPosicao ****");
        System.out.println("Lista3: ");
        lista3.append(2);
        lista3.inserirPosicao(1, 0); //Inserindo no inicio
        lista3.inserirPosicao(2, 1); //Inserindo no meio
        lista3.inserirPosicao(3, 2); //Inserindo no fim
        lista3.imprime(); //Valor esperado 1, 2, 3

        //Testando valorPosicao
        System.out.println("**** Testando valorPosicao ****");
        System.out.println("Lista1:");
        System.out.println(lista1.valorPosicao(0)); //Valor esperado -1

        //Testando concatenar
        System.out.println("**** Testando concatenar ****");
        System.out.println("lista1:");
        lista1.concatenar(lista3);
        lista1.imprime(); //valor esperado -1, 0, 1, 2, 3

        //Testando inserirAposPosicao
        System.out.println("**** Testando inserirAposPosicao ****");
        System.out.println("lista2:");
        lista2.append(0);
        lista2.inserirAposPosicao(-2, 0); // inserindo apos a posicao 0
        lista2.inserirAposPosicao(1, 1); //inserindo entre a posicao 1 e 2
        lista2.inserirAposPosicao(1, 4); //Inserindo apos a posicao 4
        lista2.imprime(); //Valor esperado -3, -2, 1, -1, 0, 1

        //Testando inverter
        System.out.println("**** Testando inverter ****");
        lista3.inverter();
        System.out.println("lista3:");
        lista3.imprime(); //Valor esperado 3, 2 ,1

        //Testando ordernar
        System.out.println("**** Testando ordernar ****");
        System.out.println("lista3:");
        lista3.ordernar();
        lista3.imprime();

        //Testando remover
        System.out.println("**** Testando remover ****");
        System.out.println("lista2:");
        lista2.remover(2);
        lista2.imprime(); //Valor esperado -3, -2, -1, 0, 1

        //Testando esvaziar
        System.out.println("**** Testando esvaziar ****");
        lista1.esvaziar();
        System.out.println("lista1:");
        lista1.imprime(); //Nada

        //Testando clonar
        Elemento teste = lista3.clonar();
        System.out.println("**** Testando Clonar ****");
        while(teste != null){
            teste.imprime(); //Esperado 1, 2 ,3
            teste = teste.getProximo();
        }

        //Testando indice
        System.out.println("**** Testando indice ****");
        System.out.println(lista3.indice(2)); //Valor esperado 1

        //Testando tamanho
        System.out.println("**** Testando tamanho ****");
        System.out.println(lista3.tamanho()); //Valor esperado 3

        //testando array
        System.out.println("**** Testando array ****");
        int[] testeArray = lista3.array();
        for( int i : testeArray ){
            System.out.println(i); //valor esperado 1, 2, 3
        }

        //testando pertence
        System.out.println("**** Testando pertence ****");
        System.out.println(lista3.pertence(2)); //Valor esperado True

        //Testando appendArray
        System.out.println("**** Testando appendArray ****");
        lista3.appendArray(testeArray);
        lista3.imprime(); //Valor esperado 1, 2, 3, 1, 2, 3

        //Testando prependArray
        System.out.println("**** Testando prependArray ****");
        System.out.println("lista2:");
        lista2.prependArray(testeArray);
        lista2.imprime(); //valor esperado 1, 2 ,3, -3, -2, -1, 0, 1

        //Testando inserirListaPosicao
        System.out.println("**** Testando ListaPosicao ****");
        lista1.inserirListaPosicao(lista2, 0); //Lista na posicao Inicial
        lista1.inserirListaPosicao(lista3, 6); //Inserindo no meio da lista
        lista1.imprime();

        //Testando inserirArrayPosicao
        System.out.println("**** Testando ListaPosicao ****");
        lista3.inserirArrayPosicao(vetor, 3);
        lista3.imprime();

        //Testando contar
        System.out.println("**** Testando Contar ****");
        System.out.println(lista3.contar(1)); //3
    }

}

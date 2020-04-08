//TODO
// Refatorar Código
// InserirPosição Substitui
// InserirPosiçãoApós(Do jeito que ta)

public class Lista {
    private Elemento primeiro;
    private Elemento ultimo;

    public Lista(int v)
    {
        this.primeiro = new Elemento(v);
        ultimo = primeiro;
    }

    public Lista(Lista lista){
        for(int i = 0; i <= lista.tamanhoParaUsoInterno(); i++){
            this.append((lista.valorPosicao(i)));
        }
    }

    public Lista(int[] v){
        for(int valor : v){
            this.append((valor));
        }
    }

    //Metodos Privados
    private Elemento getElemento(int p){
        Elemento aux = this.primeiro;
        if(p > 0){
            for(int i = 1; i <= p; i++){
                aux = aux.getProximo();
            }
        }
        return aux;
    }

    private int tamanhoParaUsoInterno(){
        Elemento aux = this.primeiro;
        int it = 0;
        while(aux != null){
            aux = aux.getProximo();
            it++;
        }
        return it - 1;
    }

    //Métodos Públicos
    public void append(int v)
    {
        if(this.primeiro == null){
            this.primeiro = new Elemento(v);
            this.ultimo = this.primeiro;
        }else {
            this.ultimo.setProximo(new Elemento(v));
            this.ultimo = this.ultimo.getProximo();
        }
    }

    public void prepend(int v) {
        if(this.primeiro == null){
            this.primeiro = new Elemento(v);
            this.ultimo = this.primeiro;
        } else {
            Elemento aux = this.primeiro;
            this.primeiro = new Elemento(v);
            this.primeiro.setProximo(aux);
        }
    }

    public void inserirPosicao(int v, int p){
        if(p == 0){
            Elemento aux = this.primeiro.getProximo();
            this.primeiro = new Elemento(v);
            this.primeiro.setProximo(aux);
        } else if(p == this.tamanhoParaUsoInterno()){
            Elemento aux = this.getElemento(p - 1);
            aux.setProximo(new Elemento(v));
            this.ultimo = aux.getProximo();
        } else {
            Elemento proximo = this.getElemento(p + 1);
            this.getElemento(p - 1).setProximo(new Elemento(v));
            this.getElemento(p).setProximo(proximo);
        }
    }

    public int valorPosicao(int p){
        Elemento aux = this.primeiro;
        for(int it = 1; it <= p;it++){
                aux = aux.getProximo();
        }

        return aux.getValor();
    }

    public void concatenar(Lista lista){
        for(int i = 0; i <= lista.tamanhoParaUsoInterno(); i++){
            this.append(lista.valorPosicao(i));
        }
    }

    public void inserirAposPosicao(int v,int p){
        if(p == 0){
            Elemento aux = this.primeiro.getProximo();
            this.primeiro.setProximo(new Elemento(v));
            this.primeiro.getProximo().setProximo(aux); //
        } else if(p == this.tamanhoParaUsoInterno()){
            this.append(v);
        } else {
            Elemento elemento = this.getElemento(p + 1);
            this.getElemento(p).setProximo(new Elemento(v));
            this.getElemento(p).getProximo().setProximo(elemento);
        }
    }

    public void inverter(){
        Elemento aux = this.ultimo;
        for(int i = this.tamanhoParaUsoInterno() -1; i >= 0  ; i--){
            this.append(this.getElemento(i).getValor());
            this.ultimo.setProximo(null);
        }
        this.primeiro = aux;
    }

    public void ordernar(){
        for(int i = 0; i < this.tamanhoParaUsoInterno(); i++){
            for(int j = 0; j < this.tamanhoParaUsoInterno() ; j++){
                if(this.valorPosicao(j) > this.valorPosicao(j + 1)){
                    int aux = this.valorPosicao(j);
                    this.inserirPosicao(this.valorPosicao(j + 1), j);
                    this.inserirPosicao(aux, j+1);
                }
            }
        }
    }

    public void remover(int p){
        if(p == 0){
            this.primeiro = this.primeiro.getProximo();
        } else if(p == this.tamanhoParaUsoInterno()){
            this.getElemento(this.tamanhoParaUsoInterno() - 1).setProximo(null);
            this.ultimo = this.getElemento(this.tamanhoParaUsoInterno());
        } else{
            this.getElemento(p - 1).setProximo(this.getElemento(p + 1));
        }
    }

    public void esvaziar(){
        this.primeiro = null;
        this.ultimo = null;
    }

    public Elemento clonar(){
        Elemento aux = new Elemento(this.valorPosicao(0));
        Elemento retorno = aux;

        for(int i = 1; i <= this.tamanhoParaUsoInterno(); i++){
            Elemento it = new Elemento(this.valorPosicao(i));
            aux.setProximo(it);
            aux = it;
        }

        return retorno;
    }

    public int indice(int v){
        for(int i = 0; i <= this.tamanhoParaUsoInterno(); i++){
            if(v == this.valorPosicao(i)){
                return i;
            }
        }
        return -1;
    }

    public int tamanho(){
        Elemento aux = this.primeiro;
        int it = 0;
        while(aux != null){
            aux = aux.getProximo();
            it++;
        }
        return it;
    }

    public int[] array(){
        int[] retorno = new int[this.tamanho()];
        retorno[0] = this.valorPosicao(0);
        for(int i = 1; i <= this.tamanhoParaUsoInterno(); i++){
            retorno[i] = this.valorPosicao(i);
        }
        return retorno;
    }

    public boolean pertence(int v){
        for(int i = 0; i<this.tamanhoParaUsoInterno(); i++){
            if(this.valorPosicao(i) == v){
                return true;
            }
        }
        return false;
    }

    public void appendArray(int[] v){
        for (int value : v) {
            this.append(value);
        }
    }

    public void prependArray( int[] v ){
        for(int i = (v.length - 1); i >= 0; i--) {
            this.prepend(v[i]);
        }
    }

    public void inserirListaPosicao(Lista lista, int p){
        if(p == 0){
            for(int i = lista.tamanhoParaUsoInterno(); i >= 0; i--){
                this.prepend(lista.valorPosicao(i));
            }
        } else if(p == this.tamanhoParaUsoInterno()){
            for(int i = 0; i < lista.tamanhoParaUsoInterno(); i++){
                this.append(lista.valorPosicao(i));
            }
        } else {
            Elemento proximo = this.primeiro;
            Elemento anterior = this.primeiro;
            Elemento aux = new Elemento(lista.valorPosicao(0));

            for(int i = 1; i < p+2;i++){
                proximo = proximo.getProximo();
            }

            for(int i = 1; i < p + 1;i++){
                anterior = anterior.getProximo();
            }

            anterior.setProximo(aux);
            for(int i = 1; i<=lista.tamanhoParaUsoInterno(); i++){
                Elemento novo = new Elemento(lista.valorPosicao(i));
                aux.setProximo(novo);
                aux = novo;
            }
            aux.setProximo(proximo);

        }
    }

    public void inserirArrayPosicao(int[] v, int p) {
        if (p == 0) {
            Elemento aux = this.primeiro;
            Elemento proximo = aux.getProximo();
            for (int value : v) {
                Elemento it = new Elemento(value);
                aux.setProximo(it);
                aux = it;
            }
            aux.setProximo(proximo);
        } else if(p == (this.tamanhoParaUsoInterno() - 1)){
            for(int value : v){
                this.append(value);
            }
        } else{
            Elemento proximo = this.primeiro;
            Elemento anterior = this.primeiro;
            Elemento aux = new Elemento(v[0]);

            for(int i = 1; i < p+2;i++){
                proximo = proximo.getProximo();
            }

            for(int i = 1; i < p + 1;i++){
                anterior = anterior.getProximo();
            }
            anterior.setProximo(aux);
            for(int i = 1; i<v.length;i++){
                Elemento novo = new Elemento(v[i]);
                aux.setProximo(novo);
                aux = novo;
            }
            aux.setProximo(proximo);
        }
    }

    public int contar(int v){
        int retorno = 0;
        for(int i = 0; i < this.tamanhoParaUsoInterno(); i++){
            if(this.valorPosicao(i) == v){
                retorno++;
            }
        }
        return retorno;
    }

    public void imprime()
    {
        Elemento aux = this.primeiro;
        while(aux != null)
        {
            aux.imprime();
            aux = aux.getProximo();
        }
    }
}

public class Elemento {
    private int valor;
    private Elemento proximo;
    public Elemento(int v)
    {
        this.valor = v;
        this.proximo = null;
    }

    public void setProximo(Elemento e)
    {
        this.proximo = e;
    }

    public Elemento getProximo()
    {
        return this.proximo;
    }

    public int getValor(){
        return this.valor;
    }

    public void imprime()
    {
        System.out.println("valor = " + this.valor);

    }
}

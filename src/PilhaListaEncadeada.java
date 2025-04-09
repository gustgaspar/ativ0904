public class PilhaListaEncadeada {

    private static class No {
        int valor;
        No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No topo;  // Referência para o topo da pilha
    private int tamanho;  // Tamanho atual da pilha

    public PilhaListaEncadeada() {
        topo = null;
        tamanho = 0;
    }

    //inserir um elemento no topo da pilha
    public void insere(int valor) {
        No novoNo = new No(valor);
        novoNo.proximo = topo;
        topo = novoNo;
        tamanho++;
    }

    // remover e retornar o elemento do topo da pilha
    public int remove() {
        if (estaVazia()) {
            throw new IllegalStateException("Pilha vazia!");
        }
        int valorRemovido = topo.valor;
        topo = topo.proximo;
        tamanho--;
        return valorRemovido;
    }

    public void imprime() {
        if (estaVazia()) {
            System.out.println("Pilha vazia!");
            return;
        }

        No atual = topo;
        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
        System.out.println();
    }

    public boolean estaVazia() {
        return topo == null;
    }

    // Retorna o tamanho da pilha
    public int tamanho() {
        return tamanho;
    }


    public static void main(String[] args) {
        PilhaListaEncadeada pilha = new PilhaListaEncadeada();

        pilha.insere(10);
        pilha.insere(20);
        pilha.insere(30);

        pilha.imprime();

        System.out.println("Elemento removido: " + pilha.remove());

        pilha.insere(40);
        pilha.imprime();

        System.out.println("Tamanho da pilha: " + pilha.tamanho());
    }
}
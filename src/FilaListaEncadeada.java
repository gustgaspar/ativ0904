public class FilaListaEncadeada {

    private static class No {
        int valor;
        No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No inicio;  // Primeiro elemento da fila
    private No fim;     // Último elemento da fila

    public FilaListaEncadeada() {
        inicio = null;
        fim = null;
    }

    // Metodo para enserir no final da fila
    public void insere(int valor) {
        No novoNo = new No(valor);

        if (inicio == null) {
            // Fila vazia, novo nó será tanto o início quanto o fim
            inicio = novoNo;
            fim = novoNo;
        } else {
            // Adiciona ao final da fila
            fim.proximo = novoNo;
            fim = novoNo;
        }
    }

    // metodo para remover no inicio da fila
    public int remove() {
        if (inicio == null) {
            System.out.println("Fila vazia!");
            return -1;
        }

        int valorRemovido = inicio.valor;
        inicio = inicio.proximo;


        if (inicio == null) {
            fim = null;
        }

        return valorRemovido;
    }


    public void imprime() {
        if (inicio == null) {
            System.out.println("Fila vazia!");
            return;
        }

        No atual = inicio;
        System.out.print("Fila (início -> fim): ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        FilaListaEncadeada fila = new FilaListaEncadeada();

        fila.insere(10);
        fila.insere(20);
        fila.insere(30);

        fila.imprime();

        System.out.println("Elemento removido: " + fila.remove());  // Remove 10

        fila.insere(40);
        fila.imprime();

        fila.remove();
        fila.remove();
        fila.remove();
        fila.imprime();
    }
}
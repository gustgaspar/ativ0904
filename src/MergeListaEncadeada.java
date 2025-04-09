import java.util.Scanner;

public class MergeListaEncadeada {
    private static class No {
        int valor;
        No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private static class Fila {
        No inicio;
        No fim;

        public Fila() {
            inicio = null;
            fim = null;
        }

        public void insere(int valor) {
            No novoNo = new No(valor);
            if (inicio == null) {
                inicio = novoNo;
                fim = novoNo;
            } else {
                fim.proximo = novoNo;
                fim = novoNo;
            }
        }

        public int remove() {
            if (inicio == null) {
                System.out.println("Fila vazia!");
                return -1;
            }
            int valor = inicio.valor;
            inicio = inicio.proximo;
            if (inicio == null) {
                fim = null;
            }
            System.out.println("Elemento removido: " + valor);
            return valor;
        }

        public boolean vazia() {
            return inicio == null;
        }

        public void imprime() {
            if (vazia()) {
                System.out.println("Fila vazia!");
                return;
            }
            System.out.print("Fila: ");
            No atual = inicio;
            while (atual != null) {
                System.out.print(atual.valor + " ");
                atual = atual.proximo;
            }
            System.out.println();
        }
    }

    public static Fila merge(Fila A, Fila B) {
        Fila C = new Fila();

        while (!A.vazia() && !B.vazia()) {
            if (A.inicio.valor < B.inicio.valor) {
                C.insere(A.remove());
            } else {
                C.insere(B.remove());
            }
        }

        while (!A.vazia()) {
            C.insere(A.remove());
        }

        while (!B.vazia()) {
            C.insere(B.remove());
        }

        return C;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== FILA A ===");
        Fila A = criarFila(scanner, "A");

        System.out.println("=== FILA B ===");
        Fila B = criarFila(scanner, "B");

        System.out.println("\n=== FILA A ORIGINAL ===");
        A.imprime();

        System.out.println("\n=== FILA B ORIGINAL ===");
        B.imprime();

        Fila C = merge(A, B);

        System.out.println("\n=== FILA C (MERGE) ===");
        C.imprime();
    }

    private static Fila criarFila(Scanner scanner, String nome) {
        Fila fila = new Fila();

        System.out.print("Quantidade de elementos da fila " + nome + ": ");
        int quantidade = scanner.nextInt();

        System.out.println("Digite os elementos ordenados da fila " + nome + ":");
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Elemento " + (i+1) + ": ");
            fila.insere(scanner.nextInt());
        }
        return fila;
    }
}
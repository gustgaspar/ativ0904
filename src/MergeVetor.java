import java.util.Scanner;

public class MergeVetor {
    private static class Fila {
        int[] elementos;
        int inicio;
        int fim;
        int capacidade;

        public Fila(int capacidade) {
            this.capacidade = capacidade;
            elementos = new int[capacidade];
            inicio = 0;
            fim = -1;
        }

        public void insere(int valor) {
            if (fim == capacidade - 1) {
                System.out.println("Fila cheia!");
                return;
            }
            elementos[++fim] = valor;
        }

        public int remove() {
            if (inicio > fim) {
                System.out.println("Fila vazia!");
                return -1;
            }
            int valor = elementos[inicio++];
            System.out.println("Elemento removido: " + valor);
            return valor;
        }

        public boolean vazia() {
            return inicio > fim;
        }

        public void imprime() {
            if (vazia()) {
                System.out.println("Fila vazia!");
                return;
            }
            System.out.print("Fila: ");
            for (int i = inicio; i <= fim; i++) {
                System.out.print(elementos[i] + " ");
            }
            System.out.println();
        }
    }

    public static Fila merge(Fila A, Fila B) {
        Fila C = new Fila(A.capacidade + B.capacidade);

        while (!A.vazia() && !B.vazia()) {
            if (A.elementos[A.inicio] < B.elementos[B.inicio]) {
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
        System.out.print("Capacidade da fila " + nome + ": ");
        int capacidade = scanner.nextInt();
        Fila fila = new Fila(capacidade);

        System.out.println("Digite os elementos ordenados da fila " + nome + ":");
        for (int i = 0; i < capacidade; i++) {
            System.out.print("Elemento " + (i+1) + ": ");
            fila.insere(scanner.nextInt());
        }
        return fila;
    }
}
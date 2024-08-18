public class FilaCircular<T> {
    private T[] fila;
    private int tamanho;
    private int inicio;
    private int fim;
    private int capacidade;

    // Construtor para inicializar a fila com a capacidade especificada
    @SuppressWarnings("unchecked")
    public FilaCircular(int capacidade) {
        this.capacidade = capacidade;
        this.fila = (T[]) new Object[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 0;
    }

    // Método para verificar se a fila está vazia
    public boolean estaVazia() {
        return tamanho == 0;
    }

    // Método para verificar se a fila está cheia
    public boolean estaCheia() {
        return tamanho == capacidade;
    }

    // Método para adicionar um elemento na fila
    public void enfileirar(T elemento) {
        if (estaCheia()) {
            throw new RuntimeException("Fila cheia");
        }
        fila[fim] = elemento;
        fim = (fim + 1) % capacidade;
        tamanho++;
    }

    // Método para remover um elemento da fila
    public T desenfileirar() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        T elemento = fila[inicio];
        fila[inicio] = null; // Opcional: Limpar o espaço para evitar vazamento de memória
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return elemento;
    }

    // Método para obter o primeiro elemento da fila sem remover
    public T espiar() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        return fila[inicio];
    }

    // Método para obter o tamanho atual da fila
    public int getTamanho() {
        return tamanho;
    }

    // Método para imprimir a fila (para fins de depuração)
    public void imprimirFila() {
        System.out.print("Fila: ");
        for (int i = 0; i < capacidade; i++) {
            System.out.print(fila[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FilaCircular<Integer> fila = new FilaCircular<>(5);

        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);
        fila.imprimirFila();

        System.out.println("Desenfileirado: " + fila.desenfileirar());
        fila.imprimirFila();

        fila.enfileirar(4);
        fila.enfileirar(5);
        fila.enfileirar(6);
        fila.imprimirFila();

        System.out.println("Desenfileirado: " + fila.desenfileirar());
        fila.imprimirFila();
    }
}
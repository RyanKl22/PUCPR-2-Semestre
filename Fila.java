public class Fila<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;

    public Fila(int tamanho) {
        data = (T[]) new Object[tamanho];
    }

    public void add(T item) {
        if (isFull()) {
            throw new IllegalStateException("A fila está cheia.");
        }
        data[++top] = item;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        T item = data[base];
        // Desloca os elementos para "frente" na fila
        for (int i = 0; i < top; i++) {
            data[i] = data[i + 1];
        }
        data[top] = null; // Limpa a posição final
        top--;
        return item;
    }

    public void clear() {
        for (int i = 0; i <= top; i++) {
            data[i] = null;
        }
        top = -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public boolean isEmpty() {
        return top < base;
    }

    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<>(5);
        fila.add(1);
        fila.add(2);
        fila.add(3);
        System.out.println(fila.remove()); // Saída: 1
        fila.add(4);
        fila.add(5);
        fila.add(6); // A fila agora está cheia
        System.out.println(fila.isFull()); // Saída: true
        fila.clear();
        System.out.println(fila.isEmpty()); // Saída: true
    }
}

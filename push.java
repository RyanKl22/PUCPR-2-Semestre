import java.util.Stack;

public class push {
    public static void main(String[] args) {
        // Cria uma nova pilha de inteiros
        Stack<Integer> pilha = new Stack<>();

        // Adiciona elementos à pilha
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        // Exibe a pilha
        System.out.println("Pilha: " + pilha);

        // Remove o elemento do topo da pilha
        int topo = pilha.pop();
        System.out.println("Elemento removido: " + topo);

        // Exibe a pilha após a remoção
        System.out.println("Pilha após remoção: " + pilha);

        // Verifica o elemento do topo sem removê-lo
        int topoAtual = pilha.peek();
        System.out.println("Elemento do topo: " + topoAtual);

        // Verifica se a pilha está vazia
        boolean estaVazia = pilha.isEmpty();
        System.out.println("A pilha está vazia? " + estaVazia);
    }
}

public class LinkedList<T> {
    public Node<T> base;
    public Node<T> top;
    private int size = 0;

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public void add(int pos, T value){
        var nodeToChange = getNode(pos);
        Node<T> newNode = new Node<T>(value, nodeToChange, nodeToChange.previos);

        nodeToChange.previos.next = newNode;
        nodeToChange.previos = newNode;
    }

    public void add(T value){
        Node<T> newNode = new Node<T>(value, null, top);
        top.next = newNode;
        top = newNode;
        size += 1;
    }

    public T remove(int pos){
        var nodeToChange = getNode(pos);

        return remove(nodeToChange);
    }

   private T remove(Node<T> node){
       node.previos.next = node.next;
       node.next.previos = node.previos;
       size -= 1;
       return node.data;
   }

   private Node<T> getNode(int pos){
        if (pos > size){
            throw new RuntimeException("Fodeu");
        }

        var halfSize = Math.round((float) size / 2);
        var nodePosition = pos < halfSize ? base : top;
        var up = pos < halfSize;
       var position = pos < halfSize ? 1 : size;

        while (true) {
            if (position != pos) {
                nodePosition = getNextNode(up, nodePosition);
            } else {
                return nodePosition;
            }
       }
   }

   private Node<T> getNextNode(boolean up, Node<T> node){
        return up ? node.next : node.previos;
   }

   public T get(int pos){
        return getNode(pos).data;
   }

   public void clear(){
        base = null;
        top = null;
        size = 0;
   }

}


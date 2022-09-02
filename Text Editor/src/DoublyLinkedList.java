public class DoublyLinkedList <Type> {
    private class Node {
        Type item;
        Node next;
        Node prev;
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public boolean isEmpty() {
        return first == null;
    }

    public void AddFirst(Type item) {
        Node Second = first;
        first = new Node();
        first.item = item;
        first.next = Second;
        first.prev = null;
        if (last == null)
            last = first;
        size++;
    }

    public void AddLast(Type item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldlast;
        if (first == null)
            first = last;
        else
            oldlast.next = last;
        size++;
    }

    public boolean insertItem(int position, Type item) {
        if (position > size || position < 0)
            System.out.println("\"Out Of Range ...!\"");
        if (position == 0) {
            AddFirst(item);
        } else if (position == size) {
            AddLast(item);
        } else {
            Node current = first;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
            Node newNode = new Node();
            newNode.item = item;
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        return true;
    }

    public Type retrieveFirst() {
        if (first == null) {
            return null;
        } else {
            Type x = first.item;
            first = first.next;
            if (first != null)
                first.prev = null;
            size--;
            return x;
        }
    }

    public Type retrieveLast() {
        if (last != null) {
            Type item = last.item;
            if (first == last) {
                first = last = null;
            } else {
                last = last.prev;
                last.next = null;
            }
            size--;
            return item;
        }
        else {
            return null;
        }

    }



    public Type removeAt(int position) {
        if (position >= size || position < 0)
            System.out.println("\"Out Of Range ...!\"");
        if (position == 0) {
            return retrieveFirst();
        } else if (position== size -1) {
            return retrieveLast();
        } else {
            Node current = first;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
            Node toRemove = current.next;
            current.next = toRemove.next;
            toRemove.next.prev = current;
            size--;
            return toRemove.item;
        }
    }


    public boolean replace_Specific_line(int index, Type new_line) {
        if (index >= size || index < 0)
            System.out.println("\"Out Of Range ...!\"");
        Node curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.item = new_line;
        return true;
    }

    public Type show_line_length(int index) {
        if (index >= size || index < 0)
            System.out.println("\"Out Of Range ...!\"");
        Node curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.item;
    }

    public int getSize() {
        return size;
    }

    public String show_all_lines() {
        String res = "";
        Node n = first;
        while (n != null) {
            res += n.item + "\n";
            n = n.next;
        }
        return res;
    }

    public void Destroy() {
        first = last = null;
    }


    public void printAll() {
        Node n =first ;
        while(n!=null){
            System.out.println(n.item);
            n=n.next;
        }

    }
}

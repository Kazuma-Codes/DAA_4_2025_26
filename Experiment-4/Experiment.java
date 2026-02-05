import java.util.*;

class Experiment {

    private static final int CAPACITY = 1000;
    private int[] data = new int[CAPACITY];
    private int size = 0;

    /* Move element UP to restore heap property */
    private void siftUp(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (data[parent] <= data[idx]) break;

            int temp = data[parent];
            data[parent] = data[idx];
            data[idx] = temp;

            idx = parent;
        }
    }

    public void add(int value) {
        if (size == CAPACITY) {
            System.out.println("Heap is full");
            return;
        }

        data[size] = value;
        size++;
        siftUp(size - 1);
    }

    private void siftDown(int idx) {
        int smallest = idx;
        int leftChild = 2 * idx + 1;
        int rightChild = 2 * idx + 2;

        if (leftChild < size && data[leftChild] < data[smallest])
            smallest = leftChild;

        if (rightChild < size && data[rightChild] < data[smallest])
            smallest = rightChild;

        if (smallest != idx) {
            int temp = data[idx];
            data[idx] = data[smallest];
            data[smallest] = temp;

            siftDown(smallest);
        }
    }

    public void removeMin() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return;
        }

        data[0] = data[size - 1];
        size--;
        siftDown(0);
    }

    public void removeValue(int value) {
        int pos = -1;

        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Value not found");
            return;
        }

        data[pos] = data[size - 1];
        size--;

        if (pos > 0 && data[pos] < data[(pos - 1) / 2])
            siftUp(pos);
        else
            siftDown(pos);
    }

    public void printHeap() {
        for (int i = 0; i < size; i++)
            System.out.print(data[i] + " ");
    }

    public static void main(String[] args) {

        Experiment heap = new Experiment();

        heap.add(10);
        heap.add(20);
        heap.add(1);
        heap.add(0);

        heap.removeMin();
        heap.removeValue(10);
        heap.removeValue(20);

        heap.printHeap();
    }
}

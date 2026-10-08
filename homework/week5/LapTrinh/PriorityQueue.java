package homework.week5.LapTrinh;

import java.util.Arrays;

public class PriorityQueue {
    int[] heap;
    int size = 0;
    int capacity;

    public PriorityQueue(int[] heap, int capacity) {
        this.heap = new int[capacity];
        this.capacity = capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(int value){
        if (size == capacity){
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *=2;
        }
        heap[size] = value;
        size++;

        heapifyUp(size - 1);
    }

    public int deleteMin(){
        if(isEmpty()){
            throw new IllegalStateException("Priority Queue is empty");
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        return root;
    }
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while(index > 0 && heap[index] < heap[parentIndex]){
            int temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int min = index;

        if (leftChild > 0 && heap[leftChild] < heap[min]){
            min = leftChild;
        }
        if (rightChild > 0 && heap[rightChild] < heap[min]){
            min = rightChild;
        }

        if (min != index){
            int temp = heap[index];
            heap[index] = heap[min];
            heap[min] = temp;
            heapifyDown(min);
        }
    }


}

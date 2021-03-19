package personal.project;

public class MaxHeap {
  private int[] heap;
  private int size; // size - 1 represents the index of the last item

  public MaxHeap() {
    this.heap = new int[11];
    this.size = 0;
  }

  /*
    Insert value into the MaxHeap
    params:
      value: value to insert into MaxHeap
  */
  public void insert(int value) {
    if(size == heap.length) {
      resize();
    }

    heap[size] = value;
    percolateUp(size);
    size++;
  }

  public int removeMax() {
    if (size == 0) throw new IllegalStateException("Cannot remove from an empty heap!");
    int retVal = heap[0];

    if (size > 1) {
      int value = heap[--size];
      int index = percolateDown(value);
      heap[index] = heap[size];
    } else {
      size--;
    }
    
    return retVal;
  }

  public int peek() {
    return size == 0 ? -1 : heap[0];
  }

  // Returns the size of the heap
  public int size() {
    return size;
  }

  public String toString() {
    String ret = "";
    for (int i = 0; i < size; i++) {
      ret += heap[i] + " ";
    }

    return ret;
  }

  // Helps retain MaxHeap order after insert, returns the index of the hole
  private void percolateUp(int hole) {
    int parent = (hole - 1) / 2;
    while (hole > 0 && heap[parent] < heap[hole]) {
      swap(parent, hole);
      hole = parent;
      parent = (hole - 1) / 2;
    }
  }

  private int percolateDown(int value) {
    int hole = 0;
    int leftChild = hole * 2 + 1;
    int rightChild = hole * 2 + 2;
    int greaterChild;
    while(leftChild < size) {
      if (rightChild < size) {
        greaterChild = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
      } else {
        greaterChild = leftChild;
      }

      if (value >= heap[greaterChild]) {
        return hole;
      }

      heap[hole] = heap[greaterChild];
      hole = greaterChild;
      leftChild = hole * 2 + 1;
      rightChild = hole * 2 + 2;
    }

    return hole;
  }

  // Swap elements from index i1 and i2
  private void swap(int i1, int i2) {
    int temp = heap[i1];
    heap[i1] = heap[i2];
    heap[i2] = temp;
  }

  // resize array when array is full
  private void resize() {
    int[] newArr = new int[heap.length * 2];
    for (int i = 0; i < heap.length; i++) {
      newArr[i] = heap[i];
    }
    heap = newArr;
  }
}

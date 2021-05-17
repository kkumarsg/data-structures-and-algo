package heaps;

public class MinHeap {

    int[] harr;
    int capacity;
    int heap_size;
    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    int extractMin()
    {
        // Your code here.
        if(heap_size==0){
            return -1;
        }
        if(heap_size==1){
            heap_size -= 1;
            return harr[0];
        }
        int temp = harr[0];
        harr[0] = harr[heap_size-1];
        harr[heap_size-1] = temp;

        heap_size = heap_size - 1;
        heapify(harr,heap_size,0);
        return temp;
    }

    //Function to insert a value in Heap.
    void insertKey(int k)
    {
        // Your code here.
        if(heap_size+1>capacity){
            return ;
        }
        heap_size = heap_size + 1;
        harr[heap_size-1] = k;
        int end = heap_size - 1;
        while(end!=0 && harr[parent(end)]>harr[end]){
            int temp = harr[end];
            harr[end] = harr[parent(end)];
            harr[parent(end)] = temp;

            end = parent(end);
        }
    }

    //Function to delete a key at ith index.
    void deleteKey(int i)
    {
        if(i>heap_size-1){
            return ;
        }
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    //Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val)
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void buildHeap(int arr[], int n)
    {
        // Your code here
        for(int i=parent(n-1); i>=0; i--){
            heapify(arr, n, i);
        }
    }

    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        int minIndex = i;
        if(left(i)<n && arr[left(i)]>arr[minIndex]){
            minIndex = left(i);
        }
        if(right(i)<n && arr[right(i)]>arr[minIndex]){
            minIndex = right(i);
        }
        if(minIndex!=i && minIndex<n){
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            heapify(arr,n,minIndex);
        }
    }

    public void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr, n);

        int size = n;
        while(size>1){
            int temp = arr[0];
            arr[0] = arr[size-1];
            arr[size-1] = temp;

            size = size - 1;
            if(size>1)
                heapify(arr,size,0);
        }
    }



}

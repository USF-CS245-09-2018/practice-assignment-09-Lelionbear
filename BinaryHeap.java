public class BinaryHeap {
    private int[] arr;
    private int size = 0;

    public BinaryHeap(){
        arr = new int[10];
    }

    public void add(int pri){
        if (arr.length == size){
            growArr();
        }
        arr[size] = pri;
        size++;
        int index = size - 1;
//        int parent = (index - 1)/2;
//        while(index > 0 && arr[index] < arr[parent]){
//            swap(index,parent);
//            index = parent;
//        }
        while(index > 0){
            int parent = (index - 1)/2;
            if (arr[index] < arr[parent]){
                swap(index,parent);
                index = parent;
            }else{
                return;
            }
        }
    }

    private void swap(int index, int parent) {
        int temp =  arr[index];
        arr[index] = arr[parent];
        arr[parent] = temp;
    }

    private void growArr() {
        int newArr[] = new int[arr.length*2];
        for(int i = 0; i < size; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int remove(){
        int priority = arr[0];
        arr[0] = arr[size-1];
        size--;
        shiftDown(0);
        return priority;
    }

    private void shiftDown(int index) {
        //BASE CASE NEEDED
        int child = index * 2 + 1;
        if (child >= size){
            return;
        }
        if (arr[child + 1] < arr[child])
            child = child + 1;
        if (arr[index] > arr[child]){
            swap(index,child);
            shiftDown(child);
        }

    }
}

public class DemoHeap
{


    int arr[] = {4,2,3,6,1,5,7};

    public static void main(String[] args)
    {
        Customheap cHeap = new Customheap(10);
        cHeap.addElement( 4 );
        cHeap.addElement( 3 );
        cHeap.addElement( 6 );
        cHeap.addElement( 1 );
        cHeap.addElement( 5 );
        cHeap.addElement( 7 );
        cHeap.addElement( 8 );

      cHeap.printHeap();
    }

}

class Customheap{

    int[] heap;
    int count;
    int capacity;

    public Customheap(int capacity)
    {
        this.capacity = capacity;
        heap = new int[capacity];
        this.count = 0;
    }

    public void addElement(int data)
    {

        heap[count++] = data;
        heapifyUp(count-1);
    }

    public int deleteElement(int index)
    {

        int value = heap[index];
        heap[index] = heap[count-1];
        count--;
        heapifyDown(index);
        return value;
    }

    private void heapifyUp(int index)
    {
        int parent = (index/2)-1;
        int temp=0;
        if(parent >=0  && heap[parent] > heap[index])
        {
            //swap
            temp = heap[parent];
            heap[parent] = heap[index];
            heap[index]=temp;
            heapifyUp(parent);
        }

    }

    private void heapifyDown(int index)
    {

        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int min = 0;


        if( leftChild < count-1 && heap[index] > heap[leftChild] )
        {
            min = leftChild;
        }
        if(rightChild < count-1 &&  heap[index] > heap[rightChild] )
        {
            min = rightChild;
        }
        //swap min with index
        int temp;
        if( index != min )
        {

            temp = heap[index];
            heap[index] = heap[min];
            heap[min] = temp;
        }
        heapifyDown( min);
    }

     public void printHeap()
     {
         System.out.println("Element in heap = ");
         for(int i=0; i< count;i++)
         {
             System.out.println(heap[i]);
         }
     }

    }


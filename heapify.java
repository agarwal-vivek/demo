public class heapify
{




    public static void main(String[] args)
    {
        heapify hp = new heapify();
        int[] heap ={4,2,1,5,6,3,7,9};

        int len = heap.length;

        hp.buildheap(heap,len);
        hp.printHeap( heap,len );

    }

    public void  buildheap(int[] heap, int n)
    {
        int maxIndex = (n/2)-1;

        for(int i= maxIndex; i>=0;i--)
        {
            heapifying( heap,n,i );

        }



    }

    public void heapifying(int[] heap, int n, int index)
    {

     int min=index,leftchild=0,rightChild=0;


        leftchild = 2*index+1;
        rightChild = 2*index+2;

       if(leftchild<n && heap[leftchild] < heap[min])
       {
           min = leftchild;
       }
       if(rightChild<n && heap[rightChild] < heap[min])
       {
           min = rightChild;
       }

       if(index != min)
       {
           int temp=0;
           temp = heap[index];
           heap[index] = heap[min];
           heap[min] = temp;

           heapifying( heap,n,min );

       }

    }

    public void printHeap(int arr[], int n)
    {
        System.out.println("Array representation of Heap is:");

        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}

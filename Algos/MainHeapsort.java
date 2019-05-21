import java.util.Scanner;
public class MainHeapsort
{
    public static void swap(int[] arr, int a, int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void heapSort(int[] arr1, int initialpos, int n1, int[] arr2)
    {

        for(int i=n1/2 - 1; i>=0;i--)
            buildHeap(arr1, arr2, n1, i);

        for(int i=n1-1; i>=0; i--)
        {
            swap(arr1, i, 0);
            swap(arr2, i, 0);

            buildHeap(arr1, arr2, i, 0);
        }


    }

    public static void buildHeap(int[] arr1, int[] arr2, int n, int i)
    {
        int largest =i;
        int l=2*i + 1;
        int r=2*i + 2;

        if(l<n && arr1[l]>arr1[largest])
            largest=l;
        if(r<n && arr1[r]>arr1[largest])
            largest=r;

        if(largest!=i)
        {
            swap(arr1, largest, i);
            swap(arr2, largest, i);

            buildHeap(arr1, arr2, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        MainHeapsort obj = new MainHeapsort();

        System.out.println("Enter the no. of vector pairs:");
        int pairs=scan.nextInt();
        int[] arr1=new int[pairs];
        int[] arr2=new int[pairs];
        System.out.println("Enter the first elements of the pairs:");
        for(int i=0; i<pairs; i++)
            arr1[i]=scan.nextInt();
        System.out.println("Enter the second elements of the pairs:");
        for(int i=0; i<pairs; i++)
            arr2[i]=scan.nextInt();

        obj.heapSort(arr1, 0, pairs, arr2);



        int z=0;
        while( z<pairs-1)
        {    int count =1;
            while(z<pairs-1 && arr1[z]==arr1[z+1])
            {
                ++count;
                z++;
            }
            if(count>1)
            {
                int initialpos=z+1-count;
                obj.heapSort(arr2, initialpos, count, arr1);
            }
            ++z;
        }
        System.out.println("The sorted array is: ");
        for(int i=0; i< pairs; i++)
            System.out.println(arr1[i]+ " "+ arr2[i]);


    }
}

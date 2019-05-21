
import java.util.Scanner;
public class MainIntrosort
{
    public static void swap(int[] arr, int a, int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void insertionSort(int arr1[], int l, int r, int arr2[])
    {

        for (int i = l; i <= r; i++) {
            int key1 = arr1[i];
            int key2 = arr2[i];
            int j = i;

            while (j > l && arr1[j - 1] > key1) {
                arr1[j] = arr1[j - 1];
                arr2[j] = arr2[j-1];
                j--;
            }
            arr1[j] = key1;
            arr2[j] = key2;
        }
    }

    public static int Pivot(int arr1[], int a, int b, int c)
    {
        int max = Math.max(Math.max(arr1[a], arr1[b]), arr1[c]);
        int min = Math.min(Math.min(arr1[a], arr1[b]), arr1[c]);
        int median = max ^ min ^ arr1[a] ^ arr1[b] ^ arr1[c];
        if (median == arr1[a])
            return a;
        else if (median == arr1[b])
            return b;
        else
            return c;
    }

    public static int partition(int arr1[], int low, int high, int arr2[])
    {
        int pivot = arr1[high];
        int i = low-1;
        for (int j=low; j<=high-1; j++)
        {
            if (arr1[j] <= pivot)
            {
                i++;
                swap(arr1, i, j);
                swap(arr2, i, j);

            }
        }

        swap(arr1, i+1, high);
        swap(arr2, i+1, high);
        return (i+1);
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

    public static void sortData(int arr1[], int begin, int end, int depthLimit, int arr2[])
    {
        if (end - begin > 16) {
            if (depthLimit == 0) {

                heapSort(arr1, begin, end+1 , arr2);
                return;
            }

            int pivot = Pivot(arr1, begin,
                    begin + ((end - begin) / 2) + 1,
                    end);
            swap(arr1, pivot, end);
            swap(arr2, pivot, end);

            int p = partition(arr1, begin, end, arr2);

            sortData(arr1, begin, p - 1, depthLimit-1, arr2);
            sortData(arr1, p + 1, end, depthLimit-1, arr2);
        }

        else
            insertionSort(arr1, begin, end, arr2);

    }

    public static void intSort(int arr1[], int initialpos, int finalpos, int arr2[])
    {
        int n=arr1.length;
        int depthLimit
                = (int)(2 * Math.floor(Math.log(n) /
                Math.log(2)));

        sortData(arr1, initialpos, finalpos, depthLimit, arr2);

    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        MainIntrosort obj = new MainIntrosort();

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

        obj.intSort(arr1, 0, pairs-1, arr2);

        System.out.println("The initial sorted array is: ");
        for(int i=0; i< pairs; i++)
            System.out.println(arr1[i]+ " "+ arr2[i]);



        int z=0;
        while( z<pairs-1)
        {
            int count =1;
            while(z<pairs-1 && arr1[z]==arr1[z+1])
            {
                ++count;
                z++;
            }
            if(count>1)
            {
                int initialpos=z+1-count;
                obj.intSort(arr2, initialpos, z, arr1);
            }
            ++z;
        }
        System.out.println("The sorted array is: ");
        for(int i=0; i< pairs; i++)
            System.out.println(arr1[i]+ " "+ arr2[i]);


    }
}


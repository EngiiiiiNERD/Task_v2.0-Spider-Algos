import java.util.Scanner;
public class MainQuicksort
{
    public static void swap(int[] arr, int a, int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
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



    public static void quickSort(int arr1[], int low, int high, int arr2[])
    {
        if (low < high)
        {
            int partindex = partition(arr1, low, high, arr2);

            quickSort(arr1, low, partindex-1, arr2);
            if(partindex+1<=high)
                quickSort(arr1, partindex+1, high, arr2);
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        MainQuicksort obj = new MainQuicksort();

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

        obj.quickSort(arr1, 0, pairs-1, arr2);




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
                obj.quickSort(arr2, initialpos, initialpos+count-1, arr1);
            }
            ++z;
        }
        System.out.println("The sorted array is: ");
        for(int i=0; i< pairs; i++)
            System.out.println(arr1[i]+ " "+ arr2[i]);


    }
}


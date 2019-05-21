The unconventional ways of sorting vector pairs used are 1. Heap Sort
                                                         2. Quick Sort
                                                         3. Introsort - Hybrid of heap sort, quick sort and insertion sort
The Quicksort is an efficient sorting algorithm as it does not swap elements that are already in order,but has 
the worst-case performance of O(N ^ 2) comparisons with O(N) auxiliary space. 
This worst-case complexity depends on two phases of the Quicksort algorithm.
1. Choosing the pivot element
2. Recursion depth during the course of the algorithm.
By choosing the optimal pivot, the worst-case of O(N ^ 2) can be avoided in quicksort. 

Heapsort has O(N log N) worst-case time complexity, which is much better than the worst case of Quicksort.  
In Heapsort, even if all of the data is already sorted, the algorithm swaps all of the elements to order the array. 
The advantage in Heapsort is that, if the recursion depth becomes too large like (log N), the worst case complexity 
would be still O(N log N).

Introsort, being a hybrid combines the advantages of heap sort, quick sort and insertion sort.
If the number of elements to be sorted is few (less than 16), the Introsort performs Insertion sort for the input.
    Quicksort is used as it implements least number of comparisons by spliting the array around the pivot element. 
    Median-of-3 concept is used to find the pivot element.
    When the recursion depth gets higher, Introsort uses Heapsort as it has the definite upper bound of O(N log N).

Hence I suggest Introsort as the best algorithm to be implemented for the purpose as it eliminates the cons of the 
three basic algorithms used in its built. It adjusts according to the length of the data structure (array) to be sorted.

The first and second elements of the vector pairs are stored in separate arrays. The first array is prioritized and sorted.
Then the identical elements in the first array are identified and its corresponding elements in the second array are sorted
under the same algorithms implemented respectively. 



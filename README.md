1)Quick sort is one of the fastest sorting done where partitioning is done.So it is divided into three parts.Pivot elements,less than pivot elements,greater than pivot elements.Then smaller ones are kept to the left and then larger ones are kept to the right and sorted.

   The function partition takes last element as pivot, places the pivot element at its correct position in sorted  array, and places all      smaller (smaller than pivot) to left  of pivot and all greater elements to  right of pivot.

2)Heap sort is one of the fastest sorting done where a maximum heap is built up.the largest item is at the root and is replaced with last item and then heap size is reduced by one.This process continues till heap size is greater than unity.

   The children nodes are heaped before before heap is applied to as a whole.

3)Merge sort is the fastest algorithm(as far as i know) where it divides them into two parts, followed by four parts and so on.Then these are sorted individually and then are merged.

  Find the middle point to divide the array into two halves:  
             middle m = (l+r)/2
     2. Call mergeSort for first half:   
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)


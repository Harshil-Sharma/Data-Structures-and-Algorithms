public class HeapSort {

	static int Temp;  
	public static int Count;
	  
	static void heapify(int arr[], int size, int i)  
	{  
		int highest = i;    //largest as root
		int left = 2*i + 1; //left
		int right = 2*i + 2;  //right  

		// If left child is larger than root 
		if (left < size && arr[left] >arr[highest])  {
			highest = left;  
		}
			
		// If right child is larger than root 
		if (right < size && arr[right] > arr[highest])  {
			highest = right; 
		}
			 		
		// If largest is not root
		if (highest != i)  
		{  
			
			Temp = arr[i];  
			arr[i]= arr[highest];   
			arr[highest] = Temp;  
			heapify(arr, size, highest); 
			compare(left, highest);
		}  
	}  

	 static void heapSort(int arr[], int size)  
	{  
  
		// Build heap
		 for (int i = size / 2 - 1; i >= 0; i--) { 
			heapify(arr, size, i);  
		 }
		// One by one extract an element from heap 
		 for (int i=size-1; i>=0; i--)  
		{  
			// Move current root to end
			Temp = arr[0];  
			arr[0]= arr[i];   
			arr[i] = Temp;  
			heapify(arr, i, 0);  
		}  
	}  
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    }
	
	 public static boolean compare(int x, int y) {
	    	Count++;
	    	if(x <= y) {
	    		return true;
	    	}
	    	return false;
	    }
	
	public static void main(String[] args) {
		
		long startTime;
		long endTime;
		int i;
		int sortedArray[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
		int reverseSortedArray[] = {32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};


		int[] randomArr = new int[32];
		for(i = 0; i <  randomArr.length; i++) {
			randomArr[i] = (int) ((Math.random() * 32)+1);
		}
		System.out.println("Random Generated Array from 1-32");
		printArray(randomArr);

		//Random Array 2^10 length
		int[] randomArrn1 = new int[1024];
		for(i = 0; i <  randomArrn1.length; i++) {
			randomArrn1[i] = (int) ((Math.random() * 1024)+1);
		}

		//Random Array 2^15
		int[] randomArrn2 = new int[32768];
		for(i = 0; i <  randomArrn2.length; i++) {
			randomArrn2[i] = (int) ((Math.random() * 32768)+1);
		}

		//Random Array 2^20
		int[] randomArrn3 = new int[1048576];
		for(i = 0; i <  randomArrn3.length; i++) {
			randomArrn3[i] = (int) ((Math.random() * 1048576)+1);
		}

		System.out.println("			PART 1		");
		
		//Heap Sort for sorted array
		System.out.println("SORTED ARRAY from 1-32");

		startTime = System.nanoTime();
		heapSort(sortedArray, sortedArray.length);
		endTime = System.nanoTime();

		System.out.println("Sorted array"); 
		printArray(sortedArray); 
		System.out.println("Time taken by Heap Sort on sorted array : " + (endTime - startTime) + " nanosec");
		System.out.println("Number of comparison for Sorted Array : " + Count);
		Count = 0;

		//Heap Sort for reverse sorted array
		System.out.println("\nREVERSE SORTED ARRAY 32-1");

		startTime = System.nanoTime();
		heapSort(reverseSortedArray, reverseSortedArray.length);
		endTime = System.nanoTime();

		System.out.println("Sorted array"); 
		printArray(reverseSortedArray); 
		System.out.println("Time of Heap Sort on reverse sorted array : " + (endTime - startTime) + " nanosec");
		System.out.println("Number of comparison for Reverse Sorted Array : " + Count);
		Count = 0;

		//Heap Sort for random array
		System.out.println("\nRANDOM ARRAY FROM 1-32 INTEGER");

		startTime = System.nanoTime();
		heapSort(randomArr, randomArr.length);
		endTime = System.nanoTime();
		System.out.println("Sorted array"); 
		printArray(randomArr); 

		System.out.println("Time of Heap Sort on random sorted array :  " + (endTime - startTime) + " nanosec");
		System.out.println("Number of comparison for Random Sorted Array : " + Count);
		Count = 0;

		System.out.println("			PART 2        ");
		
		//Heap Sort for 2^10 array
		System.out.println("ARRAY WITH 2^10 ELEMENTS");

		startTime = System.nanoTime();
		heapSort(randomArrn1, randomArrn1.length);
		endTime = System.nanoTime();

		//System.out.println("Sorted array"); 
		//printArray(randomArrn1); 

		System.out.println("Time of Heap Sort on 2^10 array : " + (endTime - startTime) + " nanosec");
		System.out.println("Number of comparison for 2^10 Sorted Array : " + Count);
		Count = 0;

		//Heap Sort for 2^15 array
		System.out.println("\nARRAY WITH 2^15 ELEMENTS");

		startTime = System.nanoTime();
		heapSort(randomArrn2, randomArrn2.length);
		endTime = System.nanoTime();

		//System.out.println("Sorted array"); 
		//printArray(randomArrn2); 

		System.out.println("Time of Heap Sort on 2^15 sorted array : " + (endTime - startTime) + " nanosec");
		System.out.println("Number of comparison for 2^15 Sorted Array : " + Count);
		Count = 0;

		//Heap Sort for 2^20 array
		System.out.println("\nARRAY WITH 2^20 ELEMENTS");

		startTime = System.nanoTime();
		heapSort(randomArrn3, randomArrn3.length);
		endTime = System.nanoTime();

		//System.out.println("Sorted array"); 
		//printArray(randomArrn3); 
		System.out.println("Time of Heap Sort on 2^20 sorted array :  " + (endTime - startTime) + " nanosec");
		System.out.println("Number of comparison for 2^20 Sorted Array : " + Count);
		Count = 0;
	} 
}
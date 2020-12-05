import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SELECT {
	
	public static int count;

//	#############################################################################################################################
	
    public static void SELECT_2(int[] arr,int n, int k){
    	
    	if (n<25) {
    		insertionsort(arr);
    		System.out.print(arr[k-1]);
    	}
    	else {
    		ArrayList<Integer> L = new ArrayList<Integer>();
    		ArrayList<Integer> E = new ArrayList<Integer>();
    		ArrayList<Integer> G = new ArrayList<Integer>();
    		int max=arr[0]; int min = arr[0];
    		for (int i =0; i<arr.length;i++) {
    			if (arr[i]>max) {
    				max=arr[i];
    			}
    			else if (arr[i]<min) {
    				min=arr[i];
    			}
    		}
    		int V = getRandomNo(min, max);
//    		System.out.println("Pivot" + V);
    		for (int j = 0; j<arr.length; j++) {
    			if (compare(arr[j],V)==-1) {//(arr[j]<V) {
    				L.add(arr[j]);
    			}
    			else if (compare(arr[j],V)==0) {//(arr[j]==V) {
    				E.add(arr[j]);
    			}
    			else if (compare(arr[j],V)==1) {//(arr[j]>V) {
    				G.add(arr[j]);
    			}
    		}
    		int n1 = L.size();
    		int n2 = E.size();
    		int n3 = G.size();
//    		System.out.println("L=" + L);
//    		System.out.println("E=" +E);
//    		System.out.println("G=" +G);
    		
    		Integer[] L1= L.toArray (new Integer[L.size()]);
    		int[] L2 = Arrays.stream(L1).mapToInt(Integer::intValue).toArray();
    		
    		Integer[] G1= G.toArray (new Integer[G.size()]);
    		int[] G2 = Arrays.stream(G1).mapToInt(Integer::intValue).toArray();
    		
    		if (k<=n1) {
    			SELECT_2(L2, n1, k); 			
    		}
    		else if (k>n1 && k<(n1+n2)) {
    			System.out.print(V);
    		}
    		else if(k>(n1+n2)) {
    			SELECT_2(G2, n3, k-n1-n2);
    		}    		   	
    	}
    }
    
//    #######################################################################################################################
     
    public static void SELECT_3(int[] arr, int n, int k) {
    	if (n<25) {
    		insertionsort(arr);
    		System.out.print(arr[k-1]);
    	}   	
    	else {
    		ArrayList<Integer> M = new ArrayList<Integer>();
	    	int j=0;
	    	for (int i=0; i<arr.length; i++) {
	    		if ((i+1)%5==0) {
	    			for (int x=j; x<i+1; x++) {
	    				int key = arr[x];
	    	            int y = x-1;
	    	            while (y>=0 && compare(arr[y],key)==1) {//arr[y] > key){//
	    	                arr[y+1] = arr[y];
	    	                y = y-1;
	    	            }
	    	        arr[y+1] = key;
	    			}
	    			M.add(arr[(j+2)]);
	    			j=i+1;
	    		}
	    		else if (i+1 == arr.length) {
	    			for (int x=j; x<i+1; x++) {
	    				int key = arr[x];
	    	            int y = x-1;
	    	            while (y>=0 && compare(arr[y],key)==1) {//arr[y] > key){//
	    	            	
	    	                arr[y+1] = arr[y];
	    	                y = y-1;
	    	            }
	    	        arr[y+1] = key;
	    			}
	    			if ((i-j+1)%2==0) {
	    				int med= (arr[((i+j)/2)+1]+arr[(i+j)/2])/2;
	    				M.add(med);
	    			}
	    			else {
	    				int med=arr[(i+j)/2];
	    			    M.add(med);
	    			}
	    		}
	    	}
	    	//System.out.println(M);
	    	Integer[] R= M.toArray (new Integer[M.size()]);
	    	int[] ret = Arrays.stream(R).mapToInt(Integer::intValue).toArray();
			insertionsort(ret);
			int pivot;
			if (ret.length % 2 == 0) {
			    pivot = (ret[ret.length/2] + ret[(ret.length/2) - 1])/2;
			}
			else {
			    pivot =  ret[ret.length/2];
			}
			//System.out.println(" PIVOT "+ pivot);
	    	ArrayList<Integer> L = new ArrayList<Integer>();
	    	ArrayList<Integer> E = new ArrayList<Integer>();
	    	ArrayList<Integer> G = new ArrayList<Integer>();
	   		for (int h = 0; h<arr.length; h++) {
	   			if (compare(arr[h],pivot)==-1) {//(arr[h]<pivot) {//
	   				L.add(arr[h]);
	   			}
	   			else if (compare(arr[h],pivot)==0) {//(arr[h]==pivot) {//
	   				E.add(arr[h]);
	   			}
	   			else if (compare(arr[h],pivot)==1) {//(arr[h]>pivot) {//
	   				G.add(arr[h]);
	   			}
	   		}
	   		int n1 = L.size();
	   		int n2 = E.size();
	   		int n3 = G.size();
//	   		System.out.println("L=" + L);
//	   		System.out.println("E=" +E);
//	   		System.out.println("G=" +G);
	   		Integer[] L1= L.toArray (new Integer[L.size()]);
	   		int[] L2 = Arrays.stream(L1).mapToInt(Integer::intValue).toArray();
	   	
	   		Integer[] G1= G.toArray (new Integer[G.size()]);
	   		int[] G2 = Arrays.stream(G1).mapToInt(Integer::intValue).toArray();
	   		
	   		if (k<=n1) {
	   			SELECT_3(L2, n1, k);
	   		}
	   		else if (k>n1 && k<(n1+n2)) {
	   			System.out.print(pivot);
	   		}
	   		else if (k>(n1+n2)) {
	   			SELECT_3(G2, n3, k-n1-n2);
	   		}
    	}
    }
    
// ##########################################################################################################################   
        
    public static void main(String[] args) {
		int number = 1000000;
		int k = number/2;
        int array[] = new int[number];
        int array_1[] = new int[number];
        int array_2[] = new int[number];
		
		for(int i=0;i<array.length;i++)
		{
			array[i]=getRandomNo(10);
		}
		array_1=array;
		array_2=array;
    	count = 0;
		System.out.print("SELECT 1: Length of the array= " + number + ", Position of Kth term= " + k + ", A[k]= "  );
		SELECT_1(array, number, k);
		System.out.print(", Key Comparison= " + count);
		System.out.println();
    	count = 0;
		System.out.print("SELECT 2: Length of the array= " + number + ", Position of Kth term= " + k + ", A[k]= "  );
		SELECT_2(array_1, number, k);
		System.out.print(", Key Comparison= " + count);
		System.out.println();
		count = 0;
		System.out.print("SELECT 3: Length of the array= " + number + ", Position of Kth term= " + k + ", A[k]= "  );
		SELECT_3(array_2, number, k);
		System.out.print(", Key Comparison= " + count);
    }
        
     
//   ########################################################################################################################
    
    public static void SELECT_1(int[] arr, int n, int k) {
		quickSort(arr, 0, n-1);
//		display(arr);
		System.out.print(arr[k-1]);
	}
    
    
    public static void quickSort(int[] arr, int low, int high) 
    {        
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) 
        {
            //Check until all values on left side array are lower than pivot
            while (compare(arr[i],pivot)==-1){//(arr[i] < pivot)         	
                i++;
            }
            //Check until all values on left side array are greater than pivot
            while (compare(arr[j],pivot)==1) {//(arr[j] > pivot) 
                j--;
            }
            //Now compare values from both side of lists to see if they need swapping. After swapping move the iterator on both lists
            if (i <= j) {
                swap (arr, i, j);
                i++; j--;
            }
        }
        if (low < j){
            quickSort(arr, low, j);
        }
        if (high > i){
            quickSort(arr, i, high);
        }
    }
     
    public static void swap (int array[], int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    
//  ########################################################################################################################
          
    public static void display(int[] arr) {
    	System.out.println();
    	for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    	System.out.println();
    }
    
	public static int getRandomNo(int max)
		{
			return (int)(ThreadLocalRandom.current().nextInt(0 , max+1));
		}
		
	public static int getRandomNo(int min, int max)
	{
		return (int)(ThreadLocalRandom.current().nextInt(min, max+1));
	}
		
	public static void insertionsort(int[] arr) {
    	for (int i=1; i<arr.length; ++i){
            int key = arr[i];
            int j = i-1;
            while (j>=0 && compare(arr[j],key)==1) {//arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
        arr[j+1] = key;
    	}
    }
	
	public static int compare(int x, int y) {
		int a=0;
		if (x>y) {
			a = 1;
			count++;
		}
		else if (x<y) {
			a= -1;
			count++;
		}
		else if (x==y) {
			a= 0;
			count++;
		}
		return a;		
	}
}
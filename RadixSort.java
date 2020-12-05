import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RadixSort {
	
	public static void main(String[] args) {
		String a = "BTS";
		String c = "KIM";
		String f = "NAM";
		//int comp= a.compareTo(c);
		//System.out.println(comp);
		String b[] = a.split("");
		String d[] = c.split("");
		//System.out.println(a.charAt(2));

		
		String[][] S = new String[3][3];
		//ArrayList<String[]> S = new ArrayList<>();
//		for(int i=0;i<S.length;i++) {
//			for(int k=0; k<S[i].length;k++) {
//				S[i][k] = a.charAt(k);
//				
//			}			
//		}

		
		
		
		//String k[] = {"D","B","C","A"};

		//System.out.println(Arrays.toString(k));
		//System.out.println(Arrays.toString(P));

		//System.out.println(Arrays.toString(P));
		

//			S.add(a.split(""));
//			S.add(c.split(""));
//			S.add(f.split(""));
			
			S[0] = a.split("");
			S[1] = c.split("");
			S[2] = f.split("");
			
			System.out.println(Arrays.deepToString(S));
			System.out.println(Arrays.toString(S[0]));
			int n= 4;
	        HashMap<Integer, ArrayList<String>> D = new HashMap<Integer, ArrayList<String>>(n);
	        for (int k = 0; k < 3; k++){
	            D.put(k, new ArrayList<String>());
	        }
	        for(int k=0; k<3; k++) {
	        	D.get(k).add(Arrays.toString(S[k]));
	        	//D.get(1).add(Arrays.toString(S[1]));
	        }
	        System.out.println(D);


		//System.out.println(Character.valueOf(S[0][0]).compareTo(Character.valueOf(S[0][0])));

		String[] P = new String[5];
		//String[] P = Stream.of(S).flatMap(Stream::of).toArray(String[]::new);
		//System.out.println(Arrays.toString(P));

	
		
		

		//System.out.println(S);
		
		String[] my = Col(S,2);
		//System.out.println(Arrays.toString(S[0]));
		bucketSort(S,my,P);
		System.out.println(Arrays.toString(my));
		//System.out.println((S[1][1]));
		
	}
	public static String[] Col(String[][] arr, int n) {
		String[] S = new String[arr.length];
		if (n<=21){
			for(int row=0; row<arr.length; row++) {
				for(int col=0; col<arr[row].length;col++) {
					S[row]= arr[row][n];	
				}
			}	
		}System.out.println(Arrays.toString(S));
		return S;
		
	}
	
	
	
	public static void bucketSort(String[][] arr,String[] array, String[] P) {
		 
		// Initialize buckets
        int bucketCount = 26;   // alphabet
        // buckets in maps
        HashMap<Character, ArrayList<String>> buckets = new HashMap<Character, ArrayList<String>>(bucketCount);
       // HashMap<Character, Vector<String>> buckets = new HashMap<Character, Vector<String>>(bucketCount);
        
        char a = 'A';
        for (int i = 0; i < bucketCount; i++, a++){
            buckets.put(a, new ArrayList<String>());
        }  
        System.out.println(buckets);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
        	char letter = array[i].charAt(0);
        	//buckets.get(letter).add(array[i]);
        	buckets.get(letter).add(Arrays.toString(arr[i]));
        }
        
        System.out.println(buckets);
        
        //Sort buckets
        int index = 0;
        int b=0;
        for(char key ='A'; key<='Z';key++,b++) {
        	ArrayList<String> bucket = buckets.get(key); 
        //System.out.println(bucket.size());
        	for (int j = 0; j < bucket.size(); j++) {
                array[index++] = bucket.get(j);
            }
        }
        //arr = Arrays.toString(array);
        //System.out.println(Arrays.toString(array));
        //System.out.println(array[1]);
        
        //System.out.println(Arrays.deepToString(arr));

        //System.out.println(Arrays.deepToString(arr));
        
	}


}

class pointer{
	public String Pointer;
//	private int n;
//	
//	public pointer(int max) {
//		Pointer = new int[max];
//		n = 0;
//	}
//	
//	public void insert(int value) {
//		Pointer[n] = value;
//		n++;
//	}
//	
////	public int size() {
////		return nElems;
////	}
//	
//	public void display() {
//		System.out.print("P=" );
//		for(int j=0; j<n; j++)
//			System.out.print(Pointer[j]+ " ");
//		System.out.println(" ");
//	}
	
}

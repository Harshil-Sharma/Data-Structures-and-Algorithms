import java.io.*;
import java.util.*;

class pointer{
	String[] P;
}

public class Radix {

	 public static void main(String args[]) throws Exception {
		 
		 pointer T=new pointer();
		 ArrayList<String> R= new ArrayList<String>();
		 String a,b;
		 if (args.length > 0) {
			 a=args[0];
		 }
		 else {
			 a="f.txt";
		 }
		 if (args.length>1) {
			 b=args[1];
		 }
		 else {
			 b="g.txt";
		 }
		 R = readfile(a);		 
		 T.P = new String[R.size()];
		 for (int j=0; j<R.size(); j++) {
			 T.P[j]=R.get(j);
		 }
		 String[][] S= new String[T.P.length][21];
		 		 
		 for (int i=0;i< T.P.length; i++) {
			 S[i]=T.P[i].split("");
		 }	
//		 for (int i=0; i<S.length; i++) {
//			 for (int j=0; j<S[i].length; j++)
//				 System.out.print(S[i][j]+",");
//			 System.out.println();
//		 }
		 radixSort(T.P,'A','Z');
		 writefile(T.P, b);
	 }
		  
	 public static void countingSort(String[] arr,int index,char lower,char upper){
		 int[] countArray = new int[(upper-lower)+2];
		 String[] tempArray = new String[arr.length];
		 Arrays.fill(countArray,0);
		    
		 //increase count for char at index
		 for(int i=0;i<arr.length;i++){
			 int charIndex = (arr[i].length()-1 < index) ? 0 : ((arr[i].charAt(index) - lower)+1);
		     countArray[charIndex]++;
		 }   
		 
		 //sum up countArray;countArray will hold last index for the char at each strings index
		 for(int i=1;i<countArray.length;i++){
		     countArray[i] += countArray[i-1];
		 }
		 
		 for(int i=arr.length-1;i>=0;i--){
		     int charIndex = (arr[i].length()-1 < index) ? 0 : (arr[i].charAt(index) - lower)+1;
		     tempArray[countArray[charIndex]-1] = arr[i];
		     countArray[charIndex]--;
		 }	
		 
		 for(int i=0;i<tempArray.length;i++){
		     arr[i] = tempArray[i];   
		 }
	 }
		  
	 public static void radixSort(String[] arr,char lower,char upper){
		int maxIndex = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i].length()-1 > maxIndex){
				maxIndex = arr[i].length()-1;
			}
		}
		for(int i=maxIndex;i>=0;i--){
			countingSort(arr,i,lower,upper);
		}
	 }
	    
//	#########################################################################################################################
	public static void writefile(String[] arr, String b) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(b));
		for (int i=0; i<arr.length; i++) {
			writer.write(arr[i]+" ");
			if (i<arr.length-1) {
				writer.write("\n");
			}
		}
		writer.close();
	}
	
//	#########################################################################################################################
	
	public static ArrayList<String> readfile(String a) throws IOException {
		ArrayList<String> R = new ArrayList<String>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(a));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			String outputString = "";
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
			    outputString += Character.isUpperCase(c) ? c : ""; 
			}
			R.add(outputString);
		}
		bufferedReader.close();
		return R;
	}
}
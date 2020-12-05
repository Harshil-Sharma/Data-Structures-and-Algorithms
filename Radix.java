import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Radix {

	 public static void main(String args[]) throws Exception {
		 ArrayList<String> R= new ArrayList<String>();
//		 for (String s : args)
//			 System.out.println(s);
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
		 String[] R1 = new String[R.size()];
		 for (int j=0; j<R.size(); j++) {
			 R1[j]=R.get(j);
//			 System.out.println(R1[j]);
		 }
//		 String[] R2=Arrays.toString(R1);
		 String[][] S= new String[R1.length][21];
		 
//		 for (int i=0;i< S.length; i++) 
//			 for (int j=0; j< 21; j++) 
//				 S[i][j]=" ";
		 
		 for (int i=0;i< R1.length; i++) {
			 S[i]=R1[i].split("");
		 }
		 
//		 for (int i=0;i< S.length; i++) {
//			 for (int j=0; j< S[i].length; j++) 
//				 System.out.print(S[i][j]+" ");
//			 System.out.println();
//		 }
		 
		 radixSort(R1,'A','Z');
//		 display(R1);
		 writefile(R1, b);
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
//		 for (int i=0; i<countArray.length;i++)
//			 System.out.print(countArray[i]+",");
//		 System.out.println();
		    
		 //sum up countArray;countArray will hold last index for the char at each strings index
		 for(int i=1;i<countArray.length;i++){
		     countArray[i] += countArray[i-1];
		 }
//		 for (int i=0; i<countArray.length;i++)
//			 System.out.print(countArray[i]+",");
//		 System.out.println();
		    
		 for(int i=arr.length-1;i>=0;i--){
		     int charIndex = (arr[i].length()-1 < index) ? 0 : (arr[i].charAt(index) - lower)+1;
		     tempArray[countArray[charIndex]-1] = arr[i];
		     countArray[charIndex]--;
		 }
//		 for (int i=0; i<countArray.length;i++)
//			 System.out.print(countArray[i]+",");
//		 System.out.println();
//		 for (int i=0; i<tempArray.length;i++)
//			 System.out.print(tempArray[i]+",");
//		 System.out.println();
		    
		 for(int i=0;i<tempArray.length;i++){
		     arr[i] = tempArray[i];   
		 }
//		 for (int i=0; i<arr.length;i++)
//			 System.out.print(arr[i]+",");
//		 System.out.println();
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
	    
//Yeh hi karde bc !!!!
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
	
//#########################################################################################################################

	public static void display(String[] arr) {
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
}
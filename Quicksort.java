public class Quicksort {
public static void quick(int[] arr) {
    quickAux(arr, 0, arr.length - 1);
}

public static void quickAux(int[] arr, int start, int end) {
    if (start < end) {
      int pivot = arr[end];
      int i = start;
      int j = end;
      while (i != j) {
        if (arr[i] < pivot) {
          i = i + 1;
        }
        else {
          arr[j] = arr[i];
          arr[i] = arr[j-1];
          j = j - 1;
        }
      }
      arr[j] = pivot;
      quickAux(arr, start, j-1);
      quickAux(arr, j+1, end);
    }
}

public static void printArr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "|");
    }
    System.out.println("");
}

public static void main(String[] args) {
    int a[]=new int[100];
    Random ran = new Random();
    for (int i = 0 ; i < 100; i++)
    {       
        int x = ran.nextInt(999);
        a[i] = x;
    }
    quick(a);
    printArr(a);
}
}
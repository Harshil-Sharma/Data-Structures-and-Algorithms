class MergeSort
{
// Merge arr[low..mid] and arr[mid+1..end]
void merge(int arr[], int low, int mid, int end)
{
int left = mid - low + 1; // First subarray is from middle - lowest element + 1
int right = end - mid; // Second subarray is from end - middle
/* Create temp arrays */
int Left[] = new int [left];
int Right[] = new int [right];
/*Copy data to temp arrays*/
for (int i=0; i<left; ++i)
Left[i] = arr[low + i];
for (int j=0; j<right; ++j)
Right[j] = arr[mid + 1+ j];
/* Merge temp arr[] */
int i = 0, j = 0;
int k = low;
while (i < left && j < right)
{
if (Left[i] <= Right[j])
{
arr[k] = Left[i];
i++;
}
else
{
arr[k] = Right[j];
j++;
}
k++;
}
/* Copy remaining elements of Left[] */
while (i < left)
{
arr[k] = Left[i];
i++;
k++;
}
/* Copy remaining elements of Right[] */
while (j < right)
{
arr[k] = Right[j];
j++;
k++;
}
}
// Main function that sorts arr[left..right]
void sort(int arr[], int left, int right)
{
if (left < right)
{
int mid = (left+right)/2;
// Sort two halves
sort(arr, left, mid);
sort(arr , mid+1, right);
merge(arr, left, mid, right); //Merge sorted halves
}
}
/*
* Print Array
* @param array
*/
static void print(int arr[])
{
int len = arr.length;
for (int i=0; i<len; ++i)
{ System.out.print(arr[i] + " ");}
System.out.println();
}
public static void main(String args[])
{
int arr[] = {1,9,3,5,4,7};  
System.out.print("Input:");
print(arr);
MergeSort mergeSort = new MergeSort();
mergeSort.sort(arr, 0, arr.length-1);
System.out.print("\nSorted Output:");
print(arr);
}
}
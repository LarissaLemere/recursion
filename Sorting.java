// Larissa Rose Lemere
// 09/05/16
public class Sorting {
	public static void main (String [] args){
		
		
	}
	public static void InsertionSort(String [] A){
		String key; // key is a temp var.
		for(int j=1; j<A.length; j++){ // iterate through the length of the array
			key = A[j]; // set the key to equal the current item in the array
			int i = j - 1; // set an int equal to the index of the previous value 
			while(i>=0 && A[i].compareTo(key)>0){ // compares the alphabetical value of the two (figures out which order they go in)
				// if it needs to be swapped, then they swap...
				A[i +1] = A[i]; // set the next value equal to the current
				i = i - 1; // sets index i equal to the index of the previous number
				A[i + 1] = key; // sets the current equal to the temp var
			}
		} 
	}
	public static void SelectionSort(int [] A){
		
		for(int i=0; i<A.length-1; i++){ // iterates through the array
			int min=i; // min index equals the lowest index of the numbers that haven't been checked yet
			for(int j=i+1; j<A.length; j++){ // iterates through the unsorted portion of the array
				if(A[j]<A[min]){ // if is is the lowest value in the unsorted portion....
					min=j; // ...set the min value equal to it
				}
			}
			int temp=A[i]; // set temp var equal to the first unsorted element in the array 
			A[i]=A[min]; // replace the current value in the array with the min (this makes it part of the sorted array) 
			A[min]=temp; // rewrite where the min value with the num that we were replacing it when it was moved
		}
	}

}

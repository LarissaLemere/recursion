// Larissa Rose Lemere
// 13/05/16
public class Divide {

	public static void main(String[] args) {

		// if majority returns -1, then that indicates there is no majority 
		int[] x = { };
		int low = 0;
		int high = x.length - 1;
		System.out.println(majority(x, low, high));
		
	}
	public static int sum(int[] A, int lo, int hi){
		if(lo==hi){ // if we have broken it down to a size one array
			return A[lo]; // return that value
		}
		else{ // if it is larger than a size one array
			int mid=((lo+hi)/2); // find the midpoint
			return sum(A, lo, mid) + sum(A, mid+1, hi); // return the sum of the halves
		}
	}
	public static void quickSort(int[] A, int low, int high) {
		// Source: http://www.programcreek.com/2012/11/quicksort-Aay-in-java/
		if (A == null || A.length == 0) // if the array is empty/size 0
			return; // exit (there's nothing to sort)
		if (low >= high) // if low is greater than high
			return; // this signals the end of the sort, and exits
		// to sort in all other cases...
		int middle = low + (high - low) / 2; // find the midpoint
		int pivot = A[middle]; // set the pivot equal to the value of the midpoint
		// make left < pivot and right > pivot
		int i = low, j = high; // set the low and high index vars.
		while (i <= j) { // while the index of the low is still lower than the high index
			while (A[i] < pivot) { // iterates through the lower half of the array until it reaches the pivot
				i++; // increments the low index to continue movement
			}
			while (A[j] > pivot) { // iterates through the higher half of the array until it reaches the pivot
				j--; // decrements the j index to continue movement
			}
			if (i <= j) { // if the low index is greater or equal to the high index
				int temp = A[i]; // set a temp var. equal to the low value
				A[i] = A[j]; // overwrite the low value with the higher value
				A[j] = temp; // overwrite the high value with the previous low value
				i++; // increment i to continue movement
				j--; // decrement j to continue movement
			}
		}
		// recursively sort the two sub parts
		if (low < j) // if there is still more sorting to do in the lower half
			quickSort(A, low, j); // recurse through the lower half
 
		if (high > i) // if there is still more sorting to do in the upper half
			quickSort(A, i, high); // recurse through the upper half
	}
	public static int majority(int[] A, int lo, int hi){
		
		if(lo==hi){ // if there is only one item in the array
			return A[lo]; // return its value
		}
		else{ // if there are multiple items in the array...
			int mid = (lo+hi)/2; // find the midpoint
			int M = majority(A, lo, mid); // set an int equal to the majority in the first half of the array
			int N = majority (A, mid+1, hi); // set an int equal to the majority in the second half of the array
			int count=0; // sert a counter equal to 0
			if(M==-1 && N==-1){ // if there are no majority candidates of either side...
				return-1; //... return negative 1 to indicate that there is no majority
			}
			else if (N==-1){ // if there is no majority candidate in one side, but there is in another
				for(int i=0; i<A.length; i++){ // iterate through the entire array
					if(A[i]==M){ // check to see if the current value in the array is the majority found previously
						count++; // if it is, add it to the count
					}
				}
				if(count>(A.length/2)){ // if the count is greater than half of the total numbers in the array, this indicates it is a majority...
					return M; //... and so returns a what that majority is
				}
				else{ // if it is not a majority
					return -1; // ..return -1 
				}
			}
			else if (M==-1){// if there is no majority candidate in one side, but there is in another
				for(int i=0; i<A.length; i++){// iterate through the entire array
					if(A[i]==N){// check to see if the current value in the array is the majority found previously
						count++; // if it is, add it to the count
					}
				}
				if(count>(A.length/2)){// if the count is greater than half of the total numbers in the array, this indicates it is a majority...
					return N; //... and so returns a what that majority is
				}
				else{ // if it is not a majority
					return -1;// ..return -1 to indicate that there is no majority
				}
			}
			else{ // if both sides have a candidate for a majority
				 // set a counter for both of the candidates
				int Mcount=0;
				int Ncount=0;
				for(int i=lo; i<hi; i++){ // increments through this section of the array
					if(A[i]==M){ // checks to see if its equal to on of the candidates
						Mcount++; // if so, increase the count for that candidate
					}
					else if(A[i]==N){  // if it is equal to the other candidate
						Ncount++; // increase the count for that candidate
					}
				}
				// checks to see which candidate has more items in the array
				if(Ncount>Mcount){ // if it is N that has more
					count = 0; // reset the counter to 0
					for(int i=0; i<A.length; i++){ // iterate through the entire array
						if(A[i]==N){ // if the current item is equal to the candidate
							count++; // increment the count
						}
					}
					if(count>(A.length/2)){ // if it is greater than half of the total size of the array
						return N;  // return the majority 
					}
					else{ // if it is less than half of the total size of the array
						return -1; // return -1 to indicate there is no majority
					}
				}
				else if(Ncount<Mcount){ // if it is M that has more
					count = 0;  // reset the counter to 0
					for(int i=0; i<A.length; i++){ // iterate through the entire array
						if(A[i]==M){ // if the current item is equal to the candidate
							count++; // increment the count
						}
					}
					if(count>(A.length/2)){ // if it is greater than half of the total size of the array
						return M; // return the majority 
					}
					else{ // if it is less than half of the total size of the array
						return -1; // return -1 to indicate there is no majority
					}
				}
			}
		}
		return -1; // in case all else fails, return -1 for no majority
	}

}

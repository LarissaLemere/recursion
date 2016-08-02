// Larissa Lemere
// 03/05/16
// A recursive solution for binary search
public class Search {

	public static void main(String [] args){
 // main method
	}

	public static boolean binarySearch(int [] A, int key, int lo, int hi){

		if(lo==hi){ // if the array is size one
			if(lo==key){ // see if the key we are looking for is the single element
				return true; // if it is, return true
			}
		}
		else if(lo>hi){ // if lo is greater than high...
			return false; // this indicates the whole array has been sorted and the key was not found, so return flase
		}
		else{ // otherwise, we cut the data size in half....
			int mid=(lo+hi)/2; // the midpoint equals the average of the low and the mid point
			if (A[mid] == key){ // if the midpoint equals the key
				return true; // then we can return true;
			}
			else if (A[mid] < key ){ // if the key is larger than the midpoint...
				lo = mid + 1; //..then we move the low index to the middle to cut the data set in half....
				return binarySearch(A, key, lo, hi); //... and repeat for the smaller cases until the key is found or proved to be not in the array
			}
			else{// if the key is smaller than the midpoint...
				hi = mid - 1; //..then we move the high index to the middle to cut the data set in half....
				return binarySearch(A, key, lo, hi);//... and repeat for the smaller cases until the key is found or proved to be not in the array
			}
		}
		return false; // if all fails, its not in there, return false
	}
}
// la fin

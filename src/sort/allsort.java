package sort;

public class allsort {
	
	static String ARRAY_NULL_EXP_STR = "Array is not initialized";
	
	
	/*
	 * This sorting algorithm swap any adjacent elements if
	 * they are not ordered.
	 * @param unsortedA: an unsorted array
	 * return an sorted array
	 */
	static int[] bubble_sort(int[] unsortedA) throws Exception{
		if(unsortedA == null){
			throw new Exception(ARRAY_NULL_EXP_STR);
		}
		boolean isStable = false;
		while(!isStable){
			isStable = true;
			for(int i = 0; i < unsortedA.length-1; i++){
				if(unsortedA[i] > unsortedA[i+1]){
					if(isStable){
						isStable = false;
					}
					int temp = unsortedA[i];
					unsortedA[i] = unsortedA[i+1];
					unsortedA[i+1] = temp;
				}
			}
		}
		return unsortedA;
	}
	
	/*
	 * Selection_sort initially scans an array from 0 to n
	 * to identify the minimal element i, and swap the ith element
	 * and the first element in the array. The following iteration will
	 * start by scanning from 1 to n.
	 */
	static int[] selection_sort(int[] unsortedA) throws Exception{
		if(unsortedA == null){
			throw new Exception(ARRAY_NULL_EXP_STR);
		}
		
		for(int i = 0; i < unsortedA.length-1; i++){
			
			int minValue = unsortedA[i];
			int minIndex = i;
			for(int j = i + 1; j < unsortedA.length; j++){
				if(minValue > unsortedA[j]){
					minValue = unsortedA[j];
					minIndex = j;
				}
			}
			
			if(minIndex != i){
				int temp = unsortedA[i];
				unsortedA[i] = unsortedA[minIndex];
				unsortedA[minIndex] = temp;
			}
		}
		
		return unsortedA;
	}
	
	/*
	 * Every iteration compares the ith element
	 * against all elements whose index is smaller
	 * than i. If mth element is bigger than ith element,
	 * then insert ith element at m, and shift all elments
	 * from m to 1 to the right by 1 
	 */
	static int[] insertion_sort(int[] unsortedA) throws Exception{
		if(unsortedA == null){
			throw new Exception(ARRAY_NULL_EXP_STR);
		}
		
		for(int i = 1; i < unsortedA.length; i++){
			int key = unsortedA[i];
			int j = i - 1;
			while(j >= 0 && key < unsortedA[j]){
				unsortedA[j+1] = unsortedA[j];
				j--;
			}
			unsortedA[j+1] = key;
		}
		
		return unsortedA;
	}
	
	
	/*
	 * The merge sort uses divide and conquer idea
	 * split the array into n arrays, each of which contains single element
	 * recursively merge sublist
	 */
	static int[] merge_sort(int[] unsortedA) throws Exception{
		if(unsortedA == null){
			throw new Exception(ARRAY_NULL_EXP_STR);
		}
		
		int[] sortedA = new int[unsortedA.length];
		merge_split_merge(unsortedA, 0, unsortedA.length, sortedA);
		return sortedA;
		
	}
	
	static void merge_split_merge(int[] unsortedA, int left, int right, int[] sortedA){
		if(right - left < 2){
			return;//either one element left or two elements left
		}
		
		int middle = (right + left)/2;
		merge_split_merge(unsortedA, left, middle, sortedA);
		merge_split_merge(unsortedA, middle, right, sortedA);
		merge(unsortedA, left, middle, right,sortedA);
	}
	
	// pay more attention to the border index
	static void merge(int[] unsortedA, int left, int middle, int right, int[] sortedA){
		
		int start_left_array = left;
		int start_right_array = middle;
		
		for(int i = left; i < right; i++){//iterate the sorted array for copying data
			if(start_left_array < middle && 
					(start_right_array >= right || 
							unsortedA[start_left_array] < unsortedA[start_right_array])){
				//this condition is true only when the left array is not empty
				//and the right array is empty or the element that is being scanned at
				// the left array is smaller than the element that is being scanned at 
				// the right array
				sortedA[i] = unsortedA[start_left_array];
				start_left_array++;
			}else{
				sortedA[i] = unsortedA[start_right_array];
				start_right_array++;
			}
		}
		
	}
	
	/*
	 * The quick sort also takes advantage of divide and conquer idea.
	 * Every iteration, it chooses a pivot, and sorts the array by
	 * placing all elements smaller than pivot at the head, and 
	 * all elements greater than pivot at the tail.
	 * TODO: take a look at it more than one times
	 */
	static int[] quick_sort(int[] unsortedA) throws Exception{
		if(unsortedA == null){
			throw new Exception(ARRAY_NULL_EXP_STR);
		}
		
		quick_sort_recur(unsortedA, 0, unsortedA.length - 1);
		
		return unsortedA;
	}
	
	// the recursion of quick sort
	static void quick_sort_recur(int[] unsortedA, int left, int right){
		if(left >= right){
			return;
		}
		
		int pivot_index = partition(unsortedA, left, right);
		quick_sort_recur(unsortedA, left, pivot_index - 1);
		quick_sort_recur(unsortedA, pivot_index+1, right);
	}
	
	//find a pivot, and make the array to be A p B where
	//A contains all elements smaller than p, and
	//B contains all elements equal to or greater than p
	static int partition(int[] unsortedA, int left, int right){
		int pivot_index = left;
		int pivot_value = unsortedA[pivot_index];
		
		//put the pivot to the end of the array
		unsortedA[pivot_index] = unsortedA[right];
		unsortedA[right] = pivot_value;
		
		int sorted_index = left;
		for(int i = left; i < right; i++){//pay more attention to the border index right,
			if(unsortedA[i] < pivot_value){
				//place the smaller element at the head,
				//sorted_index pointers to the next unsorted place of the head
				int temp = unsortedA[i];
				unsortedA[i] = unsortedA[sorted_index];
				unsortedA[sorted_index] = temp;
				sorted_index++;
			}
		}
		
		//place the pivot to the right place so that
		//its left are all elements smaller than it
		//its right are all elements equal to or greater than it
		unsortedA[right] = unsortedA[sorted_index];//made a mistake here, since the pivot_index is no longer pointing to pivot
		unsortedA[sorted_index] = pivot_value;
		return sorted_index;
	}
	
	static void print_array(int[] arr) throws Exception{
		if(arr == null){
			throw new Exception(ARRAY_NULL_EXP_STR);
		}
		
		String arr_content_str = "";
		for(int i = 0; i < arr.length; i++){
			arr_content_str += Integer.toString(arr[i]) + " ";
		}
		
		System.out.println("Sorted array content: " + arr_content_str);
	}
	
	
	public static void main(String args[]){
		
		int[] unsortedArray = {3,1,9,10,37,28,15,17,22,0,100,53,55,53,44};
		int[] sortedArray;
		
		//call bubble sort
		/*try {
			sortedArray = bubble_sort(unsortedArray);
			print_array(sortedArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//call selection sort
		
		try {
			sortedArray = selection_sort(unsortedArray);
			print_array(sortedArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//call insertion sort
		
		try {
			sortedArray = insertion_sort(unsortedArray);
			print_array(sortedArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//call merge sort
		
		try {
			sortedArray = merge_sort(unsortedArray);
			print_array(sortedArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//call quick sort
		
		try {
			sortedArray = quick_sort(unsortedArray);
			print_array(sortedArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

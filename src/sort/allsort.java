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
		try {
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
		}
	}

}

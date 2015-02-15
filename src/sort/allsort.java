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
		
		//call bubble sort
		try {
			int[] sortedArrary = bubble_sort(unsortedArray);
			print_array(sortedArrary);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/***************************************************************
Project name: findSubstring
Class file name: SubStringIndex.java
Created at 11:26:28 AM by chengli

Copyright (c) 2015 chengli.
All rights reserved. This program and the accompanying materials
are made available under the terms of the GNU Public License v2.0
which accompanies this distribution, and is available at
http://www.gnu.org/licenses/old-licenses/gpl-2.0.html

Contributors:
    chengli - initial API and implementation

Contact:
    To distribute or use this code requires prior specific permission.
    In this case, please contact chengli@mpi-sws.org.
 ****************************************************************/

/**
 * @author chengli
 *
 */
public class SubStringIndex {

	public static int strStr(String haystack, String needle) {
        
        int index = -1;
        if(needle.length() > haystack.length()){
            return index;
        }
        
        if(needle.equals("")){
            return 0;
        }
        
        char[] h_array = haystack.toCharArray();
        char[] n_array = needle.toCharArray();
        
        for(int i = 0; i < haystack.length(); i++){
            char c_h = h_array[i];
            char c_n = n_array[0];
            if(c_h == c_n){
                int start_index_in_haystack = i;
                int index_in_haystack = i + 1;
                int index_in_needle = 1;
                while(index_in_needle < needle.length() &&
                		index_in_haystack < haystack.length()){
                    if(n_array[index_in_needle] == h_array[index_in_haystack]){
                            index_in_needle++;
                            index_in_haystack++;
                    }else{
                        break;
                    }
                }
                if(index_in_needle == needle.length()){
                    index = start_index_in_haystack;
                    break;
                }
            }
        }
        return index;
    }
	
public static void rotate(int[] nums, int k) {
        
        
	//assume k < length of the nums
    /*if(k <= 0 && k == nums.length){
        return;
    }
    
    k = k % nums.length;
    
    for(int i = 0, j = k; i < k && j<nums.length; i++, j++){
    	int temp = nums[i];
    	nums[i] = nums[nums.length-k+i];
    	nums[nums.length-k+i] = temp;
    	
    	//if(i+1 != j) {
	    	temp = nums[j];
	    	nums[j] = nums[j-k] ;
	        nums[j-k] = temp;
    	//}
    }*/
	
    if(k <= 0 && k == nums.length){
        return;
    }
    
    k = k % nums.length;
    int[] new_a = new int[nums.length];
    
    for(int i = 0; i < k ; i++){
        new_a[nums.length-k+i] = nums[i];
    }
    
    for(int  j = k; j<nums.length; j++){
        new_a[j-k] = nums[j];
    }
    
    nums = new_a;
    
    for(int i = 0; i <nums.length; i++){
        System.out.println(nums[i] + " ");
    }
        
    }

public static void rotate_no_extra_space(int[] nums, int k) {
    
	if(k <= 0 && k == nums.length){
        return;
    }
    
    k = k % nums.length;
	
    rotate_no_extra_space_rec(nums, 0, nums.length-k);
    for(int i = 0; i <nums.length; i++){
        System.out.println(nums[i] + " ");
    }
    }

public static void rotate_no_extra_space_rec(int[] nums, int left_start, int right_start) {
	
        int count1 = right_start - left_start;
        int count2 = nums.length - right_start;
        
        if(count1 == count2) {
        	for(int i = left_start, j = right_start; j<nums.length; i++,j++) {
        		int temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        	}
        	return;
        }
        
        if(count1 > count2) {
        	for(int i = left_start, j = right_start; j<nums.length; i++,j++) {
        		int temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        	}
        	left_start = left_start + count2;
        }
        
        if(count1 < count2) {
        	for(int i = left_start, j = right_start; i<right_start; i++,j++) {
        		int temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        	}
        	left_start = right_start;
        	right_start = right_start + (count2 - count1);
        }
        rotate_no_extra_space_rec(nums, left_start, right_start);
    }

    public static void main(String[] args) {
    	//System.out.println(strStr("mississippi", "issip"));
    	//int[] a = {1,2,3,4,5,6};
    	//rotate_no_extra_space(a, 2);
    	int[] a = {1};
    	rotate_no_extra_space(a,0);
    }
}

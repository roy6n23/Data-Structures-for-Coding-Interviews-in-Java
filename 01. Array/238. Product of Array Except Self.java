//跟标准答案一模一样 我有点飘了哈哈哈哈哈哈
//time n， space n
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int [nums.length];
        int[] output = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;
        for(int i = 1; i < left.length; i++){
        	left[i] = nums[i-1]*left[i-1];
        }
        for(int i = right.length-1; i >=0; i--){
        	right[i] = nums[i+1]*right[i+1];
        }       
        for(int i = 0; i <= nums.length-1; i++){
        	output[i] = left[i] * right[i]; 		
        }

        return output;
    }
}


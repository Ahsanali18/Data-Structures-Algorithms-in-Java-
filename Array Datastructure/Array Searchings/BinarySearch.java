package SearchingAlgorithms;

public class BinarySearch{
    public static void main(String[] args){
        int[] numbers={-18,-14,-10,2,4,7,8,12,15,17,19,23};
        int target=19;
        int ans=search(numbers,target);
        System.out.println("Ans: "+ans);
    }
    public static int search(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            // find the middle element
            int mid= start+(end-start)/2;
            if(target<nums[mid]){
                end=mid-1;
            }else if(target>nums[mid]){
                start=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}

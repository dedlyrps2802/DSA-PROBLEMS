class Solution {
    public int search(int[] nums, int target) {
      int ans = BinarySearch(nums,target,0,nums.length-1);
      return ans;
    }

    public int BinarySearch(int[] arr , int key , int start, int end){
        if(end>=start){
            int mid = end - (end - start)/2;
          
          if(arr[mid]==key){
            return mid;
          }
          else if(arr[mid] < key){
            return BinarySearch(arr,key,mid+1,end);

          }
          else{
            return BinarySearch(arr,key,start,mid-1);
          }
        
        }
        return -1;

    }
}
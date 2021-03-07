class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>((n1,n2)->n1-n2);
        for (int n:nums) {
            heap.add(n);
            if (heap.size()>k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}

//quickSelect

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //shuffle the array
        Random rdm=new Random();
        for (int i=1; i<nums.length;i++) {
           int r=rdm.nextInt(i+1);
            swap(i,r,nums);
        }
        k=nums.length-k;
        int lo=0;
        int hi=nums.length-1;
        while (lo<hi) {
            int j=partition(lo,hi,nums);
            if (j<k) {
                lo=j+1;
            } else if (j>k) {
                hi = j-1;
            } else {
                break;
            }
        }
        //quickSelect(0,nums.length-1,k,nums);
        return nums[k];
    }
    public static void quickSelect(int left, int right, int kth_largest, int[] nums) {
        if (left==right) return;
        
        int pivot = partition(left,right,nums);
        
        if (kth_largest==pivot) {
            return;
        } else if (kth_largest>pivot) {
            quickSelect(pivot+1,right,kth_largest,nums);
        } else {
            quickSelect(left,pivot-1,kth_largest,nums);
        }
    }
    public static int partition(int left, int right, int[] nums) {
        int pivot = nums[right];
        int j=left;
        
        for (int i=left;i<right;i++) {
            if (nums[i]<=pivot) {
                swap(j,i,nums);
                j++;
            }
        }
        swap(j,right,nums);
        return j;
    }
    public static void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}

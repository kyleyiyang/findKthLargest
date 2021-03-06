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

package MedianOfSortedArrays;

public class Main {

    /**
     *
     * @param nums1 = integer array
     * @param nums2 = integer array
     * @return midNum = a double value calculated by finding the median number of the two input integer arrays
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double midNum = 0.0;

        //check if either array is invalid
        //if one is find the median of the valid input array
        if(nums1 == null){
            int n = nums2.length;
            return (((double)nums2[(n-1)]/2)*0.5 + ((double)nums2[(n)]/2)*0.5);
        }
        if(nums2 == null){
            int n = nums1.length;
            return nums1[(n - 1) / 2] * 0.5 + nums1[n / 2] * 0.5;
        }

        //if both arrays are valid check which array is larger
        //if nums1 is larger than nums2 switch them and rerun the algorithm
        if(nums1.length > nums2.length){
            return  findMedianSortedArrays(nums2, nums1);
        }

        int length1 = nums1.length; // array one length
        int length2 = nums2.length; //array two length
        int left = 0; //the far left index starting position
        int right = length1; //the right index starting position

        while(left < right){
            int i = (left + right) / 2;
            int j = (length1 + length2) / 2 - i;

            if(nums1[i] < nums2[j - 1]){
                left = i + 1;
            }else{
                right = i;
            }
        }

        int first = left;
        int second = (length1 + length2) / 2 - left;

        int shorterLeft = first == 0 ? Integer.MIN_VALUE : nums1[first - 1];
        int shorterRight = first == length1 ? Integer.MAX_VALUE : nums1[first];

        int longerLeft = second == 0 ? Integer.MIN_VALUE : nums2[second - 1];
        int longerRight = second == length2 ? Integer.MAX_VALUE : nums2[second];

        if((length1 + length2) % 2 == 1) {
            return Math.min(shorterRight, longerRight);
        }else{
            return Math.max(shorterLeft, longerLeft) * 0.5 + Math.min(shorterRight, longerRight) * 0.5;
        }

    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,8,9};
        int[] nums2 = {4,5,6,7,8,9,10};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}

public class Main {
    public static void main(String[] args) {
        //Sorting. Let's implement linear and binary search on arrays.
        int[] array = new int[] {3,4,5,6,6,7,10,11,14,14,15,17,17,18,19};
        int target = 14;


        bubbleSort(array);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(",");
        }
        System.out.println();

        System.out.println("Linear search: " + linearSearch(target, array));


        System.out.println("Binary search: " + binarySearch(target, 0, array.length - 1, array));





    }

    /**
     * This algorithm find the first instance of the target in the array, and returns the
     * index of that element. Or, returns -1 is element not found
     * @param target
     * @param array
     * @return
     */
    public static int linearSearch(int target, int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This recursively searches an array for the presence of the target integer. If found, the index is returned.
     * If not found in the array, -1 is returned. This does not guarantee to find the first instance of the
     * target element.
     * @param target the integer we are searching for
     * @param begin the beginning of the array
     * @param end the index of the last element in the array (N-1)
     * @param array The array to be searched
     * @return the index of the element, or -1 if not found
     */
    //when programming a recursive method, the first step is top consider the base case,
    // usually when you have the answer, or can;t get it. Basically, you have recursed as far as you can.
    public static int binarySearch(int target, int begin, int end, int[] array) {
        //find a midpoint based on length,
        //compare target number. If == we found it
        //if t < e we need to repeat the process on the left sub array
        //if t > e we need to repeat the process on the right sub-array

        //base case, we are done.
        if(begin > end) {
            return -1;
        }

        //finding the midpoint
        int midpoint = begin + ((end - begin) / 2);


        if(target <= array[midpoint]) {
            return binarySearch(target, begin, midpoint - 1, array);
        } else if(target > array[midpoint]) {
            return binarySearch(target, midpoint + 1, end, array);
        }

        return midpoint;
    }

    public static void bubbleSort(int[] array) {
        int temp;
        boolean finished = false;
        //need a loop to keep looping until the array is sorted.
        //need an inner loop that is traversing the array from beginning to end doing the swaps on the moving window
        //once we have completed one iteration of the inner loop without any swaps, we know we are done
        while(!finished) {
            finished = true;
            for(int i = 1; i < array.length; i++) {
                if(array[i-1] > array[i]) {
                    temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                    finished = false;
                }
            }
        }
    }

}

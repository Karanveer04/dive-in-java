import java.util.HashMap;

public class Socks {

/*

    Problem: There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

    
    Simple Approach: Sort the given array so that all the equal elements are adjacent to each other.
    Now, traverse the array and for every element if it equal to the element next to it then it is a valid pair and skip these two elements.
    Else the current element doesn’t make a valid pair with any other element and hence only skip the current element.


    Efficient Approach
        1) Create an empty hash table (unordered_map in C++, HashMap in Java, Dictionary in Python)
        2) Store frequencies of all elements.
        3) Traverse through the hash table. For every element, find its frequency. Increment the result by frequency+1 for every element
*/

    public static int sock(int[] arr){
        HashMap<Integer,Integer> frequency = new HashMap<Integer, Integer>();
        int result = 0;

        // Init Hashmap
        for(int i = 0; i < arr.length; i++){
            if(frequency.containsKey(arr[i])){      // If sock already exists, add +1 to frequency
                frequency.put(arr[i], frequency.get(arr[i])+1);
            } else {
                frequency.put(arr[i],1);            // Adds the socks and its frequency
            }
        }

        for(HashMap.Entry<Integer,Integer> item: frequency.entrySet()){ //entry set returns set view of entire map
            if (item.getValue() > 1){
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int [] arr = new int[]{1, 3, 2, 4, 1, 1, 2};
        System.out.println("Found Pairs: "+ sock(arr));
    }

}

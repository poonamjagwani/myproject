package examples;

public class Binarysearch {
    
    //Time Complexity O(logn)
    public static int searchFirstOccurrence(int a[], int target) {
        int low = 0;
        int high = a.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (high + low) / 2;

            if(target == a[mid]) {
                result = mid;
                high = mid - 1;
            }
            else if(target > a[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;

    }

    //Time Complexity O(logn)
    public static int searchLastOccurrence(int a[], int target) {
        int low = 0;
        int high = a.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if(target == a[mid]) {
                result = mid;
                low = mid + 1;
            } else if(target > a[mid]) {
                low = mid +1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    //Time Complexity O(logn)
    public static int countOccurrence(int a[], int target) {
        return searchLastOccurrence(a, target) - searchFirstOccurrence(a,target) + 1;
    }


    public static void main(String[] args) {
       
        int b[] = {2,2,2,2,2,2,4,4,4,4,10,10,10,18,18,20,20,20,20,20};

        System.out.println("First occurrence of 10: " + Binarysearch.searchFirstOccurrence(b, 10));
        System.out.println("Last occurrence of 10: " + Binarysearch.searchLastOccurrence(b, 10));
        System.out.println("Count total occurrences of 10: " + Binarysearch.countOccurrence(b, 10));

        System.out.println("First occurrence of 2: " + Binarysearch.searchFirstOccurrence(b, 2));
        System.out.println("Last occurrence of 2: " + Binarysearch.searchLastOccurrence(b, 2));
        System.out.println("Count total occurrences of 2: " + Binarysearch.countOccurrence(b, 2));
    }
}

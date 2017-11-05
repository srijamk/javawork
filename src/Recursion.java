
import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class Recursion {
    public static int strlength (String str) {
        if (str.length() == 0) {
            return 0;
        } else {
            return 1 + strlength(str.substring(1));
        }
    }
    
    public static int bunnyEars2 (int num) {
        if (num == 0) {
            return 0;
        } else {
            if (num % 2 == 0) {
                return 3 + bunnyEars2(num - 1);
            } else {
                return 2 + bunnyEars2(num - 1);
            }
        }
    }
    
    public static int triangle (int num) {
        if (num == 0) {
            return 0;
        } else {
            return num + triangle(num - 1);
        }
    }
    
    public static boolean contains(String str, String sub) {
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(0, sub.length()).equals(sub)) {
                return true;
            }
        }
        return false;
    }
    
    public static int strDist(String str, String sub) {
        System.out.println(str);
        if (str.indexOf(sub) == -1) {
            return 0;
        } else {
            if (str.substring(0, sub.length()).equals(sub) && str.substring(str.length() - sub.length()).equals(sub)) {
                return str.length();
            } else if (str.substring(0, sub.length()).equals(sub) && !(str.substring(str.length() - sub.length()).equals(sub))) {
                return strDist(str.substring(0, str.length() - 1), sub);
            } else if (!(str.substring(0, sub.length()).equals(sub)) && str.substring(str.length() - sub.length()).equals(sub)) {
                return strDist(str.substring(1, str.length()), sub);
            } else {
                return strDist(str.substring(1, str.length() - 1), sub);
            }
        }
    }
    
    public static boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return false;
        } else {
            for (start = start; start < nums.length; start++) {
                int count = nums[start];
                System.out.println(count);
                if (count < target) {
                    return groupSum(start + 1, nums, target);
                }
                if (count == target) {
                    return true;
                } else {
                    target -= count;
                }
            }
            return false;
        }
    }
    public static int instances(int start, int [] nums) {
        int count = 0;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == 6) {
                count++;
            }
        }
        return count;
    }
    
    public static boolean groupSum6(int start, int[] nums, int target) {
        System.out.println(target);
        if (start >= nums.length) {
            return target == 0;
        }
        if (groupSum6(start + 1, nums, target - nums[start] - instances(start + 1, nums))) {
            return true;
        }
        if (groupSum6(start + 1, nums, target)) {
            return true;
        }
        return false;
    }
    
    public static String reverse (String str) {
        if (str.length() == 0) {
            return "";
        } else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }
    
    public static boolean isPalindrome (String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        } else {
            return (str.charAt(0) == str.charAt(str.length() - 1)) && isPalindrome(str.substring(1, str.length() - 1));
        }
    }
    
    public static void main (String [] args) {
        System.out.println(isPalindrome("kayak"));
    }
}


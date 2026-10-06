public class Solution {
    public int largestRectangleArea(int[] arr) {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        Stack<Integer> a = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            while (!a.isEmpty() && arr[a.peek()] >= arr[i]) {
                a.pop(); 
            }

            if (a.isEmpty()) { 
                nsl[i] = -1;
            } else {
                nsl[i] = a.peek(); 
            }
            a.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            int currentArea = arr[i] * (nsr[i] - nsl[i] - 1);
            maxArea = Math.max(maxArea, currentArea);
        }

        return maxArea;
    }
}
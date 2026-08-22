class Solution {
    public int largestRectangleArea(int[] h) {
        int n=h.length,maxa=0;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && h[s.peek()]>=h[i]){
                int cur=h[s.pop()]*(s.isEmpty()?i:i-s.peek()-1);
                maxa=Math.max(maxa,cur);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int a=h[s.pop()]*(s.isEmpty()?n:n-1-s.peek());
            maxa=Math.max(maxa,a);
        }
        return maxa;
    }
}
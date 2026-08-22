class Trie{
    String word;
    Trie chars[]=new Trie[26];
}
class Solution {
    int diff[]={0,1,0,-1,0};

    void dfs(int R, int C, int r, int c, char b[][],Trie t, List<String> ans,boolean[][] vis){
        int chidx=b[r][c]-'a';
        if(t.chars[chidx]==null) return;
        Trie cur=t.chars[chidx];
        if(cur.word!=null){
            ans.add(cur.word); cur.word=null;
        }
        vis[r][c]=true;
        for(int i=0;i<4;i++){
        int  ar=r+diff[i], ac=c+diff[i+1];
        if(ar>=0 && ar<R && ac>=0 && ac<C && !vis[ar][ac]){
            dfs(R,C,ar,ac,b,cur,ans,vis);
        }
    }
    vis[r][c]=false;
    }
    void buildTrie(Trie p,String word, int idx){
        int chidx=word.charAt(idx)-'a';

        if(p.chars[chidx]==null){
            p.chars[chidx]=new Trie();
        }
        Trie curr=p.chars[chidx];
        if(idx==word.length()-1){
         curr.word=word; return;
        }
        buildTrie(curr,word,idx+1);
    }
    public List<String> findWords(char[][] b, String[] words) {
        Trie root=new Trie();
        for(String word:words){
            buildTrie(root,word,0);
        }
        List<String> ans=new ArrayList<>();
        int R=b.length, C=b[0].length;
        boolean vis[][] = new boolean[R][C];
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                dfs(R,C,r,c,b,root,ans,vis);
            }
        }
        return ans;
    }
}
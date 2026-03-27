package hard;

import java.util.*;

/**
 * Word Ladder II
 * <a href="https://leetcode.com/problems/word-ladder-ii/description/">...</a>
 */
public class WordLadderII {
    private static Map<String,ArrayList<Integer>> charLoopUp = new HashMap<>();
    private static boolean[][] visited;
    private static boolean[][] edges;
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int targetWordLength = endWord.length();
        List<String> filtered = new ArrayList<>(wordList.stream().filter(word -> word.length() == targetWordLength).toList());
        filtered.add(beginWord);

        edges = new boolean[filtered.size()][filtered.size()];
        visited = new boolean[filtered.size()][filtered.size()];
        for(int charIndex=0; charIndex<targetWordLength; charIndex++){
            for(int wordIndex=0; wordIndex<filtered.size(); wordIndex++){
                char currentChar = filtered.get(wordIndex).charAt(charIndex);
                String lookUpKey = currentChar + String.valueOf(charIndex);
                if(!charLoopUp.containsKey(lookUpKey)){
                    charLoopUp.put(lookUpKey, new ArrayList<>());
                }
                charLoopUp.get(lookUpKey).add(wordIndex);
            }
        }
        for(int currentWordIndex=0; currentWordIndex<wordList.size(); currentWordIndex++){
            int[] hitCount = new int[filtered.size()];
            for(int currCharIndex=0; currCharIndex<targetWordLength; currCharIndex++){
                char currentChar = filtered.get(currentWordIndex).charAt(currCharIndex);
                String lookUpKey = currentChar + String.valueOf(currCharIndex);
                ArrayList<Integer> matches = charLoopUp.get(lookUpKey);
                for(int matchIndex : matches){
                    hitCount[matchIndex]++;
                }
            }
            for(int hitCountIndex=0;hitCountIndex<filtered.size();hitCountIndex++){
                if(hitCount[hitCountIndex] == targetWordLength-1)
                    edges[currentWordIndex][hitCountIndex] =true;
            }
        }
        int startWordIndex = filtered.size()-1;
        int endWordIndex = filtered.indexOf(endWord);

        return null;
    }
    public static void BFS(int startWordIndex, int endWordIndex){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startWordIndex,0));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int currentWordIndex = pair.wordIndex;
            int depth = pair.depth;
            for(int nextWordIndex = 0; nextWordIndex<edges.length;nextWordIndex++){
                if(edges[currentWordIndex][nextWordIndex] && !visited[currentWordIndex][nextWordIndex]){
                    queue.add(new Pair(nextWordIndex,depth+1));
                    visited[currentWordIndex][nextWordIndex] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(findLadders("hit", "cog", List.of("hot","dot","dog","lot","log","cog")));
    }
    public static class Pair{
        int wordIndex,depth;

        public Pair(int wordIndex, int depth) {
            this.wordIndex = wordIndex;
            this.depth = depth;
        }
    }

}

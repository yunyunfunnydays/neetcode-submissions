class Solution {
    public String foreignDictionary(String[] words) {
        if (words == null || words.length == 0) return "";

        Map<Character, Set<Character>> adjList = new HashMap<>();
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (inDegree[c - 'a'] == -1) inDegree[c - 'a'] = 0;
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";

            int minLen = Math.min(w1.length(), w2.length());
            for (int j = 0; j < minLen; j++) {
                char parent = w1.charAt(j);
                char child = w2.charAt(j);
                if (parent != child) {
                    if (adjList.computeIfAbsent(parent, k -> new HashSet<>()).add(child)){
                        inDegree[child - 'a']++;
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        int totalChars = 0;
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != -1) totalChars++;
            if (inDegree[i] == 0) queue.offer((char) (i + 'a'));
            System.out.println((char) (i + 'a') +" = " + inDegree[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            System.out.println(" curr = " + curr);

            adjList.getOrDefault(curr, Collections.emptySet()).forEach(c -> {
                if (--inDegree[c - 'a'] == 0) {
                    queue.offer(c);
                }
                System.out.println( c + " = " + inDegree[c - 'a']);
            });

        }

        return sb.length() == totalChars ? sb.toString() : "";
    }
}

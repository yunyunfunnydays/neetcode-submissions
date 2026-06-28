class Solution {

    public String encode(List<String> strs) {
        //build an encoded string
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        //build a decoded string list
        List<String> res = new ArrayList<>();

        //decode
        //find prefix number by finding index before '#'
        int i = 0;
        while ( i < str.length()) {
            int j = i;
            //find the first '#', and get the range of prefix
            while ( str.charAt(j) != '#') {
                j++;
            }
            //get the substring of prefix
            int prefix = Integer.parseInt(str.substring(i, j));
          
            //get the substing of encode string 
            int start = j + 1;
            int end = start + prefix;
            res.add(str.substring(start, end));

            i = end;
        }

        return res;

    }
}

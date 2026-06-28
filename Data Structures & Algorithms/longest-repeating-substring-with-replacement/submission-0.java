class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // 用來記錄 A-Z 的出現次數
        int maxCount = 0; // 當前窗口內出現最多次的字元數量
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // 1. 將右邊字元加入窗口，並更新計數
            char currentChar = s.charAt(right);
            count[currentChar - 'A']++;
            
            // 2. 更新當前窗口內的「霸主」頻率
            // 注意：這裡其實不需要每次都重新找最大值，只需要跟新加入的字元比較即可
            maxCount = Math.max(maxCount, count[currentChar - 'A']);

            // 3. 檢查窗口是否合法
            // 窗口長度 - 霸主頻率 > k 代表替換 k 次也不夠，需要縮小窗口
            if ((right - left + 1) - maxCount > k) {
                // 移出左邊字元
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }

            // 4. 更新最大長度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
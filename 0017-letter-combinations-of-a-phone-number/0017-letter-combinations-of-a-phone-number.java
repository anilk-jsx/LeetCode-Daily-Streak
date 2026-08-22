class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result  = new ArrayList<String>();

        int n = digits.length();
        if(n == 0) return result;

        result.add("");

        String[] digitsToLetters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for(char digit : digits.toCharArray()){
            String letters = digitsToLetters[Character.getNumericValue(digit) - 2];
            List<String> temp = new ArrayList<>();
            for(String existing : result){
                for(char letter : letters.toCharArray()){
                    temp.add(existing + letter);
                }
            }
            result = temp;
        }
        return result;      
    }
}
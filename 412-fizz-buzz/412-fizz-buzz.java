class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> sol = new ArrayList<>();
        for (int i = 1 ; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sol.add("FizzBuzz");
            } else if (i % 3 == 0) {
                sol.add("Fizz");
            } else if (i % 5 == 0) {
                sol.add("Buzz");
            } else {
                sol.add(Integer.toString(i));
            }
        }
        return sol;
    }
}
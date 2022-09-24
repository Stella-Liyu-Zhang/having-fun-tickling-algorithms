20. Valid Parentheses
    This problem is relatively simple

- build a stack
- turn the String into an array of characters using toCharArray()
- Since a pair of parentheses is (), whenever we see a left one, we push the right one into the stack
- After pushing each corresponding parentheses paired to the one came across,
  - check if the stack is empty or if the top ones doesn't match

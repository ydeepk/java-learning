package interviewRound;

/*
*
* Problem Statement
* Title: Magnetic Group Formation
* Difficulty: Medium (Incedo Round 2)
* Description
* You are given a collection of magnets, each with a specific strength
* represented as an integer in an array arrayA.
* Additionally, you are given a target differenceValue.
*
* Magnets can be grouped together if the absolute difference between
* their strengths matches the differenceValue.
*
* Your task is to identify how many such unique pairs (groups) can be formed.
* If the number of groups identified is 4 or more, the function must return 4.
*
* Otherwise, it should return the actual count of groups found.
* Input:
* int differenceValue:
* The required difference between two magnet strengths to form a group.
* int[] arrayA: An array of integers representing the strengths of various magnets.
* Output:An int representing the number of groups found, capped at a maximum of 4.
* Example:
* Input: differenceValue = 2, arrayA = {1, 3, 5, 7, 10}
* Analysis:
* Pair 1: (1, 3) (rightarrow ) Difference = 2
* Pair 2: (3, 5) (rightarrow ) Difference = 2
* Pair 3: (5, 7) (rightarrow ) Difference = 2
*
* Count: 3 groups. Since 3 < 4, the output is 3.
* */
public class IncedoScreeningRound1 {

}

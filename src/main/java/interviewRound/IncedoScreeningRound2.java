package interviewRound;

/*
 * Problem Statement Title:
 * Library Section Availability MonitorDifficulty:
 * Easy/Medium
 * Description
 * You are managing a library with (n) storage sections.
 * Each section is represented as a row in an (ntimes n) matrix.
 * Every cell in this matrix indicates the current status of a book:
 * 1: The book is Available.0
 * : The book is Checked Out.
 * 2: The book is Returning/Reserved (could be available soon).
 * For the purpose of identifying the "Top Sections," books with status 1 and 2
 * are both counted as "available."
 *
 * Your Task Write a function that calculates the total number of available books in each section (row).
 * The function must return a 1D integer array of size (n),
 * where: An index is marked 1 if that section contains the maximum number of available books found across
 * all sections.An index is marked 0 otherwise.
 * Input: int n: The number of rows and columns in the matrix.int[][] grid: An (ntimes n) matrix representing book statuses.
 * Output: An int[] of size (n) consisting only of 1s and 0s.
 *
 * Example:
 * Input: n = 3, grid = {{1, 2, 0}, {1, 1, 0}, {0, 1, 1}}
 * Analysis:
 * Row 0: {1, 2, 0} (rightarrow ) Count = 2
 * Row 1: {1, 1, 0} (rightarrow ) Count = 2
 * Row 2: {0, 1, 1} (rightarrow ) Count = 2
 *
 * Maximum Count: 2. All rows have 2, so the output is {1, 1, 1}.
 * */

public class IncedoScreeningRound2 {


}

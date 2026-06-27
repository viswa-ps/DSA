package dsa.tuf.arrays.medium;

public class PascalsTriangle1 {
    //TODO : Given two integers r and c, return the value at the rth row and cth column (1-indexed) in a Pascal's Triangle.
    // In Pascal's triangle:
    // The first row contains a single element 1.
    // Each row has one more element than the previous row.
    // Every row starts and ends with 1.
    // For all interior elements (i.e., not at the ends),
    // the value at position (r, c) is computed as the sum of the two elements directly above it from the previous row:
    // Pascal[r][c]=Pascal[r−1][c−1]+Pascal[r−1][c]
    // where indexing is 1-based
    // Example
    // Input: r = 5, c = 3
    // Output: 6
    // Explanation:
    // The Pascal's Triangle is as follows:
    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1
    // 1 4 6 4 1
    // ....
    // Thus, value at row 5 and column 3 = 6
    public static void main(String[] args) {
        System.out.println(pascalTriangleI(4, 2));
        System.out.println(pascalTriangleI(5, 3));

    }

    //NOTE: We can optimize this by calculating the value of the element
    // directly using the formula for combinations (nCr) and avoiding the generation of the entire triangle.
    // The element in the rth row and cth column will be r-1Cc-1.
    // The formula for combinations (nCr) is given by:
    // nCr = n! / (r! * (n-r)!), where n! denotes the factorial of n.
    // We have the following properties of combinations: nCr = nCn-r
    // As we are iterating for r number of times, we can choose
    // the smaller value between r and (n-r) to minimize the number of iterations.
    // This will help in optimizing the calculation.
    public static int pascalTriangleI(int r, int c) {
        return nCr(r - 1, c - 1);
    }

    //NOTE: Optimal Approach
    // Complexity Analysis
    // Time Complexity: O(C)
    // Space Complexity: O(1)
    private static int nCr(int n, int r){
        if (r > n - r) r = n-r;
        if (r == 1){
            return n;
        }
        int result = 1;
        for (int i = 0; i < r; i++){
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}

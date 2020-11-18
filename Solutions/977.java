// 思路1：先计算平方，再排序 时间复杂度O(nlogn)，空间复杂度O(1)
class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
// 思路2：利用双指针方法避免直接排序 时间复杂度O(n)，空间复杂度度O(n)
class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            A[i] = A[i] * A[i];
        }
        int[] a = new int[n];
        int idx = n - 1;
        int i = 0, j = n - 1;
        while (i <= j) {
            if (A[i] > A[j]) {
                a[idx--] = A[i];
                i++;
            } else {
                a[idx--] = A[j];
                j--;
            }
        }
        return a;
    }
}

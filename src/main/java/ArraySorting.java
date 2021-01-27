import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {
		int[] A = { -19,1,2,3,4,5};
		System.out.println(Arrays.toString(getSortedArray(A)));
	}

	public static int[] getSortedArray(int[] A) {
		int[] result = new int[A.length];

		int leftMost = 0;
		int rightMost = A.length - 1;
		int index = A.length - 1;

		while (leftMost <= rightMost) {
			int low = A[leftMost] * A[leftMost];
			int high = A[rightMost] * A[rightMost];

			if (low > high) {
				result[index--] = low;
				leftMost++;
			} else {
				result[index--] = high;
				rightMost--;
			}
		}
		return result;
	}

}

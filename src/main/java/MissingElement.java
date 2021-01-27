
public class MissingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 1,1,2,3,5,5,7,9,9 };
		printMissingElement(arr);

	}

	public static void printMissingElement(int[] arr) {
		if (arr == null)
			return;

		int[] boolArr = new int[20];
		for (int val : arr) {
			boolArr[val] = 1; // initialze with 1
		}

		for (int i = 1; i < arr.length; i++) {
			// if boolArr is not having that value print it
			if (boolArr[i] == 0) {
				System.out.println(i);
			}

		}
	}

}

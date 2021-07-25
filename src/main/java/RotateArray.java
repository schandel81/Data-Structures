

public class RotateArray {
    public static void main(String args[]) {
        int[] inputArray = new int[]{1, 2, 3, 4, 5};
        int rotateCount = 2;
        int i = rotateCount;
        int j = inputArray.length - 1;
        while (i < j) {
            int temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;
            i++;
            j--;
        }
        i = 0;
        j = rotateCount - 1;
        while (i < j) {
            int temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;
            i++;
            j--;
        }

        i = 0;
        j = inputArray.length - 1;
        while (i < rotateCount && j >= 0) {
            int temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;
            i++;
            j--;
        }
        for (int x : inputArray)
            System.out.print(" " + x);
    }
}



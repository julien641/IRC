public class Main {

    public static void main(String[] args) {
        System.out.println(sumOdd(10,5));
    }

    public static boolean isOdd(int num) {
        if (num > 0) {
            return num % 2 != 0;
        }
        return false;
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;
        if (end >= start && start > 0 && end > 0) {
            for (int i = start; i <= end; i++) {
                if (isOdd(i)) {
                    sum+=i;
                }
            }
        }
        else{
            return -1;
        }
        return sum;
    }
}
import java.util.Scanner;

public class Learning {

    static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int temp = 0;

        int a = in.nextInt();
        int b = in.nextInt();

        System.out.println(sumMultiply(a, b));
        System.out.println(bitsMultiply(a, b));
        System.out.println(mathMultiply(a, b));
        System.out.println(recurseMultiply(a, b));
    }

    private static int sumMultiply(int a, int b){
        int result = 0;
        boolean negative = false;
        if(b < 0){
            b = -b;
            negative = true;
        }

        for (int i = 0; i < b; i++) {
            result += a;
        }

        return  negative? -result : result;
    }

    private static int bitsMultiply(int a, int b){
        int result = 0;

        while (b > 0){
            if((b & 1) !=0){
                result += a;
            }
            a <<= 1;
            b >>= 1;
        }

        return result;
    }

    private static int recurseMultiply(int a, int b){
        if(b == 0) return  0;
        if(b > 0) return a += recurseMultiply(a, b -1);
        return recurseMultiply(-a, -b);
    }

    private static int mathMultiply(int a, int b){
        return Math.multiplyExact(a, b);
    }
}
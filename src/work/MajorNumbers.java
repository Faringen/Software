package work;

public class MajorNumbers {
    static void main(String[] args) {
        int[] massive = new int[] {2,1,1,3,4,2,1,2,2};
        System.out.println(majorNums(massive));
        System.out.println(massive.length / 2 );
    }

    static int majorNums(int[] massive){
        int count =0;
        int temp = massive[0];

        for (int num : massive) {
            if(count == 0) temp = num;

            if (num == temp) count++;
            else count--;

        }

        int actualCount = 0;
        for (int num : massive){
            if(num == temp) actualCount++;
        }

        if( actualCount > massive.length / 2) return temp;


        return -1;
    }
}

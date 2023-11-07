import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters {
    public static int eliminateMaximum(int[] dist, int[] speed) {
        final int n = dist.length;
        int[] arrivalTime = new int[n];

        for (int i = 0; i < n; ++i) {
            arrivalTime[i] = (dist[i] - 1) / speed[i];
        }
        Arrays.sort(arrivalTime);

        for (int i = 0; i < n; ++i) {
            if (i > arrivalTime[i]) {
                return i;
            }    
        }   
        return n;
    }
    public static void main(String[] args) {
        int[] dist = {1,3,4};
        int[] speed = {1,1,1};
        System.out.println("Eliminate Maximum Number of Monsters: "+eliminateMaximum(dist, speed));
    }
}
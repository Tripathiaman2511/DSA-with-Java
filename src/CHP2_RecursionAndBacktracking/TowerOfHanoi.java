package CHP2_RecursionAndBacktracking;
// objective is to move the entire stack to another rod
// rules:
// one disk at a time
// move consist of taking one disk from rode and sliding it into the another rode, on top of the disk which may
// already present
// no disk may be placed on top the small disk
public class TowerOfHanoi {
    public void towerOfHanoi(int n,char frompeg,char topeg,char auxpeg){
        if (n == 1) {
            System.out.println("Move disk"+n+" from peg "+frompeg+" to peg "+topeg);
            return;
        }
        towerOfHanoi(n-1,frompeg,auxpeg,topeg);
        System.out.println("Move disk "+n+" from peg"+frompeg+" to peg "+auxpeg);
        towerOfHanoi(n-1,auxpeg,topeg,frompeg);

    }

    public static void main(String[] args) {
        TowerOfHanoi tof=new TowerOfHanoi();
        tof.towerOfHanoi(3,'A','B','C');
    }
}

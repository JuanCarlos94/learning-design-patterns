package adapter;

import adapter.adapters.SquarePegAdapter;
import adapter.round.RoundPeg;
import adapter.round.RoundRole;
import adapter.square.SquarePeg;

public class Demo {

    public static void main(String[] args) {
        // Round fits round, no surprise
        RoundRole hole = new RoundRole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if(hole.fits(rpeg)){
            System.out.println("Round peg r5 fits round hole r5");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Won't compile

        // Adapter solves the problem
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if(hole.fits(smallSqPegAdapter)){
            System.out.println("Square peg w2 fits round hole r5.");
        } else {
            System.out.println("Square peg w20 does not fit into round role r5");
        }
    }
}

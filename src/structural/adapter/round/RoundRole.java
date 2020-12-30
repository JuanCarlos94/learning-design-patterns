package structural.adapter.round;

public class RoundRole {
    private double radius;

    public RoundRole(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public boolean fits(RoundPeg peg){
        boolean result;
        result = (this.getRadius() >= peg.getRadius());
        return result;
    }

}

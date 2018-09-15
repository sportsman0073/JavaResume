public class Icosahedron extends Polyhedron{
    public Icosahedron(double sideLength) throws IllegalArgumentException{
        super(sideLength);

    }

    @Override
    public double getSurfaceArea() throws IllegalArgumentException{
        if(getSideLength() < 0){
            throw new IllegalArgumentException();
        }else {
            double sArea = 5.0 * Math.sqrt(3.0) * Math.pow(getSideLength(), 2.0);
            return sArea;
        }
    }

    @Override
    public double getVolume() throws IllegalArgumentException{
        if(getSideLength() < 0){
            throw new IllegalArgumentException();
        }else {
            double volume = ((15.0 + (5.0 * Math.sqrt(5.0))) / 12.0) * Math.pow(getSideLength(),3);
            return volume;
        }
    }

    @Override
    public boolean equals(Object anObject) {
        if(anObject instanceof Icosahedron){
            if(this.getSideLength() == ((Icosahedron) anObject).getSideLength()){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String name = "Icosahedron";
        String sideLength = String.format("%f",getSideLength());
        return name+"["+sideLength+"]";
    }
}

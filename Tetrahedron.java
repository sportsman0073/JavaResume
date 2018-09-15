public class Tetrahedron extends Polyhedron{

    public Tetrahedron(double sideLength) throws IllegalArgumentException {
        super(sideLength);
    }

    @Override
    public double getSurfaceArea() throws IllegalArgumentException {
        if(getSideLength() < 0){
            throw new IllegalArgumentException();
        }else {
            double sArea = Math.sqrt(3.0) * getSideLength() * getSideLength();
            return sArea;
        }
    }

    @Override
    public double getVolume() throws IllegalArgumentException {
        if(getSideLength() < 0){
            throw new IllegalArgumentException();
        }else {
            double volume = Math.pow(getSideLength(), 3) / (6 * Math.sqrt(2.0));
            return volume;
        }
    }

    @Override
    public boolean equals(Object anObject) {
        if(anObject instanceof Tetrahedron){
            if(this.getSideLength() == ((Tetrahedron) anObject).getSideLength()){
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
        String name = "Tetrahedron";
        String sideLength = String.format("%f",getSideLength());
        return name+"["+sideLength+"]";
    }
}

public abstract class Polyhedron {
    private double sideLength;

    public Polyhedron(double sideLength) throws IllegalArgumentException{
        if(sideLength < 0){
            throw new IllegalArgumentException();
        }else {
            this.sideLength = sideLength;
        }
    }

    public double getSideLength() {
        return this.sideLength;
    }
    public void setSideLength(double sideLength) throws IllegalArgumentException{
        if(sideLength < 0){
            throw new IllegalArgumentException();
        }else {
            this.sideLength = sideLength;
        }
    }

    @Override
    public boolean equals(Object anObject) {
        if(anObject instanceof Polyhedron){
            if(this.getSideLength() == ((Polyhedron) anObject).getSideLength()){
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
        String name = "Polyhedron";
        String sideLength = String.format("%f",getSideLength());
        return name+"["+sideLength+"]";
    }
    public abstract double getSurfaceArea();
    public abstract double getVolume();
}

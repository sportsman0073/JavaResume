import java.lang.IllegalArgumentException;

public final class ComplexNumber implements Comparable<ComplexNumber>{

    private double realPart;
    private double imaginaryPart;
    public ComplexNumber(){
        this.realPart = 0.0;
        this.imaginaryPart =0.0;

    }
    public ComplexNumber(double realPart, double imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;

    }
    public ComplexNumber (ComplexNumber aComplexNumber) throws IllegalArgumentException{
        if(aComplexNumber == null){
            throw new IllegalArgumentException();
        }
            this.imaginaryPart = aComplexNumber.getImaginaryPart();
            this.realPart = aComplexNumber.getRealPart();



    }

    public synchronized double getRealPart() {
        return this.realPart;
    }

    public synchronized double getImaginaryPart() {
        return this.imaginaryPart;
    }
    public synchronized void setRealPart(double realPart){
        this.realPart=realPart;
    }

    public synchronized void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }
    public synchronized ComplexNumber conjugate(){
        return new ComplexNumber(this.realPart, (-1)*this.imaginaryPart);
    }
    public synchronized ComplexNumber reciprocal(){
        double denom = ((realPart*realPart)+(imaginaryPart*imaginaryPart));
        return new ComplexNumber((this.realPart/(denom)),((-1)*this.imaginaryPart/denom));

    }
    public synchronized ComplexNumber add(ComplexNumber aComplexNumber)  throws IllegalArgumentException{
        ComplexNumber c2 = new ComplexNumber();
        if(aComplexNumber == null){
            throw new IllegalArgumentException();
        }

            c2 = new ComplexNumber((this.realPart + aComplexNumber.realPart), this.imaginaryPart + aComplexNumber.imaginaryPart);

        return c2;


    }
    public synchronized ComplexNumber subtract(ComplexNumber aComplexNumber) throws IllegalArgumentException{
        ComplexNumber c3 = new ComplexNumber();
        if(aComplexNumber == null){
            throw new IllegalArgumentException();
        }
            c3 = new ComplexNumber((this.realPart-aComplexNumber.realPart), this.imaginaryPart-aComplexNumber.imaginaryPart);
        return c3;
    }
    public synchronized ComplexNumber multiply(ComplexNumber aComplexNumber) throws IllegalArgumentException{
        ComplexNumber c4 =new ComplexNumber();
        if(aComplexNumber == null){
            throw new IllegalArgumentException();
        }
           c4 = new ComplexNumber(this.realPart * aComplexNumber.realPart - this.imaginaryPart*aComplexNumber.imaginaryPart,
                    this.imaginaryPart * aComplexNumber.realPart + this.realPart*aComplexNumber.imaginaryPart);
        return c4;

    }
    public synchronized ComplexNumber divide(ComplexNumber aComplexNumber) throws IllegalArgumentException{
        ComplexNumber c5 = new ComplexNumber();
        if(aComplexNumber == null){
            throw new IllegalArgumentException();
        }
            c5 = new ComplexNumber(
                    ((this.realPart*aComplexNumber.realPart)+(this.imaginaryPart*aComplexNumber.imaginaryPart))/(aComplexNumber.realPart*aComplexNumber.realPart +aComplexNumber.imaginaryPart*aComplexNumber.imaginaryPart),
                    ((this.imaginaryPart*aComplexNumber.realPart)-(this.realPart*aComplexNumber.imaginaryPart))/(aComplexNumber.realPart*aComplexNumber.realPart +aComplexNumber.imaginaryPart*aComplexNumber.imaginaryPart));

        return c5;
    }
    @Override
    public synchronized int compareTo(ComplexNumber complexNumber) {
        if(complexNumber == null){
            return -1;
        }
        if(this.realPart == complexNumber.realPart){
            if(this.imaginaryPart == complexNumber.imaginaryPart){
                return 0;
            }else if(this.imaginaryPart>complexNumber.imaginaryPart){
                return 1;
            }else{
                return -1;
            }
        }else if(this.realPart < complexNumber.realPart || complexNumber == null) {
            return -1;
        }
        return 1;
    }

    @Override
    public synchronized boolean equals(Object o) {
        if(o == null || this.getClass() == null){
            return false;
        }
        if(this.getClass() == o.getClass()){
            ComplexNumber c = (ComplexNumber) o;
            if(this.realPart==c.realPart && this.imaginaryPart==c.imaginaryPart){
                return true;
            }
        }

            return false;
    }

    @Override
    public synchronized String toString() {
        String realPartComplex = String.format("%f ",realPart);
        String imaginaryPartComplex = String.format(" %f",Math.abs(imaginaryPart));
        String sign ="";
        if(imaginaryPart>=0){
            sign = "+";
        }else{

            sign = "-";
        }
        String complexNumberString = realPartComplex+sign+imaginaryPartComplex+"i";
        return complexNumberString;
    }

}

public class FeetInches {
    int feet;
    int inch;

    public FeetInches() {
        feet = 0;
        inch = 0;
    }

    public FeetInches(int f, int i) {
        feet = f;
        inch = i;
        simplify();
    }

    public FeetInches(FeetInches obj2) {
        feet = obj2.feet;
        inch = obj2.inch;
    }

    public int getFeet() {
        return feet;
    }

    public int getInch() {
        return inch;
    }

    public void setFeet(int f) {
        feet = f;
    }

    public void setInch(int i) {
        inch = i;
    }

    public void simplify() {
        if(inch > 11)
        {
            feet = feet + inch/12;
            inch = inch % 12;
        }
    }

    public FeetInches add(FeetInches obj){
        int totalFeet, totalInch;

        totalFeet = feet + obj.feet;
        totalInch = inch + obj.inch;

        return new FeetInches(totalFeet, totalInch);
    }

    public boolean equals(FeetInches obj) {
        boolean status ;

        if(obj == null)
            status = false;
        else if ((feet == obj.feet) && (inch == obj.inch))
            status = true;
        else 
            status = false;
        
        return status;
    }

    public FeetInches copy(){
        FeetInches newObject = new FeetInches(feet,inch);

        return newObject;
    }

    
}

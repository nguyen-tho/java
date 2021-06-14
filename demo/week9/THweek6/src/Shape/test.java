package Shape;
public  class test {
    public static void main(String[] args) {
        Shape[] sh = new Shape[5];

        sh[0] = new Shape("Circle", 3.14);
        sh[1] = new Shape("Square", 4);
        sh[2] = new Shape("Triangle", 1.5);
        sh[3] = new Shape("Square", 16);
        sh[4] = new Shape("Circle", 6.28);

        Sorting.insertionSort(sh);
        for (int i = 0; i < sh.length; i++) {
            System.out.println(sh[i]);
        }

        Shape ts = new Shape("Square", 4);

        Comparable found =(Shape) Searching.linearSearch(sh, ts);

        if (found != -1) {
            System.out.println("Found  " + found); 
        }
        else{
            System.out.println("Not found");
        }

    }
}

package Shape;
public class Searching {
    public static  Comparable linearSearch(Comparable[] list, Comparable target) {
        int index = 0 ;
        boolean found = false;
        
        while(!found && index < list.length){
            if (list[index].equals(target)){
                found = true;
            }
            else{
                index++;
            }
        }

        if (found) {
            return list[index];
        }

        return null;
    }
}

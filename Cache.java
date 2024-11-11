import java.util.LinkedList;
import java.util.ListIterator;
import java.text.DecimalFormat;

/**
 * This class mimics a cache. It uses a linked list and stores any object as it utlizes a generic type. The
 * idea is that the linked list will have values that can be quickly accessed and adjust under certain situations.
 *  
 * @author BrianWu
 * @version 1.0 CS321 Spring 2023
 * 
 * @param <T> generic type to store
 */
public class Cache<T>{
   
    private LinkedList<T> list;
    private ListIterator<T> navi;
    private int refrences;
    private int cacheHit;
    private int size;

    /**
     * The default constructor. It doesn't have much use in this case as you need a set size otherwise it isn't really a cache.
     */
    public Cache(){
        list = new LinkedList<>();
        refrences = cacheHit = 0; 
    }

    /**
     * The overloaded constructor. This one will be taking primary as it is properly setup to mimic a cache.  
     * @param listSize
     */
    public Cache(int listSize){ 
        list = new LinkedList<>();
        refrences = cacheHit = 0;
        size = listSize;
    }
    
    /**
     * This method gives the linked list its ability to imitate a cache. It scans the linked list for the object and if it find it
     * then moves it to the front while keeping track of the references and cacheHit. If it doesn't find it in the list then it
     * adds the object to the front while also accounting for size.
     * @param retrieve
     * @return it is meant to return itself(retrieve)
     */
    public T getObject(T retrieve){
        this.refrences++;
        navi = list.listIterator();
        for(int i = 0; i < list.size(); i++){
            if(navi.next().equals(retrieve)){ //The object is found
                this.cacheHit++;
                navi.remove();
                list.addFirst(retrieve);
                return retrieve;
            }
        }
        if(list.size() == size){ //Checking if the cache is full
            navi.remove();
        }
        this.list.addFirst(retrieve);
        return retrieve;
    }
    
    /**
     * This method adds an element to the front of the linked list.
     * @param element
     */
    public void addObject(T element){
        this.list.addFirst(element);
    }

    /**
     * This method removes an element using itself assuming that it exists.
     * @param remove 
     */
    public void removeObject(T remove){
        this.list.remove(remove);
    }

    /**
     * This method clears the cache.
     */
    public void clear(){
        this.list.clear();
    }

    /**
     * This returns the ratio of the cache using a simple equation cacheHit/refrences with some extra features to flush things out.
     * @return information about the cache
     */
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00"); //Format incase the ratio is a whole number (Ex: 43.00)
        double ratio = (cacheHit * 1.00/refrences) * 100;
        String message = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n" +
                         "LinkedList Cache with " + size + " entries has been created \n" +
                         "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n" +
                         "Total number of references:         " + refrences + "\n" + 
                         "Total number of cache hits:         " + cacheHit + "\n" +
                         "Cache hit ratio:                 " + df.format(ratio) + "%" + "\n";
        return message;
    }
    
}

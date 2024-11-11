import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * This class is a tester for the Cache class. It takes in a size and test data filename in order to test
 * the effectiveness of this cache-like product.
 * 
 * The usage of this class is as follows: java CacheTest <cache-size> <serialized-data-filename>
 * Do keep in mind that the cache size must be an integer otherwise a NumberFormatException will be thrown.
 * 
 * @author Brian Wu
 * @version 1.0 CS321 Spring 2023
 **/

public class CacheTest {
    private static long startTime;
    private static long endTime;
    public static void main(String[] args) {
        Cache<Player> cache;
        startTime = System.currentTimeMillis(); //Retrieving start time
        if(args.length != 2){ //Verifying proper usage of command
            System.out.println("INVALID USE OF CacheTest");
            System.out.println("Requires: <cache-size> <serialized-data-fliename>");
            System.exit(0);
        }
        int size = Integer.parseInt(args[0]); //Aquiring proper arguments from args[]
        String fileName = args[1];
        cache = new Cache<Player>(size);
       
        try {
            File file = new File(fileName);
            FileInputStream fileReader = new FileInputStream(file);
            ObjectInputStream objectReader = new ObjectInputStream(fileReader);
            ArrayList<Player> data = new ArrayList<Player>();
            data = (ArrayList<Player>) objectReader.readObject();
            ListIterator<Player> finder = data.listIterator();
            for(int i = 0; i < data.size(); i++){
                cache.getObject(finder.next());
            }
            endTime = System.currentTimeMillis(); //Retrieving end time

            objectReader.close();
        } catch (FileNotFoundException e) {   
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        
        System.out.println(cache.toString());
        float elapsedTime = (endTime - startTime);
        System.out.println("----------------------------------------------------------------" + "\n" +
                           "Time elapsed: " + elapsedTime + " milliseconds" + "\n" +
                           "----------------------------------------------------------------");
    }

}

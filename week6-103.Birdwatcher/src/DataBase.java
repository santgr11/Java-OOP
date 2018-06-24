import java.util.ArrayList;
/**
 *
 * @author SantGr
 */
public class DataBase {
    private ArrayList<Bird> list;
    
    public DataBase(){
        this.list = new ArrayList<Bird>();
    }
    
    public void addBird(Bird newBird){
        this.list.add(newBird);
    }
    
    public void printStats(){
        for( Bird bird : list ){
            System.out.println(bird);
        }
    }
    
    public Bird searchBird(String birdName){
        for( Bird bird : list ){
            if( bird.getName().equals(birdName) ){
                return bird;
            }
        }
        
        return null;
    }
    
    public boolean isInDB(String birdName){
        Bird searching = this.searchBird( birdName );
        if( searching == null ){
            return false;
        }
        
        searching.observation();
        return true;
    }
    
}

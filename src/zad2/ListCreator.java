/**
 *
 *  @author Sroczyński Mikołaj S18840
 *
 */

package zad2;


import java.util.ArrayList;
import java.util.List;

public class ListCreator <T,V> { // Uwaga: klasa musi być sparametrtyzowana
    List<T> list;
    public ListCreator(List<T> listC){
        this.list=listC;

    }

    public static <T,V> ListCreator <T,V> collectFrom(List<T> listC){
        return  new ListCreator<>(listC);

    }


    public ListCreator<T, V> when(Selector <T> warunek) {
        List<T> warunki;
        warunki = new ArrayList<>();
        for (T t:list
             ) {if(warunek.select(t))
                 warunki.add(t);


        }
        //return new ListCreator<T>(warunki);
        //return new ListCreator<V>(warunki);
        return new ListCreator<T,V>(warunki);

    };

    public List <V> mapEvery (Mapper<T,V> warunek){
        List <V> warunki;
        warunki= new ArrayList<>();
        for (T t:list
             ) {warunki.add(warunek.map(t));
        }
        return warunki;
    }
}  

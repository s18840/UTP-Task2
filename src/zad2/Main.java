/**
 *
 *  @author Sroczyński Mikołaj S18840
 *
 */

package zad2;

import java.util.*;

public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1,7,9,11,12);/*<-- tu dopisać inicjację elementów listy */
    System.out.println(test1(src1));

    List<String> src2 =Arrays.asList("a","zzzz","vvvvvvv"); /*<-- tu dopisać inicjację elementów listy */
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {

    Selector sel = new Selector<Integer>() {
      boolean tak = true;
      boolean nie = false;
      @Override
      public boolean select(Integer interSel) {
        if(interSel<10)
          return tak;
        else
          return nie;
      }
    };/*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */
    Mapper map = new Mapper<Integer,Integer>() {
      @Override
      public Integer map(Integer interMap) {
        return interMap+10;
      }
    };  /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
    return   /*<-- zwrot wyniku
      uzyskanego przez wywołanie statycznej metody klasy ListCreator:
     */  ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public List<Integer> test2(List<String> src) {
    Selector sel= new Selector<String>() {
      boolean tak = true;
      boolean nie = false;
      @Override
      public boolean select(String interSel) {
        int a =interSel.length();
        if(a<3)
        return nie;
        else return tak;
      }
    };/*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */
    Mapper map = new Mapper<String,Integer>() {
      @Override
      public Integer map(String interMap) {
        int a = interMap.length()+10;
        return a;
      }
    };  /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
    return   /*<-- zwrot wyniku
      uzyskanego przez wywołanie statycznej metody klasy ListCreator:
     */  ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public static void main(String[] args) {
    new Main();
  }
}

package clue.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicUtils {

  /**
   * Takes an ordered list and returns a "shuffled" version.
   * randomizes the order of the elements.
   * @param aOrderedList - A list with an ordering
   * @return - a list with the same elements in a random order.
   */
  public static List shuffle(List aOrderedList) {

    if(aOrderedList == null || aOrderedList.isEmpty()) {
      return aOrderedList;
    }

    Random tRand = new Random();

    List tShuffled = new ArrayList<>();

    /**
     * Pick an element at random from aOrderedList and place it
     * in tShuffled. Then remove the chosen element from aOrderedList.
     * When all of the elements have been moved from aOrderedList to
     * tShuffled, the shuffle is complete.
     */
    for(int i = aOrderedList.size(); i > 0;  --i) {

      int tIndex = tRand.nextInt(i);

      System.out.println("i: " + i + " tIndex: " + tIndex);
      System.out.println("aOrderedList.size(): " + aOrderedList.size());
      Object tChosen = aOrderedList.get(tIndex);

      tShuffled.add(tChosen);
      aOrderedList.remove(tIndex);
    }

    System.out.println("tShuffled.size(): " + tShuffled.size());
    return tShuffled;
  }
}

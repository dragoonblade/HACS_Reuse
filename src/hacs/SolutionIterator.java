package hacs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;


class SolutionIteratorTest {
    private static int HEAD = -1;

    @Test
    void moveToHead() {
        SolutionList list = new SolutionList();
        Solution solution = new Solution();
        list.add(solution);
        list.add(solution);
        list.add(solution);
        list.add(solution);
        SolutionIterator iterator = new SolutionIterator(list);
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.moveToHead();
        assertEquals(HEAD, iterator.currentSolutionNumber);
    }

    @Test
    void testHasNextSuccess() {
        SolutionList list = new SolutionList();
        Solution solution = new Solution();
        list.add(solution);
        SolutionIterator iterator = new SolutionIterator(list);
        assertEquals(true, iterator.hasNext());
    }

    @Test
    void testHasNextFailure() {
        SolutionList list = new SolutionList();
        SolutionIterator iterator = new SolutionIterator(list);
        assertEquals(false, iterator.hasNext());
    }

    @Test
    void testNextSuccess() {
        SolutionList list = new SolutionList();
        Solution solution = new Solution();
        list.add(solution);
        SolutionIterator iterator = new SolutionIterator(list);
        assertEquals(solution, iterator.next());
    }

    @Test
    void testNextFailure() {
        SolutionList list = new SolutionList();
        SolutionIterator iterator = new SolutionIterator(list);
        assertEquals(null, iterator.next());
    }

    @Test
    void testRemoveSuccess() {
        SolutionList list = new SolutionList();
        Solution solution = new Solution();
        list.add(solution);
        SolutionIterator iterator = new SolutionIterator(list);
        iterator.next();
        iterator.remove();
        assertEquals(0, list.size());
    }

    @Test
    void testRemoveFailure() {
        SolutionList list = new SolutionList();
        SolutionIterator iterator = new SolutionIterator(list);
        iterator.next();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> iterator.remove());
    }
}


/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class SolutionIterator implements Iterator {
    SolutionList solutionList;

    ///  CurrentSolutionNumber: point to the location before the first element
    int currentSolutionNumber = -1;

    public SolutionIterator() {
    }

    public SolutionIterator(SolutionList theSolutionList) {
        solutionList = theSolutionList;
        moveToHead();
    }

    public void moveToHead() {
        ///  CurrentSolutionNumber: point to the location before the first element
        currentSolutionNumber = -1;
    }

    public boolean hasNext() {
        /**@todo: Implement this java.util.Iterator method*/
      return currentSolutionNumber < solutionList.size() - 1;
//    throw new java.lang.UnsupportedOperationException("Method hasNext() not yet implemented.");
    }

    public Object next() {
        /**@todo: Implement this java.util.Iterator method*/
        if (hasNext() == true) {
            currentSolutionNumber++;
            return solutionList.get(currentSolutionNumber);
        } else {
            return null;
        }
        //    throw new java.lang.UnsupportedOperationException("Method next() not yet implemented.");
    }

    /// get the next Solution that fits the Username;
    public Object next(String UserName) {
        Solution theSolution;
        theSolution = (Solution) next();
        while (theSolution != null) {
            if (UserName.compareTo(theSolution.theAuthor) == 0) {
                return theSolution;
            }
            theSolution = (Solution) next();
        }
        return null;
    }

    public void remove() {
        /**@todo: Implement this java.util.Iterator method*/
        solutionList.remove(currentSolutionNumber);
//    throw new java.lang.UnsupportedOperationException("Method remove() not yet implemented.");
    }


}
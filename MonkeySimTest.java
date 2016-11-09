
/**
 * CS1632 Deliverable 4
 *
 * @author Nick Taglianetti
 * @author Michael Oles
 */

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import org.mockito.*;

public class MonkeySimTest {

    @Test()
	public void getFirstMonkeyReturnsMonkeyForNonEmptyList() {
        List<Monkey> monkeyList = new LinkedList<Monkey>();
        Monkey m = new Monkey();
        monkeyList.add(m);
        assertEquals(MonkeySim.getFirstMonkey(monkeyList), m);
    }

    @Test()
	public void getFirstMonkeyReturnsNullForEmptyList() {
        List<Monkey> monkeyList = new LinkedList<Monkey>();
        assertNull(MonkeySim.getFirstMonkey(monkeyList));
    }

    @Test()
	public void getFirstMonkeyNeverReturnsNotFirstMonkey() {
        List<Monkey> monkeyList = new LinkedList<Monkey>();
        Monkey m1 = new Monkey();
        monkeyList.add(m1);
        Monkey m2 = new Monkey();
        monkeyList.add(m2);
        Monkey m3 = new Monkey();
        monkeyList.add(m3);
        assertNotEquals(MonkeySim.getFirstMonkey(monkeyList), m2);
        assertNotEquals(MonkeySim.getFirstMonkey(monkeyList), m3);
    }

    @Test()
	public void getFirstMonkeyNeverReturnsMonkeyNotInList() {
        List<Monkey> monkeyList = new LinkedList<Monkey>();
        Monkey m = new Monkey();
        assertNotEquals(MonkeySim.getFirstMonkey(monkeyList), m);
    }

    //Test that if a Monkey with a negative id is passed into stringifyResults
    //That the method catches the error and exits running
    @Test()
    public void testNegavtiveIdStringify()throws NoIdException{
      Monkey m = Mockito.mock(Monkey.class);
      Monkey m2 = new Monkey();
      Mockito.when(m.getId()).thenThrow(NoIdException.class);
      MonkeySim.stringifyResults(2,m,m2);
      //program should exit after this line
      fail();
    }

  //Test that stringifyResults returns a string with
  //the correct number of the monkey that threw and caught a banana
  @Test()
  public void testMonkeyNums() {
    Monkey m = Mockito.mock(Monkey.class);
    Mockito.when(m.getMonkeyNum()).thenReturn(4);
    Monkey m2 = Mockito.mock(Monkey.class);
    Mockito.when(m2.getMonkeyNum()).thenReturn(1000);
    String s = MonkeySim.stringifyResults(8,m,m2);
    assertTrue(s.contains("Threw banana from Monkey (#4")&&s.contains("to Monkey (#1000"));
  }

  //Test the stringifyResults returns a string with
  //the correct round based on the first parameter
  @Test()
  public void testCorrectRound() {
    Monkey m = Mockito.mock(Monkey.class);
    Mockito.when(m.getMonkeyNum()).thenReturn(2);
    Monkey m2 = Mockito.mock(Monkey.class);
    Mockito.when(m2.getMonkeyNum()).thenReturn(3);
    String s = MonkeySim.stringifyResults(27,m,m2);
    assertTrue(s.contains("//Round 27"));
  }
}

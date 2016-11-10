
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
	// Test that the first Monkey in monkeyList has a monkeyNum of 1
    @Test()
	public void testFirstMonkeyNum1() throws NoIdException {
	  List<Monkey> monkeyList = new LinkedList<Monkey>();
	  Monkey m1 = new Monkey();
	  monkeyList.add(m1);
	  assertEquals(MonkeySim.getFirstMonkey(monkeyList).getMonkeyNum(), 1);
    }

	// Test that the first monkey in monkeyList is null if no Monkeys were
	// added to monkeyList
    @Test()
	public void testFirstMonkeyNullForEmptyList() {
	  List<Monkey> monkeyList = new LinkedList<Monkey>();
	  assertNull(MonkeySim.getFirstMonkey(monkeyList));
    }

	// Test that getFirstMonkey will not return a Monkey other than
	// the first one that was added to monkeyList
    @Test()
	public void testReturnOnlyFirstMonkey() {
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

	// Tests that the a Monkey must be added to monkeyList in order to
	// be returned as the first Monkey in the list
    @Test()
	public void testFirstMonkeyAdded() {
	  List<Monkey> monkeyList = new LinkedList<Monkey>();
	  Monkey m = new Monkey();
	  assertNotEquals(MonkeySim.getFirstMonkey(monkeyList), m);
    }

    //Test that if a Monkey with a negative id is passed into stringifyResults
    //That the method catches the error and exits running
    @Test()
    public void testNegavtiveIdStringify() throws NoIdException{
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


  @Test()
  public void testMonkeyNums() {
    Monkey m = Mockito.mock(Monkey.class);
    Mockito.when(m.getId()).thenReturn(4);
    Monkey m2 = new Monkey();
    Mockito.when(m.getId()).thenReturn(23456);
    String s = MonkeySim.stringifyResults(8,m,m2);
    assertTrue(s.contains("ID 0")&&s.contains("ID 23456"));
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

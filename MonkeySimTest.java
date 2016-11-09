
/**
 * CS1632 Deliverable 4
 *
 * @author Nick Taglianetti
 * @author Michael Oles
 */

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

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
}

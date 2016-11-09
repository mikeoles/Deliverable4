/**
 * CS1632 Deliverable 4
 *
 * @author Nick Taglianetti
 * @author Michael Oles
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class MonkeyTest {
  @Test
  public void returnsCorrectId(){
    Monkey m = new Monkey();
    int id = m.generateId(3);
    assertEquals(id,223495);
  }

  @Test
  public void checkSameIdReturned(){
    Monkey m = new Monkey();
    int id = m.generateId(23434);
    int secondId = m.generateId(23434);
    assertEquals(id,secondId);
  }

  @Test
  public void negativeParameterIdTest(){
    Monkey m = new Monkey();
    int id = m.generateId(-1);
    assertEquals(id,223491);
  }
}

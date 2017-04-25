package leo.controllers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DataControllerTest {

    private DataController controller = new DataController();

    @Test
    public void checkMorning(){
        assertNotNull(controller.printGreeting());
        assertEquals(controller.printGreeting(), DataController.GOOD_MORNING);
    }

    @Test
    public void checkDay() throws Exception {
        assertNotNull(controller.printGreeting());
        assertEquals(controller.printGreeting(), DataController.GOOD_DAY);
    }

    @Test
    public void checkEvening() throws Exception {
        assertNotNull(controller.printGreeting());
        assertEquals(controller.printGreeting(), DataController.GOOD_EVENING);
    }

    @Test
    public void checkNight() throws Exception {
        assertNotNull(controller.printGreeting());
        assertEquals(controller.printGreeting(), DataController.GOOD_NIGHT);
    }

}
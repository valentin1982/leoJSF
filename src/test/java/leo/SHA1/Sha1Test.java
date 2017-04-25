package leo.SHA1;

import leo.utils.Sha1Utils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sha1Test {

    @Test
    public void shaIsWorks(){
        String password = "smith";
        String userinput = Sha1Utils.encryptPassword("smith");
        assertNotEquals(userinput, password);
    }

    @Test
    public void shaNotEqualsTest() {
        String password = "a94a8fe5ccb19ba61c4c0873d391e987982fbbd3";
        String userinput = Sha1Utils.encryptPassword("smith");
        assertNotEquals(userinput, password);
    }

    @Test
    public void shaEqualsTest() {
        String password = "2b5c240e6abd88e71ffc225b0459016e4cba9bda";
        String userinput = Sha1Utils.encryptPassword("smith");
        assertEquals(userinput, password);
    }

}

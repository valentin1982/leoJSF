package leo.controllers;

import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;

@ManagedBean
@SessionScoped
public class DataController implements Serializable {

    final private static Logger loger = Logger.getLogger(DataController.class);

    public static final String GOOD_MORNING = "Good Morning ";
    public static final String GOOD_DAY = "Good day ";
    public static final String GOOD_EVENING = "Good Evening ";

    public static final String GOOD_NIGHT = "Good Night ";
    private Calendar c = Calendar.getInstance();
    int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
    private String greeting;

    public DataController() {
    }

    public String printGreeting() {
        if(timeOfDay >= 6 && timeOfDay < 9){
            greeting = GOOD_MORNING;
            loger.info(GOOD_MORNING + c.getTime());
            return greeting;
        }else if(timeOfDay >= 9 && timeOfDay < 19){
            greeting = GOOD_DAY;
            loger.info(GOOD_DAY + c.getTime());
        }else if(timeOfDay >= 19 && timeOfDay < 23){
            greeting = GOOD_EVENING;
            loger.info(GOOD_EVENING + c.getTime());
        }else if(timeOfDay >= 23 && timeOfDay < 24 || timeOfDay >= 0 && timeOfDay < 6){
            greeting = GOOD_NIGHT;
            loger.info(GOOD_NIGHT + c.getTime());
        }
        loger.info(greeting);

        return greeting;
    }

}

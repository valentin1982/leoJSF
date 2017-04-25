package leo.beans;

import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Locale;

@ManagedBean(eager = true)
@SessionScoped
public class LocaleChanger implements Serializable {

    final private Logger logger = Logger.getLogger(LocaleChanger.class);
    private Locale currentLocale;
    private Locale defaultLocale = Locale.getDefault();

    public void changeLocale(String localeCode) {
        currentLocale = new Locale(localeCode);
    }

    public Locale getCurrentLocale() {

        if (currentLocale == null) {
            currentLocale = defaultLocale;
            logger.info("LocaleChanger " + currentLocale.getLanguage());
        }
        return currentLocale;
    }
}


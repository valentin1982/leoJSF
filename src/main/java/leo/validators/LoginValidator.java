package leo.validators;

import org.apache.log4j.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;


@FacesValidator("library.validators.LoginValidator")
public class LoginValidator implements Validator {

    final private static Logger logger = Logger.getLogger(LoginValidator.class);

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {

        ResourceBundle bundle = ResourceBundle.getBundle("locales.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());

        try {
            String newValue = value.toString();

            if (newValue.length() < 2) {
                throw new IllegalArgumentException(bundle.getString("login_length_error"));
            }

            if (!Character.isLetter(newValue.charAt(0))) {
                throw new IllegalArgumentException(bundle.getString("first_letter_error"));
            }


        } catch (IllegalArgumentException e) {
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            logger.error("LoginValidator : " + message.getDetail());
            throw new ValidatorException(message);
        }

    }


}


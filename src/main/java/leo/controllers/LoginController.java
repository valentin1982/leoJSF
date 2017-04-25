package leo.controllers;


import leo.dao.UserDAOimpl;
import leo.model.User;
import org.apache.log4j.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;


@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

    private static final long serialVersionUID = 1L;

    final private static Logger loger = Logger.getLogger(LoginController.class);
    public static final String LOGIN_XHTML = "/index.xhtml?faces-redirect=true";
    public static final String HOME_XHTML = "/pages/home?faces-redirect=true";

    private UserDAOimpl userDAOimpl = new UserDAOimpl();

    private User user = new User();

    public LoginController() {
    }

    public String login() {
        user = userDAOimpl.checkLogin(user.getLogin(), user.getPassword());
        if (user == null) {
            user = new User();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "User not found!", " Login Error!")
            );
            loger.error("login  User not found! " + FacesContext.getCurrentInstance().getMessages());
            return null;
        } else {
            return HOME_XHTML;
        }
    }

    public String logout() {
        String result = LOGIN_XHTML;
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
        } catch (ServletException e) {
            loger.error("login  User not found! " +
                    FacesContext.getCurrentInstance().getMessages() +
                    e.getLocalizedMessage());
        }
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return result;
    }

    public String goHome() {
        return LOGIN_XHTML;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


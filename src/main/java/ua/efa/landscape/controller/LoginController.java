package ua.efa.landscape.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping("/login-page")
public class LoginController{

    private static final String ERROR_ATTR = "error";

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/{errorKey}", method = RequestMethod.GET)
    public String showLoginPageWithErrors(@PathVariable("errorKey") String errorKey, Model model) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute(ERROR_ATTR, messageSource.getMessage(errorKey, null, currentLocale));
        return "login";
    }


}

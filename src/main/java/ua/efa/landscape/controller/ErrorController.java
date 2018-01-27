package ua.efa.landscape.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class ErrorController {

    private static final String ERROR_MSG_ATTR = "errorMsg";
    private static final String ERROR_PAGE_MESSAGE_KEY = "error.page.message.";
    private static final String ERROR_PAGE_DEFAULT_MESSAGE_KEY = "error.page.message.default";

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String showErrorPage(HttpServletRequest request, Model model) {
        model.addAttribute(ERROR_MSG_ATTR, getErrorMessage(request));
        return "error";
    }

    private String getErrorMessage(HttpServletRequest request) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String errorCode = getErrorCode(request);
        String errorMsg;
        try {
            errorMsg = messageSource.getMessage(ERROR_PAGE_MESSAGE_KEY + errorCode, null, currentLocale);
        } catch (NoSuchMessageException e) {
            errorMsg = messageSource.getMessage(ERROR_PAGE_DEFAULT_MESSAGE_KEY, null, currentLocale);
        }
        return errorMsg;
    }

    private String getErrorCode(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        return statusCode.toString();
    }
}

package ua.efa.landscape.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.efa.landscape.Constants;
import ua.efa.landscape.data.PlantPageableData;
import ua.efa.landscape.form.PlantForm;
import ua.efa.landscape.model.ColorEnum;
import ua.efa.landscape.service.PlantService;
import ua.efa.landscape.validation.PlantFormValidationRespponse;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Controller
@RequestMapping("/")
@ManagedResource(objectName = "plantDB:name=HomeController")
public class HomeController {

    //static volatile because of JMX
    private static volatile int pageSize;

    @Autowired
    private PlantService plantService;

    @Autowired
    private MessageSource messageSource;

    public HomeController(@Value("${db.pagination.size}") int pSize) {
        pageSize = pSize;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(Model model) {
        model.addAttribute("colors", ColorEnum.values());
        model.addAttribute("plantForm", new PlantForm());
        return "home";
    }

    @RequestMapping(value = "/validate/form", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PlantFormValidationRespponse validateForm(@Valid @ModelAttribute("plantForm") PlantForm plantForm,
                                                     BindingResult bindingResult) {
        PlantFormValidationRespponse respponse = new PlantFormValidationRespponse();
        if (bindingResult.hasErrors()) {
            Locale currentLocale = LocaleContextHolder.getLocale();
            Map<String, String> errors = bindingResult.getFieldErrors().stream()
                    .collect(toMap(FieldError::getField, error -> getLocalizedErrorMessage(error, currentLocale)));
            respponse.setErrors(errors);
        }
        return respponse;
    }

    private String getLocalizedErrorMessage(FieldError error, Locale locale) {
        return messageSource.getMessage(error.getDefaultMessage(), null, locale);
    }

    @RequestMapping(value = "/submit/form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("plantForm") PlantForm plantForm, Model model,
                             @RequestParam("pn") int pageNumber) {
        PlantPageableData pageableData = createPageableData(pageNumber);
        pageableData = plantService.getPlantsByCriteriasPagineted(getPlantParams(plantForm), pageableData);
        model.addAttribute("pageableData", pageableData);
        return Constants.Fragments.PLANT_TABLE_FRAGMENT;
    }

    private PlantPageableData createPageableData(int pageNumber) {
        PlantPageableData pageableData = new PlantPageableData();
        pageableData.setPageNumber(pageNumber);
        pageableData.setPageSize(pageSize);
        return pageableData;
    }

    private Map<String, Object> getPlantParams(PlantForm plantForm) {
        Map<String, Object> params = new HashMap<>();
        String color = plantForm.getColor();

        params.put("name", plantForm.getName());
        params.put("color", isBlank(color) ? color : ColorEnum.valueOf(color));
        params.put("heightFrom", plantForm.getHeightFrom());
        params.put("heightTo", plantForm.getHeightTo());
        params.put("priceFrom", plantForm.getPriceFrom());
        params.put("priceTo", plantForm.getPriceTo());

        return params;
    }

    @ManagedAttribute
    public int getPageSize() {
        return pageSize;
    }

    @ManagedAttribute
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

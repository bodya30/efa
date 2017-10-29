package ua.efa.landscape.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.efa.landscape.Constants;
import ua.efa.landscape.data.PlantPageableData;
import ua.efa.landscape.form.PlantForm;
import ua.efa.landscape.model.ColorEnum;
import ua.efa.landscape.model.Plant;
import ua.efa.landscape.service.PlantService;
import ua.efa.landscape.validation.PlantFormValidationRespponse;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Controller
@RequestMapping("/")
public class HomeController {
    @Value("${db.pagination.size}")
    private int pageSize;

    @Autowired
    private PlantService plantService;

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
            Map<String, String> errors = bindingResult.getFieldErrors().stream()
                    .collect(toMap(FieldError::getField, FieldError::getDefaultMessage));
            respponse.setErrors(errors);
        }
        return respponse;
    }

    @RequestMapping(value = "/submit/form", method = RequestMethod.POST)
    @ResponseBody
    public String submitForm(@ModelAttribute("plantForm") PlantForm plantForm, Model model, int pageNumber){
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
        params.put("name", plantForm.getName());
        params.put("color", ColorEnum.valueOf(plantForm.getColor()));
        params.put("heightFrom", plantForm.getHeightFrom());
        params.put("heightTo", plantForm.getHeightTo());
        params.put("priceFrom", plantForm.getPriceFrom());
        params.put("priceTo", plantForm.getPriceTo());
        return params;
    }

}

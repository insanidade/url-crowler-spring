package com.crawler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/**
 * @author ofranca
 *
 */
@Controller
public class ListController implements WebMvcConfigurer  {
	
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    /**
     * @param urlForm The form object that represents the form to be presented in the view
     * @return The string representing the view that shall be rendered.
     */
    @GetMapping("/")
    public String showForm(UrlForm urlForm) {
        return "form";
    }

    /**
     * @param urlForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/")
    public ModelAndView findAllUrls(@Valid UrlForm urlForm, BindingResult bindingResult) {

    	if (bindingResult.hasErrors()) {
    		return new ModelAndView("form");
    	}

    	FindManager findManager = new FindManager();

    	List<Url> urlsFound;

    	urlsFound = findManager.findAllUrls(urlForm.getUrl());

    	return new ModelAndView("results", "urlsFound", urlsFound);
    }

}

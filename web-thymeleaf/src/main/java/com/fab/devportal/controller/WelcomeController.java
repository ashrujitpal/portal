package com.fab.devportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fab.devportal.dao.ApiDescTbl;
import com.fab.devportal.dao.SubApiTbl;
import com.fab.devportal.repo.SubAPIRepository;
import com.fab.devportal.service.APIDetailsService;
import com.fab.devportal.service.SubApiService;

import ch.qos.logback.classic.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("fabapis")
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;
    
    @Autowired 
	private SubApiService subApiService;
    
    @Autowired
    private APIDetailsService apiDtlsService;

    //private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/")
    public String main(Model model) {
        //model.addAttribute("message", message);
        //model.addAttribute("tasks", tasks);

        return "welcome"; //view
    }

    @GetMapping("/smartbank")
    public String smartBank(Model model) {

        List<SubApiTbl> subApiLists = subApiService.findByParentApiName("Smart Bank");
        
        model.addAttribute("subapilist", subApiLists);

        return "smartbank"; //view
    }
    
    @GetMapping("/openbank")
    public String openBank(Model model) {

        List<SubApiTbl> subApiLists = subApiService.findByParentApiName("Open Bank");
        
        model.addAttribute("subapilist", subApiLists);

        return "openbank"; //view
    }
    
    @PostMapping("/apidetails")
    public String apiDetails(@RequestParam Long id,  Model model) {
    	
    	System.out.println("Id Received from Smart bank page" + id);

        Optional<ApiDescTbl> apiDetailsList =apiDtlsService.findById(id);
        
        model.addAttribute("apidetails", apiDetailsList.get());
        
        System.out.println("apiDetailsList.get()" + apiDetailsList.get().getId());

        return "apidescription"; //view
    }

}
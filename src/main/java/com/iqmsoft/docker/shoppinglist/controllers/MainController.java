package com.iqmsoft.docker.shoppinglist.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.iqmsoft.docker.shoppinglist.services.ItemsListService;



@Slf4j
@Controller
@AllArgsConstructor
public class MainController {
    private ItemsListService itemsListService;

    @GetMapping("/")
    public String getAllLists(ModelMap modelMap) {
        modelMap.addAttribute("itemsLists", itemsListService.findAllLists());
        return "index";
    }
}

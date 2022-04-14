package com.gmail.vladyslavnicko.beerstore.controllers;

import com.gmail.vladyslavnicko.beerstore.dto.AddressDTO;
import com.gmail.vladyslavnicko.beerstore.dto.CategoriesDTO;
import com.gmail.vladyslavnicko.beerstore.services.address.AddressServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/address")
public class AddressController {

    private final AddressServices addressServices;

    public AddressController(AddressServices addressServices) {
        this.addressServices = addressServices;
    }

    @GetMapping("/add")
    public String addressAdd(Model model){
        return "add-address";
    }

    @PostMapping("/add")
    public String saveCategories(@RequestParam String country, @RequestParam String region, @RequestParam String city,
                                 @RequestParam String street, @RequestParam int numberBuilding,
                                 @RequestParam int apartment,Model model){
        AddressDTO addressDTO = new AddressDTO(country, region, city, street, numberBuilding, apartment);
        addressServices.addAddress(addressDTO);
        return "redirect:/";
    }
}

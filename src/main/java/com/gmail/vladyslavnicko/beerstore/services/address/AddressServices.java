package com.gmail.vladyslavnicko.beerstore.services.address;

import com.gmail.vladyslavnicko.beerstore.dto.AddressDTO;

public interface AddressServices {

    boolean addAddress(AddressDTO addressDTO);
    void deleteAddress(long userId);
}

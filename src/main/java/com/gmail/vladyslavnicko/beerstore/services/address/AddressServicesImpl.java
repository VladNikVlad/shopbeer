package com.gmail.vladyslavnicko.beerstore.services.address;

import com.gmail.vladyslavnicko.beerstore.dto.AddressDTO;
import com.gmail.vladyslavnicko.beerstore.model.Address;
import com.gmail.vladyslavnicko.beerstore.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServicesImpl implements AddressServices{

    private final AddressRepository addressRepository;

    public AddressServicesImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public boolean addAddress(AddressDTO addressDTO) {
        Address address = Address.fromDTO(addressDTO);
        addressRepository.save(address);
        return true;
    }

    @Override
    public void deleteAddress(long addressId) {
        addressRepository.deleteById(addressId);
    }
}

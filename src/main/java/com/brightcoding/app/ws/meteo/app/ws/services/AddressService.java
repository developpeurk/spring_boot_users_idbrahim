package com.brightcoding.app.ws.meteo.app.ws.services;

import java.util.List;

import com.brightcoding.app.ws.meteo.app.ws.shared.dto.AddressDto;

public interface AddressService {
    List<AddressDto> getAllAddresses(String email);

	AddressDto createAddress(AddressDto address, String email);

	AddressDto getAddress(String addressId);

	void deleteAddress(String addressId);
}

package com.brightcoding.app.ws.meteo.app.ws.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brightcoding.app.ws.meteo.app.ws.entities.AddressEntity;
import com.brightcoding.app.ws.meteo.app.ws.entities.UserEntity;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long>{

	List<AddressEntity> findByUser(UserEntity currentUser);

	AddressEntity findByAddressId(String addressId);

}

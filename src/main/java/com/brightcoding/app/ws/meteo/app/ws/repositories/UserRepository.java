/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brightcoding.app.ws.meteo.app.ws.repositories;

import com.brightcoding.app.ws.meteo.app.ws.entities.UserEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yassine
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long>{
    UserEntity findByEmail(String email);
    UserEntity findByUserId(String userId);
//    @Query(value="SELECT * FROM users", nativeQuery = true)
//    Page<UserEntity> findAllUsers(Pageable pageableRequest);

    //    le nom de l'entité JPQL
    @Query(value="SELECT user FROM UserEntity user")
    Page<UserEntity> findAllUsers(Pageable pageableRequest);
    
    // ?1 1er paramétre
//    @Query(value="SELECT * FROM users u WHERE (u.first_name =?1 OR u.last_name =?1) AND u.email_verification_status=?2 ", nativeQuery = true)
//    Page<UserEntity> findAllUserByCriteria(Pageable pageableRequest,String search,int status);
    
    //NamedQuery
    
//    @Query(value="SELECT * FROM users u WHERE (u.first_name =:search OR u.last_name =:search) AND u.email_verification_status=:status ", nativeQuery = true)
//    Page<UserEntity> findAllUserByCriteria(Pageable pageableRequest,@Param("search")String search,@Param("status")int status);

    @Query(value="SELECT * FROM users u WHERE (u.first_name LIKE %:search% OR u.last_name LIKE %:search%) AND u.email_verification_status=:status ", nativeQuery = true)
    Page<UserEntity> findAllUserByCriteria(Pageable pageableRequest,@Param("search")String search,@Param("status")int status);
}

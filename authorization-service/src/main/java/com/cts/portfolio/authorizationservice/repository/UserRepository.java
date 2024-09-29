package com.cts.portfolio.authorizationservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.portfolio.authorizationservice.model.UserData;

/**
 * interface extending JpaRepository to access Userdata from table
 * @author POD-3
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserData, String> {

}

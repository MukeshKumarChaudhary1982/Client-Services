package com.dxc.ClientServices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.ClientServices.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}

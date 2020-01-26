package com.dxc.ClientServices.service;

import java.util.List;

import com.dxc.ClientServices.entity.Client;

public interface ClientService {
	
	public List<Client> findAll();
	
	public Client findById(int theId);
	
	public void save(Client theClient);
	
	public void deletebyId(int theId);
}

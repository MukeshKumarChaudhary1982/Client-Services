package com.dxc.ClientServices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.ClientServices.dao.ClientRepository;
import com.dxc.ClientServices.entity.Client;
import com.dxc.ClientServices.exception.ClientNotFoundException;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	@Transactional
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	@Transactional
	public Client findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Client> result = clientRepository.findById(theId);
		
		Client theClient = null;
		if(result.isPresent()) {
			theClient=result.get();
		}else {
			throw new ClientNotFoundException("Cleint not found with ID "+theId);
		}
		
		return theClient;
	}

	@Override
	@Transactional
	public void save(Client theClient) {
		// TODO Auto-generated method stub
		clientRepository.save(theClient);
	}

	@Override
	@Transactional
	public void deletebyId(int theId) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(theId);
	}

}

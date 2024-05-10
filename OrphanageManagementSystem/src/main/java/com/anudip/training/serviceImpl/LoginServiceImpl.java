package com.anudip.training.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.entity.Login;
import com.anudip.training.repository.LoginRepository;
import com.anudip.training.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository lrepo;
	
	@Override
	public Login loginUser(String userNmae, String password) {

		Login login= lrepo.findByUserNameAndPassword(userNmae, password);
		return login;
	}

}

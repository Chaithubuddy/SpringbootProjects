package com.chaithu.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.chaithu.bindings.ActiveAccount;
import com.chaithu.bindings.Login;
import com.chaithu.bindings.User;
import com.chaithu.dao.UserMasterRepo;
import com.chaithu.entity.UserMaster;
import com.chaithu.utils.EmailUtils;

@Service
public class UserMasterServiceIMPL implements UserService {

	@Autowired
	private UserMasterRepo masterRepo;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public Boolean saveUser(User user) {
		UserMaster entity = new UserMaster();
		BeanUtils.copyProperties(user, entity);

		// understand requirement
		entity.setPassword(genarateRandomPwd());
		entity.setActiveStatus("In-Active");

		UserMaster save = masterRepo.save(entity);
		String subject = "Registartion Succes";
		String filename = "REG-EMAIL-BODY.txt";
		String body = readEmailBody(entity.getFullName(), entity.getPassword(), filename);

		emailUtils.sendMail(user.getEmail(), subject, body);
		return save != null;
	}

	@Override
	public Boolean activeUserAcc(ActiveAccount actiavateAcc) {
		UserMaster entity = new UserMaster();
		entity.setEmail(actiavateAcc.getEmail());
		entity.setPassword(actiavateAcc.getTempPwd());

		Example<UserMaster> of = Example.of(entity);
		List<UserMaster> findAll = masterRepo.findAll(of);
		if (findAll.isEmpty()) {
			return false;
		} else {
			UserMaster userMaster = findAll.get(0);
			userMaster.setPassword(actiavateAcc.getNewPwd());
			userMaster.setActiveStatus("Active");
			masterRepo.save(entity);
			return true;

		}
	}

	@Override
	public Boolean statusChange(Integer id, String status) {

		Optional<UserMaster> findById = masterRepo.findById(id);
		if (findById.isPresent()) {
			UserMaster userMaster = new UserMaster();
			userMaster.setActiveStatus(status);

			masterRepo.save(userMaster);
			return true;
		}
		return false;
	}

	@Override
	public String login(Login login) {
		UserMaster findByMailAndPassword = masterRepo.findByMailAndPassword(login.getEmail(), login.getPassword());
		if (findByMailAndPassword == null) {
			return "Invalid credetails";

		} else {
			if (findByMailAndPassword.getActiveStatus().equals("Active")) {
				return "suucess";

			} else {
				return "Account not activated";
			}

		}

	}

	@Override
	public User getUserById(Integer id) {
		Optional<UserMaster> findById = masterRepo.findById(id);

		if (findById.isPresent()) {
			User user = new User();
			UserMaster userMaster = findById.get();
			BeanUtils.copyProperties(userMaster, user);
			return user;

		}
		return null;
	}

	@Override
	public Boolean deleteUser(Integer id) {
		try {
			masterRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = new ArrayList<>();
		List<UserMaster> findAll = masterRepo.findAll();
		for (UserMaster entity : findAll) {
			User user = new User();
			BeanUtils.copyProperties(entity, user);
			users.add(user);
		}

		return users;
	}

	@Override
	public String forgetPassword(String email) {
		UserMaster findByMail = masterRepo.findByMail(email);
		if (findByMail == null) {
			return "Inavalid email";
		}
		String subject = "Forget Password";
		String filename = "RECOVER-PWD-BODY.txt";
		String body = readEmailBody(findByMail.getFullName(), findByMail.getPassword(), filename);
		boolean sendMail = emailUtils.sendMail(email, subject, body);
		if (sendMail) {
			return "password send to register mail";
		}
		return null;
	}

	private String genarateRandomPwd() {
		int length = 6; // Length of the password
		String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";

		StringBuilder password = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(charSet.length());
			password.append(charSet.charAt(index));
		}

		return password.toString();

	}

	private String readEmailBody(String fullname, String pwd, String fileName) {
		StringBuffer buffer = new StringBuffer();
		String mailBody = "";
		String url = "";

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String readLine = br.readLine();
			while (readLine != null) {
				buffer.append(readLine);
				readLine = br.readLine(); // if not write then while will infinite loop;
			}
			br.close();
			mailBody = buffer.toString();
			mailBody = mailBody.replace("{FULLNAME}", fullname);
			mailBody = mailBody.replace("{TEMP-PWD}", pwd);
			mailBody = mailBody.replace("{URL}", url);
			mailBody = mailBody.replace("{PWD}", pwd);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return mailBody;

	}
}

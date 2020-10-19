package com.bit.university.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bit.university.db.StudentManager;
import com.bit.university.vo.StudentVo;

@Service
public class LoginService implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(String std_no) throws UsernameNotFoundException {
		StudentVo vo = StudentManager.getStudent(std_no);
		if (vo == null) {
			throw new UsernameNotFoundException(std_no);
		}
		return User.builder()
				.username(std_no)
				.password(vo.getStd_pwd())
				.roles("ADMIN")
				.build();
	}
}

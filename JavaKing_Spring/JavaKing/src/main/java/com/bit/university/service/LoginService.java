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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		StudentVo student_vo = StudentManager.getStudent(username);
		if (student_vo == null) {
			throw new UsernameNotFoundException(username);
		}
		return User.builder()
		.username(username)
		.password(student_vo.getStd_pwd())
		.roles(student_vo.getRole())
		.build();
	}
}

package com.bit.university.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorVo {
	private int pro_no;
	private String pro_name;
	private String pro_email;
	private String pro_major;
	private String pro_type;
}

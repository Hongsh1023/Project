package com.bit.university.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterVo {
	private int reg_no;
	private Date reg_date;
	private int reg_semester;
	private int reg_level;
	private int reg_entfee;
	private int reg_fee;
	private int reg_regfee;
	private int std_no;
	private int reg_year;
}

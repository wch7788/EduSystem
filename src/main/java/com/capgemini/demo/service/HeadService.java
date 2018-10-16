package com.capgemini.demo.service;

import com.capgemini.demo.bean.Head;
import com.capgemini.demo.bean.Student;

public interface HeadService {

	boolean checkRegister(Head head);

	void addHead(Head head);

	int AutoID();

	boolean checklogin(String name, String password);

}

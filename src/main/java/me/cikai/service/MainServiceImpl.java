package me.cikai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.cikai.dao.MainDao;
import me.cikai.dto.FormDto;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainDao dao = null;

	@Override
	public void add(FormDto formDto) {

		dao.add(formDto);

	}

}

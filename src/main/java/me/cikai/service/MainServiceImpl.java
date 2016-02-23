package me.cikai.service;

import me.cikai.dao.MainDao;
import me.cikai.dto.FormDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainDao dao = null;

	@Override
	public void add(FormDto formDto) {

		dao.insert(formDto);

	}

}

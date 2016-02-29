package me.cikai.service;

import java.util.List;

import me.cikai.dto.FormDto;
import me.cikai.dto.ListDto;

public interface MainService {

	public void add(FormDto formDto);

	public List<ListDto> getList();

}

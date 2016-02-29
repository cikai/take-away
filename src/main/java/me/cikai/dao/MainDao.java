package me.cikai.dao;

import java.util.List;

import me.cikai.dto.FormDto;
import me.cikai.dto.ListDto;

public interface MainDao {

	public void insert(FormDto formDto);

	public List<ListDto> select();

}

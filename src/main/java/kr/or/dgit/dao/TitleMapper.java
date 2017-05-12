package kr.or.dgit.dao;

import java.util.List;

import kr.or.dgit.dto.Title;

public interface TitleMapper {
	List<Title> selectByAll();

	Title selectTitle(Title title);

	int insertTitle(Title title);

	int updateTitle(Title title);

	int deleteTitle(Title title);
}

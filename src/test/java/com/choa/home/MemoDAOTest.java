package com.choa.home;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.memo.MemoDAO;
import com.choa.memo.MemoDTO;
import com.choa.util.ListInfo;

public class MemoDAOTest extends MyAbstract{

	
	@Inject
	private MemoDAO memoDAO;
	

	public void test() throws Exception{
		
		MemoDTO memoDTO = new MemoDTO();
		
		memoDTO.setNum(1);
		memoDTO.setWriter("god");
		memoDTO.setContents("mother");
		
		int result = memoDAO.update(memoDTO);
		
		assertEquals(1, result);
		
	}

	@Test
	public void test2() throws Exception{
		
		
		int result = memoDAO.delete(999);
		
		assertEquals(1, result);
		
	}
	
}

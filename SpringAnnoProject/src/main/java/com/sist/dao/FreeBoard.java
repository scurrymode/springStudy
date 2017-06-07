package com.sist.dao;

import org.springframework.stereotype.Component;

@Component("freeb")
public class FreeBoard implements Board {

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("FreeBoard:select() Call...");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("FreeBoard:insert() Cal;...");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("FreeBoard:update() Call...");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("FreeBoard:delete() Call...");
	}

}

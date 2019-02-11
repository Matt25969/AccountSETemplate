package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {
	
	AccountMapRepository repo;
	private JSONUtil util;

	@Before
	public void setup() {
		repo = new AccountMapRepository();
		repo.createAccount("{\"Id\": 1, \"firstName\": \"Phil\", \"lastName\": \"Jerry\", \"accountNumber\": \"102836\"}");
		repo.createAccount("{\"Id\": 2, \"firstName\": \"Ella\", \"lastName\": \"Jerry\", \"accountNumber\": \"123456\"}");
		}

	@Test
	public void addAccountTest() {
		repo.createAccount("{\"Id\": 1, \"firstName\": \"Phil\", \"lastName\": \"Jerry\", \"accountNumber\": \"102836\"}");
		assertNotNull(repo.getAccountMap().get(1L));
	}

	@Test
	public void add2AccountsTest() {
		repo.createAccount("{\"Id\": 1, \"firstName\": \"Phil\", \"lastName\": \"Jerry\", \"accountNumber\": \"102836\"}");
		repo.createAccount("{\"Id\": 2, \"firstName\": \"Ella\", \"lastName\": \"Jerry\", \"accountNumber\": \"123456\"}");
		assertNotNull(repo.getAccountMap().get(2L));
	}

	@Test
	public void removeAccountTest() {
		repo.deleteAccount(1L);
		assertNull(repo.getAccountMap().get(1L));
	}

	@Test
	public void remove2AccountsTest() {
		repo.deleteAccount(1L);
		repo.deleteAccount(2L);
		assertNull(repo.getAccountMap().get(2L));
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		repo.deleteAccount(1L);
		repo.deleteAccount(2L);
		assertEquals("{\"message\": \"no such account\"}",repo.deleteAccount(2L));
	}

	@Test
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void accountConversionToJSONTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		// For a later piece of functionality
		fail("TODO");
	}

}

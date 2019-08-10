package com.dbshacktron.backend.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dbshacktron.backend.models.Message;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyServiceTest {
	@Autowired
	private MyService myService;

	@Test
	public void testStoreMessages() {

	}

	@Test
	public void testGetMessages() {
		List<Message> list = myService.getMessages("");
		assertEquals(list.size(), 2);
	}

	@Test
	public void testClearQueue() {
	}

}

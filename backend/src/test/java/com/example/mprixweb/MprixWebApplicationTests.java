package com.example.mprixweb;

import com.example.mprixweb.helper.ExcelHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MprixWebApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(ExcelHelper.pathArticles);
	}

}

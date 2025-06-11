package com.senac.pizzademo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled("Teste de integração depende do banco de dados e será ignorado por padrão")
class PizzademoApplicationTests {

	@Test
	void contextLoads() {
	}

}

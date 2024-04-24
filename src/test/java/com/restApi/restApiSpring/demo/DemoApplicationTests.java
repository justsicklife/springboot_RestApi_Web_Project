package com.restApi.restApiSpring.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	@DisplayName("notnull 테스트")
	void name() {

	}


	@Test
	@DisplayName("제네릭 메서드 테스트")
	void 제네릭테스트() {
		A a = new A<Integer>();
		a.a(150);
		A.getName(10);
	}

	static class A<T> {

		T a(T t) {
			return t;
		}

		static <T> T getName(T name) {
			return name;
		}

		public <T> T getGeneric(T generic) {
			return generic;
		}

	}

}

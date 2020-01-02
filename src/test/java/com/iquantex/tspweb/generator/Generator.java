package com.iquantex.tspweb.generator;


import com.iquantex.generator.MybatisBeanDaoGenerator;
import org.junit.Test;

public class Generator {

	@Test
	public void gen() {
		try {
			MybatisBeanDaoGenerator.generator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

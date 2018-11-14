package jdbc_coffee_study;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import jdbc_coffee_study.dao.CoffeeDaoImpl;
import jdbc_coffee_study.dto.Coffee;
import jdbc_coffee_study.jdbc.LogUtil;

public class CoffeeDaoTest {

	static CoffeeDaoImpl dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start CoffeeDaoTest");
		dao = new CoffeeDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("End CoffeeDaoTest");
		dao = null;
	}

	@Test
	public void testInsertCoffee() {
		try {
			Coffee newCoffee = new Coffee(5, "A002", 4500, 100, 10);
			int rowAffected = dao.insertCoffee(newCoffee);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				LogUtil.prnLog("해당 커피 존재");
			} else {
				LogUtil.prnLog(e);
			}
		}
	}
	

}

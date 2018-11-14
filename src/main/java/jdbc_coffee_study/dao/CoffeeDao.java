package jdbc_coffee_study.dao;

import java.sql.SQLException;
import java.util.List;

import jdbc_coffee_study.dto.Coffee;



public interface CoffeeDao {
	List<Coffee> selectDepartmentByAll();
	int insertCoffee(Coffee coffee) throws SQLException;
	
	/*int deleteCoffee(Coffee coffee) throws SQLException;
	int updateCoffee(Coffee coffee) throws SQLException;
	Coffee selectCoffeeByNo(Coffee coffee) throws SQLException;*/
}

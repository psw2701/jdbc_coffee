package jdbc_coffee_study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_coffee_study.dto.Coffee;
import jdbc_coffee_study.jdbc.ConnectionProvider;
import jdbc_coffee_study.jdbc.LogUtil;



public class CoffeeDaoImpl implements CoffeeDao {

	@Override
	public List<Coffee> selectDepartmentByAll() {
		List<Coffee> list = new ArrayList<>();
		String sql = "select no, p.code, price, saleCnt, marginRate from sale";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			LogUtil.prnLog(pstmt);
			while (rs.next()) {
				list.add(getCoffee(rs));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	private Coffee getCoffee(ResultSet rs) throws SQLException {
		int no = rs.getInt("no");
		String code = rs.getString("code");
		int price = rs.getInt("price");
		int saleCnt = rs.getInt("saleCnt");
		int marginRate = rs.getInt("marginRate");	
		return new Coffee(no, code, price, saleCnt, marginRate );
		
		
		
	}

	@Override
	public int insertCoffee(Coffee coffee) throws SQLException {
		LogUtil.prnLog("insert()");
		String sql = "insert into sale values(null,?, ?, ?, ?);";
		int rowAffected = 0;
		try (Connection conn = ConnectionProvider.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, coffee.getCode());
			pstmt.setInt(2, coffee.getPrice());
			pstmt.setInt(3, coffee.getSaleCnt());
			pstmt.setInt(4, coffee.getMarginRate());
			LogUtil.prnLog(pstmt);
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

/*	@Override
	public int deleteCoffee(Coffee coffee) throws SQLException {
		LogUtil.prnLog("deleteCoffee()");
		String sql = "delete from coffee where code=?";
		int rowAffected = 0;
		try (Connection conn = ConnectionProvider.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, coffee.getCode());
			LogUtil.prnLog(pstmt);
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public int updateCoffee(Coffee coffee) throws SQLException {
		LogUtil.prnLog("updateCoffee()");
		String sql = "update coffee set name=?, floor=? where deptno=?";
		int rowAffected = 0;
		try (Connection conn = ConnectionProvider.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, coffee.getCode());
			pstmt.setInt(2, coffee.getPrice());
			pstmt.setInt(3, coffee.getSaleCnt());
			pstmt.setInt(3, coffee.getMarginRate());
			LogUtil.prnLog(pstmt);
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public Coffee selectCoffeeByNo(Coffee coffee) throws SQLException {
		LogUtil.prnLog("selectDepartmentByNo()");
		Coffee coff = null;
		String sql = "SELECT deptno, deptname, floor from department where deptno=?";

		try (Connection conn = ConnectionProvider.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, coffee.getCode());
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					coff = getCoffee(rs);
				}
			}
		}
		return coff;
	}
*/
	}

	

	



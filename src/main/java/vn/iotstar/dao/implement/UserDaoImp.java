package vn.iotstar.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBconnectMysql;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImp extends DBconnectMysql implements IUserDao {

	public Connection conn = null;// ket noi database
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findall() {
		String sql = "select * from user";
		List<UserModel> list = new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("fullname"), rs.getString("email"),
						rs.getString("image"), rs.getString("username"), rs.getString("password"), rs.getInt("roleid"),
						rs.getString("phone"), rs.getDate("createdate")));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user where id=?";
		UserModel a = new UserModel();
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				a.setId(rs.getInt("id"));
				a.setFullname(rs.getString("fullname"));
				a.setEmail(rs.getString("email"));
				a.setImage(rs.getString("image"));
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
				a.setRoleid(rs.getInt("roleid"));
				a.setPhone(rs.getString("phone"));
				a.setCreatedate(rs.getDate("createdate"));
			}
			return a;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		String sql = "select * from user where username=?";
		UserModel a = new UserModel();
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				a.setId(rs.getInt("id"));
				a.setFullname(rs.getString("fullname"));
				a.setEmail(rs.getString("email"));
				a.setImage(rs.getString("image"));
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
				a.setRoleid(rs.getInt("roleid"));
				a.setPhone(rs.getString("phone"));
				a.setCreatedate(rs.getDate("createdate"));
			}
			return a;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel insert(UserModel a) {
		String sql = "insert into user(id,fullname,email,image,username,password,roleid,phone,createdate) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getId());
			ps.setString(2, a.getFullname());
			ps.setString(3, a.getEmail());
			ps.setString(4, a.getImage());
			ps.setString(5, a.getUsername());
			ps.setString(6, a.getPassword());
			ps.setInt(7, a.getRoleid());
			ps.setString(8, a.getPhone());
			ps.setDate(9, a.getCreatedate());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	public static void main(String[] args) {
		IUserDao userdao = new UserDaoImp();
		//UserModel b = new UserModel(2,"david nguyễn","david123@gmai.com",null,"david","123");
		//userdao.insert(b);
		List<UserModel> list = userdao.findall();
		
		for (UserModel user : list) {
			System.out.println(user);
		}
//		try {
//			UserModel a = userdao.findByUserName("quochuy123");
//			System.out.println(a);
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}

}

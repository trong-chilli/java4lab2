package DAO;

import java.util.List;

import entitys.User;

public interface interfaceDAO {
	/**Truy vấn tất cả*/
	List<User> findAll();
	
	/**Truy vấn theo mã*/
	User findById(String id);
	
	/**Thêm mới*/
	void create(User item);
	
	/**Cập nhật*/
	void update(User item);
	
	/**Xóa theo mã*/
	void deleteById(String id);
	
	
	
}

package cc.ligu.mvc.service;
import cc.ligu.mvc.persistence.entity.User;

public interface UserService {

	User saveUser(User user);

	User getByAccountAndPwd(String account, String pwd);

	User getUserById(Integer userId);
}

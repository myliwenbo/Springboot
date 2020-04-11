package cn.lwb.dao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.lwb.dao.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);
}

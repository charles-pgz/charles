package com.pgz.charles.repository;

import com.pgz.charles.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author charles
 * @title: UserRepository
 * @projectName charles
 * @description: TODO
 * @date 19/4/1814:47
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);

    User findByUserNameOrNickNameOrEmail(String userName, String nickName,String email);

}

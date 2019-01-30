package org.osama.kpi.services;




import org.osama.kpi.model.UserInfo;
import org.osama.kpi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UsersRepository usersRepository;
    public List<UserInfo> getAllUsers(){
        List<UserInfo> listUsers=new ArrayList<>();
        usersRepository.findAll().forEach(listUsers::add);
        return listUsers;
    }

    public void addUser(UserInfo users){
       usersRepository.save(users);
    }
    public void deleteUser(String name){
        List<UserInfo> byUserName = usersRepository.findByUserName(name);
        usersRepository.delete(byUserName);

   }

}

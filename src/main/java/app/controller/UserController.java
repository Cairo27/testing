package app.controller;

import app.dao.UserDao;
import app.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String userCreateGet(){
        return "user.create";
    }
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String userCreatePost(@RequestParam("name")String name, @RequestParam("email")String email, @RequestParam("phone")String phone, @RequestParam("city")String city){
       UserDao userDao = new UserDao();
       User user=new User(name, email, phone, city);
       userDao.createUser(user);
        System.out.println(name);
        return "user.create";
    }
    @RequestMapping(value ="/user/view", method = RequestMethod.GET)
    public String userViewGet(){
        return "user.view";
    }
    @RequestMapping(value ="/user/view", method = RequestMethod.POST)
    public String userViewPost(){
        return "user.view";
    }
    @ModelAttribute
    public String setAttribute(Model model) {
        UserDao dao = new UserDao();
        List<User> users = dao.getAllUser();
        model.addAttribute("users", users);
        return "user.view";
    }
    @RequestMapping(value ="/user/delete", method = RequestMethod.GET)
    public String userIdGet(@RequestParam(value = "id") int id) {
        UserDao userDao = new UserDao();
        userDao.deleteUser(id);
        return "user.view";
    }
    @RequestMapping(value = "/user/upate", method = RequestMethod.POST)
    public String userFindPost(@RequestParam(value = "id") int id){
        UserDao userDao = new UserDao();
        userDao.FindUser(id);
        return"user.updae";
    }
    @RequestMapping(value="/user/update", method = RequestMethod.GET)
    public String userFindGet(){
        return"user.update";
    }

    @RequestMapping(value="/user/update", method = RequestMethod.POST)
    public String userUpdatePost(@RequestParam("id")int id,@RequestParam("name")String name, @RequestParam("email")String email, @RequestParam("phone")String phone, @RequestParam("city")String city) {

        User user = new User(id, name, email, phone, city);
        UserDao dao = new UserDao();
        dao.editUser(user);
        {
            return "user.view";
        }
    }}




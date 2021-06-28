package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserServiceImpl;
import support.JWTUtil;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String name,String password){
        User user=new User();
        if (user==null||user.getName()==null){
            return "用户不存在或用户名、密码错误";
        }
        String sign= JWTUtil.sign(user,60L * 1000L * 30L);
        return "hello"+user.getName()+"token:"+sign;
    }

    @RequestMapping(value = "logon",method = RequestMethod.POST)
    @ResponseBody
    public String logon(String username,String password,int math,int chinese,int english){
        if (username==null||password==null){
            return "用户名和密码不能为空";
        }
        User user=new User(username,password,math,chinese,english);
        userService.insertUser(user);
        return user.getName()+"添加成功";
    }

    @RequestMapping(value = "registry", method = RequestMethod.POST)
    @ResponseBody
    public String registry(User user) {
        boolean register = userService.register(user);
        if (register) {
            return "hello" + user.getName();
        }
        return "注册失败";
    }

    @RequestMapping(value = "test", method = RequestMethod.POST)
    @ResponseBody
    public String test(User user){
        int score=0;
        if (user.getMath()<60){
            score=score+(60-user.getMath());
        }
        if (user.getEnglish()<60){
            score=score+(60-user.getEnglish());
        }
        if (user.getChinese()<60){
            score=score+(60-user.getChinese());
        }
        int s=score/10;
        switch (score){
            case 1:return "学业预警";
            case 2:return "学业严重预警";
            default:return "劝退！";
        }
    }
}

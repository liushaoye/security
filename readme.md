
# Springboot Security

### 0、登录账户和密码
```
   用户名 :user
   密码 : password

```

### 1、修复权限访问问题

```
 @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

```

### 2、修复页面跳转问题

```java
@Controller
public class HelloController {


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/index")
    public String index2() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }


}
```

### 3、修复html界面冗余问题

```html
   <!DOCTYPE html>
   <html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
   <head>
       <meta charset="UTF-8">
       <title>Hello World!</title>
   </head>
   <body>
   <h1 th:inline="text">Hello [[${#httpServletRequest.remoteUser}]]!</h1>
   <form th:action="@{/logout}" method="post">
       <input type="submit" value="注销"/>
   </form>
   
   </body>
   </html>
```
### 4、添加applicaiton.properties路径配置问题
```
  spring.thymeleaf.prefix=classpath:/templates/

```

### 5、 关注我 | About Me

- [北极的大企鹅](http://www.cnblogs.com/liuyangfirst/ "北极的大企鹅")
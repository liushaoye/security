
# Springboot Security

## 推荐接口设计规范

### 1、统一返回格式

- **统一RESTFUL请求返回对象模型**：

```java
/**
 * Created by liuya on 2018-02-06.
 */
public enum DataResult {

    //访问成功
    SUCCESS_CODE(200,"访问成功"),

    //空指针异常
    FAIL_CODE(500,"空指针异常");

    private final Integer code;

    private final String message;

    DataResult(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

```

### 2、使用合适的请求方法
- **添加信息统一使用Post方法**

```java
@Controller
@Scope("prototype")
@RequestMapping("common")
public class CommonController extends BaseController {
      /**
       * 主类型service注入
       */
       private final IBomMainService bomMainService;
       
       @Autowired
       public CommonController(IBomMainService bomMainService) {
                                                                        
            this.bomMainService = bomMainService;
       }
       
       /**
        * http://localhost:8081/rent/bomMain/bomMainList
        * 列表显示主类子类型
        *
        * @return Object
      */
      @RequestMapping(value = "bomMainList", method = RequestMethod.POST)
      @ResponseBody
      public Object bomMainList() {
         return bomMainService.bomMainList();
       }
}
```
**+ 删除信息统一使用Delete方法**
```
    在获取信息的场景中，使用get方法比post响应更快
```

**+比如订单接口可以这样设计：**

```
    获取订单列表 Get /rent/order/list
    主类型列表     rent/bomMain/bomMainList
    创建订单 Post /rent/order/add
    修改订单 Put /rent/order/{id}
    删除订单 Delete /rent/order/{id}
```

**+ 获取信息统一使用Get方法**

**+ 修改信息统一使用Put方法**


### 3、简化接口设计

**(1)** 根据业务逻辑，有时需要对接口进行适当的抽象, 简化接口设计，同时也便于后期扩展，但也不能过度封装，把简单问题复杂化

**(2)**  实现一个功能，不是代码写的越多越好，而是代码越少越好

### 4、简介| 介绍
```
    Mybatis增强工具包 - 只做增强不做改变，简化CRUD操作
```
### 5、优点| 优点

- **无侵入**：Mybatis-Plus 在 Mybatis 的基础上进行扩展，只做增强不做改变，引入 Mybatis-Plus 不会对您现有的 Mybatis 构架产生任何影响，而且 MP 支持所有 Mybatis 原生的特性
- **依赖少**：仅仅依赖 Mybatis 以及 Mybatis-Spring
- **损耗小**：启动即会自动注入基本CURD，性能基本无损耗，直接面向对象操作
- **预防Sql注入**：内置Sql注入剥离器，有效预防Sql注入攻击
- **通用CRUD操作**：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作，更有强大的条件构造器，满足各类使用需求
- **多种主键策略**：支持多达4种主键策略（内含分布式唯一ID生成器），可自由配置，完美解决主键问题
- **支持热加载**：Mapper 对应的 XML 支持热加载，对于简单的 CRUD 操作，甚至可以无 XML 启动
- **支持ActiveRecord**：支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可实现基本 CRUD 操作
- **支持代码生成**：采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、 Controller 层代码，支持模板引擎，更有超多自定义配置等您来使用（P.S. 比 Mybatis 官方的 Generator 更加强大！）
- **支持自定义全局通用操作**：支持全局通用方法注入（ Write once, use anywhere ）
- **支持关键词自动转义**：支持数据库关键词（order、key......）自动转义，还可自定义关键词
- **内置分页插件**：基于Mybatis物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于写基本List查询
- **内置性能分析插件**：可输出Sql语句以及其执行时间，建议开发测试时启用该功能，能有效解决慢查询
- **内置全局拦截插件**：提供全表 delete 、 update 操作智能分析阻断，预防误操作

### 6、原理 | Principle

- [Mybatis-Plus 实践及架构原理](http://git.oschina.net/baomidou/mybatis-plus/attach_files)

### 7、 应用实例 | Demo

- [Spring-MVC](https://git.oschina.net/baomidou/mybatisplus-spring-mvc)


### 8、下载地址 | Download

- [点此去下载](http://maven.aliyun.com/nexus/#nexus-search;quick~mybatis-plus)

```xml

<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus</artifactId>
    <version>maven 官方最新版本为准</version>
</dependency>

```

### 9、结构目录 | Architecture

![项目结构说明](http://git.oschina.net/uploads/images/2016/0821/161516_58956b85_12260.png "项目结构说明")

### 10、 其他开源项目 | Other Project

- [基于Cookie的SSO中间件 Kisso](http://git.oschina.net/baomidou/kisso)
- [Java快速开发框架 SpringWind](http://git.oschina.net/baomidou/SpringWind)
- [基于Hibernate扩展 Hibernate-Plus](http://git.oschina.net/baomidou/hibernate-plus)
- [Spring-Boot](https://git.oschina.net/baomidou/mybatisplus-spring-boot)
- [mybatisplus-sharding-jdbc](https://gitee.com/baomidou/mybatisplus-sharding-jdbc)
- [SSM-实战 Demo](http://git.oschina.net/baomidou/SpringWind)

### 11、 版权 | License

- [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)

### 12、 关注我 | About Me

- [北极的大企鹅](http://www.cnblogs.com/liuyangfirst/ "北极的大企鹅")
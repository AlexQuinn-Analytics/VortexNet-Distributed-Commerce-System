package com.example.demo.controller;

import com.example.demo.dto.Message;
import com.example.demo.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller - 处理所有HTTP请求
 * @RestController: 标记这是一个REST API控制器
 */
@RestController
public class HelloController {

    /**
     * API 1: 简单的GET请求
     * URL: http://localhost:8080/hello
     * 返回: 纯文本字符串
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Success! I am a Java developer, and this is my first web API!";
    }

    /**
     * API 2: 带查询参数的GET
     * URL: http://localhost:8080/greeting?name=Student
     * @RequestParam: 从URL查询字符串中获取name参数
     * 返回: 拼接好的问候语
     */
    @GetMapping("/greeting")
    public String greeting(@RequestParam String name) {
        return "Hello " + name + "! Welcome back!";
    }

    /**
     * API 3: 带路径变量的GET
     * URL: http://localhost:8080/user/alice
     * @PathVariable: 从URL路径中获取username
     * 返回: 用户信息
     */
    @GetMapping("/user/{username}")
    public String getUserProfile(@PathVariable String username) {
        return "Displaying profile for user: " + username;
    }

    /**
     * API 4: 返回JSON对象的GET
     * URL: http://localhost:8080/api/message
     * @RestController会自动把Message对象序列化为JSON
     * 返回: JSON格式的Message对象
     */
    @GetMapping("/api/message")
    public Message getJsonResponse() {
        return new Message("This is my first JSON response from Spring Boot!");
    }

    /**
     * API 5: 接收JSON并返回JSON的POST
     * URL: http://localhost:8080/api/messages
     * @RequestBody: 把请求体的JSON自动转换成Message对象
     * 返回: 新的Message对象（JSON格式）
     */
    @PostMapping("/api/messages")
    public Message createMessage(@RequestBody Message incomingMessage) {
        String reply = "We have received your message: " + incomingMessage.getContent();
        return new Message(reply);
    }

    /**
     * API 6: 接收User对象，返回Message对象的POST
     * URL: http://localhost:8080/api/users
     * @RequestBody: 把请求体的JSON自动转换成User对象
     * 返回: 确认消息（JSON格式）
     */
    @PostMapping("/api/users")
    public Message createUser(@RequestBody User user) {
        String reply = "User " + user.getUsername() + " was created with email " + user.getEmail();
        return new Message(reply);
    }
}

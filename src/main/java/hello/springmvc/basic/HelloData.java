package hello.springmvc.basic;

import lombok.Data;

@Data // 게터 세터 생성자 등 다만들어줌
public class HelloData {
    private String username;
    private int age;
}

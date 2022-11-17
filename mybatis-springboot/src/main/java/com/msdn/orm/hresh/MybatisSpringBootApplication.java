package com.msdn.orm.hresh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author hresh
 * @博客 https://juejin.cn/user/2664871918047063
 * @网站 https://www.hreshhao.com/
 * @date 2022/9/15 8:05 下午
 * @description
 */
@SpringBootApplication
@MapperScan({"com.msdn.orm.**.mapper"})
public class MybatisSpringBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybatisSpringBootApplication.class, args);
  }
}

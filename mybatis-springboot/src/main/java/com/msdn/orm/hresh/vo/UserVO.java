package com.msdn.orm.hresh.vo;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {

    private String name;

    private Integer age;

    private String address;

    private List<JobVO> jobVOS;
}

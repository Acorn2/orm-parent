package com.msdn.orm.hresh.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author hresh
 * @博客 https://juejin.cn/user/2664871918047063
 * @网站 https://www.hreshhao.com/
 */
@Component
public class SpringUtils implements ApplicationContextAware {

  /**
   * 当前IOC
   */
  private static ApplicationContext applicationContext;

  /**
   * 设置applicationContext
   */
  @Override
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    SpringUtils.applicationContext = context;
  }

  public static <T> T getBean(Class<T> clazz) {
    return applicationContext.getBean(clazz);
  }
}
package com.msdn.orm.hresh.utils;

import cn.hutool.core.util.PageUtil;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hresh
 * @博客 https://juejin.cn/user/2664871918047063
 * @网站 https://www.hreshhao.com/
 * @date 2022/9/10
 * @description 分页工具类
 */
@Slf4j
public class PageUtils extends PageUtil {

  public static <S, D> Page<D> convert(Page<S> sourceList, Class<D> targetClass) {
    try {
      try (Page<D> result = new Page<>(sourceList.getPageNum(), sourceList.getPageSize(),
          sourceList.isCount())) {
        result.setTotal(sourceList.getTotal());
        for (S s : sourceList) {
          D temp = BeanUtils.copyProperties(s, targetClass);
          result.add(temp);
        }
        return result;
      }
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
    return new Page<>();
  }
}

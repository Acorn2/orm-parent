package com.msdn.orm.hresh.common.mybatis;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

@RegisterMapper
public interface ListMapper<T, PK> {

    /**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`id`属性并且必须为自增列
     *
     * @param recordList
     * @return
     */
    @InsertProvider(type = ListProvider.class, method = "dynamicSQL")
    int insertList(List<? extends T> recordList);

    /**
     * 批量更新
     *
     * @return
     */
    @UpdateProvider(type = ListProvider.class, method = "dynamicSQL")
    int updateBatchByPrimaryKeySelective(List<? extends T> recordList);

    /**
     * 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段
     *
     * @param idList
     * @return
     */
    @SelectProvider(type = ListProvider.class, method = "dynamicSQL")
    List<T> selectByIdList(@Param("idList") List<PK> idList);

    /**
     * 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
     *
     * @param idList
     * @return
     */
    @DeleteProvider(type = ListProvider.class, method = "dynamicSQL")
    int deleteByIdList(@Param("idList") List<PK> idList);
}

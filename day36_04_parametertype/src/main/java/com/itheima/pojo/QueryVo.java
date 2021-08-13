package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包名:com.itheima.pojo
 * @author Leevi
 * 日期2020-10-29  14:45
 * Query 查询
 * Vo  ViewObject 视图对象
 * QueryVo 就是封装查询视图的数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryVo {
    public QueryVo(Long currentPage, Integer pageSize, User queryCondition) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.queryCondition = queryCondition;
    }

    private Long currentPage;
    private Integer pageSize;
    /**
     * 查询条件
     */
    private User queryCondition;

    private Long offset;

    public Long getOffset() {
        return (currentPage - 1)*pageSize;
    }
}

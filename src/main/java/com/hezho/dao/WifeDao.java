package com.hezho.dao;

import com.hezho.bean.Husband;
import com.hezho.bean.Wife;

public interface WifeDao {
    // 根据丈夫查询妻子
    public Wife findByHusbandId (int id);

    // 根据妻子查询丈夫
    public Husband findByWifeId(int id);
}

package com.scau.hyskjf.dao;

import com.scau.hyskjf.pojo.Merchantaccount;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantaccountMapper {
    int deleteByPrimaryKey(Integer macid);

    int insert(Merchantaccount record);

    int insertSelective(Merchantaccount record);

    Merchantaccount selectByPrimaryKey(Integer macid);

    int updateByPrimaryKeySelective(Merchantaccount record);

    int updateByPrimaryKey(Merchantaccount record);
}
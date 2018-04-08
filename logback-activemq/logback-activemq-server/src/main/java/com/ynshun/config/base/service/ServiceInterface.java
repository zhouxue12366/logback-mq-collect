package com.ynshun.config.base.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

/**
 * @description:
 *
 * @createdTime: 2017年11月30日 下午5:14:03
 * @createdUser: ynshun
 * @version: 1.0
 */
public interface ServiceInterface<T> {

	public int insertList(List<T> recordList);

	public int insertUseGeneratedKeys(T record);

	public int delete(T record);

	public T selectOne(T record);

	public List<T> select(T record);

	public int insertSelective(T record);

	public int selectCountByExample(Object example);

	public T selectByPrimaryKey(Object key);

	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);

	public int deleteByExample(Object example);

	public int updateByExample(T record, Object example);

	public List<T> selectByExample(Object example);

	public int updateByExampleSelective(T record, Object example);

	public int updateByPrimaryKey(T record);

	public List<T> selectByRowBounds(T record, RowBounds rowBounds);

	public int deleteByPrimaryKey(Object key);

	public int updateByPrimaryKeySelective(T record);

	public int selectCount(T record);

	public int insert(T record);
}

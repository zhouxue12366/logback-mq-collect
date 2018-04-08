package com.ynshun.config.base.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import com.ynshun.config.base.mapper.BaseMapper;


/**
 * @description:
 *
 * @createdTime: 2017年11月30日 下午5:13:45
 * @createdUser: ynshun
 * @version: 1.0
 */
public abstract class BaseService<T> implements ServiceInterface<T> {
	@Autowired
	private BaseMapper<T> baseMapper;

	@Override
	public int insertList(List<T> recordList) {
		return this.baseMapper.insertList(recordList);
	}

	@Override
	public int insertUseGeneratedKeys(T record) {
		return this.baseMapper.insertUseGeneratedKeys(record);
	}

	@Override
	public int delete(T record) {
		return this.baseMapper.delete(record);
	}

	@Override
	public T selectOne(T record) {
		return this.baseMapper.selectOne(record);
	}

	@Override
	public List<T> select(T record) {
		return this.baseMapper.select(record);
	}

	@Override
	public int insertSelective(T record) {
		return this.baseMapper.insertSelective(record);
	}

	@Override
	public int selectCountByExample(Object example) {
		return this.baseMapper.selectCountByExample(example);
	}

	@Override
	public T selectByPrimaryKey(Object key) {
		return this.baseMapper.selectByPrimaryKey(key);
	}

	@Override
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
		return this.baseMapper.selectByExampleAndRowBounds(example, rowBounds);
	}

	@Override
	public int deleteByExample(Object example) {
		return this.baseMapper.deleteByExample(example);
	}

	@Override
	public int updateByExample(T record, Object example) {
		return this.baseMapper.updateByExample(record, example);
	}

	@Override
	public List<T> selectByExample(Object example) {
		return this.baseMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(T record, Object example) {
		return this.baseMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		return this.baseMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
		return this.baseMapper.selectByRowBounds(record, rowBounds);
	}

	@Override
	public int deleteByPrimaryKey(Object key) {
		return this.baseMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		return this.baseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int selectCount(T record) {
		return this.baseMapper.selectCount(record);
	}

	@Override
	public int insert(T record) {
		return this.baseMapper.insert(record);
	}

}

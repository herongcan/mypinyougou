package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author Steven
 * @version 1.0
 * @description com.pinyougou.sellergoods.service.impl
 * @date 2018-5-9
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;
    @Override
    public List<TbBrand> findAll() {
        List<TbBrand> select = null;
        try {
            select = brandMapper.select(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return select;
    }

    @Override
    public PageResult<TbBrand> findPage(int pageNum, int pageSize,TbBrand brand) {
        PageResult<TbBrand> result = new PageResult<TbBrand>();
        Example example = new Example(TbBrand.class);
        Example.Criteria criteria = example.createCriteria();
        //构造查询条件
        if (null!=brand.getName() && brand.getName().trim().length()>0) {
            criteria.andLike("name", "%" + brand.getName() + "%");
        }
        if (StringUtils.isNotEmpty(brand.getFirstChar())) {
            criteria.andEqualTo("firstChar", brand.getFirstChar());
        }


        //设置分页条件//查询数据//保存数据列表//获取总记录数
        PageHelper.startPage(pageNum,pageSize);
        List<TbBrand> brands = brandMapper.selectByExample(example);
        result.setRows(brands);

        PageInfo<TbBrand> info = new PageInfo<TbBrand>(brands);
        result.setTotal(info.getTotal());

        return result;
    }

    @Override
    public void saveBrand(TbBrand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public TbBrand findById(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateBrand(TbBrand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void deleteBrand(Long[] ids) {
        List longs = Arrays.asList(ids);
        Example example = new Example(TbBrand.class);
        Example.Criteria criteria = example.createCriteria();
        //区间搜索id对应的数据,批量删除
        criteria.andIn("id", longs);
        //跟据查询条件删除数据
        brandMapper.deleteByExample(example);
    }

}

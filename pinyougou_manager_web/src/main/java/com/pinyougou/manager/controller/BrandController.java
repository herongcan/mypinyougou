package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Steven
 * @version 1.0
 * @description com.pinyougou.manager.controller
 * @date 2018-5-9
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    Logger logger = Logger.getLogger(BrandController.class);

    @RequestMapping("findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    /**
     * 分页查询品牌
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("findPage")
    public PageResult<TbBrand> findPage(Integer page, Integer size,@RequestBody TbBrand brand){

        System.out.println(page+"==="+size);
        return brandService.findPage(page,size,brand);
    }

    /**
     * 新增品牌
     */
    @RequestMapping("add")
    public Result saveBrand(@RequestBody TbBrand brand){
        try {
            brandService.saveBrand(brand);
            return new Result(true,"保存成功");
        } catch (Exception e) {
            logger.error("保存品牌出现异常",e);
            return new Result(false,"保存品牌失败");
        }
    }
    /**
     * 跟据id查找数据
     * @param id
     * @return
     */
    @RequestMapping("findById")
    @ResponseBody
    public TbBrand findById(Long id){
        return brandService.findById(id);
    }
    /**
     * 修改品牌
     * @param brand
     * @return
     */
    @RequestMapping("update")
    public Result updateBrand(@RequestBody TbBrand brand){
        try {
            brandService.updateBrand(brand);
            return new Result(true,"修改品牌成功");
        } catch (Exception e) {
            logger.error("修改品牌出现异常",e);
            return new Result(false,"修改品牌失败");

        }
    }/**
     * 删除品牌
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    public Result deleteBrand(Long[] ids){
        try {
            brandService.deleteBrand(ids);
            return new Result(true,"删除品牌成功");
        } catch (Exception e) {
            logger.error("删除品牌出现异常",e);
            return new Result(false,"删除品牌失败");

        }
    }
}

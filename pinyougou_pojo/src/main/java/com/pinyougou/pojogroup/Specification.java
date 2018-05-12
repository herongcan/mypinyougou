package com.pinyougou.pojogroup;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 * 规格组合业务实体
 */
public class Specification implements Serializable {
    private TbSpecification specification;
    private List<TbSpecificationOption> specificationOptionList;

    /**
     * 添加get方法用于支持前端select2获取内容
     */
    public String getText(){
        return this.specification.getSpecName();
    }
    public TbSpecification getSpecification() {
        return specification;
    }

    public void setSpecification(TbSpecification specification) {
        this.specification = specification;
    }

    public List<TbSpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}

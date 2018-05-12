 //控制层
app.controller('typeTemplateController' ,function($scope,$controller,typeTemplateService,brandService,specificationService){
	
	$controller('baseController',{$scope:$scope});//继承

    //新增扩展属性行
    $scope.addTableRow=function(){
        $scope.entity.customAttributeItems.push({});
    }
    //删除扩展属性行
    $scope.deleTableRow=function(index){
        $scope.entity.customAttributeItems.splice(index,1);//删除
    }



    //品牌列表
    $scope.brandList={data:[]};
	//查找品牌列表
    $scope.findBrandList=function () {
        brandService.findAll().success(function (response) {
            $scope.brandList.data = response;
            console.log($scope.brandList)
        });
    }
    //规格列表
    $scope.specList={data:[]};
	//查找规格列表
    $scope.findSpecList=function () {
        specificationService.findAll().success(function (response) {
            // var arr = [];
            // for(var i=0; i<response.length;i++){
        		// arr.push({id:response[i].id,text:response[i].specName})
            // }
            // $scope.specList.data = arr;
            // $scope.specList={data:arr};
            $scope.specList.data = response;
            console.log($scope.specList)
            console.log(response)
        });
    }



    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		typeTemplateService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		typeTemplateService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		typeTemplateService.findOne(id).success(
			function(response){
				$scope.entity= response;
                //转换品牌列表为json
                $scope.entity.brandIds=JSON.parse($scope.entity.brandIds);
                //转换规格列表为json
                $scope.entity.specIds=JSON.parse($scope.entity.specIds);
                //转换自定义属性列表为json
                $scope.entity.customAttributeItems=JSON.parse($scope.entity.customAttributeItems);
				console.log(response)

            }
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=typeTemplateService.update( $scope.entity ); //修改  
		}else{
			serviceObject=typeTemplateService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		typeTemplateService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		typeTemplateService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
});	

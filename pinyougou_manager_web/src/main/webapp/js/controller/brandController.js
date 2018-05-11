//品牌控制层
app.controller('brandController' ,function($scope,$controller,brandService){
    $controller('baseController',{$scope:$scope});//继承

    /*------------------------------------------------分页开始*/
    //定义搜索对象
    $scope.searchEntity={};
    //分页查询数据/
    $scope.findPage = function (page,size) {
        brandService.findPage(page,size,$scope.searchEntity).success(function (response) {
            $scope.list=response.rows;//更新数据列表
            $scope.paginationConf.totalItems = response.total;//更新总记录数
        })
    }/*---------------------------------------------分页结束*/
    $scope.findAll = function () {
        brandService.findAll().success(function (response) {
            $scope.list = response;
        })
    }
    /*修改品牌开始--回显*/
    $scope.findById = function (id) {
        brandService.findById(id).success(function (response) {
            console.log(response);
            $scope.entity = response;
        })
    }
    /*新增-修改品牌 开始*/
    $scope.add = function () {
        var object = brandService.add($scope.entity)
        if(null!=$scope.entity.id){ //如果id不为空则是修改操作
            object = brandService.update($scope.entity)
        }
        object.success(function (response) {
            if (response.success) {
                alert(response.message)
                $scope.reloadList()
            } else {
                alert(response.message)//失败成功都提示
            }
        })
    }
    /*删除功能--开始*/
    $scope.delete = function () {
        var isDel = confirm("Are you sure to delete this item?")
        if (isDel) {
            if($scope.selectIds.length==0){
                alert("未选中")
                return;
            }
            brandService.delete($scope.selectIds).success(function (response) {
                if (response.success) {
                    alert(response.message);//成功时显示成功消息
                    $scope.reloadList();
                }else{
                    alert(response.message); //失败时显示失败消息
                }
            })
        }
    }
    /*删除功能--结束*/
})
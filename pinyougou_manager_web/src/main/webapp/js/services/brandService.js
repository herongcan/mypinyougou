//品牌服务层
app.service("brandService",function ($http) {
    this.findAll = function () {
        return $http.get("../brand/findAll.do")
    }
    this.findPage = function (page,size,searchEntity) {
        return $http.post("../brand/findPage.do?page="+page+"&size="+size,searchEntity)
    }
    this.findById = function(id) {
        return $http.get("../brand/findById.do?id="+id)
    }
    this.add = function (entity) {
        return $http.post("../brand/add.do",entity)
    }
    this.update = function (entity) {
        return $http.post("../brand/update.do",entity)
    }
    this.delete = function (ids) {
        return $http.get("../brand/delete.do?ids="+ids)
    }
})
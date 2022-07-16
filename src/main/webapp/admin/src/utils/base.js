const base = {
    get() {
                return {
            url : "http://localhost:8080/ssm3gwbm/",
            name: "ssm3gwbm",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm3gwbm/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "废旧物品回收管理系统"
        } 
    }
}
export default base

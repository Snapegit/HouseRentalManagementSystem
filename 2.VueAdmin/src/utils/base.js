const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot02098g12/",
            name: "springboot02098g12",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot02098g12/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "房屋租赁管理系统"
        } 
    }
}
export default base

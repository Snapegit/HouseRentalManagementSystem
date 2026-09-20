import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import fangwuleixing from '@/views/modules/fangwuleixing/list'
    import news from '@/views/modules/news/list'
    import fangwuzulin from '@/views/modules/fangwuzulin/list'
    import fangwuchushou from '@/views/modules/fangwuchushou/list'
    import yuyuekanfang from '@/views/modules/yuyuekanfang/list'
    import zulinhetong from '@/views/modules/zulinhetong/list'
    import dichangongsi from '@/views/modules/dichangongsi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import discussnews from '@/views/modules/discussnews/list'
    import fangwugoumai from '@/views/modules/fangwugoumai/list'
    import chushouhetong from '@/views/modules/chushouhetong/list'
    import fangwuchuzu from '@/views/modules/fangwuchuzu/list'
    import config from '@/views/modules/config/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/fangwuleixing',
        name: '房屋类型',
        component: fangwuleixing
      }
      ,{
	path: '/news',
        name: '购房常识',
        component: news
      }
      ,{
	path: '/fangwuzulin',
        name: '房屋租赁',
        component: fangwuzulin
      }
      ,{
	path: '/fangwuchushou',
        name: '房屋出售',
        component: fangwuchushou
      }
      ,{
	path: '/yuyuekanfang',
        name: '预约看房',
        component: yuyuekanfang
      }
      ,{
	path: '/zulinhetong',
        name: '租赁合同',
        component: zulinhetong
      }
      ,{
	path: '/dichangongsi',
        name: '地产公司',
        component: dichangongsi
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/discussnews',
        name: '购房常识',
        component: discussnews
      }
      ,{
	path: '/fangwugoumai',
        name: '房屋购买',
        component: fangwugoumai
      }
      ,{
	path: '/chushouhetong',
        name: '出售合同',
        component: chushouhetong
      }
      ,{
	path: '/fangwuchuzu',
        name: '房屋出租',
        component: fangwuchuzu
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/newstype',
        name: '购房常识分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;

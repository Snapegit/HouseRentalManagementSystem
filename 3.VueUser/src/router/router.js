import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import dichangongsiList from '../pages/dichangongsi/list'
import dichangongsiDetail from '../pages/dichangongsi/detail'
import dichangongsiAdd from '../pages/dichangongsi/add'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import fangwuleixingList from '../pages/fangwuleixing/list'
import fangwuleixingDetail from '../pages/fangwuleixing/detail'
import fangwuleixingAdd from '../pages/fangwuleixing/add'
import fangwuchuzuList from '../pages/fangwuchuzu/list'
import fangwuchuzuDetail from '../pages/fangwuchuzu/detail'
import fangwuchuzuAdd from '../pages/fangwuchuzu/add'
import yuyuekanfangList from '../pages/yuyuekanfang/list'
import yuyuekanfangDetail from '../pages/yuyuekanfang/detail'
import yuyuekanfangAdd from '../pages/yuyuekanfang/add'
import fangwuzulinList from '../pages/fangwuzulin/list'
import fangwuzulinDetail from '../pages/fangwuzulin/detail'
import fangwuzulinAdd from '../pages/fangwuzulin/add'
import zulinhetongList from '../pages/zulinhetong/list'
import zulinhetongDetail from '../pages/zulinhetong/detail'
import zulinhetongAdd from '../pages/zulinhetong/add'
import fangwuchushouList from '../pages/fangwuchushou/list'
import fangwuchushouDetail from '../pages/fangwuchushou/detail'
import fangwuchushouAdd from '../pages/fangwuchushou/add'
import fangwugoumaiList from '../pages/fangwugoumai/list'
import fangwugoumaiDetail from '../pages/fangwugoumai/detail'
import fangwugoumaiAdd from '../pages/fangwugoumai/add'
import chushouhetongList from '../pages/chushouhetong/list'
import chushouhetongDetail from '../pages/chushouhetong/detail'
import chushouhetongAdd from '../pages/chushouhetong/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import emailregistercodeList from '../pages/emailregistercode/list'
import emailregistercodeDetail from '../pages/emailregistercode/detail'
import emailregistercodeAdd from '../pages/emailregistercode/add'
import discussnewsList from '../pages/discussnews/list'
import discussnewsDetail from '../pages/discussnews/detail'
import discussnewsAdd from '../pages/discussnews/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'dichangongsi',
					component: dichangongsiList
				},
				{
					path: 'dichangongsiDetail',
					component: dichangongsiDetail
				},
				{
					path: 'dichangongsiAdd',
					component: dichangongsiAdd
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'fangwuleixing',
					component: fangwuleixingList
				},
				{
					path: 'fangwuleixingDetail',
					component: fangwuleixingDetail
				},
				{
					path: 'fangwuleixingAdd',
					component: fangwuleixingAdd
				},
				{
					path: 'fangwuchuzu',
					component: fangwuchuzuList
				},
				{
					path: 'fangwuchuzuDetail',
					component: fangwuchuzuDetail
				},
				{
					path: 'fangwuchuzuAdd',
					component: fangwuchuzuAdd
				},
				{
					path: 'yuyuekanfang',
					component: yuyuekanfangList
				},
				{
					path: 'yuyuekanfangDetail',
					component: yuyuekanfangDetail
				},
				{
					path: 'yuyuekanfangAdd',
					component: yuyuekanfangAdd
				},
				{
					path: 'fangwuzulin',
					component: fangwuzulinList
				},
				{
					path: 'fangwuzulinDetail',
					component: fangwuzulinDetail
				},
				{
					path: 'fangwuzulinAdd',
					component: fangwuzulinAdd
				},
				{
					path: 'zulinhetong',
					component: zulinhetongList
				},
				{
					path: 'zulinhetongDetail',
					component: zulinhetongDetail
				},
				{
					path: 'zulinhetongAdd',
					component: zulinhetongAdd
				},
				{
					path: 'fangwuchushou',
					component: fangwuchushouList
				},
				{
					path: 'fangwuchushouDetail',
					component: fangwuchushouDetail
				},
				{
					path: 'fangwuchushouAdd',
					component: fangwuchushouAdd
				},
				{
					path: 'fangwugoumai',
					component: fangwugoumaiList
				},
				{
					path: 'fangwugoumaiDetail',
					component: fangwugoumaiDetail
				},
				{
					path: 'fangwugoumaiAdd',
					component: fangwugoumaiAdd
				},
				{
					path: 'chushouhetong',
					component: chushouhetongList
				},
				{
					path: 'chushouhetongDetail',
					component: chushouhetongDetail
				},
				{
					path: 'chushouhetongAdd',
					component: chushouhetongAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'emailregistercode',
					component: emailregistercodeList
				},
				{
					path: 'emailregistercodeDetail',
					component: emailregistercodeDetail
				},
				{
					path: 'emailregistercodeAdd',
					component: emailregistercodeAdd
				},
				{
					path: 'discussnews',
					component: discussnewsList
				},
				{
					path: 'discussnewsDetail',
					component: discussnewsDetail
				},
				{
					path: 'discussnewsAdd',
					component: discussnewsAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})

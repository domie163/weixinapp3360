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

         import users from '@/views/modules/users/list'
         import address from '@/views/modules/address/list'
         import cart from '@/views/modules/cart/list'
         import chat from '@/views/modules/chat/list'
         import dictionary from '@/views/modules/dictionary/list'
         import goods from '@/views/modules/goods/list'
         import goodsCollection from '@/views/modules/goodsCollection/list'
         import goodsCommentback from '@/views/modules/goodsCommentback/list'
         import news from '@/views/modules/news/list'
         import orders from '@/views/modules/orders/list'
         import yonghu from '@/views/modules/yonghu/list'
         import config from '@/views/modules/config/list'
		 

        import dictionaryGoods from '@/views/modules/dictionaryGoods/list'
        import dictionaryGoodsBiaoqian from '@/views/modules/dictionaryGoodsBiaoqian/list'
        import dictionaryNews from '@/views/modules/dictionaryNews/list'




//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
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
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryGoods',
        name: '商品分类名称',
        component: dictionaryGoods
    }
    ,{
        path: '/dictionaryGoodsBiaoqian',
        name: '商品标签名称',
        component: dictionaryGoodsBiaoqian
    }
    ,{
        path: '/dictionaryNews',
        name: '资讯类型名称',
        component: dictionaryNews
    }


    ,{
        path: '/config',
        name: '轮播图',
        component: config
      }
    ,{
        path: '/address',
        name: '地址',
        component: address
      }
    ,{
        path: '/cart',
        name: '购物车表',
        component: cart
      }
    ,{
        path: '/chat',
        name: '客服聊天',
        component: chat
      }
    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/goods',
        name: '商品信息',
        component: goods
      }
    ,{
        path: '/goodsCollection',
        name: '商品收藏',
        component: goodsCollection
      }
    ,{
        path: '/goodsCommentback',
        name: '商品评论',
        component: goodsCommentback
      }
    ,{
        path: '/news',
        name: '商品资讯',
        component: news
      }
    ,{
        path: '/orders',
        name: '订单',
        component: orders
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
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
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
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

export default router;

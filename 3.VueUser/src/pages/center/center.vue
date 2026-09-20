<template>
<div class="center-preview" :style='{"padding":"80px 18% 50px","margin":"0 auto","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20231029/b89b677f7bba41d694305c19dc3b820d.jpg) no-repeat center top,#fff","display":"flex","width":"100%","position":"relative","justifyContent":"space-between"}'>
	<div class="title" :style='{"padding":"10px 45px","margin":"20px 0","color":"#fff","textAlign":"left","background":"url(http://codegen.caihongy.cn/20231028/ebcf7e5fa7584d1e9b407dd18d5d7b1b.png) no-repeat left center / auto 100%,#000","width":"100%","fontSize":"24px"}'>{{ title }}</div>
	
	<div class="info" :style='{"padding":"40px 0 50px","boxShadow":"0 0px 0px rgba(0, 0, 0, 0.3)","margin":"20px 0 0 0","borderColor":"#333","borderRadius":"0px","background":"#fff","borderWidth":"1px","width":"300px","position":"relative","borderStyle":"solid","height":"auto","order":"1"}'>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","color":"#333","textAlign":"center","top":"280px","borderWidth":"0 0 0px 0","background":"none","width":"100%","lineHeight":"44px","fontSize":"22px","position":"absolute","borderStyle":"solid","fontWeight":"600","height":"44px"}'>个人信息</div>
		<div :style='{"borderColor":"#333","margin":"0 auto","textAlign":"center","borderWidth":"0 0 1px 0","background":"none","width":"100%","fontSize":0,"borderStyle":"solid","height":"auto"}' v-if="userTableName=='dichangongsi'">
			<el-image :style='{"margin":"0px auto 60px","borderColor":"#efefef","objectFit":"cover","borderRadius":"100%","borderWidth":"0 0 1px 0","display":"block","width":"230px","borderStyle":"solid","height":"230px"}' :src="sessionForm.tupian?baseUrl + sessionForm.tupian:require('@/assets/avator.png')" fit="cover"></el-image>
		</div>
		<div :style='{"borderColor":"#333","margin":"0 auto","textAlign":"center","borderWidth":"0 0 1px 0","background":"none","width":"100%","fontSize":0,"borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<el-image :style='{"margin":"0px auto 60px","borderColor":"#efefef","objectFit":"cover","borderRadius":"100%","borderWidth":"0 0 1px 0","display":"block","width":"230px","borderStyle":"solid","height":"230px"}' :src="sessionForm.touxiang?baseUrl + sessionForm.touxiang:require('@/assets/avator.png')" fit="cover"></el-image>
		</div>
		<div :style='{"padding":"0 10px","borderColor":"#333","margin":"0 auto","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"50px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='dichangongsi'">
			<span class="icon iconfont icon-geren8" :style='{"padding":"0 5px","fontSize":"16px","color":"#333","display":"inline-block"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>公司账号</div>
			<div :style='{"fontSize":"14px","color":"#666","textAlign":"left","flex":1}'>{{sessionForm.gongsizhanghao}}</div>
		</div>
		<div :style='{"padding":"0 10px","borderColor":"#333","margin":"0 auto","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"50px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='dichangongsi'">
			<span class="icon iconfont icon-shuju9" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"inline-block"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>公司名称</div>
			<div :style='{"fontSize":"14px","color":"#666","textAlign":"left","flex":1}'>{{sessionForm.gongsimingcheng}}</div>
		</div>
		<div :style='{"padding":"0 10px","borderColor":"#333","margin":"0 auto","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"50px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='dichangongsi'">
			<span class="icon iconfont icon-huifu18" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"inline-block"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>联系人</div>
			<div :style='{"fontSize":"14px","color":"#666","textAlign":"left","flex":1}'>{{sessionForm.lianxiren}}</div>
		</div>
		<div :style='{"padding":"0 10px","borderColor":"#333","margin":"0 auto","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"50px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='dichangongsi'">
			<span class="icon iconfont icon-xiugai2" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"inline-block"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>联系电话</div>
			<div :style='{"fontSize":"14px","color":"#666","textAlign":"left","flex":1}'>{{sessionForm.lianxidianhua}}</div>
		</div>
		<div :style='{"padding":"0 10px","borderColor":"#333","margin":"0 auto","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"50px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='dichangongsi'">
			<span class="icon iconfont icon-touxiang03" :style='{"padding":"0 5px","fontSize":"16px","color":"#333","display":"inline-block"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>公司地址</div>
			<div :style='{"fontSize":"14px","color":"#666","textAlign":"left","flex":1}'>{{sessionForm.gongsidizhi}}</div>
		</div>
		<div :style='{"padding":"0 10px","borderColor":"#333","margin":"0 auto","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"50px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-geren8" :style='{"padding":"0 5px","fontSize":"16px","color":"#333","display":"inline-block"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>用户账号</div>
			<div :style='{"fontSize":"14px","color":"#666","textAlign":"left","flex":1}'>{{sessionForm.yonghuzhanghao}}</div>
		</div>
		<div :style='{"padding":"0 10px","borderColor":"#333","margin":"0 auto","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"50px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shuju9" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"inline-block"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>用户姓名</div>
			<div :style='{"fontSize":"14px","color":"#666","textAlign":"left","flex":1}'>{{sessionForm.yonghuxingming}}</div>
		</div>
		<div :style='{"padding":"0 10px","borderColor":"#333","margin":"0 auto","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"50px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-huifu18" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"inline-block"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>性别</div>
			<div :style='{"fontSize":"14px","color":"#666","textAlign":"left","flex":1}'>{{sessionForm.xingbie}}</div>
		</div>
		<div :style='{"padding":"0 10px","borderColor":"#333","margin":"0 auto","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"50px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-xiugai2" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"inline-block"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>手机号码</div>
			<div :style='{"fontSize":"14px","color":"#666","textAlign":"left","flex":1}'>{{sessionForm.shoujihaoma}}</div>
		</div>
		<div :style='{"padding":"0 10px","borderColor":"#333","margin":"0 auto","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"50px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-touxiang03" :style='{"padding":"0 5px","fontSize":"16px","color":"#333","display":"inline-block"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>邮箱</div>
			<div :style='{"fontSize":"14px","color":"#666","textAlign":"left","flex":1}'>{{sessionForm.email}}</div>
		</div>
		
	</div>
	
    <el-tabs tab-position="left" :style='{"border":"1px solid #333","margin":"20px 0 0","flexWrap":"wrap","background":"#fff","display":"flex","width":"calc(100% - 320px)","order":"2"}' @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="80px">
          <el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' v-if="userTableName=='dichangongsi'" label="公司账号" prop="gongsizhanghao">
            <el-input v-model="sessionForm.gongsizhanghao" placeholder="公司账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' v-if="userTableName=='dichangongsi'" label="公司名称" prop="gongsimingcheng">
            <el-input v-model="sessionForm.gongsimingcheng" placeholder="公司名称" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' v-if="userTableName=='dichangongsi'" label="图片" prop="tupian">
			<file-upload
			tip="点击上传图片"
			action="file/upload"
			:limit="1"
			:multiple="true"
			:fileUrls="sessionForm.tupian?sessionForm.tupian:''"
			@change="dichangongsitupianHandleAvatarSuccess"
			></file-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' v-if="userTableName=='dichangongsi'" label="联系人" prop="lianxiren">
            <el-input v-model="sessionForm.lianxiren" placeholder="联系人" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' v-if="userTableName=='dichangongsi'" label="联系电话" prop="lianxidianhua">
            <el-input v-model="sessionForm.lianxidianhua" placeholder="联系电话" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' v-if="userTableName=='dichangongsi'" label="公司地址" prop="gongsidizhi">
            <el-input v-model="sessionForm.gongsidizhi" placeholder="公司地址" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yonghu'" label="用户账号" prop="yonghuzhanghao">
            <el-input v-model="sessionForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yonghu'" label="用户姓名" prop="yonghuxingming">
            <el-input v-model="sessionForm.yonghuxingming" placeholder="用户姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yonghu'" label="头像" prop="touxiang">
			<file-upload
			tip="点击上传头像"
			action="file/upload"
			:limit="1"
			:multiple="true"
			:fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
			@change="yonghutouxiangHandleAvatarSuccess"
			></file-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yonghu'" label="性别" prop="xingbie">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yonghu'" label="手机号码" prop="shoujihaoma">
            <el-input v-model="sessionForm.shoujihaoma" placeholder="手机号码" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yonghu'" label="邮箱" prop="email">
            <el-input v-model="sessionForm.email" placeholder="邮箱" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0 0 20px"}'>
            <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"6px","background":"#833cf7","width":"110px","lineHeight":"36px","fontSize":"14px","height":"36px"}' type="primary" @click="onSubmit('sessionForm')">更新信息</el-button>
            <el-button :style='{"border":"0px solid #eee","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"6px","background":"#000","width":"110px","lineHeight":"36px","fontSize":"14px","height":"36px"}' type="danger" @click="logout">退出登录</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
	  <el-tab-pane label="修改密码">
		<el-form class="center-preview-pv" ref="passwordForm" :model="passwordForm" :rules="passwordRules" label-width="80px">
			<el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' label="原密码" prop="password">
			  <el-input type="password" v-model="passwordForm.password" placeholder="原密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' label="新密码" prop="newpassword">
			  <el-input type="password" v-model="passwordForm.newpassword" placeholder="新密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"padding":"0px","margin":"0 0 20px","background":"#fff","display":"inline-block"}' label="确认密码" prop="repassword">
			  <el-input type="password" v-model="passwordForm.repassword" placeholder="确认密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0 0 20px"}'>
			  <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"6px","background":"#833cf7","width":"110px","lineHeight":"36px","fontSize":"14px","height":"36px"}' type="primary" @click="updatePassword">修改密码</el-button>
			</el-form-item>
		</el-form>
	  </el-tab-pane>
		<el-tab-pane v-for="(item,index) in menuList" :key="index" v-if="hasBack(item.menu)" :label="item.child[0].menu" :name="item.child[0].tableName"></el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
    </el-tabs>

</div>
</template>

<script>
  import config from '@/config/config'
  import menu from '@/config/menu'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: '个人中心',
        baseUrl: config.baseUrl,
        sessionForm: {},
		passwordForm: {},
		passwordRules: {
			password: [
				{
					required: true,
					message: "密码不能为空",
					trigger: "blur"
				}
			],
			newpassword: [
				{
					required: true,
					message: "新密码不能为空",
					trigger: "blur"
				}
			],
			repassword: [
				{
					required: true,
					message: "确认密码不能为空",
					trigger: "blur"
				}
			]
		},
        rules: {},
		menuList: [],
        disabled: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('frontToken')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {},
      }
    },
    created() {
		let menus = menu.list()
		for(let x in menus){
			if(menus[x].tableName == this.userTableName){
				this.menuList = menus[x].backMenu
			}
		}
		if ('dichangongsi' == this.userTableName) {
			this.$set(this.sessionForm, 'gongsizhanghao', null);
		}
		if ('dichangongsi' == this.userTableName) {
			this.$set(this.sessionForm, 'gongsimingcheng', null);
		}
		if ('dichangongsi' == this.userTableName) {
			this.$set(this.sessionForm, 'mima', null);
		}
		if ('dichangongsi' == this.userTableName) {
			this.$set(this.sessionForm, 'tupian', null);
		}
		if ('dichangongsi' == this.userTableName) {
			this.$set(this.sessionForm, 'lianxiren', null);
		}
		if ('dichangongsi' == this.userTableName) {
			this.$set(this.sessionForm, 'lianxidianhua', null);
		}
		if ('dichangongsi' == this.userTableName) {
			this.$set(this.sessionForm, 'gongsidizhi', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'yonghuzhanghao', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'mima', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'yonghuxingming', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'touxiang', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'xingbie', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'shoujihaoma', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'email', null);
		}

		if ('dichangongsi' == this.userTableName&&this.rules['gongsizhanghao']){
			this.rules['gongsizhanghao'].push({ required: true, message: '请输入公司账号', trigger: 'blur' })
		}else if('dichangongsi' == this.userTableName&&!this.rules['gongsizhanghao']) {
			this.$set(this.rules, 'gongsizhanghao', [{ required: true, message: '请输入公司账号', trigger: 'blur' }]);
		}
		if ('dichangongsi' == this.userTableName&&this.rules['gongsimingcheng']){
			this.rules['gongsimingcheng'].push({ required: true, message: '请输入公司名称', trigger: 'blur' })
		}else if('dichangongsi' == this.userTableName&&!this.rules['gongsimingcheng']) {
			this.$set(this.rules, 'gongsimingcheng', [{ required: true, message: '请输入公司名称', trigger: 'blur' }]);
		}
		if ('dichangongsi' == this.userTableName&&this.rules['mima']){
			this.rules['mima'].push({ required: true, message: '请输入密码', trigger: 'blur' })
		}else if('dichangongsi' == this.userTableName&&!this.rules['mima']) {
			this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
		}
		if ('dichangongsi' == this.userTableName) {
			this.$set(this.rules, 'lianxidianhua', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName&&this.rules['yonghuzhanghao']){
			this.rules['yonghuzhanghao'].push({ required: true, message: '请输入用户账号', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['yonghuzhanghao']) {
			this.$set(this.rules, 'yonghuzhanghao', [{ required: true, message: '请输入用户账号', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName&&this.rules['mima']){
			this.rules['mima'].push({ required: true, message: '请输入密码', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['mima']) {
			this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName&&this.rules['yonghuxingming']){
			this.rules['yonghuxingming'].push({ required: true, message: '请输入用户姓名', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['yonghuxingming']) {
			this.$set(this.rules, 'yonghuxingming', [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'shoujihaoma', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'email', [{ required: false, validator: this.$validate.isEmail, trigger: 'blur' }]);
		}

      this.init();
      this.sessionForm = JSON.parse(localStorage.getItem('sessionForm'))
    },
    //方法集合
    methods: {
      init() {
        if ('yonghu' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
      },
	  setSession(){
		  localStorage.setItem('sessionForm',JSON.stringify(this.sessionForm))
	  },
      onSubmit(formName) {
		if(`dichangongsi` == this.userTableName && this.sessionForm.tupian!=null){
			this.sessionForm.tupian = this.sessionForm.tupian.replace(new RegExp(this.$config.baseUrl,"g"),"");
		}
		if(`yonghu` == this.userTableName && this.sessionForm.touxiang!=null){
			this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl,"g"),"");
		}
        this.$refs[formName].validate((valid) => {
			if (valid) {
				this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
					if (res.data.code == 0) {
						this.setSession()
						this.$message({
							message: '更新成功',
							type: 'success',
							duration: 1500
						});
					}
				});
			} else {
				return false;
			}
        });
      },
      dichangongsitupianHandleAvatarSuccess(fileUrls) {
        this.sessionForm.tupian = fileUrls;
      },
      yonghutouxiangHandleAvatarSuccess(fileUrls) {
        this.sessionForm.touxiang = fileUrls;
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case '个人中心':
            tab.$router.push('/index/center');
            break;
          case '修改密码':
            this.passwordForm = {
				password: '',
				newpassword: '',
				repassword: '',
			}
			this.$forceUpdate()
            break;
          case '我的收藏':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
		  default:
		  	tab.$router.push(`/index/${tab.name}?centerType=1`);
        }

        this.title = event.target.outerText;
      },
	  async updatePassword(){
			this.$refs["passwordForm"].validate(async valid => {
				if (valid) {
					var password = "";
					if (this.sessionForm.mima) {
						password = this.sessionForm.mima;
					} else if (this.sessionForm.password) {
						password = this.sessionForm.password;
					}
					if (this.passwordForm.password != password) {
						this.$message.error("原密码错误");
						return;
					}
					if (this.passwordForm.newpassword != this.passwordForm.repassword) {
						this.$message.error("两次密码输入不一致");
						return;
					}
					if (this.userTableName == 'yonghu') {
					}
					this.sessionForm.password = this.passwordForm.newpassword;
					this.sessionForm.mima = this.passwordForm.newpassword;
					this.$http.post(`${this.userTableName}/update`,this.sessionForm).then(({data})=>{
						if (data && data.code === 0) {
							this.$message({
								message: "修改密码成功,下次登录系统生效",
								type: "success",
								duration: 1500,
								onClose: () => {
								}
							});
							this.setSession()
						} else {
							this.$message.error(data.msg);
						}
					});
				}
			})
	  },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: '登出成功',
            type: 'success',
            duration: 1500,
        });
      },
	  hasBack(name){
		  switch(name){
			case '我的收藏管理':
				return false
				break;
			default:
				return true
		  }
	  }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & ::v-deep .el-tabs__header {
		.el-tabs__nav{
			overflow: auto;
		}
		::-webkit-scrollbar {
		  -webkit-appearance: none;
		  width: 6px;
		  height: 6px;
		}
		::-webkit-scrollbar-track {
		  background: rgba(0, 0, 0, 0.1);
		  border-radius: 0;
		}
		::-webkit-scrollbar-thumb {
		  cursor: pointer;
		  border-radius: 5px;
		  background: rgba(0, 0, 0, 0.15);
		  transition: color 0.2s ease;
		}
		::-webkit-scrollbar-thumb:hover {
		  background: rgba(0, 0, 0, 0.3);
		}
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs ::v-deep .el-tabs__header {
	padding: 0 40px;
	margin: 20px 0 0;
	background: none;
	width: 100%;
	border-color: #d7d7d7;
	border-width: 0 0 0px;
	position: relative;
	float: left;
	border-style: solid;
	height: auto;
  }
  
  .center-preview .el-tabs ::v-deep .el-tabs__header .el-tabs__item {
  	padding: 0 10px;
  	margin: 0 10px 0 0;
  	color: #333;
  	font-weight: 500;
  	display: block;
  	font-size: 16px;
  	border-color: #d7d7d7;
  	line-height: 60px;
  	float: left;
  	background: none;
  	width: auto;
  	border-width: 0 0 2px;
  	position: relative;
  	border-style: solid;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview .el-tabs ::v-deep .el-tabs__header .el-tabs__item:hover {
  	padding: 0 10px;
  	color: #833cf7;
  	background: none;
  	font-weight: 600;
  	font-size: 16px;
  	border-color: #833cf7;
  	border-width: 0 0 2px;
  	line-height: 60px;
  	position: relative;
  	border-style: solid;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview .el-tabs ::v-deep .el-tabs__header .el-tabs__item.is-active {
  	padding: 0 10px;
  	margin: 0 10px 0 0;
  	color: #833cf7;
  	font-weight: 600;
  	display: block;
  	font-size: 16px;
  	border-color: #833cf7;
  	line-height: 60px;
  	float: left;
  	background: none;
  	width: auto;
  	border-width: 0 0 2px;
  	position: relative;
  	border-style: solid;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview .el-tabs ::v-deep .el-tabs__content {
  	padding: 0 20px 0 0;
  	margin: 20px 0 0;
  	background: #fff;
  	width: 100%;
  }
  .center-preview .el-tabs ::v-deep .el-tabs__content .el-tab-pane {
  }
  
  .center-preview-pv .el-form-item ::v-deep .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #333;
  	font-weight: 500;
  	width: 80px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 80px;
  }
  
  .center-preview-pv .el-input ::v-deep .el-input__inner {
  	padding: 0 12px;
  	color: #666;
  	font-size: 14px;
  	border-color: #333;
  	border-radius: 0px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	outline: none;
  	background: #fff;
  	width: auto;
  	border-width: 1px;
  	border-style: solid;
  	min-width: 300px;
  	height: 40px;
  }
  
  .center-preview-pv .el-select ::v-deep .el-input__inner {
  	padding: 0 12px;
  	color: #666;
  	font-size: 14px;
  	border-color: #333;
  	border-radius: 0px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	outline: none;
  	background: #fff;
  	width: auto;
  	border-width: 1px;
  	border-style: solid;
  	min-width: 300px;
  	height: 40px;
  }
  
  .center-preview-pv .el-date-editor ::v-deep .el-input__inner {
  	padding: 0 10px 0 30px;
  	color: #666;
  	font-size: 14px;
  	border-color: #333;
  	border-radius: 0px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	outline: none;
  	background: #fff;
  	width: auto;
  	border-width: 1px;
  	border-style: solid;
  	min-width: 300px;
  	height: 40px;
  }
  
  .center-preview-pv ::v-deep .avatar-uploader-icon {
  	cursor: pointer;
  	border-radius: 50px;
  	color: #333;
  	background: #fff;
  	width: 160px;
  	font-size: 32px;
  	border-color: #333;
  	border-width: 1px;
  	line-height: 60px;
  	border-style: solid;
  	text-align: center;
  	height: 60px;
  }
  
  .center-preview-pv .el-form-item.balance ::v-deep .el-input__inner {
  	border-radius: 0px;
  	padding: 0 12px;
  	color: #666;
  	background: #fff;
  	display: inline-block;
  	width: auto;
  	font-size: 14px;
  	border-color: #333;
  	border-width: 1px;
  	border-style: solid;
  	min-width: 300px;
  	height: 40px;
  }
</style>

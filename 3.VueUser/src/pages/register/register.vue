<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231026/ba2b6fee01214824bf4a72f3853b4ffc.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"minHeight":"90vh","padding":"50px 100px 50px 50%","margin":"50px auto","borderRadius":"0px","background":"none","width":"86%","position":"relative","height":"auto","zIndex":"2"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"width":"auto","margin":"0 0 20px","lineHeight":"1.5","fontSize":"24px","color":"#fff","textAlign":"center"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"margin":"0 0 20px","color":"#fff","textAlign":"center","width":"100%","letterSpacing":"2px","lineHeight":"1.5","fontSize":"24px"}'>房屋租赁管理系统注册</p></div>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='dichangongsi'" prop="gongsizhanghao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('gongsizhanghao')?'required':''">公司账号：</div>
				<el-input v-model="registerForm.gongsizhanghao"  placeholder="请输入公司账号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='dichangongsi'" prop="gongsimingcheng">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('gongsimingcheng')?'required':''">公司名称：</div>
				<el-input v-model="registerForm.gongsimingcheng"  placeholder="请输入公司名称" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='dichangongsi'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='dichangongsi'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='dichangongsi'" prop="tupian">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('tupian')?'required':''">图片：</div>
                <file-upload
					tip="点击上传图片"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.tupian?registerForm.tupian:''"
					@change="dichangongsitupianUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='dichangongsi'" prop="lianxiren">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('lianxiren')?'required':''">联系人：</div>
				<el-input v-model="registerForm.lianxiren"  placeholder="请输入联系人" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='dichangongsi'" prop="lianxidianhua">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
				<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='dichangongsi'" prop="gongsidizhi">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('gongsidizhi')?'required':''">公司地址：</div>
				<el-input v-model="registerForm.gongsidizhi"  placeholder="请输入公司地址" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="yonghuzhanghao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
				<el-input v-model="registerForm.yonghuzhanghao"  placeholder="请输入用户账号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="yonghuxingming">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
				<el-input v-model="registerForm.yonghuxingming"  placeholder="请输入用户姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="touxiang">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="yonghutouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingbie">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in yonghuxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}' v-if="tableName=='yonghu'" prop="shoujihaoma">
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' :class="changeRules('shoujihaoma')?'required':''">手机号码：</div>
				<el-input v-model="registerForm.shoujihaoma"  placeholder="请输入手机号码" />
			</el-form-item>
			<el-form-item v-if="tableName=='yonghu'" class="el-email" :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}'>
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' class="required">邮箱：</div>
				<div style="display: flex;flex: 1;">
					<input v-model="registerForm.email" :style='{"padding":"0 12px","margin":"0","outline":"none","borderColor":"#c7c7c7","color":"#606266","borderRadius":"0px","background":"none","borderWidth":"0 0 2px","width":"220px","fontSize":"14px","borderStyle":"solid","height":"40px"}' type="text" id="email" name="email" placeholder="请输入邮箱" autocomplete="off" class="el-input">
					<button v-if="isEndFlag" :style='{"cursor":"pointer","padding":"0","margin":"0 0 0 10px","borderColor":"#ddd","color":"#fff","outline":"none","borderRadius":"8px","background":"#7c3ef3","borderWidth":"0px","width":"100px","fontSize":"14px","borderStyle":"solid","height":"40px"}' @click="sendemailcode" id="sendemailcode" type="button" class="el-btn">发送验证码</button>
					<button v-if="!isEndFlag" disabled="disabled" :style='{"cursor":"pointer","padding":"0","margin":"0 0 0 10px","borderColor":"#ddd","color":"#fff","outline":"none","borderRadius":"8px","background":"#7c3ef3","borderWidth":"0px","width":"100px","fontSize":"14px","borderStyle":"solid","height":"40px"}' type="button" class="el-btn">{{count}}秒后重发</button>
				</div>
			</el-form-item>
			<el-form-item v-if="tableName=='yonghu'" class="el-email" :style='{"width":"100%","padding":"0","margin":"0 auto 20px","height":"auto"}'>
				<div v-if="true" :style='{"padding":"0 10px","color":"#fff","textAlign":"right","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","minWidth":"80px"}' class="required">验证码：</div>
				<el-input v-model="emailcode" type="text" id="emailcode" name="emailcode" placeholder="请输入验证码" autocomplete="off" class="el-input" />
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px auto 5px","color":"#fff","display":"block","float":"right","outline":"none","borderRadius":"100%","background":"#7c3ef3","width":"80px","fontSize":"16px","height":"80px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0px auto 0px","color":"#666","textAlign":"right","display":"none","outline":"none","borderRadius":"8px","background":"none","width":"80%","fontSize":"16px","height":"44px"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0","margin":"60px 0 0","color":"#ccc","display":"inline-block","lineHeight":"1","fontSize":"14px","textDecoration":"none"}' to="/login">已有账户登录</router-link>
			<div class="idea1" :style='{"top":"0","left":"0","background":"url(http://codegen.caihongy.cn/20231026/e27f5cab1b6a400a88a1dc7a3693864c.jpg) no-repeat  center top / cover","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"-2"}'></div>
			<div class="idea2" :style='{"top":"0","background":"rgba(0,0,0,.75)","display":"block","width":"50%","position":"absolute","right":"0","height":"100%","zIndex":"-1"}'></div>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
            emailcode:'',
			//倒计时60s
			count: 60,
			//倒计时定时器
			inter: null,
			//倒计结束标识
			isEndFlag: true,
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='dichangongsi'){
				this.registerForm = {
					gongsizhanghao: '',
					gongsimingcheng: '',
					mima: '',
					mima2: '',
					tupian: '',
					lianxiren: '',
					lianxidianhua: '',
					gongsidizhi: '',
				}
			}
			if(this.tableName=='yonghu'){
				this.registerForm = {
					yonghuzhanghao: '',
					mima: '',
					mima2: '',
					yonghuxingming: '',
					touxiang: '',
					xingbie: '',
					shoujihaoma: '',
					email: '',
				}
			}
			if ('dichangongsi' == this.tableName) {
				this.requiredRules.gongsizhanghao = [{ required: true, message: '请输入公司账号', trigger: 'blur' }]
			}
			if ('dichangongsi' == this.tableName) {
				this.requiredRules.gongsimingcheng = [{ required: true, message: '请输入公司名称', trigger: 'blur' }]
			}
			if ('dichangongsi' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
		if(this.$route.query.pageFlag=='register'){
		  if ('dichangongsi' == this.tableName) {
			this.rules.gongsizhanghao = [{ required: true, message: '请输入公司账号', trigger: 'blur' }];
		  }
		  if ('dichangongsi' == this.tableName) {
			this.rules.gongsimingcheng = [{ required: true, message: '请输入公司名称', trigger: 'blur' }];
		  }
		  if ('dichangongsi' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('dichangongsi' == this.tableName) {
			this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }];
		  }
			this.yonghuxingbieOptions = "男,女".split(',');
		  if ('yonghu' == this.tableName) {
			this.rules.shoujihaoma = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.email = [{ required: true, validator: this.$validate.isEmail, trigger: 'blur' }];
		  }
		}
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      dichangongsitupianUploadChange(fileUrls) {
          this.registerForm.tupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      yonghutouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数

        sendemailcode() {
            if(!this.registerForm.email){
              this.$message.error(`邮箱不能为空`);
              return
            }
            let emailF = this.$validate.isEmail2(this.registerForm.email);
            if(this.registerForm.email&&(!this.$validate.isEmail2(this.registerForm.email))){
              this.$message.error(`请输入正确的邮箱格式`);
              return
            }
            this.isEndFlag = false;
            var _this = this;
            this.inter = window.setInterval(function() {
                _this.count = _this.count - 1;
                if (_this.count <= 0) {
                  window.clearInterval(_this.inter);
                  _this.isEndFlag = true;
                  _this.count=60;
                }
            }, 1000);
            this.$http({
              url: `${this.tableName}/sendemail?email=`+this.registerForm.email,
              method: "get",
              params: {}
            }).then(({ data }) => {
              if (data && data.code === 0) {
                  this.$message.success(`发送成功`);
              } else {
                  this.$message.error(`服务器异常，请稍后重试`)
              }
            });
        },

      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
				if((!this.registerForm.gongsizhanghao) && `dichangongsi` == this.tableName){
					this.$message.error(`公司账号不能为空`);
					return
				}
				if((!this.registerForm.gongsimingcheng) && `dichangongsi` == this.tableName){
					this.$message.error(`公司名称不能为空`);
					return
				}
               if(`dichangongsi` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `dichangongsi` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
					if(`dichangongsi` == this.tableName && this.registerForm.lianxidianhua &&(!this.$validate.isMobile2(this.registerForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
              if(`yonghu` == this.tableName ){
                url=this.tableName+"/register?emailcode="+this.emailcode;
                if(this.registerForm.email&&(!this.$validate.isEmail2(this.registerForm.email))){
                        this.$message.error(`请输入正确的邮箱格式`);
                        return
                }
              }
              if((!this.emailcode) && `yonghu` == this.tableName){
                this.$message.error(`验证码不能为空`);
                return
              }
				if((!this.registerForm.yonghuzhanghao) && `yonghu` == this.tableName){
					this.$message.error(`用户账号不能为空`);
					return
				}
               if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `yonghu` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.yonghuxingming) && `yonghu` == this.tableName){
					this.$message.error(`用户姓名不能为空`);
					return
				}
					if(`yonghu` == this.tableName && this.registerForm.shoujihaoma &&(!this.$validate.isMobile2(this.registerForm.shoujihaoma))){
						this.$message.error(`手机号码应输入手机格式`);
						return
					}
					if(`yonghu` == this.tableName && this.registerForm.email &&(!this.$validate.isEmail2(this.registerForm.email))){
						this.$message.error(`邮箱应输入邮件格式`);
						return
					}
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20231026/ba2b6fee01214824bf4a72f3853b4ffc.jpg);
		
		.el-input {
		  width: auto;
		}
		
		.el-date-editor.el-input {
			width: auto;
		}
		
		.el-form-item ::v-deep .el-form-item__content {
						display: flex;
						width: 100%;
						flex-wrap: wrap;
					}
		
		.rgs-form .el-input ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						outline: none;
						color: #666;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #c7c7c7;
						border-width: 0 0 2px;
						border-style: solid;
						min-width: 330px;
						height: 40px;
					}
		
		.rgs-form .el-select ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						outline: none;
						color: #666;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #c7c7c7;
						border-width: 0 0 2px;
						border-style: solid;
						min-width: 330px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #666;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #c7c7c7;
						border-width: 0 0 2px;
						border-style: solid;
						min-width: 330px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor ::v-deep .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #666;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #c7c7c7;
						border-width: 0 0 2px;
						border-style: solid;
						min-width: 330px;
						height: 40px;
					}
		
		.rgs-form ::v-deep .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form ::v-deep .upload .upload-img {
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #ccc;
		  		  font-weight: 600;
		  		  width: 100px;
		  		  font-size: 24px;
		  		  border-color: #c7c7c7;
		  		  border-width: 2px;
		  		  line-height: 60px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form ::v-deep .el-upload-list .el-upload-list__item {
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #ccc;
		  		  font-weight: 600;
		  		  width: 100px;
		  		  font-size: 24px;
		  		  border-color: #c7c7c7;
		  		  border-width: 2px;
		  		  line-height: 60px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form ::v-deep .el-upload .el-icon-plus {
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #ccc;
		  		  font-weight: 600;
		  		  width: 100px;
		  		  font-size: 24px;
		  		  border-color: #c7c7c7;
		  		  border-width: 2px;
		  		  line-height: 60px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: 68px;
				position: absolute;
				content: "*";
				order: 2;
			}
</style>

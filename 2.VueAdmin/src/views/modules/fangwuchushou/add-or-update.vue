<template>
	<div class="addEdit-block" :style='{"width":"100%","padding":"50px 0 30px 0","margin":"0","overflow-y":"auto","background":"#fff","height":"auto"}'>
		<el-form
			:style='{"padding":"0"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="房屋名称" prop="fangwumingcheng">
					<el-input v-model="ruleForm.fangwumingcheng" placeholder="房屋名称" clearable  :readonly="ro.fangwumingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="房屋名称" prop="fangwumingcheng">
					<el-input v-model="ruleForm.fangwumingcheng" placeholder="房屋名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.fangwufengmian" label="房屋封面" prop="fangwufengmian">
					<file-upload
						tip="点击上传房屋封面"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.fangwufengmian?ruleForm.fangwufengmian:''"
						@change="fangwufengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.fangwufengmian" label="房屋封面" prop="fangwufengmian">
					<img v-if="ruleForm.fangwufengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fangwufengmian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fangwufengmian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="房屋类型" prop="fangwuleixing">
					<el-select :disabled="ro.fangwuleixing" v-model="ruleForm.fangwuleixing" placeholder="请选择房屋类型" >
						<el-option
							v-for="(item,index) in fangwuleixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="房屋类型" prop="fangwuleixing">
					<el-input v-model="ruleForm.fangwuleixing"
						placeholder="房屋类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="房屋面积" prop="fangwumianji">
					<el-input v-model="ruleForm.fangwumianji" placeholder="房屋面积" clearable  :readonly="ro.fangwumianji"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="房屋面积" prop="fangwumianji">
					<el-input v-model="ruleForm.fangwumianji" placeholder="房屋面积" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="售价" prop="shoujia">
					<el-input v-model.number="ruleForm.shoujia" placeholder="售价" clearable  :readonly="ro.shoujia"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="售价" prop="shoujia">
					<el-input v-model="ruleForm.shoujia" placeholder="售价" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="房屋地址" prop="fangwudizhi">
					<el-input v-model="ruleForm.fangwudizhi" placeholder="房屋地址" clearable  :readonly="ro.fangwudizhi"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="房屋地址" prop="fangwudizhi">
					<el-input v-model="ruleForm.fangwudizhi" placeholder="房屋地址" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="户主" prop="huzhu">
					<el-input v-model="ruleForm.huzhu" placeholder="户主" clearable  :readonly="ro.huzhu"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="户主" prop="huzhu">
					<el-input v-model="ruleForm.huzhu" placeholder="户主" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="联系方式" prop="lianxifangshi">
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" clearable  :readonly="ro.lianxifangshi"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="联系方式" prop="lianxifangshi">
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="出售状态" prop="chushouzhuangtai">
					<el-select :disabled="ro.chushouzhuangtai" v-model="ruleForm.chushouzhuangtai" placeholder="请选择出售状态" >
						<el-option
							v-for="(item,index) in chushouzhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="出售状态" prop="chushouzhuangtai">
					<el-input v-model="ruleForm.chushouzhuangtai"
						placeholder="出售状态" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="公司账号" prop="gongsizhanghao">
					<el-input v-model="ruleForm.gongsizhanghao" placeholder="公司账号" clearable  :readonly="ro.gongsizhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="公司账号" prop="gongsizhanghao">
					<el-input v-model="ruleForm.gongsizhanghao" placeholder="公司账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="公司名称" prop="gongsimingcheng">
					<el-input v-model="ruleForm.gongsimingcheng" placeholder="公司名称" clearable  :readonly="ro.gongsimingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="公司名称" prop="gongsimingcheng">
					<el-input v-model="ruleForm.gongsimingcheng" placeholder="公司名称" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="type!='info'"  label="房屋详情" prop="fangwuxiangqing">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.fangwuxiangqing" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.fangwuxiangqing" label="房屋详情" prop="fangwuxiangqing">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.fangwuxiangqing"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao16" :style='{"margin":"0 2px","fontSize":"14px","color":" rgb(134, 150, 176)","height":"40px"}'></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-shanchu16" :style='{"margin":"0 2px","fontSize":"14px","color":"rgb(134, 150, 176)","height":"40px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui13" :style='{"margin":"0 2px","fontSize":"14px","color":"rgb(134, 150, 176)","height":"40px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				fangwumingcheng : false,
				fangwufengmian : false,
				fangwuleixing : false,
				fangwumianji : false,
				shoujia : false,
				fangwudizhi : false,
				huzhu : false,
				lianxifangshi : false,
				fangwuxiangqing : false,
				chushouzhuangtai : false,
				gongsizhanghao : false,
				gongsimingcheng : false,
				storeupnum : false,
			},
			
			
			ruleForm: {
				fangwumingcheng: '',
				fangwufengmian: '',
				fangwuleixing: '',
				fangwumianji: '',
				shoujia: '',
				fangwudizhi: '',
				huzhu: '',
				lianxifangshi: '',
				fangwuxiangqing: '',
				chushouzhuangtai: '未出售',
				gongsizhanghao: '',
				gongsimingcheng: '',
			},
		
			fangwuleixingOptions: [],
			chushouzhuangtaiOptions: [],

			
			rules: {
				fangwumingcheng: [
					{ required: true, message: '房屋名称不能为空', trigger: 'blur' },
				],
				fangwufengmian: [
				],
				fangwuleixing: [
					{ required: true, message: '房屋类型不能为空', trigger: 'blur' },
				],
				fangwumianji: [
					{ required: true, message: '房屋面积不能为空', trigger: 'blur' },
				],
				shoujia: [
					{ required: true, message: '售价不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				fangwudizhi: [
				],
				huzhu: [
				],
				lianxifangshi: [
				],
				fangwuxiangqing: [
				],
				chushouzhuangtai: [
				],
				gongsizhanghao: [
				],
				gongsimingcheng: [
				],
				storeupnum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='fangwumingcheng'){
							this.ruleForm.fangwumingcheng = obj[o];
							this.ro.fangwumingcheng = true;
							continue;
						}
						if(o=='fangwufengmian'){
							this.ruleForm.fangwufengmian = obj[o];
							this.ro.fangwufengmian = true;
							continue;
						}
						if(o=='fangwuleixing'){
							this.ruleForm.fangwuleixing = obj[o];
							this.ro.fangwuleixing = true;
							continue;
						}
						if(o=='fangwumianji'){
							this.ruleForm.fangwumianji = obj[o];
							this.ro.fangwumianji = true;
							continue;
						}
						if(o=='shoujia'){
							this.ruleForm.shoujia = obj[o];
							this.ro.shoujia = true;
							continue;
						}
						if(o=='fangwudizhi'){
							this.ruleForm.fangwudizhi = obj[o];
							this.ro.fangwudizhi = true;
							continue;
						}
						if(o=='huzhu'){
							this.ruleForm.huzhu = obj[o];
							this.ro.huzhu = true;
							continue;
						}
						if(o=='lianxifangshi'){
							this.ruleForm.lianxifangshi = obj[o];
							this.ro.lianxifangshi = true;
							continue;
						}
						if(o=='fangwuxiangqing'){
							this.ruleForm.fangwuxiangqing = obj[o];
							this.ro.fangwuxiangqing = true;
							continue;
						}
						if(o=='chushouzhuangtai'){
							this.ruleForm.chushouzhuangtai = obj[o];
							this.ro.chushouzhuangtai = true;
							continue;
						}
						if(o=='gongsizhanghao'){
							this.ruleForm.gongsizhanghao = obj[o];
							this.ro.gongsizhanghao = true;
							continue;
						}
						if(o=='gongsimingcheng'){
							this.ruleForm.gongsimingcheng = obj[o];
							this.ro.gongsimingcheng = true;
							continue;
						}
						if(o=='storeupnum'){
							this.ruleForm.storeupnum = obj[o];
							this.ro.storeupnum = true;
							continue;
						}
				}
				










				this.ruleForm.chushouzhuangtai = '未出售'; 


			}
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.gongsizhanghao!=''&&json.gongsizhanghao) || json.gongsizhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.gongsizhanghao = json.gongsizhanghao
						this.ro.gongsizhanghao = true;
					}
					if(((json.gongsimingcheng!=''&&json.gongsimingcheng) || json.gongsimingcheng==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.gongsimingcheng = json.gongsimingcheng
						this.ro.gongsimingcheng = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/fangwuleixing/fangwuleixing`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.fangwuleixingOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
            this.chushouzhuangtaiOptions = "已出售,未出售".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `fangwuchushou/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.fangwuxiangqing = this.ruleForm.fangwuxiangqing.replace(reg,'../../../springboot02098g12/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {


	if(this.ruleForm.fangwufengmian!=null) {
		this.ruleForm.fangwufengmian = this.ruleForm.fangwufengmian.replace(new RegExp(this.$base.url,"g"),"");
	}












var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "fangwuchushou/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `fangwuchushou/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.fangwuchushouCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `fangwuchushou/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.fangwuchushouCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
			   }
			});
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.fangwuchushouCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    fangwufengmianUploadChange(fileUrls) {
	    this.ruleForm.fangwufengmian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 180px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input ::v-deep .el-input__inner {
	  	  border: 1px solid rgb(201, 208, 220);
	  	  border-radius: 20px;
	  	  padding: 0 12px;
	  	  color: rgb(134, 150, 176);
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number ::v-deep .el-input__inner {
		text-align: left;
	  	  border: 1px solid rgb(201, 208, 220);
	  	  border-radius: 20px;
	  	  padding: 0 12px;
	  	  color: rgb(134, 150, 176);
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number ::v-deep .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number ::v-deep .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select ::v-deep .el-input__inner {
	  	  border: 1px solid rgb(201, 208, 220);
	  	  border-radius: 20px;
	  	  padding: 0 10px;
	  	  color:  rgb(134, 150, 176);
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor ::v-deep .el-input__inner {
	  	  border: 1px solid rgb(201, 208, 220);
	  	  border-radius: 20px;
	  	  padding: 0 10px 0 30px;
	  	  color: rgb(134, 150, 176);
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview ::v-deep .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview ::v-deep .upload .upload-img {
	  	  border: 1px dashed rgb(201, 208, 220);
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color:  rgb(201, 208, 220);
	  	  width: 100px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview ::v-deep .el-upload-list .el-upload-list__item {
	  	  border: 1px dashed rgb(201, 208, 220);
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color:  rgb(201, 208, 220);
	  	  width: 100px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview ::v-deep .el-upload .el-icon-plus {
	  	  border: 1px dashed rgb(201, 208, 220);
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color:  rgb(201, 208, 220);
	  	  width: 100px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview .el-textarea ::v-deep .el-textarea__inner {
	  	  border: 1px solid rgb(201, 208, 220);
	  	  border-radius: 20px;
	  	  padding: 12px;
	  	  color: rgb(201, 208, 220);
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 1px solid rgb(201, 208, 220);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: rgb(134, 150, 176);
				background: #fff;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 1px solid rgb(201, 208, 220);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: rgb(134, 150, 176);
				background: #fff;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 1px solid rgb(201, 208, 220);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color:  rgb(134, 150, 176);
				background: #fff;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border:  1px solid rgb(201, 208, 220);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: rgb(134, 150, 176);
				background: #fff;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border:  1px solid rgb(201, 208, 220);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: rgb(134, 150, 176);
				background: #fff;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				opacity: 0.8;
			}
</style>

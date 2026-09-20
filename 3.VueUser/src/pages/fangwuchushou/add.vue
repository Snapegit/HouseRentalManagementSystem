<template>
<div :style='{"width":"100%","padding":"100px 18% 60px","margin":"0px auto","position":"relative","background":"url(http://codegen.caihongy.cn/20231029/b89b677f7bba41d694305c19dc3b820d.jpg) no-repeat center top,#fff"}'>
    <el-form
	  :style='{"border":"1px solid #333","width":"100%","padding":"30px","position":"relative","background":"#fcfcfc"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="房屋名称" prop="fangwumingcheng">
            <el-input v-model="ruleForm.fangwumingcheng" 
                placeholder="房屋名称" clearable :disabled=" false  ||ro.fangwumingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="房屋封面" v-if="type!='cross' || (type=='cross' && !ro.fangwufengmian)" prop="fangwufengmian">
            <file-upload
            tip="点击上传房屋封面"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.fangwufengmian?ruleForm.fangwufengmian:''"
            @change="fangwufengmianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' class="upload" v-else label="房屋封面" prop="fangwufengmian">
                <img v-if="ruleForm.fangwufengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fangwufengmian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fangwufengmian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}'  label="房屋类型" prop="fangwuleixing">
            <el-select v-model="ruleForm.fangwuleixing" placeholder="请选择房屋类型" :disabled=" false  ||ro.fangwuleixing" >
              <el-option
                  v-for="(item,index) in fangwuleixingOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="房屋面积" prop="fangwumianji">
            <el-input v-model="ruleForm.fangwumianji" 
                placeholder="房屋面积" clearable :disabled=" false  ||ro.fangwumianji"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="售价" prop="shoujia">
            <el-input v-model.number="ruleForm.shoujia" 
                placeholder="售价" clearable :disabled=" false  ||ro.shoujia"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="房屋地址" prop="fangwudizhi">
            <el-input v-model="ruleForm.fangwudizhi" 
                placeholder="房屋地址" clearable :disabled=" false  ||ro.fangwudizhi"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="户主" prop="huzhu">
            <el-input v-model="ruleForm.huzhu" 
                placeholder="户主" clearable :disabled=" false  ||ro.huzhu"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="联系方式" prop="lianxifangshi">
            <el-input v-model="ruleForm.lianxifangshi" 
                placeholder="联系方式" clearable :disabled=" false  ||ro.lianxifangshi"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}'  label="出售状态" prop="chushouzhuangtai">
            <el-select v-model="ruleForm.chushouzhuangtai" placeholder="请选择出售状态" :disabled=" false  ||ro.chushouzhuangtai" >
              <el-option
                  v-for="(item,index) in chushouzhuangtaiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="公司账号" prop="gongsizhanghao">
            <el-input v-model="ruleForm.gongsizhanghao" 
                placeholder="公司账号" clearable :disabled=" false  ||ro.gongsizhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="公司名称" prop="gongsimingcheng">
            <el-input v-model="ruleForm.gongsimingcheng" 
                placeholder="公司名称" clearable :disabled=" false  ||ro.gongsimingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="房屋详情" prop="fangwuxiangqing">
            <editor 
                :style='{"minHeight":"250px","padding":"0","margin":"0","borderColor":"#1abc9e30","backgroundColor":"none","borderRadius":"0","borderWidth":"0px","background":"#fff","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.fangwuxiangqing" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#833cf6","width":"110px","lineHeight":"36px","fontSize":"14px","height":"36px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid #eee","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#000","width":"110px","lineHeight":"36px","fontSize":"14px","height":"36px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
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
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
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
          chushouzhuangtai: '未出售' ,
          gongsizhanghao: '',
          gongsimingcheng: '',
          storeupnum: '',
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
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
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
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='fangwumingcheng'){
              this.ruleForm.fangwumingcheng = obj[o];
              this.ro.fangwumingcheng = true;
              continue;
            }
            if(o=='fangwufengmian'){
              this.ruleForm.fangwufengmian = obj[o].split(",")[0];
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
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.gongsizhanghao!=''&&json.gongsizhanghao) || json.gongsizhanghao==0){
                this.ruleForm.gongsizhanghao = json.gongsizhanghao
            }
            if((json.gongsimingcheng!=''&&json.gongsimingcheng) || json.gongsimingcheng==0){
                this.ruleForm.gongsimingcheng = json.gongsimingcheng
            }
          }
        });
        this.$http.get('option/fangwuleixing/fangwuleixing', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.fangwuleixingOptions = res.data.data;
          }
        });
        this.chushouzhuangtaiOptions = "已出售,未出售".split(',')

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`fangwuchushou/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('fangwuchushou/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`fangwuchushou/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`fangwuchushou/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
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
			this.$router.go(-1);
		},
      fangwufengmianUploadChange(fileUrls) {
          this.ruleForm.fangwufengmian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #000;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item ::v-deep .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input ::v-deep .el-input__inner {
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
	.add-update-preview .el-input-number ::v-deep .el-input__inner {
		text-align: left;
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
	.add-update-preview .el-input-number ::v-deep .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number ::v-deep .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select ::v-deep .el-input__inner {
	  border-radius: 0px;
	  padding: 0 10px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #333;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 300px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor ::v-deep .el-input__inner {
	  border-radius: 0px;
	  padding: 0 10px 0 30px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #333;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 300px;
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
	
	.add-update-preview ::v-deep .el-upload-list .el-upload-list__item {
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
	
	.add-update-preview ::v-deep .el-upload .el-icon-plus {
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
	
	.add-update-preview .el-textarea ::v-deep .el-textarea__inner {
	  border: 1px solid #333;
	  border-radius: 0px;
	  padding: 12px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  min-width: 500px;
	  height: 120px;
	}
</style>

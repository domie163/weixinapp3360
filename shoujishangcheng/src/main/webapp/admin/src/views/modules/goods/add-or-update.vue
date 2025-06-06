





<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}"
        >
            <el-row>
                                    <input id="updateId" name="id" type="hidden">
                                   <el-col :span="12">
                                       <el-form-item class="input" v-if="type!='info'"  label="商品名称" prop="goodsName">
                                           <el-input v-model="ruleForm.goodsName"
                                                     placeholder="商品名称" clearable  :readonly="ro.goodsName"></el-input>
                                       </el-form-item>
                                       <div v-else>
                                           <el-form-item class="input" label="商品名称" prop="goodsName">
                                               <el-input v-model="ruleForm.goodsName"
                                                         placeholder="商品名称" readonly></el-input>
                                           </el-form-item>
                                       </div>
                                   </el-col>
                                 <el-col :span="12">
                                     <el-form-item class="select" v-if="type!='info'"  label="商品分类" prop="goodsTypes">
                                         <el-select v-model="ruleForm.goodsTypes" placeholder="请选择商品分类">
                                             <el-option
                                                     v-for="(item,index) in goodsTypesOptions"
                                                     v-bind:key="item.codeIndex"
                                                     :label="item.indexName"
                                                     :value="item.codeIndex">
                                             </el-option>
                                         </el-select>
                                     </el-form-item>
                                     <div v-else>
                                         <el-form-item class="input" label="商品分类" prop="goodsValue">
                                             <el-input v-model="ruleForm.goodsValue"
                                                       placeholder="商品分类" readonly></el-input>
                                         </el-form-item>
                                     </div>
                                 </el-col>
                                 <el-col :span="12">
                                     <el-form-item class="select" v-if="type!='info'"  label="商品标签" prop="goodsBiaoqianTypes">
                                         <el-select v-model="ruleForm.goodsBiaoqianTypes" placeholder="请选择商品标签">
                                             <el-option
                                                     v-for="(item,index) in goodsBiaoqianTypesOptions"
                                                     v-bind:key="item.codeIndex"
                                                     :label="item.indexName"
                                                     :value="item.codeIndex">
                                             </el-option>
                                         </el-select>
                                     </el-form-item>
                                     <div v-else>
                                         <el-form-item class="input" label="商品标签" prop="goodsBiaoqianValue">
                                             <el-input v-model="ruleForm.goodsBiaoqianValue"
                                                       placeholder="商品标签" readonly></el-input>
                                         </el-form-item>
                                     </div>
                                 </el-col>
                                     <el-col :span="24">
                                         <el-form-item class="upload" v-if="type!='info' && !ro.goodsPhoto" label="图片" prop="goodsPhoto">
                                             <file-upload
                                                     tip="点击上传图片"
                                                     action="file/upload"
                                                     :limit="3"
                                                     :multiple="true"
                                                     :fileUrls="ruleForm.goodsPhoto?ruleForm.goodsPhoto:''"
                                                     @change="goodsPhotoUploadChange"
                                             ></file-upload>
                                         </el-form-item>
                                         <div v-else>
                                             <el-form-item v-if="ruleForm.goodsPhoto" label="图片" prop="goodsPhoto">
                                                 <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.goodsPhoto || '').split(',')" :src="item" width="100" height="100">
                                             </el-form-item>
                                         </div>
                                     </el-col>
                                   <el-col :span="12">
                                       <el-form-item class="input" v-if="type!='info'"  label="品牌" prop="goodsPinpai">
                                           <el-input v-model="ruleForm.goodsPinpai"
                                                     placeholder="品牌" clearable  :readonly="ro.goodsPinpai"></el-input>
                                       </el-form-item>
                                       <div v-else>
                                           <el-form-item class="input" label="品牌" prop="goodsPinpai">
                                               <el-input v-model="ruleForm.goodsPinpai"
                                                         placeholder="品牌" readonly></el-input>
                                           </el-form-item>
                                       </div>
                                   </el-col>
                                   <el-col :span="12">
                                       <el-form-item class="input" v-if="type!='info'"  label="规格" prop="goodsGuige">
                                           <el-input v-model="ruleForm.goodsGuige"
                                                     placeholder="规格" clearable  :readonly="ro.goodsGuige"></el-input>
                                       </el-form-item>
                                       <div v-else>
                                           <el-form-item class="input" label="规格" prop="goodsGuige">
                                               <el-input v-model="ruleForm.goodsGuige"
                                                         placeholder="规格" readonly></el-input>
                                           </el-form-item>
                                       </div>
                                   </el-col>
								   <el-col :span="12">
								       <el-form-item class="select" v-if="type!='info'"  label="是否特卖" prop="goodsTemaiTypes">
								           <el-select v-model="ruleForm.goodsTemaiTypes" placeholder="请选择是否特卖">
								               <el-option
								                       v-for="(item,index) in goodsTemaiTypesOptions"
								                       v-bind:key="item.codeIndex"
								                       :label="item.indexName"
								                       :value="item.codeIndex">
								               </el-option>
								           </el-select>
								       </el-form-item>
								       <div v-else>
								           <el-form-item class="input" label="是否特卖" prop="goodsTemaiValue">
								               <el-input v-model="ruleForm.goodsTemaiValue"
								                         placeholder="是否特卖" readonly></el-input>
								           </el-form-item>
								       </div>
								   </el-col>
								   
                                   <el-col :span="12">
                                       <el-form-item class="input" v-if="type!='info'"  label="现价" prop="goodsNewMoney">
                                           <el-input v-model="ruleForm.goodsNewMoney"
                                                     placeholder="现价" clearable  :readonly="ro.goodsNewMoney"></el-input>
                                       </el-form-item>
                                       <div v-else>
                                           <el-form-item class="input" label="现价" prop="goodsNewMoney">
                                               <el-input v-model="ruleForm.goodsNewMoney"
                                                         placeholder="现价" readonly></el-input>
                                           </el-form-item>
                                       </div>
                                   </el-col>
                                 <el-col :span="24">
                                     <el-form-item v-if="type!='info'"  label="商品详情" prop="goodsContent">
                                         <editor style="min-width: 200px; max-width: 600px;"
                                                 v-model="ruleForm.goodsContent"
                                                 class="editor"
                                                 action="file/upload">
                                         </editor>
                                     </el-form-item>
                                     <div v-else>
                                         <el-form-item v-if="ruleForm.goodsContent" label="商品详情" prop="goodsContent">
                                             <span v-html="ruleForm.goodsContent"></span>
                                         </el-form-item>
                                     </div>
                                 </el-col>

            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>


    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                ro:{
                    goodsName: false,
                    goodsTypes: false,
                    goodsBiaoqianTypes: false,
                    goodsPhoto: false,
                    goodsPinpai: false,
                    goodsGuige: false,
                    goodsNewMoney: false,
                    goodsClickTime: false,
                    goodsClickNumber: false,
                    goodsContent: false,
                    goodsTemaiTypes: false,
                    insertTime: false,
                },
                ruleForm: {
                    goodsName: '',
                    goodsTypes: '',
                    goodsBiaoqianTypes: '',
                    goodsPhoto: '',
                    goodsPinpai: '',
                    goodsGuige: '',
                    goodsNewMoney: '',
                    goodsClickTime: '',
                    goodsClickNumber: '',
                    goodsContent: '',
                    goodsTemaiTypes: '',
                    insertTime: '',
                },
                goodsTypesOptions : [],
                goodsBiaoqianTypesOptions : [],
                goodsTemaiTypesOptions : [],
                rules: {
                   goodsName: [
                              { required: true, message: '商品名称不能为空', trigger: 'blur' },
                          ],
                   goodsTypes: [
                              { required: true, message: '商品分类不能为空', trigger: 'blur' },
                          ],
                   goodsBiaoqianTypes: [
                              { required: true, message: '商品标签不能为空', trigger: 'blur' },
                          ],
                   goodsPhoto: [
                              { required: true, message: '图片不能为空', trigger: 'blur' },
                          ],
                   goodsPinpai: [
                              { required: true, message: '品牌不能为空', trigger: 'blur' },
                          ],
                   goodsGuige: [
                              { required: true, message: '规格不能为空', trigger: 'blur' },
                          ],
                   goodsNewMoney: [
                              { required: true, message: '现价不能为空', trigger: 'blur' },
                          ],
                   goodsClickTime: [
                              { required: true, message: '最近点击时间不能为空', trigger: 'blur' },
                          ],
                   goodsClickNumber: [
                              { required: true, message: '点击次数不能为空', trigger: 'blur' },
                          ],
                   goodsContent: [
                              { required: true, message: '商品详情不能为空', trigger: 'blur' },
                          ],
                   goodsTemaiTypes: [
                              { required: true, message: '是否特卖不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '创建时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=goods_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
            this.goodsTypesOptions = data.data.list;
        }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=goods_biaoqian_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
            this.goodsBiaoqianTypesOptions = data.data.list;
        }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=goods_temai_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
            this.goodsTemaiTypesOptions = data.data.list;
        }
                });

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
                }else if(this.type=='cross'){
                    var obj = this.$storage.getObj('crossObj');
                    for (var o in obj){

                      if(o=='goodsName'){
                          this.ruleForm.goodsName = obj[o];
                          this.ro.goodsName = true;
                          continue;
                      }
                      if(o=='goodsTypes'){
                          this.ruleForm.goodsTypes = obj[o];
                          this.ro.goodsTypes = true;
                          continue;
                      }
                      if(o=='goodsBiaoqianTypes'){
                          this.ruleForm.goodsBiaoqianTypes = obj[o];
                          this.ro.goodsBiaoqianTypes = true;
                          continue;
                      }
                      if(o=='goodsPhoto'){
                          this.ruleForm.goodsPhoto = obj[o];
                          this.ro.goodsPhoto = true;
                          continue;
                      }
                      if(o=='goodsPinpai'){
                          this.ruleForm.goodsPinpai = obj[o];
                          this.ro.goodsPinpai = true;
                          continue;
                      }
                      if(o=='goodsGuige'){
                          this.ruleForm.goodsGuige = obj[o];
                          this.ro.goodsGuige = true;
                          continue;
                      }
                      if(o=='goodsNewMoney'){
                          this.ruleForm.goodsNewMoney = obj[o];
                          this.ro.goodsNewMoney = true;
                          continue;
                      }
                      if(o=='goodsClickTime'){
                          this.ruleForm.goodsClickTime = obj[o];
                          this.ro.goodsClickTime = true;
                          continue;
                      }
                      if(o=='goodsClickNumber'){
                          this.ruleForm.goodsClickNumber = obj[o];
                          this.ro.goodsClickNumber = true;
                          continue;
                      }
                      if(o=='goodsContent'){
                          this.ruleForm.goodsContent = obj[o];
                          this.ro.goodsContent = true;
                          continue;
                      }
                      if(o=='goodsTemaiTypes'){
                          this.ruleForm.goodsTemaiTypes = obj[o];
                          this.ro.goodsTemaiTypes = true;
                          continue;
                      }
                      if(o=='insertTime'){
                          this.ruleForm.insertTime = obj[o];
                          this.ro.insertTime = true;
                          continue;
                      }
                    }
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                    var json = data.data;
                } else {
                    this.$message.error(data.msg);
                }
            });


            },
            // 多级联动参数
            info(id) {
                this.$http({
                    url: `goods/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                    this.ruleForm = data.data;
                    //解决前台上传图片后台不显示的问题
                    let reg=new RegExp('../../../upload','g')//g代表全部
                } else {
                    this.$message.error(data.msg);
                }
            });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`goods/${!this.ruleForm.id ? "save" : "update"}`,
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
                            this.parent.goodsCrossAddOrUpdateFlag = false;
                            this.parent.search();
                            this.parent.contentStyleChange();
                        }
                        });
                        } else {
                            this.$message.error(data.msg);
                        }
                    });
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
                this.parent.goodsCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
    //图片
            goodsPhotoUploadChange(fileUrls){
                    this.ruleForm.goodsPhoto = fileUrls;
                    this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                    el.style.height = this.addEditForm.inputHeight
                el.style.color = this.addEditForm.inputFontColor
                el.style.fontSize = this.addEditForm.inputFontSize
                el.style.borderWidth = this.addEditForm.inputBorderWidth
                el.style.borderStyle = this.addEditForm.inputBorderStyle
                el.style.borderColor = this.addEditForm.inputBorderColor
                el.style.borderRadius = this.addEditForm.inputBorderRadius
                el.style.backgroundColor = this.addEditForm.inputBgColor
            })
                document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                    el.style.lineHeight = this.addEditForm.inputHeight
                el.style.color = this.addEditForm.inputLableColor
                el.style.fontSize = this.addEditForm.inputLableFontSize
            })
                // select
                document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                    el.style.height = this.addEditForm.selectHeight
                el.style.color = this.addEditForm.selectFontColor
                el.style.fontSize = this.addEditForm.selectFontSize
                el.style.borderWidth = this.addEditForm.selectBorderWidth
                el.style.borderStyle = this.addEditForm.selectBorderStyle
                el.style.borderColor = this.addEditForm.selectBorderColor
                el.style.borderRadius = this.addEditForm.selectBorderRadius
                el.style.backgroundColor = this.addEditForm.selectBgColor
            })
                document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                    el.style.lineHeight = this.addEditForm.selectHeight
                el.style.color = this.addEditForm.selectLableColor
                el.style.fontSize = this.addEditForm.selectLableFontSize
            })
                document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                    el.style.color = this.addEditForm.selectIconFontColor
                el.style.fontSize = this.addEditForm.selectIconFontSize
            })
                // date
                document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                    el.style.height = this.addEditForm.dateHeight
                el.style.color = this.addEditForm.dateFontColor
                el.style.fontSize = this.addEditForm.dateFontSize
                el.style.borderWidth = this.addEditForm.dateBorderWidth
                el.style.borderStyle = this.addEditForm.dateBorderStyle
                el.style.borderColor = this.addEditForm.dateBorderColor
                el.style.borderRadius = this.addEditForm.dateBorderRadius
                el.style.backgroundColor = this.addEditForm.dateBgColor
            })
                document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                    el.style.lineHeight = this.addEditForm.dateHeight
                el.style.color = this.addEditForm.dateLableColor
                el.style.fontSize = this.addEditForm.dateLableFontSize
            })
                document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                    el.style.color = this.addEditForm.dateIconFontColor
                el.style.fontSize = this.addEditForm.dateIconFontSize
                el.style.lineHeight = this.addEditForm.dateHeight
            })
                // upload
                let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                    el.style.width = this.addEditForm.uploadHeight
                el.style.height = this.addEditForm.uploadHeight
                el.style.borderWidth = this.addEditForm.uploadBorderWidth
                el.style.borderStyle = this.addEditForm.uploadBorderStyle
                el.style.borderColor = this.addEditForm.uploadBorderColor
                el.style.borderRadius = this.addEditForm.uploadBorderRadius
                el.style.backgroundColor = this.addEditForm.uploadBgColor
            })
                document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                    el.style.lineHeight = this.addEditForm.uploadHeight
                el.style.color = this.addEditForm.uploadLableColor
                el.style.fontSize = this.addEditForm.uploadLableFontSize
            })
                document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                    el.style.color = this.addEditForm.uploadIconFontColor
                el.style.fontSize = this.addEditForm.uploadIconFontSize
                el.style.lineHeight = iconLineHeight
                el.style.display = 'block'
            })
                // 多文本输入框
                document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                    el.style.height = this.addEditForm.textareaHeight
                el.style.color = this.addEditForm.textareaFontColor
                el.style.fontSize = this.addEditForm.textareaFontSize
                el.style.borderWidth = this.addEditForm.textareaBorderWidth
                el.style.borderStyle = this.addEditForm.textareaBorderStyle
                el.style.borderColor = this.addEditForm.textareaBorderColor
                el.style.borderRadius = this.addEditForm.textareaBorderRadius
                el.style.backgroundColor = this.addEditForm.textareaBgColor
            })
                document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                    // el.style.lineHeight = this.addEditForm.textareaHeight
                    el.style.color = this.addEditForm.textareaLableColor
                el.style.fontSize = this.addEditForm.textareaLableFontSize
            })
                // 保存
                document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                    el.style.width = this.addEditForm.btnSaveWidth
                el.style.height = this.addEditForm.btnSaveHeight
                el.style.color = this.addEditForm.btnSaveFontColor
                el.style.fontSize = this.addEditForm.btnSaveFontSize
                el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                el.style.borderColor = this.addEditForm.btnSaveBorderColor
                el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                el.style.backgroundColor = this.addEditForm.btnSaveBgColor
            })
                // 返回
                document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                    el.style.width = this.addEditForm.btnCancelWidth
                el.style.height = this.addEditForm.btnCancelHeight
                el.style.color = this.addEditForm.btnCancelFontColor
                el.style.fontSize = this.addEditForm.btnCancelFontSize
                el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                el.style.borderColor = this.addEditForm.btnCancelBorderColor
                el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                el.style.backgroundColor = this.addEditForm.btnCancelBgColor
            })
            })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                    el.style.width = this.addEditForm.uploadHeight
                el.style.height = this.addEditForm.uploadHeight
                el.style.borderWidth = this.addEditForm.uploadBorderWidth
                el.style.borderStyle = this.addEditForm.uploadBorderStyle
                el.style.borderColor = this.addEditForm.uploadBorderColor
                el.style.borderRadius = this.addEditForm.uploadBorderRadius
                el.style.backgroundColor = this.addEditForm.uploadBgColor
            })
            })
            },
        }
    };
</script>
<style lang="scss">
.editor{
        height: 500px;

    & /deep/ .ql-container {
          height: 310px;
      }
    }
    .amap-wrapper {
        width: 100%;
        height: 500px;
    }
    .search-box {
        position: absolute;
    }
    .addEdit-block {
        margin: -10px;
    }
    .detail-form-content {
        padding: 12px;
    }
    .btn .el-button {
        padding: 0;
    }</style>


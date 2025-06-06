





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

                                    <el-col :span="12">
                                        <el-form-item class="select" v-if="type!='info'"  label="地址" prop="addressId">
                                            <el-select v-model="ruleForm.addressId" placeholder="请选择地址" @change="addressChange">
                                                <el-option
                                                        v-for="(item,index) in addressOptions"
                                                        v-bind:key="item.id"
                                                        :label="item.addressName"
                                                        :value="item.id">
                                                </el-option>
                                            </el-select>
                                        </el-form-item>
                                    </el-col>

                                    <el-col :span="12">
                                        <el-form-item class="input" v-if="type!='info'"  label="地址" prop="addressName">
                                            <el-input v-model="addressForm.addressName"
                                                      placeholder="地址" clearable  :readonly="ro.addressName" readonly></el-input>
                                        </el-form-item>
                                        <div v-else>
                                            <el-form-item class="input" label="地址" prop="addressName">
                                                <el-input v-model="ruleForm.addressName"
                                                          placeholder="地址" readonly></el-input>
                                            </el-form-item>
                                        </div>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-form-item class="input" v-if="type!='info'"  label="电话" prop="addressPhone">
                                            <el-input v-model="addressForm.addressPhone"
                                                      placeholder="电话" clearable  :readonly="ro.addressPhone" readonly></el-input>
                                        </el-form-item>
                                        <div v-else>
                                            <el-form-item class="input" label="电话" prop="addressPhone">
                                                <el-input v-model="ruleForm.addressPhone"
                                                          placeholder="电话" readonly></el-input>
                                            </el-form-item>
                                        </div>
                                    </el-col>

                                    <el-col :span="12">
                                        <el-form-item class="select" v-if="type!='info'"  label="商品信息" prop="goodsId">
                                            <el-select v-model="ruleForm.goodsId" placeholder="请选择商品信息" @change="goodsChange">
                                                <el-option
                                                        v-for="(item,index) in goodsOptions"
                                                        v-bind:key="item.id"
                                                        :label="item.goodsName"
                                                        :value="item.id">
                                                </el-option>
                                            </el-select>
                                        </el-form-item>
                                    </el-col>

                                    <el-col :span="12">
                                        <el-form-item class="input" v-if="type!='info'"  label="商品名称" prop="goodsName">
                                            <el-input v-model="goodsForm.goodsName"
                                                      placeholder="商品名称" clearable  :readonly="ro.goodsName" readonly></el-input>
                                        </el-form-item>
                                        <div v-else>
                                            <el-form-item class="input" label="商品名称" prop="goodsName">
                                                <el-input v-model="ruleForm.goodsName"
                                                          placeholder="商品名称" readonly></el-input>
                                            </el-form-item>
                                        </div>
                                    </el-col>
                                     <el-col :span="24">
                                         <el-form-item class="upload" v-if="type!='info' && !ro.goodsPhoto" label="图片" prop="goodsPhoto">
                                             <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (goodsForm.goodsPhoto || '').split(',')" :src="item" width="100" height="100">
                                         </el-form-item>
                                         <div v-else>
                                             <el-form-item v-if="ruleForm.goodsPhoto" label="图片" prop="goodsPhoto">
                                                 <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.goodsPhoto || '').split(',')" :src="item" width="100" height="100">
                                             </el-form-item>
                                         </div>
                                     </el-col>
                                    <el-col :span="12">
                                        <el-form-item class="input" v-if="type!='info'"  label="品牌" prop="goodsPinpai">
                                            <el-input v-model="goodsForm.goodsPinpai"
                                                      placeholder="品牌" clearable  :readonly="ro.goodsPinpai" readonly></el-input>
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
                                            <el-input v-model="goodsForm.goodsGuige"
                                                      placeholder="规格" clearable  :readonly="ro.goodsGuige" readonly></el-input>
                                        </el-form-item>
                                        <div v-else>
                                            <el-form-item class="input" label="规格" prop="goodsGuige">
                                                <el-input v-model="ruleForm.goodsGuige"
                                                          placeholder="规格" readonly></el-input>
                                            </el-form-item>
                                        </div>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-form-item class="input" v-if="type!='info'"  label="现价" prop="goodsNewMoney">
                                            <el-input v-model="goodsForm.goodsNewMoney"
                                                      placeholder="现价" clearable  :readonly="ro.goodsNewMoney" readonly></el-input>
                                        </el-form-item>
                                        <div v-else>
                                            <el-form-item class="input" label="现价" prop="goodsNewMoney">
                                                <el-input v-model="ruleForm.goodsNewMoney"
                                                          placeholder="现价" readonly></el-input>
                                            </el-form-item>
                                        </div>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-form-item class="input" v-if="type!='info'"  label="最近点击时间" prop="goodsClickTime">
                                            <el-input v-model="goodsForm.goodsClickTime"
                                                      placeholder="最近点击时间" clearable  :readonly="ro.goodsClickTime" readonly></el-input>
                                        </el-form-item>
                                        <div v-else>
                                            <el-form-item class="input" label="最近点击时间" prop="goodsClickTime">
                                                <el-input v-model="ruleForm.goodsClickTime"
                                                          placeholder="最近点击时间" readonly></el-input>
                                            </el-form-item>
                                        </div>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-form-item class="input" v-if="type!='info'"  label="点击次数" prop="goodsClickNumber">
                                            <el-input v-model="goodsForm.goodsClickNumber"
                                                      placeholder="点击次数" clearable  :readonly="ro.goodsClickNumber" readonly></el-input>
                                        </el-form-item>
                                        <div v-else>
                                            <el-form-item class="input" label="点击次数" prop="goodsClickNumber">
                                                <el-input v-model="ruleForm.goodsClickNumber"
                                                          placeholder="点击次数" readonly></el-input>
                                            </el-form-item>
                                        </div>
                                    </el-col>

                                    <el-col :span="12">
                                        <el-form-item class="select" v-if="type!='info'"  label="用户" prop="yonghuId">
                                            <el-select v-model="ruleForm.yonghuId" placeholder="请选择用户" @change="yonghuChange">
                                                <el-option
                                                        v-for="(item,index) in yonghuOptions"
                                                        v-bind:key="item.id"
                                                        :label="item.yonghuName"
                                                        :value="item.id">
                                                </el-option>
                                            </el-select>
                                        </el-form-item>
                                    </el-col>

                                    <el-col :span="12">
                                        <el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuName">
                                            <el-input v-model="yonghuForm.yonghuName"
                                                      placeholder="用户姓名" clearable  :readonly="ro.yonghuName" readonly></el-input>
                                        </el-form-item>
                                        <div v-else>
                                            <el-form-item class="input" label="用户姓名" prop="yonghuName">
                                                <el-input v-model="ruleForm.yonghuName"
                                                          placeholder="用户姓名" readonly></el-input>
                                            </el-form-item>
                                        </div>
                                    </el-col>
                                    <input id="updateId" name="id" type="hidden">
                                   <el-col :span="12">
                                       <el-form-item class="input" v-if="type!='info'"  label="订单编号" prop="goodsOrderUuidNumber">
                                           <el-input v-model="ruleForm.goodsOrderUuidNumber"
                                                     placeholder="订单编号" clearable  :readonly="ro.goodsOrderUuidNumber"></el-input>
                                       </el-form-item>
                                       <div v-else>
                                           <el-form-item class="input" label="订单编号" prop="goodsOrderUuidNumber">
                                               <el-input v-model="ruleForm.goodsOrderUuidNumber"
                                                         placeholder="订单编号" readonly></el-input>
                                           </el-form-item>
                                       </div>
                                   </el-col>
                                <input id="yonghuId" name="yonghuId" type="hidden">
                                <input id="goodsId" name="goodsId" type="hidden">
                                   <el-col :span="12">
                                       <el-form-item class="input" v-if="type!='info'"  label="购买数量" prop="buyNumber">
                                           <el-input v-model="ruleForm.buyNumber"
                                                     placeholder="购买数量" clearable  :readonly="ro.buyNumber"></el-input>
                                       </el-form-item>
                                       <div v-else>
                                           <el-form-item class="input" label="购买数量" prop="buyNumber">
                                               <el-input v-model="ruleForm.buyNumber"
                                                         placeholder="购买数量" readonly></el-input>
                                           </el-form-item>
                                       </div>
                                   </el-col>
                                   <el-col :span="12">
                                       <el-form-item class="input" v-if="type!='info'"  label="总价格" prop="discounttotal">
                                           <el-input v-model="ruleForm.discounttotal"
                                                     placeholder="总价格" clearable  :readonly="ro.discounttotal"></el-input>
                                       </el-form-item>
                                       <div v-else>
                                           <el-form-item class="input" label="总价格" prop="discounttotal">
                                               <el-input v-model="ruleForm.discounttotal"
                                                         placeholder="总价格" readonly></el-input>
                                           </el-form-item>
                                       </div>
                                   </el-col>
                                 <el-col :span="12">
                                     <el-form-item class="select" v-if="type!='info'"  label="订单状态" prop="orderTypes">
                                         <el-select v-model="ruleForm.orderTypes" placeholder="请选择订单状态">
                                             <el-option
                                                     v-for="(item,index) in orderTypesOptions"
                                                     v-bind:key="item.codeIndex"
                                                     :label="item.indexName"
                                                     :value="item.codeIndex">
                                             </el-option>
                                         </el-select>
                                     </el-form-item>
                                     <div v-else>
                                         <el-form-item class="input" label="订单状态" prop="orderValue">
                                             <el-input v-model="ruleForm.orderValue"
                                                       placeholder="订单状态" readonly></el-input>
                                         </el-form-item>
                                     </div>
                                 </el-col>
                                <input id="addressId" name="addressId" type="hidden">


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
                addressForm: {},
                goodsForm: {},
                yonghuForm: {},
                ro:{
                    insertTime: false,
                    goodsOrderUuidNumber: false,
                    yonghuId: false,
                    goodsId: false,
                    buyNumber: false,
                    price: false,
                    discountprice: false,
                    total: false,
                    discounttotal: false,
                    orderTypes: false,
                    addressId: false,
                },
                ruleForm: {
                    insertTime: '',
                    goodsOrderUuidNumber: '',
                    yonghuId: '',
                    goodsId: '',
                    buyNumber: '',
                    price: '',
                    discountprice: '',
                    total: '',
                    discounttotal: '',
                    orderTypes: '',
                    addressId: '',
                },
                orderTypesOptions : [],
                addressOptions : [],
                goodsOptions : [],
                yonghuOptions : [],
                rules: {
                   insertTime: [
                              { required: true, message: '创建时间不能为空', trigger: 'blur' },
                          ],
                   goodsOrderUuidNumber: [
                              { required: true, message: '订单编号不能为空', trigger: 'blur' },
                          ],
                   yonghuId: [
                              { required: true, message: '用户id不能为空', trigger: 'blur' },
                          ],
                   goodsId: [
                              { required: true, message: '商品id不能为空', trigger: 'blur' },
                          ],
                   buyNumber: [
                              { required: true, message: '购买数量不能为空', trigger: 'blur' },
                          ],
                   price: [
                              { required: true, message: '价格/积分不能为空', trigger: 'blur' },
                          ],
                   discountprice: [
                              { required: true, message: '折扣价格不能为空', trigger: 'blur' },
                          ],
                   total: [
                              { required: true, message: '总价格/总积分不能为空', trigger: 'blur' },
                          ],
                   discounttotal: [
                              { required: true, message: '折扣总价格不能为空', trigger: 'blur' },
                          ],
                   orderTypes: [
                              { required: true, message: '订单状态不能为空', trigger: 'blur' },
                          ],
                   addressId: [
                              { required: true, message: '地址不能为空', trigger: 'blur' },
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
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=order_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
            this.orderTypesOptions = data.data.list;
        }
                });

         this.$http({
             url: `address/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
            this.addressOptions = data.data.list;
        }
         });

         this.$http({
             url: `goods/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
            this.goodsOptions = data.data.list;
        }
         });

         this.$http({
             url: `yonghu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
            this.yonghuOptions = data.data.list;
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

                      if(o=='insertTime'){
                          this.ruleForm.insertTime = obj[o];
                          this.ro.insertTime = true;
                          continue;
                      }
                      if(o=='goodsOrderUuidNumber'){
                          this.ruleForm.goodsOrderUuidNumber = obj[o];
                          this.ro.goodsOrderUuidNumber = true;
                          continue;
                      }
                      if(o=='yonghuId'){
                          this.ruleForm.yonghuId = obj[o];
                          this.ro.yonghuId = true;
                          continue;
                      }
                      if(o=='goodsId'){
                          this.ruleForm.goodsId = obj[o];
                          this.ro.goodsId = true;
                          continue;
                      }
                      if(o=='buyNumber'){
                          this.ruleForm.buyNumber = obj[o];
                          this.ro.buyNumber = true;
                          continue;
                      }
                      if(o=='price'){
                          this.ruleForm.price = obj[o];
                          this.ro.price = true;
                          continue;
                      }
                      if(o=='discountprice'){
                          this.ruleForm.discountprice = obj[o];
                          this.ro.discountprice = true;
                          continue;
                      }
                      if(o=='total'){
                          this.ruleForm.total = obj[o];
                          this.ro.total = true;
                          continue;
                      }
                      if(o=='discounttotal'){
                          this.ruleForm.discounttotal = obj[o];
                          this.ro.discounttotal = true;
                          continue;
                      }
                      if(o=='orderTypes'){
                          this.ruleForm.orderTypes = obj[o];
                          this.ro.orderTypes = true;
                          continue;
                      }
                      if(o=='addressId'){
                          this.ruleForm.addressId = obj[o];
                          this.ro.addressId = true;
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
            addressChange(id){
                    this.$http({
                        url: `address/info/`+id,
                        method: "get"
                    }).then(({ data }) => {
                        if (data && data.code === 0) {
                        this.addressForm = data.data;
                    }
                });
            },
            goodsChange(id){
                    this.$http({
                        url: `goods/info/`+id,
                        method: "get"
                    }).then(({ data }) => {
                        if (data && data.code === 0) {
                        this.goodsForm = data.data;
                    }
                });
            },
            yonghuChange(id){
                    this.$http({
                        url: `yonghu/info/`+id,
                        method: "get"
                    }).then(({ data }) => {
                        if (data && data.code === 0) {
                        this.yonghuForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                this.$http({
                    url: `orders/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                    this.ruleForm = data.data;
                                    this.addressChange(data.data.addressId)
                                    this.goodsChange(data.data.goodsId)
                                    this.yonghuChange(data.data.yonghuId)
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
                            url:`orders/${!this.ruleForm.id ? "save" : "update"}`,
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
                            this.parent.ordersCrossAddOrUpdateFlag = false;
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
                this.parent.ordersCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
    //图片

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


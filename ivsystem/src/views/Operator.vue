<template>
  <div style="
  text-align: center;
  background-color: #ffffff;
  box-shadow: black;
  height: auto;
  border-radius: 10px;

  ">
    <div style="height: 70px;width: 90%;line-height: 70px;margin: auto" >
      <p style="font-size: 25px;font-weight: bold">操作员信息</p>

    </div>
    <div style="border-bottom: 4px lightgray solid;height: 70px ;" >
      <div style="width: 100%;margin: auto;line-height: 70px;text-align: left">
        <el-input v-model="search" placeholder="请输入关键字" size="large"  style="width: 25%;margin-left: 20px"  clearable/>
        <el-button size="large" type="primary" style="margin-left: 30px" @click="load">查询</el-button>
        <el-button type="primary" size="large" @click="add" >创建</el-button>
      </div>

    </div>

    <el-table
        :data="tableData"
        style="width: 100%"
    >
      <el-table-column prop="operator_id" label="编号" width="100" />
      <el-table-column prop="name" label="操作员名称"  />
      <el-table-column prop="address" label="操作员地址" />
      <el-table-column prop="phone" label="操作员电话" width="200"/>
      <el-table-column prop="state" label="操作员状态" width="200" />


    </el-table>


<!--    <el-dialog
        v-model="dialogVisible"
        title="操作员信息"
        width="30%"

    >
      <el-form  :model="operatorForm" label-width="120px">
        <el-form-item label="操作员名称">
          <el-input v-model="operatorForm.name" />
        </el-form-item>
        <el-form-item label="操作员地址">
          <el-input v-model="operatorForm.address" />
        </el-form-item>
        <el-form-item label="操作员电话">
          <el-input v-model="operatorForm.phone" />
        </el-form-item>
        <el-form-item label="操作员状态">
          <el-input v-model="operatorForm.state" />
        </el-form-item>
        <el-form-item label="操作员用户名">
          <el-input v-model="form.telephone" />
        </el-form-item>
        <el-form-item label="操作员密码">
          <el-input v-model="form.telephone" />
        </el-form-item>

      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确认</el-button>
      </span>
      </template>
    </el-dialog>-->



  </div>

</template>

<script>

import request from "@/utils/request";

export default {
    data(){
      return {
        operatorForm:{
          operator_id:"",
          name:"",
          address:"",
          phone:"",


        },
        dialogVisible : false,
        search: '',
        tableData:[

        ]
      }
    },
    created() {
      this.load();

    },
    methods:{
      add(){
        this.dialogVisible = true
        this.form = {
        }

      },
      save(){
        if(this.operatorForm.operator_id){  //更新
          request.put('/client_infomation',this.form).then(res =>{
            console.log(res)
            if(res.code === '0'){
              this.$message({
                type: "success",
                message: "更新成功"
              })
            }else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          })
          this.load()
        }else{
          request.post('/client_infomation',this.form).then(res =>{
            console.log(res)
            if(res.code === '0'){
              this.$message({
                type: "success",
                message: "创建成功"
              })
            }else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          })
          this.load()
        }
        this.dialogVisible = false
      },
      load(){
        request.get('/getInfoOperator',{
          params: {
            search: this.search
          }

        }).then(res=>{
          this.tableData = res.data
        })
      },
      handleEdit(row){
        this.form = JSON.parse(JSON.stringify(row))
        this.dialogVisible = true;
      },
      handleDelete(clientNo){
        console.log(clientNo)
        request.delete("/client_infomation/" + clientNo).then(res=>{
              if(res.code === '0'){
                this.$message({
                  type: "success",
                  message: "删除成功"
                })
              }else {
                this.$message({
                  type: "error",
                  message: res.msg
                })
              }
            })
        this.load()

      },

      /**/
    },


}






</script>


<style>

</style>
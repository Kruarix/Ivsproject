<template>
  <div style="
  text-align: center;
  background-color: #ffffff;
  box-shadow: black;
  height: auto;
  border-radius: 10px;

  ">
    <div style="height: 60px;">
      <h1 style="float: left;margin-top: 20px;margin-left: 40px">客户信息</h1>

    </div>
    <div style="border-bottom: 4px lightgray solid;height: 60px ;" >
      <el-input v-model="search" placeholder="请输入关键字" size="large" style="width: 20%;float: left;margin-left: 2%" clearable/>
      <el-button size="large" type="primary" style="float: left;margin-left: 1%" @click="load">查询</el-button>
      <el-button type="primary" size="large" style="float: right; margin-right: 5%;" @click="add" >创建</el-button>
    </div>

    <el-table
        :data="tableData"
        style="width: 100%"
    >
      <el-table-column prop="clientNo" label="编号" width="100" />
      <el-table-column prop="clientName" label="客户名称"  />
      <el-table-column prop="address" label="客户地址" />
      <el-table-column prop="telephone" label="客户电话" width="200"/>
      <el-table-column width="200">
        <template #default="scope">
          <el-button  type="primary" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="你确定要删除吗?" @confirm="handleDelete(scope.row.clientNo)">
            <template #reference>
              <el-button  type="danger"  >删除</el-button>
            </template>
          </el-popconfirm>




        </template>
      </el-table-column>

    </el-table>


    <el-dialog
        v-model="dialogVisible"
        title="客户信息"
        width="30%"

    >
      <el-form  :model="form" label-width="120px">
        <el-form-item label="客户名称">
          <el-input v-model="form.clientName" />
        </el-form-item>
        <el-form-item label="客户地址">
          <el-input v-model="form.address" />
        </el-form-item>
        <el-form-item label="客户电话">
          <el-input v-model="form.telephone" />
        </el-form-item>

      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确认</el-button>
      </span>
      </template>
    </el-dialog>



  </div>

</template>

<script>

import request from "@/utils/request";

export default {
    data(){
      return {
        form:{},
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
        if(this.form.clientNo){  //更新
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
        request.get('/client_infomation',{
          params: {
            search: this.search
          }

        }).then(res=>{
          this.tableData = res.data.records
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

      }
    },


}






</script>


<style>

</style>
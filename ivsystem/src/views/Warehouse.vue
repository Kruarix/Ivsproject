<template>
  <div style="
  text-align: center;
  background-color: #ffffff;
  box-shadow: black;
  height: auto;
  border-radius: 10px;

  ">
    <div style="height: 50px;width: 90%;line-height: 50px;margin: auto" >
      <p style="font-size: 25px;font-weight: bold">仓库货物信息</p>

    </div>
    <div style="border-bottom: 4px lightgray solid;height: 70px ;" >
      <div style="width: 100%;margin: auto;line-height: 70px;text-align: left">
<!--        <el-input v-model="search" placeholder="请输入关键字" size="large"  style="width: 25%;margin-left: 20px"  clearable/>-->
<!--        <el-button size="large" type="primary" style="margin-left: 30px" @click="load">查询</el-button>-->
        <el-button type="primary" size="large" style="margin-left: 30px" @click="add" >创建</el-button>
      </div>

    </div>


    <el-table
        :data="tableData"
        style="width: 100%"
    >
      <el-table-column prop="goods_id" label="编号" width="200" />
      <el-table-column prop="goods_name" label="货物名称"  />
      <el-table-column prop="quantity" label="货物数量" width="200"/>
      <el-table-column width="200">
        <template #default="scope">
          <el-button  type="primary" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="你确定要删除吗?" @confirm="handleDelete(scope.row.goods_id)">
            <template #reference>
              <el-button  type="danger"  >删除</el-button>
            </template>
          </el-popconfirm>


        </template>
      </el-table-column>

    </el-table>


    <el-dialog
        v-model="dialogVisible"
        title="货物信息"
        width="30%"

    >
      <el-form  :model="form" label-width="120px">
        <el-form-item label="货物名称">
          <el-input v-model="form.goods_name" />
        </el-form-item>
        <el-form-item label="货物数量">
          <el-input v-model="form.quantity" />
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
      form:{
        goods_id:'',
        goods_name:'',
        quantity:''
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
      if(this.form.goods_id){  //更新
        request.put('/updateWarehouse',this.form).then(res =>{
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
          this.load()
        })

      }else{  //创建
        request.post('/addWarehouse',this.form).then(res =>{
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
          this.load()
        })

      }
      this.dialogVisible = false
    },
    load(){
      request.get('/getInfoWarehouse').then(res=>{
        this.tableData = res.data
      })
    },

    handleEdit(row){
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true;
    },
    handleDelete(goods_id){
      console.log(goods_id)
      request.get("/deleteWarehouse",{
        params:
            {goods_id: goods_id}
      }).then(res=>{
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
        this.load()
      })


    }
  },


}






</script>


<style>

</style>
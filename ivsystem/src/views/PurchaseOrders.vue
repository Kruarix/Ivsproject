<template>
  <div style="
  text-align: center;
  background-color: #ffffff;
  box-shadow: black;
  height: auto;
  border-radius: 10px;

  ">
    <div style="height: 50px;width: 90%;line-height: 50px;margin: auto" >
      <p style="font-size: 25px;font-weight: bold">进货订单信息</p>

    </div>
<!--    <div style="border-bottom: 4px lightgray solid;height: 70px ;" >-->
<!--      <div style="width: 100%;margin: auto;line-height: 70px;text-align: left">-->
<!--        <el-input v-model="search" placeholder="请输入关键字" size="large"  style="width: 25%;margin-left: 20px"  clearable/>-->
<!--        <el-button size="large" type="primary" style="margin-left: 30px" @click="load">查询</el-button>-->
<!--        <el-button type="primary" size="large" style="margin-left: 30px" @click="add" >创建</el-button>-->
<!--      </div>-->

<!--    </div>-->

    <el-table :data="tableData"  style="width: 95%;margin: auto;background-color: #ffffff"
              :default-sort="{ prop: 'date', order: 'descending' }" >
      <el-table-column
          type="expand"
          width="80"
      >
        <template #default="props">
          <div style="width: 95%;margin: auto">
            <el-table :data="props.row.purchaseInfoList">
              <el-table-column label="货物名称" prop="goods_name" />
              <el-table-column label="采购单价" prop="unit_price" />
              <el-table-column label="采购数量" prop="count" />
            </el-table>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="日期" prop="delivery_date" sortable width="200" />
      <el-table-column label="采购合同编号" prop="purchase_contract_id" />
      <el-table-column label="供应商" prop="supplier_name" />
      <el-table-column label="操作员名称" prop="operator_name" />
      <el-table-column width="140">

          <el-button  type="primary" size="small" @click="handleClick">修改</el-button>
          <el-button  type="danger" size="small" @click="handleClick">删除</el-button>

      </el-table-column>

    </el-table>
  </div>

</template>

<script>

import request from "@/utils/request";

export default {
  data(){
    return{
      form:{
        purchase_contract_id: "",
        operator_name: "",
        delivery_date: "",
        supplier_name: "",
        purchaseInfoList:[
            {
              goods_name: "",
              count: '',
              unit_price: ""
            }
        ]
      },
      search:'',
      tableData:[

      ]

    }
  },
  created() {
    this.load()
  },
  methods:{
    add(){
      this.dialogVisible = true
      this.form = {
      }

    },
    save(){
      if(this.form.client_id){  //更新
        request.put('/updatePurchase',this.form).then(res =>{
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
        request.post('/addPurchase',this.form).then(res =>{
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
      request.get('/getInfoPurchase').then(res=>{
        this.tableData = res.data

      })
    },

    handleEdit(row){
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true;
    },
    handleDelete(client_id){
      console.log(client_id)
      request.get("/deletePurchase",{
        params:
            {client_id: client_id}
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
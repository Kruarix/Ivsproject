<template>
  <div style="
  text-align: center;
  background-color: #ffffff;
  box-shadow: black;
  height: auto;
  border-radius: 10px;

  ">
    <div style="height: 50px;width: 90%;line-height: 50px;margin: auto" >
      <p style="font-size: 25px;font-weight: bold">处理中心</p>
    </div>

    <div class="demo-collapse" style="width: 60%;margin:auto" >
      <el-collapse v-model="activeNames" accordion  >

        <el-collapse-item title="查询某种货物进货时间、进货数量，进货商家" @click="check" name="1"   >
          <div>
            <div style="height: 70px ;" >
              <div style="width: 100%;margin: auto;line-height: 70px;text-align: left">
                <el-input v-model="search" placeholder="请输入关键字" size="large"  style="width: 25%;margin-left: 20px"  clearable/>
                <el-button size="large" type="primary" style="margin-left: 30px" @click="select">查询</el-button>
              </div>

            </div>

            <el-table
                :data="tableData"
                style="width: 100%"
            >
              <el-table-column prop="delivery_date" label="进货时间" />
              <el-table-column prop="count" label="进货数量"  />
              <el-table-column prop="supplier_name" label="进货商家" />

            </el-table>

          </div>

        </el-collapse-item>
        <el-collapse-item title="查询货物销量情况及剩余库存数量" @click="check" name="2">
          <div>
            <div style="height: 70px ;" >
              <div style="width: 100%;margin: auto;line-height: 70px;text-align: left">
                <el-input v-model="search" placeholder="请输入关键字" size="large"  style="width: 25%;margin-left: 20px"  clearable/>
                <el-button size="large" type="primary" style="margin-left: 30px" @click="select">查询</el-button>
              </div>

            </div>

            <el-table
                :data="tableData"
                style="width: 100%"
            >
              <el-table-column prop="sale_date" label="时间" />
              <el-table-column prop="count" label="销量情况"  />
              <el-table-column prop="quantity" label="剩余库存数量" />

            </el-table>

          </div>
        </el-collapse-item>
        <el-collapse-item title="查询某供应商当月全部供货信息" @click="check" name="3">
          <div>
            <div style="height: 70px ;" >
              <div style="width: 100%;margin: auto;line-height: 70px;text-align: left">
                <el-input v-model="search" placeholder="请输入关键字" size="large"  style="width: 25%;margin-left: 20px"  clearable/>
                <el-button size="large" type="primary" style="margin-left: 30px" @click="select">查询</el-button>
              </div>

            </div>

            <el-table
                :data="tableData"
                style="width: 100%"
            >
              <el-table-column prop="delivery_date" label="时间" />
              <el-table-column prop="goods_name" label="供应货物名称"  />
              <el-table-column prop="purchase_contract_id" label="供应订单编号" />

            </el-table>

          </div>
        </el-collapse-item>
        <el-collapse-item title="查询可以供应某种货物的全部供应商信息" @click="check" name="4">
          <div>
            <div style="height: 70px ;" >
              <div style="width: 100%;margin: auto;line-height: 70px;text-align: left">
                <el-input v-model="search" placeholder="请输入关键字" size="large"  style="width: 25%;margin-left: 20px"  clearable/>
                <el-button size="large" type="primary" style="margin-left: 30px" @click="select">查询</el-button>
              </div>

            </div>

            <el-table
                :data="tableData"
                style="width: 100%"
            >
              <el-table-column prop="supplier_name" label="供应商名称"  />
              <el-table-column prop="supplier_address" label="供应商地址" />
              <el-table-column prop="supplier_phone" label="供应商电话" />

            </el-table>

          </div>
        </el-collapse-item>


      </el-collapse>
    </div>

  </div>

</template>

<script>

import request from "@/utils/request";

export default {
  data(){
    return {
      search: '',
      activeNames:'',
      tableData:[

      ]
    }
  },
  methods:{
    select(){
      if(this.activeNames === "1"){
        request.get('/selectGoodsPurchase',{
          params:{
            goods_name: this.search
          }
        }).then(res=>{
          this.tableData = res.data
        })
      }else if (this.activeNames === "2"){
        request.get('/selectGoodsSales',{
          params:{
            goods_name: this.search
          }
        }).then(res=>{
          this.tableData = res.data
        })
      }else if (this.activeNames === "3"){
        request.get('/selectSupplierPurchase',{
          params:{
            supplier_name: this.search
          }
        }).then(res=>{
          this.tableData = res.data
        })
      }else if (this.activeNames === "4"){
        request.get('/selectSupplierGoods',{
          params:{
            goods_name: this.search
          }
        }).then(res=>{
          this.tableData = res.data
        })
      }





    },
    check(){
      if(this.activeNames!=""){
        this.search = ''
        this.tableData= ''
      }
    }

  },


}



</script>


<style>

</style>
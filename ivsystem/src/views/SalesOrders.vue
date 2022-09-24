<template>
  <div style="
  text-align: center;
  background-color: #ffffff;
  box-shadow: black;
  height: auto;
  border-radius: 10px;

  ">
    <div style="height: 60px;">
      <h1 style="float: left;margin-top: 20px;margin-left: 40px">销货单</h1>

    </div>
    <div style="border-bottom: 4px lightgray solid;height: 60px ;" >
      <el-input v-model="search" placeholder="请输入关键字" size="large" style="width: 20%;float: left;margin-left: 2%" />
      <el-button size="large" type="primary" style="float: left;margin-left: 1%">查询</el-button>
      <el-button type="primary" size="large" style="float: right; margin-right: 5%;  " >创建</el-button>
    </div>



    <el-table :data="tableData"  style="width: 95%;margin: auto"
              :default-sort="{ prop: 'date', order: 'descending' }" show-summary sum-text="合计">
      <el-table-column
          type="expand"
          width="80"
      >
        <template #default="props">
          <div style="width: 95%;margin: auto;"  >
            <el-table :data="props.row.list" >
              <el-table-column label="货物名称" prop="goodsname" width="250"/>
              <el-table-column label="仓库操作序号" prop="operation" />
              <el-table-column label="订购单价" prop="unitprice" width="200"/>
              <el-table-column label="订购数量" prop="count" width="200" />
              <el-table-column label="订购价格" prop="cost" width="200" />
            </el-table>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="日期" prop="date" sortable width="200"/>
      <el-table-column label="订购合同编号" prop="SalesNo" />
      <el-table-column label="客户" prop="client" />
      <el-table-column label="金额" prop="sumcost" width="120"/>
      <el-table-column width="120">
        <el-popconfirm title="确认删除吗？">
          <template #reference>
            <el-button  type="danger" size="small" @click="handleClick">删除</el-button>
          </template>

        </el-popconfirm>
      </el-table-column>

    </el-table>
  </div>

</template>

<script>




export default {
  data(){
    return{
      search:'',
      tableData:[
        {
          date: '2016-05-01',
          supplier: 'Tom',
          purchase: 'California',
          sumcost: 1202,
          list: [
            {
              goodsname: 'Jerry',
              unitprice: 'California',
              count: 'San Francisco',
              cost: '3650 21st St, San Francisco',
            },
            {
              goodsname: 'Jerry',
              unitprice: 'California',
              count: 'San Francisco',
              cost: '3650 21st St, San Francisco',
            },
            {
              goodsname: 'Jerry',
              unitprice: 'California',
              count: 'San Francisco',
              cost: '3650 21st St, San Francisco',
            },
          ],
        },
        {
          date: '2016-05-01',
          supplier: 'Tom',
          purchase: 'California',
          sumcost: 1202,
          list: [
            {
              goodsname: 'Jerry',
              unitprice: 'California',
              count: 'San Francisco',
              cost: '3650 21st St, San Francisco',
            },
            {
              goodsname: 'Jerry',
              unitprice: 'California',
              count: 'San Francisco',
              cost: '3650 21st St, San Francisco',
            },
            {
              goodsname: 'Jerry',
              unitprice: 'California',
              count: 'San Francisco',
              cost: '3650 21st St, San Francisco',
            },
          ],
        },
        {
          date: '2016-05-01',
          supplier: 'Tom',
          purchase: 'California',
          sumcost: 1202,
          list: [
            {
              goodsname: 'Jerry',
              unitprice: 'California',
              count: 'San Francisco',
              cost: '3650 21st St, San Francisco',
            },
            {
              goodsname: 'Jerry',
              unitprice: 'California',
              count: 'San Francisco',
              cost: '3650 21st St, San Francisco',
            },
            {
              goodsname: 'Jerry',
              unitprice: 'California',
              count: 'San Francisco',
              cost: '3650 21st St, San Francisco',
            },
          ],
        },
      ]

    }
  },
  methods:{
    handleClick(){
      console.log('click')
    }
  }


}

</script>


<style>

</style>
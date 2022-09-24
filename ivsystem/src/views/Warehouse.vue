<template>
  <div style="
  text-align: center;
  background-color: #ffffff;
  box-shadow: black;
  height: auto;
  border-radius: 10px;

  ">
    <el-table
        :data="tableData"
        style="width: 100%"
        :row-class-name="tableRowClassName"
    >
      <el-table-column prop="date" label="Date" width="180" />
      <el-table-column prop="name" label="Name" width="180" />
      <el-table-column prop="address" label="Address" />
    </el-table>
  </div>

</template>

<script setup>





const tableData = [


]
</script>


<style>

</style>
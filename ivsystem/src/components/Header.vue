<template>
  <el-menu
      default-active="/takeOver"
      class="el-menu-demo"
      mode="horizontal"
      :ellipsis="false"
      router
  >
    <el-menu-item index="/processingCenter" style="font-weight: bold;font-size: larger">进销存管理系统</el-menu-item>
    <div class="flex-grow" />
<!--    <el-menu-item index="1">处理中心</el-menu-item>-->
<!--    <el-sub-menu index="2">-->
<!--      <template #title>张三</template>-->
<!--      <el-menu-item index="2-1">个人中心</el-menu-item>-->
<!--      <el-menu-item index="2-2">注销登录</el-menu-item>-->
<!--    </el-sub-menu>-->
  </el-menu>





</template>

<script >



</script>

<style>
.flex-grow {
  flex-grow: 1;
}

</style>
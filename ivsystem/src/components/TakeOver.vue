<template>
  <div class="common-layout">
    <el-container>
      <!--    头部-->
      <el-header>
        <Header />
      </el-header>


      <el-container style="height: 95.1vh ">
        <el-aside   >
          <Aside />
        </el-aside>

        <el-container style="height: 95.1vh;" >
          <el-main style="background-color: lightgrey" >

            <router-view name="MainBody" />
          </el-main>

          <el-footer style="background-color: chocolate">
            底部
          </el-footer>

        </el-container>



      </el-container>


    </el-container>

  </div>
</template>

<script>
import Header from "@/components/Header";
import Aside from "@/components/Aside";

export default {
  name : "Layout",
  components: {
    Header,
    Aside

  }
}
</script>

<style scoped>

</style>
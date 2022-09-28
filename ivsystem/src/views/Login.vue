<template>

  <div class="login_container">


    <div class="login_box">
      <!--头像-->
      <div class="avatar_box">
        <img src="../assets/logo.png" />
      </div>
      <!--表单-->
      <el-form
          ref="LoginFormRef"
          :model="loginForm"
          status-icon
          :rules="rules"
          size="large"
          class="login-ruleForm"
      >
        <el-form-item  prop="username">
          <el-input v-model="loginForm.username"
                    type="text"
                    autocomplete="off"
          />
        </el-form-item>

        <el-form-item  prop="password">
          <el-input
              v-model="loginForm.password"
              type="password"
              autocomplete="off"
              show-password=true

          />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm(LoginFormRef)"
          >登录</el-button>
          <el-button @click="">注册</el-button>
        </el-form-item>
      </el-form>
    </div>


  </div>

</template>



<script lang="ts" setup>
import { reactive, ref } from 'vue'
import type { FormInstance } from 'element-plus'
import request from "@/utils/request";
import router from "@/router";
import {ElMessage, ElNotification} from "element-plus";



const LoginFormRef = ref<FormInstance>()

const validateUsername = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('请输入用户名'))
  } else {
    if (loginForm.username !== '') {
      if (!LoginFormRef.value) return
      LoginFormRef.value.validateField('password', () => null)
    }
    callback()
  }
}
const validatePassword = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('请输入密码'))
  } else {
    callback()
  }
}


const loginForm = reactive({
  username: '',
  password: ''
})



const rules = reactive({
  username: [{ validator: validateUsername, trigger: 'blur' }],
  password: [{ validator: validatePassword, trigger: 'blur' }],
})


const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      //console.log('submit!')

      request.post('/selectOperator',loginForm).then(res=>{
        if(res.code === '0' ){
          ElNotification({
            title: '登陆成功',
            message: '正在跳转到管理系统...',
            type: 'success',
            duration: 1800,
          })
          setTimeout(()=>{
            //需要延迟的代码 :3秒后延迟跳转到首页，可以加提示什么的
            router.push({
              name:"processingCenter"
            });
            //延迟时间
          },1500)



        }else if(res.code === '1'){
          //alert("账号不存在，请重新输入账号")
          ElMessage.error('账号不存在，请重新输入账号和密码')
          resetForm(formEl);
        }else if(res.code === '2'){
          //alert("密码错误，请重新输入密码")
          ElMessage.error('密码错误，请重新输入密码')

        }
      })
      //跳转



    } else {
      console.log('error submit!')
      return false
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}

// register



</script>



<style scoped>
.login_container{
  background-image: url("../assets/desk.jpg");
  height: 100%;
  background-repeat: no-repeat;
  background-position: center;
  background-attachment: fixed;
  background-size: cover;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;

}
.login_box{
  padding-top: 200px;
  padding-left: 50px;
  padding-right: 50px;
  width: 350px;
  height: 200px;
  border-radius: 10px;
  position: absolute;
  left: 50%;
  top: 40%;
  background-color: rgba(245, 245, 245, 0.9);
  transform: translate(-50%, -50%);
  /*opacity: 0.5;*/
}
.avatar_box{
  width: 130px;
  height: 130px;
  border: 1px solid #b6b6b6;
  border-radius: 50%;
  padding: 10px;
  box-shadow: 0 0 10px #ddd;
  position: absolute;

  left: 50%;
  transform: translate(-50%, -120%);
}
img{
  width: 100%;
  height: 100%;
  border-radius: 50%;
}



</style>
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
          />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm(LoginFormRef)"
          >登录</el-button>
          <el-button @click="resetForm(LoginFormRef)">重置</el-button>
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

      request.post('/selectOne',loginForm)
      //跳转
      router.push({ name: 'home' });

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
  width: 350px;
  height: 200px;
  border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
}
.avatar_box{
  width: 130px;
  height: 130px;
  border: 1px solid #eee;
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
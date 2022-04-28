<template>
  <div class="home">
      <div class="home_head">
          <!--这个表示一个head横栏-->
      </div>
      <div class="home_body">
        <div class="home_body_left">
          <div class="home_body_left_menu">
            <el-menu
              style="height: 100%;border-radius: 10px"
              default-active="2"
              class="el-menu-vertical-demo"
              @select="handleSelect"
              router: true
            >
              <el-menu-item index="1">
                <i class="el-icon-location"></i>
                <span slot="title">课程管理</span>
              </el-menu-item>
              <el-menu-item index="2" disabled>
                <i class="el-icon-menu"></i>
                <span slot="title">导航二</span>
              </el-menu-item>
              <el-menu-item index="3" disabled>
                <i class="el-icon-document"></i>
                <span slot="title">导航三</span>
              </el-menu-item>
              <el-menu-item index="4" disabled>
                <i class="el-icon-setting"></i>
                <span slot="title">导航四</span>
              </el-menu-item>
            </el-menu>
          </div>
        </div>
        <div class="home_body_right">
          <component :is="nowView"/>
        </div>
      </div>
  </div>
</template>

<script>
import CoursePage from "./Course/CoursePage";
import DefaultPage from "./DefaultPage";

export default {
  name: "home",
  components: {
    CoursePage,DefaultPage
  },
  data(){
    return {
      nowView:"DefaultPage"
    }
  },
  methods: {
    handleSelect(key){
      console.log(key)
      if(key == 1){
        this.nowView = 'CoursePage'
      }
    },
    mae() {
    }
  }
}
</script>

<style scoped>
.home{
  height: 100%;
  width: 100%;
  min-width: 1000px;
  min-height: 600px;
  display: flex;
  flex-direction: column;
}

.home_head{
  width: 100%;
  height: 80px;
  display: block;
  background: cadetblue;
}
.home_body{
  margin-top: 10px;
  height: 100%;
  display: flex;
  flex-direction: row;
}

.home_body_left{
  height: 100%;
  width: 200px;
  display: block;
  overflow: auto;
}

.home_body_left_menu{
  height: 100%;
  width: 150px;
  margin: 0 auto;
}

.home_body_right{
  height: 100%;
  width: 100%;
  display: flex;
  margin-right: 10px;
  border-radius: 20px;
  background: blanchedalmond;
}
</style>

<template>
  <div class="coursePage">
    <div class="coursePage_head">
       <!--   控制组件     -->
      <el-button type="primary" style="float: right;margin: 20px 10px;" @click="addCourse">添加课程</el-button>

      <el-dialog
        title="创建课程"
        :visible.sync="dialogVisible"
        width="800px"
        :before-close="handleClose">
        <div style="width: 100%;height: 100%;display: flex;flex-direction: column;font-size: 15px;line-height: 50px">
          <form>
            <div class="form">
              <div style="height: 100%;">课程名称:</div>
              <input style="height: 20px;margin: 13px;float: left" v-model="course.name" required></input>
            </div>
            <div class="form">
              <div style="height: 100%;">课&ensp;&ensp;&ensp;&ensp;时:</div>
              <input style="height: 20px;margin: 13px;float: left" v-model="course.hours" required></input>
            </div>
            <div class="form">
              <div style="height: 100%;">学&ensp;&ensp;&ensp;&ensp;院:</div>
              <select style="height: 25px;width: 170px;margin:13px;float: left" v-model="course.sid" required>
                <option v-for="item in options" :key="item.id" :value="item.id">{{item.name}}</option>
              </select>
            </div>
          </form>
          <div class="form">
            <div style="height: 100%;">导入图片:</div>
            <input style="height: 24px;margin: 13px;float: left;border: 1px solid" type="file" @change="show_uuid" ref="inputdd"></input>
          </div>
<!--          <el-image :src="src" style="width: 200px;height: 200px"></el-image>-->
        </div>

        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="CreateCourse">确 定</el-button>
        </span>
      </el-dialog>
    </div>
    <div class="coursePage_body">
      <div class="coursePage_body_table">
        <el-table
          :data="tableData"
          style="width: 100%;border-radius: 10px;min-width: 500px;"
          max-height="500"
          >
          <el-table-column
            fixed
            prop="id"
            label="序号"
            width="100">
          </el-table-column>
          <el-table-column
            prop="pic"
            label="封面"
            width="150">
            <template slot-scope="scope">
              <img :src="scope.row.pic" style="height: 100px;width: 100px"/>
            </template>
          </el-table-column>
          <el-table-column
            prop="name"
            label="名称"
            width="150">
          </el-table-column>
          <el-table-column
            prop="time"
            label="课时"
            width="100">
          </el-table-column>
          <el-table-column
            prop="academy"
            label="开设学院"
            width="200">
          </el-table-column>
          <el-table-column
            fixed="right"
            label="操作"
            width="100">
            <template slot-scope="scope">
              <el-button
                @click.native.prevent="deleteRow(scope, tableData)"
                type="text"
                size="small">
                删除
              </el-button>
              <el-button
                @click.native.prevent="updateRow(scope, tableData)"
                type="text"
                size="small">
                修改
              </el-button>
            </template>
          </el-table-column>
        </el-table>

      </div>
      <el-dialog
        title="修改课程"
        :visible.sync="updatedialogVisible"
        width="800px"
        :before-close="handleClose">
        <div style="width: 100%;height: 100%;display: flex;flex-direction: column;font-size: 15px;line-height: 50px">
          <form>
            <div class="form">
              <div style="height: 100%;">课程名称:</div>
              <input style="height: 20px;margin: 13px;float: left" v-model="course.name" required></input>
            </div>
            <div class="form">
              <div style="height: 100%;">课&ensp;&ensp;&ensp;&ensp;时:</div>
              <input style="height: 20px;margin: 13px;float: left" v-model="course.hours" required></input>
            </div>
            <div class="form">
              <div style="height: 100%;">学&ensp;&ensp;&ensp;&ensp;院:</div>
              <select style="height: 25px;width: 170px;margin:13px;float: left" v-model="course.sid" required>
                <option v-for="item in options" :key="item.id" :value="item.id">{{item.name}}</option>
              </select>
            </div>
          </form>
          <div class="form">
            <div style="height: 100%;">导入图片:</div>
            <input style="height: 24px;margin: 13px;float: left;border: 1px solid" type="file" @change="show_uuid" ref="inputdd"></input>
          </div>
        </div>

        <span slot="footer" class="dialog-footer">
          <el-button @click="updatedialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="updateCourse">确 定</el-button>
        </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import {respose} from "../../util/axios";

export default {
  name: "CoursePage",
  methods: {
    open1() {
      this.$message({
        message: '恭喜哦，操作成功',
        type: 'success'
      });
    },
    open2() {
      this.$message.error('错了哦，操作失败');
    },
    open3() {
      this.$message({
        message: '警告哦，记得填写完整',
        type: 'warning'
      });
    },
    show_uuid(){
      let files = this.$refs.inputdd.files;
      let params = new FormData();//传送文件使用这种数据类型
      params.append('picFile', files[0])
      respose({
        url:'pic_show',
        method: "post",
        headers: {
          'Content-Type': 'multipart/form-data'
        },
        data: params,
      }).then(res=>{
        this.course.picUrl="http://localhost:8000/images/"+res.data+".png"
      })
    },
    deleteRow(scope, data) {
      // console.log(scope.row.courseid)
      // console.log(data)
      respose({
        url:'deleteCourse/'+scope.row.courseid,
        method:'delete'
      }).then(res=>{
        if(res.data.code==1){
          this.open1()
          data.splice(scope.$index,1)
        }else {
          this.open2()
        }
      })
      // rows.splice(index, 1);
    },
    updateRow(scope,data){
      this.updatedialogVisible = true
      this.course.id = scope.row.courseid
      this.updateIndex = scope.$index
      this.getAcademy()
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          this.course.name = null
          this.course.hours = null
          this.course.sid = null
          this.course.picUrl = null
          done();
        })
        .catch(_ => {});
    },
    CreateCourse(){
      this.dialogVisible = false
      console.log(this.course.sid)
      if(this.course.name!=""&&this.course.hours!=""&&this.course.sid!=""){
        respose({
          url:"/insertCourse",
          method:'post',
          data:this.course
        }).then(res=>{
          console.log(res.data)
          if(res.data.code == 1){
            this.open1()
            this.tableData.push({
              id : this.index,
              pic : this.course.picUrl,
              name : this.course.name,
              time : this.course.hours,
              academy : this.dicOption[this.course.sid],
              courseid : res.data.data
            })
            this.course.name = null
            this.course.hours = null
            this.course.sid = null
            this.course.picUrl = null
          }else{
            this.open2()
          }
        }).catch(error=>{
          this.open2()
        })
      }else{
        this.open3()
      }

    },
    updateCourse(){
      this.updatedialogVisible = false
      if(this.course.name!=""||this.course.hours!=""||this.course.sid!=""){
        respose({
          url:"/updateCourse",
          method:'post',
          data:this.course
        }).then(res=>{
          console.log(res.data)
          if(res.data.code == 1){
            this.open1()
            if(this.course.name !=null ){
              this.tableData[this.updateIndex].name = this.course.name
            }
            if(this.course.hours !=null){
              this.tableData[this.updateIndex].time = this.course.hours
            }
            if(this.course.sid != null){
              this.tableData[this.updateIndex].academy = this.dicOption[this.course.sid]
            }
            if(this.course.picUrl!=null ){
              this.tableData[this.updateIndex].pic = this.course.picUrl
            }
            this.course.name = null
            this.course.hours = null
            this.course.sid = null
            this.course.picUrl = null
          }else{
            this.open2()
          }
        }).catch(error=>{
          this.open2()
        })
      }else{
        this.open3()
      }
    },
    getAcademy() {
      respose({
        url: '/getAcademy',
        method: "get"
      }).then(res => {
        console.log(res)
        this.options = res.data.data;
        for(let i in this.options){
          this.dicOption[this.options[i].id] = this.options[i].name
        }
        console.log(this.dicOption)
      })
    },
    addCourse(){
      this.dialogVisible = true
      this.getAcademy()
    }
  },
  data() {
    return {
      tableData: [],
      dialogVisible: false,
      updatedialogVisible: false,
      options: [],
      dicOption:{},
      updateIndex:'',
      course:{
        id: null,
        name:null,
        hours:null,
        sid:null,
        picUrl:null
      },
      index:1
    }
  },
  mounted() {
    respose({
        url:'/getAllAcademy',
        method:"get"
      }
    ).then(res=>{
      let academyData = res.data.data;
      console.log(res)
      for(let i = 0;i<academyData.length;i++){
        let courseData = academyData[i].courses;
        for(let j = 0;j<courseData.length;j++){
          let course = new Object();
          course.id = this.index;
          course.pic = courseData[j].picUrl;
          course.name = courseData[j].name;
          course.time = courseData[j].hours;
          course.academy = academyData[i].name;
          course.courseid = courseData[j].id
          this.tableData.push(course);
          this.index++;
        }
      }
    })
  }
}
</script>

<style scoped>
.coursePage{
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
}
.coursePage_head{
  height: 80px;
  width: 100%;
  background: white;
  display: block;
}
.coursePage_body{
  height: 100%;
  width: 100%;
  display: flex;
}
.coursePage_body_table{
  margin: 5px;
  width: 100%;
  height: 95%;
  /*display: flex;*/
}
.form{
  height: 50px;width: 100%;display: flex;flex-direction: row
}
</style>

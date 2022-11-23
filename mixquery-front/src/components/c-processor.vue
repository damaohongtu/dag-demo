<template>
  <div class="flow-base-node" :id="itemData.id" :style="{ top: itemData.top + 'px', left: itemData.left + 'px', width:'300px' }">
    <i class="iconfont ${opts.options.iconType}"/>
    <el-row class="bg1">
      <el-col :span="24">
        <!--头部信息-->
        <el-row>
          <el-col :span="10" class="inline">
            <label>节点名:</label>
            <input v-model="itemData.id" type="input" class="node_title_input"/>
          </el-col>
          <el-col :span="10" class="inline">
            <label>配置码:</label>
            <input v-model="itemData.id" type="text" disabled="disabled" class="node_title_input"/>
          </el-col>
          <el-col :span="4">
            <div class="del_node">
              <button @click="delNode(itemData.id)">x</button>
            </div>
          </el-col>
        </el-row>
        <div class="line"></div>
        <!--输出字段-->
        <el-row class="input_data">
          <div class="field_title">输出字段:</div>
          <el-row>
            <el-col :span="2"></el-col>
            <el-col :span="8">字段</el-col>
            <el-col :span="8">字段名</el-col>
            <el-col :span="6">类型</el-col>
          </el-row>
          <el-row>
            <div>
              <div v-for="(item, index) in itemData.configInfo.outputField" :key="index">
                <el-row>
                  <el-col :span="8">
                    <input class="_input" v-model="itemData.configInfo.outputField[index].key"/>
                  </el-col>
                  <el-col :span="8">
                    <input class="_input" v-model="itemData.configInfo.outputField[index].name"/>
                  </el-col>
                  <el-col :span="6">
                    <select v-model="itemData.configInfo.outputField[index].type">
                      <option>string</option>
                      <option>int</option>
                    </select>
                  </el-col>
                  <el-col :span="2">
                    <button @click="delOutputField(item.key)">-</button>
                  </el-col>
                </el-row>
              </div>
              <el-row>
                <div class="add_button" align="right">
                  <button @click="addOutputField">+</button>
                </div>
              </el-row>
            </div>
          </el-row>
        </el-row>
        <div class="line"></div>


        <!--输入字段-->
        <el-row class="input_data">
          <div class="field_title">输入字段:</div>
          <el-row>
            <el-col :span="2"></el-col>
            <el-col :span="8">
              <input class="_input" v-model="itemData.configInfo.inputField.key"/>
            </el-col>
            <el-col :span="8">
              <input class="_input" v-model="itemData.configInfo.inputField.name"/>
            </el-col>
            <el-col :span="6">
              <select v-model="itemData.configInfo.inputField.type">
                <option>string</option>
                <option>int</option>
              </select>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <div align="right">
                路由规则:
              </div>
            </el-col>
            <el-col :span="16">
              <div>
                <input class="width_input" v-model="itemData.configInfo.routeRule"/>
              </div>
            </el-col>
          </el-row>
        </el-row>
        <div class="line"></div>

        <!--数据源-->
        <el-row>
          <el-row>
            <el-col :span="8">
              <div align="right">
                数据源:
              </div>
            </el-col>
            <el-col :span="16">
              <div>
                <select class="data_source_select" v-model="itemData.configInfo.dataSource.dataSource">
                  <option>
                    zft
                  </option>
                  <option>
                    vb
                  </option>
                </select>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <div align="right">
                表名:
              </div>
            </el-col>
            <el-col :span="16">
              <div>
                <input class="width_input" v-model="itemData.configInfo.dataSource.table"/>
              </div>
            </el-col>
          </el-row>
        </el-row>

        <div class="line"></div>
        <!--处理器名字-->
        <el-row class="hive">
          <el-col :span="24">
            <div>Hive数据源</div>
          </el-col>
        </el-row>
      </el-col>

    </el-row>
  </div>
</template>

<script>

export default {
  props: ['itemData'],
  methods: {
    onInputConfigInfo(e) {
      this.$store.commit('updateConfigInfo', {
        id: this.itemData.id,
        configInfo: e.target.value
      });
    },
    // 动态添加
    addOutputField () {
      this.itemData.configInfo.outputField.push({key:'', name:'', type:'' })
    },
    delOutputField(key){
      let index = null;
      index = this.itemData.configInfo.outputField.findIndex(item => {
        if(item.key == key){
          return true;
        }
      })
      this.itemData.configInfo.outputField.splice(index, 1)
    },
    // 查看
    search () {
      console.log(this.table)
    },
    delNode(id){
      console.log(id);
      this.$store.commit('delNode', id);
    }
  },
  data(){
    return {
      input_fields: [
        { id:'1', key: '1', name: '', type:'' }
      ]
    }
  }
}
</script>

<style>
.bg1{
  border-radius: 10px;
  background-color: white;
  border: 1px solid #2c3e50;
}
.input_data{

}
.inline{
  align-content: flex-start;
  display: inline;
  flex-wrap: wrap;
}
.line {
  position: relative;
  margin-top: 2px;
  height: 1px;
  background-color: black;
  text-align: center;
  font-size: 16px;
  color: black;
}
.hive{
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  background-color: #009979;
}
.field_title{
  text-align: left;
  color: red;
  font-size: 10px;
}
._input{
  border: 0px;	/*去除所有边框*/
  outline: none;	/*去除选中时出现的边框*/
  border-bottom-color: black;	/*下边框颜色*/
  border-bottom-left-radius: 0px;	/*下左边框的圆角为0px*/
  border-bottom-right-radius: 0px;	/*下右边框的圆角为0px*/
  border-bottom-width: 0.2px;	/*下边框的宽度*/
  border-bottom-style: solid;	/*下边框的样式 solid-->实线*/
  width: 80px;
}
.width_input{
  border: 0px;	/*去除所有边框*/
  outline: none;	/*去除选中时出现的边框*/
  border-bottom-color: black;	/*下边框颜色*/
  border-bottom-left-radius: 0px;	/*下左边框的圆角为0px*/
  border-bottom-right-radius: 0px;	/*下右边框的圆角为0px*/
  border-bottom-width: 0.2px;	/*下边框的宽度*/
  border-bottom-style: solid;	/*下边框的样式 solid-->实线*/
}
.node_title_input{
  width: 50px;
}
.data_source_select{
  width: 140px;
}
.add_button{
  padding-right: 2px;
}
</style>

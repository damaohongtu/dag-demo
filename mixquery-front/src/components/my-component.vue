<template>
    <div>
      <div style="font-size: 30px">
        MixQuery关联图配置
      </div>

      <div class="graph">
        <butterfly-vue
            :canvasData="formattedData"
            @onCreateEdge="onCreateEdge"
        />
        <div class="content"></div>
        <div class="datasource_list">
          <button @click="addA" style="margin-right: 10px">MySQL数据源</button>
          <button @click="addB" style="margin-right: 10px">ClickHouse数据源</button>
          <button @click="addC" style="margin-right: 10px">Hive数据源</button>
          <button @click="addD" style="margin-right: 10px">HTTP数据源</button>
        </div>
      </div>

      <el-row style="padding-top: 20px">
        <el-col :span="24">

          <el-row>
            <el-col :span="1" align="right" style="padding-right: 10px">
              <label>BizCode:</label>
            </el-col>
            <el-col :span="7" align="left">
              <input placeholder="" v-model="bizCode"/>
            </el-col>
          </el-row>

          <el-row style="padding-top: 10px">
            <el-col :span="1" align="right" style="padding-right: 10px">
              <label><font color="red">*</font>BizName:</label>
            </el-col>
            <el-col :span="7" align="left">
              <input placeholder="" v-model="bizName"/>
            </el-col>
          </el-row>

          <el-row style="padding-top: 10px">
            <el-col :span="1" align="right" style="padding-right: 10px">
              <label><font color="red">*</font>关联关系:</label>
            </el-col>
            <el-col :span="6" >
              <div style="border: #2c3e50 1px solid;">
                <!--关联关系-->
                  <el-row>
                    <el-col :span="5">FROM节点</el-col>
                    <el-col :span="5">FROM字段</el-col>
                    <el-col :span="5">TO节点</el-col>
                    <el-col :span="5">TO字段</el-col>
                  </el-row>

                  <el-row>
                      <div v-for="(item, index) in relations" :key="index">
                        <el-row>
                          <el-col :span="5">
                            <el-select v-model="relations[index].fromNode">
                              <el-option
                                  v-for="item in formattedData.nodes"
                                  :key="item.id"
                                  :title="item.id"
                                  :label="item.id"
                                  :value="item.id"
                              >
                              </el-option>
                            </el-select>
                          </el-col>
                          <el-col :span="5">
                            <el-select v-model="relations[index].fromField">
                              <el-option
                                  v-for="item in formattedData.nodeMap.get(relations[index].fromNode)"
                                  :key="item.key"
                                  :title="item.key"
                                  :label="item.key"
                                  :value="item.key"
                              >
                              </el-option>
                            </el-select>
                          </el-col>
                          <el-col :span="5">
                            <el-select v-model="relations[index].toNode">
                              <el-option
                                  v-for="item in formattedData.nodes"
                                  :key="item.id"
                                  :title="item.id"
                                  :label="item.id"
                                  :value="item.id"
                              >
                              </el-option>
                            </el-select>
                          </el-col>
                          <el-col :span="5">
                            <el-select v-model="relations[index].toField">
                              <el-option
                                  v-for="item in formattedData.nodeMap.get(relations[index].toNode)"
                                  :key="item.key"
                                  :title="item.key"
                                  :label="item.key"
                                  :value="item.key"
                              >
                              </el-option>
                            </el-select>
                          </el-col>
                          <el-col :span="1">
                            <el-button type="danger" icon="el-icon-delete" @click="delOutputField(item.id)" circle plain></el-button>
                          </el-col>
                        </el-row>
                      </div>
                      <el-row>
                        <el-col :span="5">&nbsp;</el-col>
                        <el-col :span="5">&nbsp;</el-col>
                        <el-col :span="5">&nbsp;</el-col>
                        <el-col :span="5">&nbsp;</el-col>
                        <el-col :span="1">
                          <div class="add_button">
                            <el-button type="success" icon="el-icon-plus" @click="addOutputField" circle plain></el-button>
                          </div>
                        </el-col>

                      </el-row>
                  </el-row>
              </div>
            </el-col>
          </el-row>

          <el-row style="padding-top: 10px">
            <el-col :span="1" align="right" style="padding-right: 10px">
              业务描述:
            </el-col>
            <el-col :span="6">
              <el-input type="textarea"></el-input>
            </el-col>
          </el-row>

          <el-row align="left" style="padding-top: 10px">
            <el-col :span="1" align="right" style="padding-right: 10px">
              <el-button type="primary" @click="commitGraph">提交</el-button>

            </el-col>
          </el-row>
        </el-col>


      </el-row>


    </div>

</template>

<script>
import { ButterflyVue } from 'butterfly-vue';
import {PROCESSOR_DICT} from '../processor-dict.js';

export default {
    components: {
        ButterflyVue
    },

    data(){
        return {
          bizCode: -1,
          bizName: '',
          relations: [
            { fromNode: '', fromField: '', toNode:'', toField:'' }
          ]
        };
    },
    computed: {
        
        data: {
            get() {
                return this.$store.state.data;
            },
            set(val) {
                this.$store.commit('update', val);
            }
        },
        configInfo(){
          let configlist = {...this.data};
          let nodes = configlist.nodes;
          let edges = configlist.edges;
            // 解析边，获取from,to
          let graphParent = {}
          let graphChild = {}
            for (let index = 0; index < nodes.length; index++) {
                const element = nodes[index];
                graphParent[element.id] = [];
                graphChild[element.id] = [];
            }
            for (let index = 0; index < edges.length; index++) {
                const element = edges[index];
                graphParent[element.targetNode].push(element.sourceNode);
                graphChild[element.sourceNode].push(element.targetNode);
            }

          let res = [];
            for (let index = 0; index < nodes.length; index++) {
                const element = nodes[index];
              let item = {
                    'id': element.id,
                    'configInfo': element.configInfo,
                    'parent': graphParent[element.id].join('; '),
                    'child': graphChild[element.id].join('; ')
                };
                res.push(item);
            }
            
            return res;
        },
        formattedData() {
          let configList = {...this.data};
          let nodeList = configList.nodes;
          let nodeMap = new Map()
          nodeList.forEach(
              (item) => {
                nodeMap.set(item.id, item.configInfo.outputField)
              }
          );
            return {
              ...this.data,
              nodes: this.data.nodes.map(x => ({...x, render: PROCESSOR_DICT[x.processor]})),
              nodeMap: nodeMap
            }
        }
    },

    methods: {
        addA() {
            this.$store.commit('addA');
            this.save();
        },
        addB(){
            this.$store.commit('addB');
            this.save();
        },
        addC(){
            this.$store.commit('addC');
            this.save();
        },
        addD(){
            this.$store.commit('addD');
            this.save();
        },
        onCreateEdge() {
            this.save();
        },
        save() {
            this.$store.commit('save');
        },
        commitGraph(){
          console.log(this.formattedData);

          let nodes = [];
          for (let index =0;  index < this.formattedData.nodes.length; index++) {
            let node = this.formattedData.nodes[index];
            let curRelations = [];
            for (let idx =0; idx<this.relations.length; idx++){
              if(this.relations[idx].fromNode == node.id){
                curRelations.push(
                    {
                      fromNode: this.relations[idx].fromNode,
                      fromField: this.relations[idx].fromField,
                      toNode: this.relations[idx].toNode,
                      toField: this.relations[idx].toField
                    }
                );
              }
            }
            nodes.push(
                {
                  "id": node.id,
                  "nodeType": "1",
                  "coordinate": JSON.stringify({
                    "left": node.left,
                    "top": node.top
                  }),
                  "configInfo": {
                    "dataSource": JSON.stringify(node.configInfo.dataSource),
                    "inputField": JSON.stringify(node.configInfo.inputField),
                    "outputField": JSON.stringify(node.configInfo.outputField),
                    "routeRule": JSON.stringify(node.configInfo.routeRule),
                    "relations": JSON.stringify(curRelations)
                  }
                }
            );
          }

          let data = {
            "bizCode": this.bizCode,
            "bizName": this.bizName,
            "bizDesc": "str",
            "nodes": nodes,
            "edges": JSON.stringify(this.formattedData.edges)
          }
          this.axios.post('/config', data).then(res => {
            console.log(JSON.stringify(res));
          });


        },
      addOutputField () {
        this.relations.push(
          {
            fromNode: '',
            fromField: '',
            toNode: '',
            toField: ''
          }
        );
        let test = this.formattedData.nodeMap;
        console.log(test)
        console.log(JSON.stringify(test.get("1")));

      },
      delOutputField(index){
        this.relations.splice(index, 1)
      }
    }
}
</script>

<style scoped>
.content{
    margin-top: 10px;
    display: flex;
    align-items: center;
    justify-content: center;
}
.graph{
  border: 1px solid #2c3e50;
  padding: 10px;
}
.datasource_list{
  padding: 10px;
}
</style>
<template>
  <div>
    <div style="font-size: 30px">
      MixQuery关联图管理
    </div>
    <div class="content" style="border: #2c3e50 solid 1px;">
      <el-row :span="24">
        <el-col :span="16">
          <el-col :span="12">
            <el-form>
              <el-col :span="6">
                <el-form-item label="配置编码:" prop="name">
                  <el-input style="width: 80px;"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="配置名称:">
                  <el-input placeholder="名称" style="width: 80px;"></el-input>
                </el-form-item>
              </el-col>
            </el-form>
          </el-col>
          <el-col :span="4">
            <div align="right" style="padding-bottom: 10px">
              <el-button type="primary" @click="testBackEnd">查询</el-button>
            </div>
          </el-col>
        </el-col>
        <el-col :span="8">
          <div align="right" style="padding-bottom: 10px">
            <el-button type="primary" @click="add">新增</el-button>
          </div>
        </el-col>
      </el-row>

      <div class="content">
        <el-table :data="graphInfo" border>
          <el-table-column prop="graphCode" label="配置编码"></el-table-column>
          <el-table-column prop="graphName" label="业务名"></el-table-column>
          <el-table-column prop="createTime" label="创建时间"></el-table-column>
          <el-table-column prop="updateTime" label="更新时间"></el-table-column>
          <el-table-column prop="createBy" label="创建人"></el-table-column>
          <el-table-column prop="updateBy" label="更新人"></el-table-column>
          <el-table-column prop="updateBy" label="操作">
            <el-button type="success" @click="query">查看</el-button>
            <el-button type="danger" @click="edit">编辑</el-button>
          </el-table-column>

        </el-table>
        <div align="right" style="padding-right: 10px; padding-top: 5px">
          <el-pagination
              background
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="currentPage"
              :page-sizes="[5, 10, 20, 40]"
              :page-size="pagesize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="100">
          </el-pagination>
        </div>

      </div>
    </div>

  </div>

</template>

<script>
export default {
  name: "graph-manage",
  data(){
    return {
      graphInfo: [
        {graphCode: "G202211120001", graphName: "测试", createTime: "2022-11-20 17:00 000", updateTime: "2022-11-20 17:00 000", createBy: "tianmao", updateBy: "tianmao"},
        {graphCode: "G202211120002", graphName: "测试", createTime: "2022-11-20 17:00 000", updateTime: "2022-11-20 17:00 000", createBy: "tianmao", updateBy: "tianmao"},
        {graphCode: "G202211120003", graphName: "测试", createTime: "2022-11-20 17:00 000", updateTime: "2022-11-20 17:00 000", createBy: "tianmao", updateBy: "tianmao"}
      ],
      graphCondition: {
        code: ''
      }
    }
  },
  methods: {
    add(){
      this.$router.push({path: '/graph'})
    },
    query(graphCode){
      this.$router.push({path: '/graph', params: {graphCode: graphCode}})
    },
    edit(graphCode){
      this.$router.push({path: '/graph', params: {graphCode: graphCode}})
    },
    testBackEnd(){
      this.axios.get('/test').then(res => {
        console.log(JSON.stringify(res));
        this.graphInfo = res.data;
      });
    }
  },
  created() {
    this.axios.get('/test').then(res => {
      console.log(JSON.stringify(res));
      this.graphInfo = res.data;
    });
  }
}
</script>

<style scoped>
.content{
  padding: 5px;

}
</style>
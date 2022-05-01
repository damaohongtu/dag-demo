<template>
    <div>
        <butterfly-vue
            :canvasData="formattedData"
            @onCreateEdge="onCreateEdge"
        />
        <div class="content"></div>
        <button @click="addA">添加A处理器</button>
        <button @click="addB">添加B处理器</button>
        <button @click="addC">添加C处理器</button>
        <button @click="addD">添加D处理器</button>
        <div class="content">
            <el-table :data="configInfo" border>
                <el-table-column prop="id" label="配置码"></el-table-column>
                <el-table-column prop="config2" label="配置2"></el-table-column>
                <el-table-column prop="config3" label="配置3"></el-table-column>
                <el-table-column prop="parent" label="父节点"></el-table-column>
                <el-table-column prop="child" label="子节点"></el-table-column>
            </el-table>
        </div>

        <!-- <div>{{configInfo}}</div> -->
    </div>

</template>

<script>
import { ButterflyVue } from 'butterfly-vue';
import {PROCESSOR_DICT} from './processor-dict.js';

export default {
    components: {
        ButterflyVue
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
            var configlist = {...this.data};
            var nodes = configlist.nodes;
            var edges = configlist.edges;
            // 解析边，获取from,to
            var graphParent = {}
            var graphChild = {}
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

            var res = [];
            for (let index = 0; index < nodes.length; index++) {
                const element = nodes[index];
                var item = {
                    'id':element.id, 
                    'config2':element.config2,
                    'config3':element.config3,
                    'parent':graphParent[element.id].join('; '), 
                    'child':graphChild[element.id].join('; ')
                };
                res.push(item);
            }
            
            return res;
        }
        ,
        formattedData() {
            return {
                ...this.data,
                nodes: this.data.nodes.map(x => ({...x, render: PROCESSOR_DICT[x.processor]}))
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
        }

    }
}
</script>

<style scoped>
.content{
    margin-top: 30px;
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>
<template>
    <div class="flow-base-node" :id="itemData.id" :style="{ top: itemData.top + 'px', left: itemData.left + 'px', width:'300px' }">
        <div class="bg3">
            <i class="iconfont ${opts.options.iconType}"/>
            <div class="text">C处理器</div>
            <div>
                <label>配置码:</label>
                <input class="input_config" v-model="itemData.id"  type="text" disabled="disabled"/>
            </div>
            <div>
                <label>配置:</label>
                <input  v-model="itemData.configInfo" @input="onInputConfigInfo" class="input_config" placeholder=""/>
            </div>
        </div>
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
        }
    }
}
</script>

<style>
    .bg3{
        background-color: #B0E3E6;
        padding: 20px;
        border-radius: 10px;
    }
    .input_config{
        width:100px;
    }
    label{
        width: 60px;
        display: inline-block;
        text-align: right;
    }
</style>

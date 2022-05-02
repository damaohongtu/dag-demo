<template>
    <div class="flow-base-node" :id="itemData.id" :style="{ top: itemData.top + 'px', left: itemData.left + 'px', width:'300px' }">
        <div class="bg1">
            <i class="iconfont ${opts.options.iconType}"/>
            <div class="text">A处理器</div>
            <div>
                <label>配置码:</label>
                <input class="input_config" v-model="itemData.id"  type="text" disabled="disabled"/>
            </div>
            <div>
                <label>配置:</label>
                <input class="input_config" placeholder="" v-model="itemData.configInfo" @input="onInputConfigInfo"/>
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
    .bg1{
        background-color: #CDEB8B;
        padding: 20px;
        border-radius: 10px;
    }
    .input_config{
        width:100px;
    }
    label{
        width: 50px;
        display: inline-block;
        text-align: right;
    }
</style>

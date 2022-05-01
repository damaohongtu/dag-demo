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
                <label>配置2:</label>
                <input  v-model="itemData.config2" @input="onInputConfig2" class="input_config" placeholder=""/>
            </div>
            <div>
                <label>配置3:</label>
                <select  v-model="itemData.config3" @input="onInputConfig3" class="input_config">
                    <option value="配置3.1">配置3.1</option>
                    <option value="配置3.2">配置3.2</option>
                </select>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: ['itemData'],
    methods: {
        onInputConfig2(e) {
            this.$store.commit('updateConfig2', { 
                id: this.itemData.id, 
                config2: e.target.value
            });
        },
        onInputConfig3(e) {
            this.$store.commit('updateConfig3', { 
                id: this.itemData.id, 
                config3: e.target.value
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

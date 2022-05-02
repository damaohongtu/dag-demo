import Vuex from 'vuex';
import Vue from 'vue';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        // data: JSON.parse(localStorage.getItem('data')) || {
        //     bizCode: -1,
        //     bizName: '',
        //     nodes: [],
        //     edges: []
        // }
        data: {
            bizCode: -1,
            bizName: '',
            nodes: [],
            edges: []
        }
    },
    mutations: {
        update(state, payload) {
            state.data = payload;
            localStorage.setItem('data', JSON.stringify(state.data));
        },
        addA(state) {
            const length = state.data.nodes.length;
            state.data.nodes.push({
                id: `${length + 1}`,
                label: 'recordBusinessNo_1',
                left: length * 400,
                top: length%2 * 300,
                iconType: 'icon-xianshang',
                configInfo: '',
                processor: 'A',
                endpoints: [
                    {
                        id: 'right',
                        orientation: [1, 0],
                        pos: [0, 0.5]
                    }, 
                    {
                        id: 'bottom',
                        orientation: [0, 1],
                        pos: [0.5, 0]
                    }, 
                    {
                        id: 'left',
                        orientation: [-1, 0],
                        pos: [0, 0.5]
                    },
                    {
                        id: 'top',
                        orientation: [0, -1],
                        pos: [0.5, 0]
                    }
                ]
            });
        },
        addB(state) {
            const length = state.data.nodes.length;
            state.data.nodes.push({
                id: `${length + 1}`,
                label: 'recordBusinessNo_1',
                left: length * 400,
                top: length%2 * 300,
                iconType: 'icon-xianshang',
                configInfgo:'',
                processor: 'B',
                endpoints: [
                    {
                        id: 'right',
                        orientation: [1, 0],
                        pos: [0, 0.5]
                    }, 
                    {
                        id: 'bottom',
                        orientation: [0, 1],
                        pos: [0.5, 0]
                    }, 
                    {
                        id: 'left',
                        orientation: [-1, 0],
                        pos: [0, 0.5]
                    },
                    {
                        id: 'top',
                        orientation: [0, -1],
                        pos: [0.5, 0]
                    }
                ]
            });
        },
        addC(state) {
            const length = state.data.nodes.length;
            state.data.nodes.push({
                id: `${length + 1}`,
                label: 'recordBusinessNo_1',
                left: length * 400,
                top: length%2 * 300,
                iconType: 'icon-xianshang',
                configInfo:'',
                processor: 'C',
                endpoints: [
                    {
                        id: 'right',
                        orientation: [1, 0],
                        pos: [0, 0.5]
                    }, 
                    {
                        id: 'bottom',
                        orientation: [0, 1],
                        pos: [0.5, 0]
                    }, 
                    {
                        id: 'left',
                        orientation: [-1, 0],
                        pos: [0, 0.5]
                    },
                    {
                        id: 'top',
                        orientation: [0, -1],
                        pos: [0.5, 0]
                    }
                ]
            });
        },
        addD(state) {
            const length = state.data.nodes.length;
            state.data.nodes.push({
                id: `${length + 1}`,
                label: 'recordBusinessNo_1',
                left: length * 400,
                top: length%2 * 300,
                iconType: 'icon-xianshang',
                configInfo:'',
                processor: 'D',
                endpoints: [
                    {
                        id: 'right',
                        orientation: [1, 0],
                        pos: [0, 0.5]
                    }, 
                    {
                        id: 'bottom',
                        orientation: [0, 1],
                        pos: [0.5, 0]
                    }, 
                    {
                        id: 'left',
                        orientation: [-1, 0],
                        pos: [0, 0.5]
                    },
                    {
                        id: 'top',
                        orientation: [0, -1],
                        pos: [0.5, 0]
                    }
            ]
            });
        },

        updateConfigInfo(state, { id, configInfo }) {
            state.data.nodes.find(x => x.id === id).configInfo = configInfo;
            //localStorage.setItem('data', JSON.stringify(state.data));
        },

        updateBizCode(state, {bizCode}) {
            state.data.bizCode = bizCode;
            //localStorage.setItem('data', JSON.stringify(state.data));
        },

        updateBizName(state, {bizName}) {
            state.data.bizName = bizName;
            localStorage.setItem('data', JSON.stringify(state.data));
        },

        save(state) {
            localStorage.setItem('data', JSON.stringify(state.data));
        }
    }
})
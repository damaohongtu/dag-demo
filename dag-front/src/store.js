import Vuex from 'vuex';
import Vue from 'vue';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        data: JSON.parse(localStorage.getItem('data')) || {
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
                config2:'',
                config3:'',
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
                config2:'',
                config3:'',
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
                config2:'',
                config3:'',
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
                config2:'',
                config3:'',
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

        updateConfig2(state, { id, config2 }) {
            state.data.nodes.find(x => x.id === id).config2 = config2;
            localStorage.setItem('data', JSON.stringify(state.data));
        },
        updateConfig3(state, { id, config3 }) {
            state.data.nodes.find(x => x.id === id).config3 = config3;
            localStorage.setItem('data', JSON.stringify(state.data));
        },
        save(state) {
            localStorage.setItem('data', JSON.stringify(state.data));
        }
    }
})

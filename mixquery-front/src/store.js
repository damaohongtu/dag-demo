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

        delNode(state, id){
            let index = null;
            index = state.data.nodes.findIndex(item => {
                if(item.id == id){
                    return true;
                }
            })
            state.data.nodes.splice(index, 1);
        },
        addA(state) {
            const length = state.data.nodes.length;
            state.data.nodes.push({
                id: `${length + 1}`,
                label: 'recordBusinessNo_1',
                left: length * 50,
                top: length * 50,
                iconType: 'icon-xianshang',
                configInfo: {
                    outputField:[
                        {
                            key: '',
                            name: '',
                            type: ''
                        }
                    ],
                    inputField:{
                        key: '',
                        name: '',
                        type: ''
                    },
                    routeRule:'',
                    dataSource:{
                        dataSource: '',
                        table:'',
                        hash:''
                    }
                },
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
                left: length * 50,
                top: length * 50,
                iconType: 'icon-xianshang',
                configInfo: {
                    outputField:[
                        {
                            key: '',
                            name: '',
                            type: ''
                        }
                    ],
                    inputField:{
                        key: '',
                        name: '',
                        type: ''
                    },
                    routeRule:'',
                    dataSource:{
                        dataSource: '',
                        table:''
                    }
                },
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
                left: length * 50,
                top: length * 50,
                iconType: 'icon-xianshang',
                configInfo: {
                    outputField:[
                        {
                            key: '',
                            name: '',
                            type: ''
                        }
                    ],
                    inputField:{
                        key: '',
                        name: '',
                        type: ''
                    },
                    routeRule:'',
                    dataSource:{
                        dataSource: '',
                        table:''
                    }
                },
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
                left: length * 50,
                top: length * 50,
                iconType: 'icon-xianshang',
                configInfo: {
                    outputField:[
                        {
                            key: '',
                            name: '',
                            type: ''
                        }
                    ],
                    inputField:{
                        key: '',
                        name: '',
                        type: ''
                    },
                    routeRule:'',
                    dataSource:{
                        uri: '',
                        method:''
                    }
                },
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
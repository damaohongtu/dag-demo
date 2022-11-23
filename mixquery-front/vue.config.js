const path = require("path");

module.exports = {
    assetsDir:"static",
    devServer: {
        host: "0.0.0.0",
        port: 9999,
        https: false,
        open: true,
        proxy: {
            "/test": {
                target: "http://127.0.0.1:8080",
                //ws: true, // 是否启用websockets
                changeOrigin: true,
                pathRewrite: {
                    '^/test': '/api/mixquery/graph'
                }
            },
            "/config": {
                target: "http://127.0.0.1:8080",
                //ws: true, // 是否启用websockets
                changeOrigin: true,
                pathRewrite: {
                    '^/config': '/api/mixquery/graph/config'
                }
            }
        }
    }
}

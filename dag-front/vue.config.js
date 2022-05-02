const path = require("path");

module.exports = {
    assetsDir:"static",
    devServer: {
        host: "0.0.0.0",
        port: 8889,
        https: false,
        open: true,
        proxy: {
            "/test": {
                target: "http://127.0.0.1:9999",
                //ws: true, // 是否启用websockets
                changeOrigin: true,
                pathRewrite: {
                    '^/test': '/test/createConfig'
                }
            }
        }
    }
}

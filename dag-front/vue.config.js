const path = require("path");

module.exports = {
    assetsDir:"static",
    devServer: {
        host: "0.0.0.0",
        port: 8889, // 端口号
        https: false, // https:{type:Boolean}
        open: true, //配置自动启动浏览器
        proxy: {
            "/test": {
                target: "http://127.0.0.1:9999",
                //ws: true, // 是否启用websockets
                changeOrigin: true,
                pathRewrite: {
                    '^/test': '/test/getConfig'
                }
            }
        }
    }
}

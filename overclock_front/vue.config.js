const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
const target = 'http://localhost:9090'
module.exports = {
  devServer: {
    port: 8080,
    proxy: { '/api': { target, changeOrigin: true } },
  },
  outputDir:
    'D:/Overclock/overclock/src/main/resources/static',
}
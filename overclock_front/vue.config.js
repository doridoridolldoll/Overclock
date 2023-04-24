const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
const target = 'http://localhost:9090'
module.exports = {
  devServer: {
<<<<<<< Updated upstream
    port: 8080,

=======
    historyApiFallback: true,
>>>>>>> Stashed changes
    proxy: {
      '/api': { target, changeOrigin: true } ,
      '/member': { target, changeOrigin: true } 
    }

  },
  outputDir:
    'D:/Overclock/overclock/src/main/resources/static'
}
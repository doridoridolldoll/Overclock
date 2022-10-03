const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
const target = 'http://localhost:9090'
module.exports = {
  configureWebpack: {
    resolve: {
        alias: {
            '@': path.join(__dirname, 'src/'),
            '@comp': path.join(__dirname, 'src/components'),
            '@views': path.join(__dirname, 'src/views')
        }
    },
        devServer: {
          port: 8080,
          proxy: {
            '/api': { target, changeOrigin: true } ,
            '/member': { target, changeOrigin: true } 
          }
        },
        outputDir:
          'D:/Overclock/overclock/src/main/resources/static'
      }
    }



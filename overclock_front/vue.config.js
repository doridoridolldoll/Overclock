const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
});
const target = "http://localhost:9090";
module.exports = defineConfig({
  configureWebpack: {
    performance: {
      maxEntrypointSize: 5120000,
      maxAssetSize: 5120000,
    },
  },

  devServer: {
    port: 8080,
    historyApiFallback: true,
    proxy: {
      "/api/": { target, changeOrigin: true },
      "/overclock/register": { target, changeOrigin: true },
      "/overclock/member": { target, changeOrigin: true },
    },
  },
  transpileDependencies: ["vue-meta"],
});

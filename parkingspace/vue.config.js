const { defineConfig } = require('@vue/cli-service')
process.env.VUE_APP_BACKEND_URL = `http://localhost:${process.env.SPRINGBOOT_PORT}`
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port : process.env.FRONTEND_PORT,
    proxy: {
      '^/api': {
        target: `http://localhost:${process.env.SPRINGBOOT_PORT}`,
        changeOrigin: true
      },
    }
  }
})

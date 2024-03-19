const { defineConfig } = require('@vue/cli-service')
// process.env.VUE_APP_BACKEND_URL = `http://localhost:${process.env.SPRINGBOOT_PORT}`
process.env.VUE_APP_BACKEND_URL = `http://localhost:8080`
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  devServer: {
    // port : process.env.FRONTEND_PORT,
    port : 8080,
    proxy: {
      '^/api': {
        // target: `http://localhost:${process.env.SPRINGBOOT_PORT}`,
        target: `http://localhost:8080`,

        changeOrigin: true
      },
    }
  }
})

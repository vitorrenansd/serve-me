import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      // Redireciona qualquer requisição que comece com /api
      '/api': {
        target: 'http://localhost:8080', // O endereço do backend
        changeOrigin: true, //aceita qualquer requisição
        secure: false,      // Se formos utilizar HTTPS no BE, alterar para true
      }
    }
  }
})
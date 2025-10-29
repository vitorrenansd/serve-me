import axios from 'axios';

const apiClient = axios.create({
  baseURL: '/api', //Aponta para o BE
  headers: {
    'Content-Type': 'application/json',
  },
});

// Função para enviar um novo pedido
export const sendOrder = (orderData) => {
  // orderData deve ser um objeto no formato do seu DTO OrderRequest
  return apiClient.post('/order/send', orderData);
};

// (Podemos adicionar uma função para buscar os produtos aqui depois)
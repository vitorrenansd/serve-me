import { useState } from 'react';
import { sendOrder } from './services/api'; // Importamos nossa função

function App() {
  // Simulando os dados do formulário
  // No futuro, isso virá de inputs, selects, etc.
  const [waiter, setWaiter] = useState('Vitor');
  const [table, setTable] = useState(10);
  const [productId, setProductId] = useState('1');
  const [quantity, setQuantity] = useState(2);
  const [notes, setNotes] = useState('Sem gelo');
  
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage('');

    // Monta o obj exatamente como está no DTO `OrderRequest`
    const orderData = {
      waiter: waiter,
      table: parseInt(table),
      orderItems: [
        {
          productId: productId,
          quantity: parseInt(quantity),
          notes: notes
        }
      ]
    };

    try {
      // O `sendOrder` usa o axios para fazer o POST
      await sendOrder(orderData);
      setMessage('Pedido enviado com sucesso!');
      
    } catch (error) {
      console.error('Erro ao enviar pedido:', error);
      setMessage('Falha ao enviar o pedido.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div>
      <h1>Enviar Pedido - ServeMe</h1>
      <form onSubmit={handleSubmit}>
        {/* Aqui ficaria os inputs, porém utilizando valores fixos por enquanto */}
        <p>Garçom: {waiter}</p>
        <p>Mesa: {table}</p>
        <p>Item: Batata Frita (ID: {productId})</p>
        <p>Qtd: {quantity}</p>
        
        <button type="submit" disabled={loading}>
          {loading ? 'Enviando...' : 'Enviar Pedido'}
        </button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
}

export default App;
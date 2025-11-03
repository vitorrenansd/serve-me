import React, { useState } from 'react';
import './Modal.css';

const Modal = ({ product, onClose, onAddToCart }) => {
  const [quantity, setQuantity] = useState(1);

  if (!product) {
    return null;
  }

  const handleQuantityChange = (e) => {
    const value = parseInt(e.target.value, 10);
    if (value > 0) {
      setQuantity(value);
    }
  };

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()}>
        <button className="modal-close" onClick={onClose}>X</button>
        <div className="modal-body">
          <img src={product.photoUrl} alt={product.name} className="modal-image" />
          <div className="modal-info">
            <h2>{product.name}</h2>
            <p>{product.description}</p>
            <span className="modal-price">R$ {product.price.toFixed(2)}</span>
            <div className="modal-actions">
              <input type="number" value={quantity} onChange={handleQuantityChange} min="1" />
              <button onClick={() => onAddToCart(product, quantity)}>Adicionar ao Carrinho</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Modal;

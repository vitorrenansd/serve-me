import React, { useState, useEffect } from 'react';
import Modal from './Modal';
import { getProducts, getCategories } from '../services/api';
import './Menu.css';

const Menu = () => {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedProduct, setSelectedProduct] = useState(null);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [cart, setCart] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [productsResponse, categoriesResponse] = await Promise.all([
          getProducts(),
          getCategories(),
        ]);
        setProducts(productsResponse.data);
        setCategories(categoriesResponse.data);
      } catch (error) {
        console.error('Erro ao buscar dados:', error);
      }
    };

    fetchData();
  }, []);

  const scrollToCategory = (categoryId) => {
    const categoryElement = document.getElementById(`category-${categoryId}`);
    if (categoryElement) {
      categoryElement.scrollIntoView({ behavior: 'smooth' });
    }
  };

  const handleProductClick = (product) => {
    setSelectedProduct(product);
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
    setSelectedProduct(null);
  };

  const handleAddToCart = (product, quantity) => {
    setCart([...cart, { ...product, quantity }]);
    handleCloseModal();
  };

  return (
    <div className="menu-container">
      <header className="menu-header">
        <h1>Cardápio</h1>
        <nav className="category-nav">
          {categories.map(category => (
            <button key={category.id} onClick={() => scrollToCategory(category.id)}>
              {category.name}
            </button>
          ))}
        </nav>
        <div className="cart-icon">
          Carrinho: {cart.length}
        </div>
      </header>

      <main className="menu-content">
        {categories.map(category => (
          <section key={category.id} id={`category-${category.id}`} className="category-section">
            <h2>{category.name}</h2>
            <div className="product-list">
              {products.filter(p => p.fkCategory === category.id).map(product => (
                <div key={product.id} className="product-card" onClick={() => handleProductClick(product)}>
                  <img src={product.images && product.images[0]} alt={product.name} className="product-image" />
                  <div className="product-info">
                    <h3>{product.name}</h3>
                    <p>{product.description}</p>
                    <span className="product-price">R$ {product.price.toFixed(2)}</span>
                  </div>
                </div>
              ))}
            </div>
          </section>
        ))}
      </main>

      <Modal 
        product={selectedProduct} 
        onClose={handleCloseModal} 
        onAddToCart={handleAddToCart} 
      />
    </div>
  );
};

export default Menu;

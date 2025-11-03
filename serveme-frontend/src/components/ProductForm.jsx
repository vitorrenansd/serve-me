import React, { useState, useEffect } from 'react';
import { createProduct, getCategories } from '../services/api';
import axios from 'axios'; // Import axios
import './ProductForm.css';

const ProductForm = () => {
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const [price, setPrice] = useState('');
    const [categoryId, setCategoryId] = useState('');
    const [selectedFiles, setSelectedFiles] = useState([]); // To store file objects
    const [imageUrls, setImageUrls] = useState([]); // To store URLs from backend
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        const fetchCategories = async () => {
            try {
                const response = await getCategories();
                setCategories(response.data);
            } catch (error) {
                console.error('Erro ao buscar categorias:', error);
            }
        };

        fetchCategories();
    }, []);

    const handleFileChange = (e) => {
        setSelectedFiles(Array.from(e.target.files));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        // 1. Upload images first
        const uploadedImageUrls = [];
        if (selectedFiles.length > 0) {
            const formData = new FormData();
            selectedFiles.forEach(file => {
                formData.append('files', file);
            });

            try {
                const uploadResponse = await axios.post('/api/upload', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data',
                    },
                });
                uploadedImageUrls.push(...uploadResponse.data);
            } catch (error) {
                console.error('Erro ao fazer upload das imagens:', error);
                alert('Erro ao fazer upload das imagens.');
                return; // Stop submission if image upload fails
            }
        }

        // 2. Then create the product with the uploaded image URLs
        const productData = {
            name,
            description,
            price: parseFloat(price),
            fkCategory: parseInt(categoryId),
            images: uploadedImageUrls,
        };

        try {
            await createProduct(productData);
            // Limpar o formulário após o sucesso
            setName('');
            setDescription('');
            setPrice('');
            setCategoryId('');
            setSelectedFiles([]);
            setImageUrls([]);
            alert('Produto criado com sucesso!');
        } catch (error) {
            console.error('Erro ao criar produto:', error);
            alert('Erro ao criar produto.');
        }
    };

    return (
        <div className="product-form-container">
            <h2>Adicionar Novo Produto</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Nome</label>
                    <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label>Descrição</label>
                    <textarea value={description} onChange={(e) => setDescription(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label>Preço</label>
                    <input type="number" value={price} onChange={(e) => setPrice(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label>Categoria</label>
                    <select value={categoryId} onChange={(e) => setCategoryId(e.target.value)} required>
                        <option value="">Selecione uma categoria</option>
                        {categories.map(category => (
                            <option key={category.id} value={category.id}>{category.name}</option>
                        ))}
                    </select>
                </div>
                <div className="form-group">
                    <label>Imagens</label>
                    <input type="file" multiple onChange={handleFileChange} />
                </div>
                <div className="image-preview">
                    {selectedFiles.map((file, index) => (
                        <img key={index} src={URL.createObjectURL(file)} alt={`preview ${index}`} />
                    ))}
                </div>
                <button type="submit">Adicionar Produto</button>
            </form>
        </div>
    );
};

export default ProductForm;
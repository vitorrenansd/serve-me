import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Menu from './components/Menu';
import ProductForm from './components/ProductForm';

function App() {
  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/">Menu</Link>
            </li>
            <li>
              <Link to="/admin/products/new">Adicionar Produto</Link>
            </li>
          </ul>
        </nav>

        <hr />

        <Routes>
          <Route path="/" element={<Menu />} />
          <Route path="/admin/products/new" element={<ProductForm />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;

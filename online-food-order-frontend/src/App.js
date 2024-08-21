import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from './Components/Login';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Signup from './Components/Signup';
import Home from './Components/Home';
import "react-toastify/dist/ReactToastify.css";
import { ToastContainer } from 'react-toastify';
import FoodCategory from './Components/FoodCategory';
import CategoryDishes from './Components/CategoryDishes';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <ToastContainer position='bottom-center' icon={false} />
        {/* <CustomNavbar /> */}
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path='/order' element={<FoodCategory />} />
          <Route path='/category/:categoryName' element={<CategoryDishes />} /> {/* Add this route */}
        </Routes>
      </BrowserRouter>
      {/* <Login /> */}
      {/* <Signup /> */}
    </div>
  );
}

export default App;

import logo from './logo.svg';
import './App.css';
import {LoginForm} from "./Components/LoginForm";

import { Route, Routes } from "react-router-dom";
import "./App.css";
import {Dashboard} from "./Components/Dashboard";
import {Customers} from "./Components/Customers";
import {Products} from "./Components/Products";
import {Orders} from "./Components/Orders";

function App() {
    return (
        <Routes>
            <Route path='/' element={  <LoginForm />} />
            <Route path='login' element={  <LoginForm />} />
            <Route path='dashboard' element={  <Dashboard />} />
            <Route path='customers' element={  <Customers />} />
            <Route path='products' element={  <Products />} />
            <Route path='Orders' element={  <Orders />} />

        </Routes>
    );
}

export default App;

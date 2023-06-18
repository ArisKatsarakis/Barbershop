import logo from './logo.svg';
import './App.css';
import {LoginForm} from "./Components/LoginForm";

import { Route, Routes } from "react-router-dom";
import "./App.css";
import {Dashboard} from "./Components/Dashboard";

function App() {
    return (
        <Routes>
            <Route path='/' element={  <LoginForm />} />
            <Route path='login' element={  <LoginForm />} />
            <Route path='dashboard' element={  <Dashboard />} />

        </Routes>
    );
}

export default App;

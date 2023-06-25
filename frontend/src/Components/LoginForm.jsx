import React from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {Navigation} from "./Navigation";
export const LoginForm = () => {
    const [username, setUsername] = React.useState();
    const [password, setPassword] = React.useState();
    const [message, setMessage] = React.useState();
    const navigate = useNavigate();



    const  handleSubmit = async (e) => {
        e.preventDefault();
        console.log(username, password);

        const  config = {
            method: 'post',
            maxBodyLength: Infinity,
            headers: { }
        };
         const request  = await axios.post(`http://localhost:8080/api/v1/authenticate?username=${username}&password=${password}`,null,config);
        console.log(request);
        setMessage(request.data.toString());
        if(message === undefined) {navigate('/dashboard');}



    }
    const changeUsername = (e) => {
        e.preventDefault();
        setUsername(e.target.value)
    }

    const changePassword = (e) => {
        e.preventDefault();
        setPassword(e.target.value);
    }
    return (
        <>

            <Navigation/>
            <h1>Login Page</h1>
            <form method={"POST"} onSubmit={handleSubmit} className={"login-form form-control"}>
                <label htmlFor={"username"} className={"form-label"}>Username: </label>
                <input type={"text"} value={username} name={"username"} onChange={changeUsername} className={"form-control small"}/>
                <label htmlFor={"password"}>Password: </label>
                <input type={"password"} value={password} name={"password"} onChange={changePassword} className={'form-control'}/>
                <input type={"submit"} value={"Login"} className={'btn btn-success mt-2'}/>
            </form>

            {message}

        </>
    )
}

import {Navigate} from "react-router-dom";
import {useState} from "react";
import axios from "axios";


export const Login = () => {

    const [login, setLogin] = useState('');
    const [password, setPassword] = useState('');
    const [navigate, setNavigate] = useState(false);

    const submit = async e => {
        e.preventDefault();

        const {data} = await axios.post("auth/login", {login, password}, {withCredentials: true});

        axios.defaults.headers.common['Authorization'] = `Bearer ${data['accessToken']}`;
        setNavigate(true);
    }

    if (navigate) {
        return <Navigate to="/"/>;
    }

    return <main className="form-signin">
        <form onSubmit={submit}>
            <h1>Please sign in</h1>

            <div className="form-floating">
                <input type="text" className="form-control" name="login" placeholder="Login"
                       onChange={event => setLogin(event.target.value)}/>
                <label htmlFor="floatingInput">Login</label>
            </div>
            <div className="form-floating">
                <input type="password" className="form-control" name="password" placeholder="Password"
                       onChange={event => setPassword(event.target.value)}/>
                <label htmlFor="floatingPassword">Password</label>
            </div>

            <button className="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        </form>
    </main>

}
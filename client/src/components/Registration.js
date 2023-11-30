import {Navigate} from "react-router-dom";
import {useState} from 'react';
import axios from 'axios';

export const Registration = () => {

    const [login, setLogin] = useState('');
    const [password, setPassword] = useState('');
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [navigate, setNavigate] = useState(false);

    const submit = async e => {
        e.preventDefault();

        await axios.post("registration", {login, password, firstName, lastName});
        setNavigate(true);
    }

    if (navigate) {
        return <Navigate to="/login"/>;
    }

    return <main className="form-signin">
        <form onSubmit={submit}>
            <h1>Please register</h1>

            <div className="form-floating">
                <input type="text" className="form-control" name="login" placeholder="Login"
                       onChange={event => setLogin(event.target.value)}
                />
                <label htmlFor="floatingInput">Login</label>
            </div>
            <div className="form-floating">
                <input type="password" className="form-control" name="password" placeholder="Password"
                       onChange={event => setPassword(event.target.value)}/>
                <label htmlFor="floatingPassword">Password</label>
            </div>
            <div className="form-floating">
                <input type="text" className="form-control" name="firstName" placeholder="First name"
                       onChange={event => setFirstName(event.target.value)}/>
                <label htmlFor="floatingInput">First name</label>
            </div>
            <div className="form-floating">
                <input type="text" className="form-control" name="lastName" placeholder="Last name"
                       onChange={event => setLastName(event.target.value)}/>
                <label htmlFor="floatingInput">Last name</label>
            </div>

            <button className="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
        </form>
    </main>

}
import {useEffect, useState} from "react";
import {Navigate} from "react-router-dom";
import axios from "axios";

export const Home = () => {

    const [text, setText] = useState('');
    const [navigate, setNavigate] = useState(false);

    useEffect(() => {
        (async () => {
            try {
                const {data} = await axios.get('home');

                setText(data['text']);
            } catch (e) {
                setNavigate(true);
            }
        })();
    }, []);

    const logout = async () => {
        await axios.post('logout', {}, {withCredentials: true});

        setNavigate(true);
    }

    if (navigate) {
        return <Navigate to="/login"/>;
    }

    return <div className="form-signin mt-5 text-center">
        <h3>{text}</h3>

        <a href="javascript:void(0)" className="btn btn-lg btn-primary"
           onClick={logout}
        >Logout</a>
    </div>

}
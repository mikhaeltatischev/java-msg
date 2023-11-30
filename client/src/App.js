import {BrowserRouter, Routes, Route, Link} from 'react-router-dom'
import {Registration} from "./components/Registration";
import {Login} from "./components/Login";
import {Home} from "./components/Home";
import './App.css'

function App() {
  return (
      <BrowserRouter>

          <header className="p-3 bg-dark text-white">
              <div className="container">
                  <div className="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                      <ul className="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                          <li><Link to="/" className="nav-link px-2 text-white">Home</Link></li>
                      </ul>

                      <div className="text-end">
                      <Link to="/login" className="btn btn-outline-light me-2">Login</Link>
                      <Link to="/registration" className="btn btn-warning">Register</Link>
                  </div>
                  </div>
              </div>
          </header>

        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/login" element={<Login/>}/>
            <Route path="/registration" element={<Registration/>}/>
        </Routes>
      </BrowserRouter>
  );
}

export default App;
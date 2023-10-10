import React, { useEffect, useState } from "react";
import { createRoot } from 'react-dom/client';
import {
  Route,
  Link,
  HashRouter as Router,
  Routes,
  Navigate
} from "react-router-dom";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import { Container, Navbar, Nav, Button } from "react-bootstrap";
import Login from "./components/Login/Login";
import { logout } from "./services/auth";
import Axios from "./apis/Axios";
import GetAxios from "./services/AxiosGet";
import Slots from "./slots/slots";
import SlotGame from "./slots/slotGame";


const App = () => {

const [balance,setBalance] = useState([])


const jwt = window.localStorage['jwt'];


const getBalance = () =>{
  Axios.get("/users/balance")
  .then(res =>{
     setBalance(res.data)
     console.log(res.data)
     
  })
  .catch(error =>{
      console.log(error)
  })
}

useEffect(() =>{
  getBalance();
},[])

if(jwt){
  
    

 


    return (
      
      <div>
        <Router>
          <Navbar bg="dark" variant="dark" expand>
            <Navbar.Brand as={Link} to="/">
              Hromis Slot
            </Navbar.Brand>
            {/* <Button onClick={() => GetAxios("slots")}>Test</Button> */}
            <Nav className="mr-auto">
              <Nav.Link as={Link} to="/slots">
                Slotovi
              </Nav.Link>
              <span className="navbar-text mr-3">Balance {balance}</span>
            </Nav>

            {window.localStorage['jwt'] ? 
                <Button onClick = {()=>logout()}>Log out</Button> :
                <Nav.Link as={Link} to="/login">Log in</Nav.Link>
            }
          </Navbar>

          <Container style={{marginTop:25}}>
            <Routes>
              <Route path="/" element={<Home/>} />
              {/* <Route path="/" element={} />
              <Route path="/:" element={} /> */}
              <Route path="/slots" element={<Slots/>} />
              <Route path="/login" element={<Login/>}/>
              <Route path="*" element={<NotFound/>} />
              <Route path="/slot/igra/:broj" element={<SlotGame balanceCheck={balance} balance = {()=>getBalance()}></SlotGame>} />
            </Routes>
          </Container>
        </Router>
      </div>
    );
}else{
  return(
    <>
    <Router>
    <Navbar expand bg="dark" variant="dark">
            <Navbar.Brand as={Link} to="/">
                JWD
            </Navbar.Brand>
            {/* <Nav>
            <Nav.Link as={Link} to="/">
                Movies
            </Nav.Link> */}
            <Nav.Link as={Link} to="/login">
                Login
            </Nav.Link>
        </Navbar>
        <Container style={{paddingTop:"10px"}}>
        <Routes>
            <Route path="/" element={<Home/>} />
            <Route path="/login" element={<Login/>}/>
            
            <Route path="*" element={<Navigate replace to = "/login"/>}/>
        </Routes>
        </Container>
    </Router>
</>
);
  
  
}
}

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
    <App/>,
)

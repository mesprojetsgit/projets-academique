import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import AddProduct from './Component/AddProduct'
import ListProduct from './Component/ListProduct'
import Acceuil from './Component/Acceuil'





import './App.css';

function App() {
  return (
< div className="App">
<div className="container">
<Router>
    <main>
      <nav className="navbar navbar-inverse bg-primary  navbar-fixed-top">
        <ul className="nav navbar-nav">
          <li className="active"> <Link to="/acceuil">Accueil</Link></li>
          <li> <Link to="/ajout">Ajout de produits</Link></li>
          <li> <Link to="/liste">Liste des produits</Link></li>
        </ul>
        <form className="navbar-form navbar-right">
          <div className="form-group"> 
            <input type="search" className="input-sm form-control" placeholder="Rechercher"/>
            <button type="Submit" className="btn btn-primary btn-sn">Chercher</button>
          </div>
        </form>
      </nav>
      <Route path="/acceuil" component={Acceuil} />
      <Route path="/ajout"  component={AddProduct} />
      <Route path="/liste"  component={ListProduct} />
      </main>
</Router>
  </div>
  
</div>

  );
}

export default App;

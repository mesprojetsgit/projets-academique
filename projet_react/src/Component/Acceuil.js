import React from 'react'
import '../css/Acceuil.css'
import habi from '../img/habi.jpg'
import Chauss from  '../img/Chauss.jpg'
import Sacs from '../img/Sacs.jpg'

const Acceuil=(props)=>{

return(
    
    <div className="Acceuil">
        <p><h1>BIENVENUE DANS NOTRE BOUTIQUE</h1></p>
    <div class="card mb-3" >
  <div class="row no-gutters">
    <div class="col-md-4">
      <img src={habi} class="card-img" alt="..."/>
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">Exposition 1</h5>
        <p class="card-text">Vous trouverez ici des games de produits de votre choix telles les chemises, pantalons...</p>
        <p class="card-text"><small class="text-muted">L'élegance en marche!!</small></p>
      </div>
    </div>
  </div>

  <div class="card mb-3" >
  <div class="row no-gutters">
    <div class="col-md-4">
      <img src={Chauss} class="card-img" alt="..."/>
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">Exposition 2</h5>
        <p class="card-text">Vous trouverez ici des games de chaussures de grandes marques</p>
        <p class="card-text"><small class="text-muted">L'élegance en marche!!</small></p>
      </div>
    </div>
  </div>
</div>
</div>

<div class="card mb-3" >
  <div class="row no-gutters">
    <div class="col-md-4">
      <img src={Sacs} class="card-img" alt="..."/>
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">Exposition 3</h5>
        <p class="card-text">Vous trouverez ici des games de sacs de grandes marques</p>
        <p class="card-text"><small class="text-muted">L'élegance en marche!!</small></p>
      </div>
    </div>
  </div>
</div>
    </div>
)
}

export default Acceuil
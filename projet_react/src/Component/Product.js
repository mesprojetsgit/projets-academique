import React from 'react'
import DetailsProduct from './DetailsProduct'
import UpdateProduct from './UpdateProduct'
import axios from 'axios'
import '../css/Product.css'



const Product=({modifier,produit,handleDelete,handleDetail,handleModifier,id,fermer,voir})=>{
    
    const handleAdd=(nom,prix,description,quantite)=>{
        axios.put('http://localhost:3333/produits/'+id,{nom,prix,description,quantite}) 
       }

    var option=""
    if(voir && id===produit.id){
        option=<div className='Detbordure'><DetailsProduct product={produit}/></div>
    
    }
    if(modifier && id===produit.id){
        option=<div className='modbordure'><UpdateProduct handleAdd={handleAdd} produit={produit}/></div>
    }if(fermer && id===produit.id){
        option=''
    }
 return( 
 <div className="Product">
    <div className="row" >
        <div className="col-md-2">
           <h4>Nom: <strong>{produit.nom}</strong></h4>
        </div>
        <div className="col-md-3">
            <h4>Prix: <strong>{produit.prix}(FCFA)</strong></h4>
        </div>
        <div className="col-md-1">
            <button type="button" className="btn btn-info" onClick={handleDetail.bind(this,produit.id)}><span >Details</span></button>   
        </div>
        <div className="col-md-1">
            <button type="button" className="btn btn-primary" onClick={handleModifier.bind(this,produit.id)}><span >Modifier</span></button>      
        </div>
        <div className="col-md-1">
            <button type="button" className="btn btn-danger" onClick={handleDelete.bind(this,produit.id)}><span >Suprimer</span></button>     
        </div >
        <div className="col-md-1">
    
        </div >
        <div className="col-md-3">
           {option}
        </div >
        </div>
    </div>   
    )  
}

export default Product
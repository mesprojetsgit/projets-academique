import React from 'react'
import '../css/DetailsProduct.css'

const DetailsProduct=({product})=>(

 <div className="DetailsProduct">
    <div className="row name">
        <div className="col-md-2">
            NOM:
        </div>
        <div className="col-md-8">
            {product.nom}
        </div>
    </div>
    <div className="row ">
        <div className="col-md-4">
            DESCRIPTION:
        </div>
        <div className="col-md-8">
            {product.description}
        </div>
    </div>
    <div className="row ">
        <div className="col-md-2">
            QUANTITE:
        </div>
        <div className="col-md-8">
            {product.quantite}
        </div>
    </div>
    <div className="row ">
        <div className="col-md-2">
            PRIX:
        </div>
        <div className="col-md-8">
            {product.prix}
        </div>
    </div> 
        
</div>
    
)

export default DetailsProduct
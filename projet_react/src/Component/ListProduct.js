import React, {Component} from 'react'
import Product from './Product'
import axios from 'axios'
import '../css/ListProduct.css'


class ListProduct extends Component{
 constructor(){
     super()
     this.state = {isLoading:true, product:[], error:null,voir:false,fermer:false,modifier:false ,id:0}
     this.handleDelete = this.handleDelete.bind(this);
     this.handleDetail=this.handleDetail.bind(this);
     this.handleModifier=this.handleModifier.bind(this);
    
 }
 handleDelete(id) {
    var supprime=window.confirm("voulez vous supprimer le produit?")
    if(supprime===true){
    axios.delete('http://localhost:3333/produits/'+id)
    .then(
        res=>{
            this.setState(prevstate => ({
                product : prevstate.product.filter(
                    product => product.id !== id)
            }))
    }
    )
    .catch(error=>this.setState({error,isLoading:false}))
   }
    
    }  
    
handleAdd=(nom,prix,description,quantite)=>{
    axios.post('http://localhost:3333/produits/',{nom,prix,description,quantite})
    .then(
        res=>{
            this.setState({product:[...this.state.product,res.data]})
    }
    )    
}
handleDetail(id){
    
   if(!this.state.voir){
     
        this.setState({fermer:false,modifier:false,voir:true,id:id})       
    }

    if(this.state.voir && this.state.id===id){
    
        this.setState({modifier:false,voir:false,fermer:true,id:id})
    }

    if(this.state.voir && this.state.id!==id){
       this.setState({voir:false,fermer:false,modifier:false,id:id})
       this.setState({voir:true})
    }
}

handleModifier(id){
        this.setState({voir:false})
        this.setState({modifier:true})
        this.setState({fermer:false}) 
        this.setState({id:id}) 
}

 componentDidMount(){
    axios.get('http://localhost:3333/produits')
    .then(
        res=>{
        const product=res.data;
        this.setState({product,isLoading:false});
    }
    )
    .catch(error=>this.setState({error,isLoading:false}))
    }

    render=props=>{
        const _product=this.state.product
        if(!_product.length){
            return(
                <div>
                    <h1>Liste des produits {this.props.nom}</h1>
                    <p>Aucun produit</p>
                </div>
            )
        }
        const isLoading = this.state.isLoading;
        return(
            <div className="ListProduct">
                
              <div> <h1>Liste des produits {this.props.nom}</h1></div>
                <div class="row ">
                    <div class="col-md-2">
                        <span>Noms Produits</span>
                    </div>
                    <div class="col-md-3">
                        <span>Prix Produits(FCFA)</span>
                    </div>
                    <div class="col-md-3">
                        <span>Options</span>
                    </div>
                </div>
                <hr/>
                   
                    <div>
                    {
                        (isLoading) ? <p>Loading...</p> :
                        _product.map(_product=>(
                            <div class="list">
                            <Product className="produit" key={_product.id} produit={_product}
                             handleDelete={this.handleDelete}
                             handleDetail={this.handleDetail}
                             voir={this.state.voir}
                             modifier={this.state.modifier}
                             handleModifier={this.handleModifier}
                             id={this.state.id}
                             fermer={this.state.fermer}
                            />
                            </div>
                           
                            )
                        )
                    }
                    </div>
                
            </div>
        )
}

}
export default ListProduct
import React, {Component} from 'react'
import '../css/AddProduct.css'
import axios from 'axios'

class AddProduct extends Component{
    constructor(){
        super()
        this.state={nom:'',prix:'',description:'',quantite:''}
    }
    handleChange1=event=>this.setState({nom:event.target.value})
    handleChange2=event=>this.setState({prix:event.target.value})
    handleChange3=event=>this.setState({description:event.target.value})
    handleChange4=event=>this.setState({quantite:event.target.value})
    render(){
        
        return(
    <div className="AddProduct">
        <div className="container">
                <h1>Veuiller remplir ce formulaire</h1>
        
              <form  onSubmit={this.handleAdd}>

                <div className="row" >
                    <div className="col-md-2">
                      <label for="nom">Nom</label>    
                   </div>
                   <div className="col-md-8">
                      <input type="text" placeholder="Entrer le nom" className="form-control" 
                      name="nom" onChange={this.handleChange1}></input>
                   </div>
                </div>

                <div className="row" >
                    <div className="col-md-2">
                      <label for="nom">Prix</label>    
                   </div>
                   <div className="col-md-8">
                      <input type="text" placeholder="Entrer le prix"  className="form-control" name="prix" 
                      onChange={this.handleChange2} ></input>
                   </div>
                </div>

                <div className="row" >
                    <div className="col-md-2">
                      <label for="nom">Description</label>    
                   </div>
                   <div className="col-md-8">
                      <textarea onChange={this.handleChange3} className="form-control is-invalid" name="Description" 
                      placeholder="Description" required></textarea>
                    </div>
                </div>

                <div className="row" >
                <div className="col-md-2">
                      <label for="nom">Quantité</label>    
                   </div>
                   <div className="col-md-8">
                      <input type="text" placeholder="Entrer la quantite"  className="form-control" name="quantite" 
                      onChange={this.handleChange4} ></input>
                   </div>
                </div>

                <div className="row">
                    <div col-md-3>
                        <input
                        type="submit"
                        value="Ajouter"
                        />
                   </div>
                </div> 
             
            </form>
         </div>
         

        </div>
     
        )
    }

    handleAdd=(e,nom,prix,description,quantite)=>{
        e.preventDefault()
        nom=this.state.nom;
        prix=this.state.prix;
        description=this.state.description;
        quantite=this.state.quantite;
       
        axios.post('http://localhost:3333/produits/',{nom,prix,description,quantite})
        this.setState({nom:'',prix:"",description:'',quantite:''})
    }
}

export default AddProduct
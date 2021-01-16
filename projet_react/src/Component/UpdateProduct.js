import React, {Component} from 'react'


class UpdateProduct extends Component{
    constructor(props){
        super(props)
       
        this.state={id:0,nom:this.produit().nom,prix:this.produit().prix, 
            description:this.produit().description,quantite:this.produit().quantite,placeholder:"entrer votre nom!!"}
    }
    handleChange1=event=>this.setState({nom:event.target.value})
    handleChange2=event=>this.setState({prix:event.target.value})
    handleChange3=event=>this.setState({description:event.target.value})
    handleChange4=event=>this.setState({quantite:event.target.value})

    
    render(){       
       
        return(
    <div className="AjouterProduit">          
        <div className="row">
            <div className="col-md-10 formulaire">
              <form  onSubmit={this.handleAdd}>

                <div className="row" >
                    <div className="col-md-4">
                         <span>Nom:</span>
                    </div>
                    <div className="col-md-8">
                          <input type="text" defaultValue={this.produit().nom}  className="form-control" name="nom" 
                          onChange={this.handleChange1} required></input>
                   </div>
                </div>

                <div className="row" >
                    <div className="col-md-4">
                         <span>Prix:</span>
                    </div>
                   <div className="col-md-8">
                          <input type="text" defaultValue={this.produit().prix}  className="form-control" name="prix" 
                          onChange={this.handleChange2} required ></input>
                   </div>
                </div>

                <div className="row" >
                    <div className="col-md-4">
                         <span>Description:</span>
                    </div>
                   <div className="col-md-8">
                        <textarea  defaultValue={this.produit().description} onChange={this.handleChange3} className="form-control " 
                        name="description"  ></textarea>
                    </div>
                </div>

                <div className="row" >
                    <div className="col-md-4">
                         <span>Quantité:</span>
                    </div>
                   <div className="col-md-8">
                          <input type="text"   defaultValue={this.produit().quantite}  className="form-control" 
                          name="quantite" onChange={this.handleChange4}  required></input>
                   </div>
                </div>

                <div className="row">
                    <div col-md-3>
                        <input
                        type="submit"
                        value="Modifier"
                        />
                   </div>
                </div> 
             
            </form>
         </div>   
        </div>
       </div>
        )
    }

    handleAdd=e=>{
        e.preventDefault() 
        this.props.handleAdd(this.state.nom,this.state.prix,this.state.description,this.state.quantite)
    }

    //methode qui recupere le produit
    produit(){return this.props.produit}
}

export default UpdateProduct
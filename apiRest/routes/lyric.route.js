const express=require('express')
const app=express();
const appRoute=express.Router();
let NewModel=require('../model/lyrics');

// add lyric
appRoute.route('/create-lyric').post((req,res, next)=>{
    NewModel.create(req.body,(error,data)=>{
      if(error){
          return next(error);
      }else{
          res.json(data)
      }
    })
});


//get all lyrics
appRoute.route('/get-lyrics').get((req,res)=>{
    NewModel.find((error,data)=>{
       if(error){
            
       }else{
           res.json(data);
       }
   })
})


//get single lyric
appRoute.route('/get-lyric/:id').get((req,res)=>{
    NewModel.findById(req.params.id,(error,data)=>{
        if(error){
            return next(error);
        }else{
            res.json(data)
        }
    })
})


//update lyric

appRoute.route('/update-lyric/:id').put((req,res,next)=>{
    NewModel.findByIdAndUpdate(req.params.id, {
        $set:req.body
    },(error,data)=>{
        if(error){
            return next(error);
            console.log(error)
        }else{
            res.json(data);
            console.log('Note modifie avec succes!')
        }
    })
})


//delete lyric
appRoute.route('/delete-lyric/:id').delete((req,res ,next)=>{
    NewModel.findByIdAndRemove(req.params.id,(error,data)=>{
        if(error){
            return next(error);
        }else{
            res.status(200).json({
                msg: data
            })
        }
    })
})


module.exports=appRoute
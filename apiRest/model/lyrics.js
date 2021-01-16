const mongoose=require('mongoose');
const Schema=mongoose.Schema;

let Lyrics=new Schema({
    _id:{
       type:String
    },
    album: {
        type:String
    },
    lyrics_title:{
        type:String
    },
    lyrics_url: {
        type:String
    },
    lyrics: {
        type:String
    },
    track_views: {
        type:String
    }
    
},{collection: 'drake'})

Lyrics.method("toJSON", function() {
    const { __v, _id, ...object } = this.toObject();
    object.id = _id;
    return object;
  });

module.exports=mongoose.model('Lyrics',Lyrics)



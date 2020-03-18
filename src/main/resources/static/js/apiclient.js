apiclient = (function(){
	return{
		getAirports:function(name,callback){
			var promise = $.get({
				url:"/airports/"+name
			});
			promise.then(function(data){
				callback(null,JSON.parse(data));
			},function(err){
				callback(err,null);
			});
			
		}
	}
})();
function buy(goodsId){
	$.post("goods_buy", {goodsid:goodsId}, function(data){
		if(data=="ok"){
			layer.msg("Added to Cart!", {time:600}, function(){
				location.reload();
			});
		}
	});
}

function lessen(goodsId){
	$.post("goods_lessen", {goodsid:goodsId}, function(data){
		if(data=="ok"){
			layer.msg("Removed!", {time:600}, function(){
				location.reload();
			});
		}
	});
}


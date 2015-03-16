function codesToName(json, val, field1, field2){
	field1 = field1 || 'id';
	field2 = field2 || 'name';
	if(val != ""){
		var arr = val.split(",");
		var ret = new Array();
		$.each(json, function(k, v){
			for(var i in arr){
				if(arr[i] == v[field1]){
					ret.push(v[field2]);
					return;
				}
			}
		})
		return ret.join();
	}
	return val;
}
/**
 * 
 */
var vnum=0;
$(function(){
	var getIntoStockListAllUrl='/pssmsys/intostockadmin/getinotstocklist';
	
	$.getJSON(getIntoStockListAllUrl,function(item,data){
		var stockObj=item.intoStockList;
		var viewHTML1='';
		var uid=1;
		
		stockObj.map(function(item,data){
			var ifStaus='未完成';
			var isFis=item.isFinished;
			var opAHTML='<button onclick="finishIntoStockByid('+item.id+','+item.goodsId+')" type="button" data-toggle="modal"  class="btn btn-sm btn-warning">完成</button>&nbsp;<button type="button" data-toggle="modal" data-target="#myModal2" onclick="deleteIntoStockByid('+item.id+')"  class="btn btn-sm btn-danger">删除</button>';
			if(isFis==0){
				ifStaus='未完成';
			}else if(isFis==1){
				ifStaus='已收货';
				opAHTML='';
			}
			viewHTML1=viewHTML1+'<tr><th scope="row">'+uid+'</th>'+
                          '<td>'+item.uniqueId+'</td>'+
                          '<td>'+item.goddsNameString+'</td>'+
                          '<td>'+item.intoStockPrice+'</td>'+
                          '<td>'+item.intoStockNumber+'</td>'+
                          '<td>'+item.supplierName+'</td>'+
                          '<td>'+ifStaus+'</td>'+
                          '<td>'+opAHTML+'</td>'+
                       '</tr>';
			uid++;
		});
		$('#viewBody').html(viewHTML1);
	});
	
	showGoodHTML(0);
	
	$('#submit0').click(function(){
		var addGoodsUrl='/pssmsys/goodsadmin/addgoods';
		var goodsListName0=$('#goodsListName0').val();
		var stockNumer0=$('#stockNumer0').val();
		var suplierName0=$('#suplierName0').val();
		var stockNumber0=$('#stockNumber0').val();
		var inputPrice0=$('#inputPrice0').val();
		var goodsSelect0 = $('#goodsSelect0').find('option').not(
				function() {
					return !this.selected;
				}).val();
		var goodsSelect0Text = $('#goodsSelect0').find('option').not(
				function() {
					return !this.selected;
				}).text();
		if(goodsListName0==''||stockNumer0==''||suplierName0==''||stockNumber0==''||inputPrice0==''){
			alert('请填写完整');
			return;
		}
		var opHTML='<tr><th scope="row" id="gln'+vnum+'">'+goodsListName0+'</th>'+
        '<td id="gst'+vnum+'" >'+goodsSelect0Text+'</td>'+
        '<td id="stn'+vnum+'">'+stockNumer0+'</td>'+
        '<td id="sln'+vnum+'">'+suplierName0+'</td>'+
        '<td id="ipp'+vnum+'">'+inputPrice0+'</td>'+
        '<td id="gstA'+vnum+'" hidden="hidden">'+goodsSelect0+'</td>'+
        '<td id=""><a onclick="removeOp(this)" href="javascript:void(0)">移除</a></td>'+
        '</tr>';
		//var opVal=goodsListName0+'|'+goodsSelect0+'|'+stockNumer0+'|'+suplierName0+'|'+inputPrice0;
		$('#viewBody0').append(opHTML);
		vnum++;
	});
	$('#submitBtn0').click(function(){
		if(vnum==0){
			alert('货单为空');
			return;
		}else{
			for(var i=0;i<vnum;i++){
				var uniqueId=$('#gln'+i).text();
				var goodsId=$('#gstA'+i).text();
				var intoStockNumber=$('#stn'+i).text();
				var supplierName=$('#sln'+i).text();
				var intoStockPrice=$('#ipp'+i).text();
				if(uniqueId==''||goodsId==''||intoStockNumber==''||supplierName==''||intoStockPrice==''){
					return;
				}else{
					var addToIntoStockListUrl='/pssmsys/intostockadmin/addintostock';
					var formData = new FormData();
					formData.append('uniqueId',uniqueId);
					formData.append('goodsId',goodsId);
					formData.append('intoStockNumber',intoStockNumber);
					formData.append('supplierName',supplierName);
					formData.append('intoStockPrice',intoStockPrice);
					//发送请求
					$.ajax({
						url : addToIntoStockListUrl,
						type : 'POST',
						data : formData,
						contentType : false,
						processData : false,
						cache : false,
						success : function(data) {
							if(data.success){
								//
							}else{
								alert('添加失败');
							}
						}
					});
				}
			}
			self.location='/pssmsys/stock/inputindex';
			vnum=0;
		}
	})
});
function removeOp(obj){
	$(obj).parent().parent().remove();
}
function delOptionA(){
	$('#viewBody0').html('');
	vnum=0;
}
function showGoodHTML(id){
	//
	var getGoodsListUrl='/pssmsys/goodsadmin/getgoodslist';
	var goodsObj={};
	var depHTML2='';
	$.ajaxSetup({async:false});
	$.getJSON(getGoodsListUrl,function(item,data){
		goodsObj=item.goodsList;
	});
	goodsObj.map(function(item,data){
		depHTML2=depHTML2+'<option value="'+item.id+'">'+item.name+'</option>';
		
	});
	$('#goodsSelect'+id).html(depHTML2);
	
}
function editGoodsById(id,name,inputPrice,outputPrice,stockNumber,supplierName){
	$('#goodsName1').val(name);
	$('#inputPrice1').val(inputPrice);
	$('#outputPrice1').val(outputPrice);
	$('#stockNumber1').val(stockNumber);
	$('#supplierName1').val(supplierName);
	//showGoodsCategoryHTML('');
	$('#submitBtn1').click(function(){
		var updateGoodsUrl='/pssmsys/goodsadmin/updategoodsbyitem';
		var goodsName1=$('#goodsName1').val();
		var inputPrice1=$('#inputPrice1').val();
		var outputPrice1=$('#outputPrice1').val();
		var stockNumber1=$('#stockNumber1').val();
		var supplierName1=$('#supplierName1').val();
		var goodsCategorySelect1 = $('#goodsCategorySelect').find('option').not(
				function() {
					return !this.selected;
				}).val();
		if(goodsName1==''||inputPrice1==''||outputPrice1==''||stockNumber1==''||supplierName1==''){
			alert('请填写完整');
			return;
		}
		var formData = new FormData();
		formData.append('id',id);
		formData.append('name',goodsName1);
		formData.append('inputPrice',inputPrice1);
		formData.append('outputPrice',outputPrice1);
		formData.append('stockNumber',stockNumber1);
		formData.append('supplierName',supplierName1);
		formData.append('categoryLevel2Id',goodsCategorySelect1);
		//发送请求
		$.ajax({
			url : updateGoodsUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if(data.success){
					alert('修改成功！');
					self.location='/pssmsys/goods/list';
				}
			}
		});
	})
}
function deleteIntoStockByid(id){
	$('#submitBtn2').click(function(){
		$.ajaxSetup({async:false});
		$.getJSON('/pssmsys/intostockadmin/deleteintostockbyid?id='+id,function(item,data){	
		})
		$('#myModal2').parent().remove();
		self.location='/pssmsys/stock/inputindex';
	})
}
function finishIntoStockByid(id,goodsId){
	
	$.ajaxSetup({async:false});
	$.getJSON('/pssmsys/intostockadmin/finishintostockbyid?id='+id+'&goodsId='+goodsId,function(item,data){	
	});
	self.location='/pssmsys/stock/inputindex';
	
}

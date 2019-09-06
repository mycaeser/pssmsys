/**
 * 
 */
$(function(){
	var getGoodsListAllUrl='/pssmsys/goodsadmin/getgoodslist';
	$.ajaxSetup({async:false});
	var goodsObj={};
	$.getJSON(getGoodsListAllUrl,function(item,data){
		goodsObj=item.goodsList;
		var viewHTML1='';
		var uId=1;
		goodsObj.map(function(item,data){
			
			viewHTML1=viewHTML1+'<tr><th scope="row">'+uId+'</th>'+
                          '<td>'+item.name+'</td>'+
                          '<td>'+item.inputPrice+'</td>'+
                          '<td>'+item.outputPrice+'</td>'+
                          '<td>'+item.stockNumber+'</td>'+
                          '<td>'+item.supplierName+'</td>'+
                          '<td><button onclick="editGoodsById('+item.id+',\''+item.name+'\',\''+item.inputPrice+'\',\''+item.outputPrice+'\',\''+item.stockNumber+'\',\''+item.supplierName+'\')" type="button" data-toggle="modal" data-target="#myModal1" class="btn btn-sm btn-warning">修改</button>&nbsp;<button type="button" data-toggle="modal" data-target="#myModal2" onclick="deleteGoodsByid('+item.id+')"  class="btn btn-sm btn-danger">删除</button></td>'+
                       '</tr>';
			uId++;
		});
		$('#viewBody').html(viewHTML1);
	});
	$('#newUserItem').click(function(){
		//点击添加新用户
		//
		//showDepPosHTML(1);
		var addUserInfoUrl='/pssmsys/userinfoadmin/adduserinfostr';
		$('#userName1').attr('disabled',false);
		$('#userIdCard1').attr('disabled',false);
		$('#userPhone1').attr('disabled',false);
		$('#userDep1').attr('disabled',false);
		$('#userPos1').attr('disabled',false);
		$('#userName1').val('');
		$('#userIdCard1').val('');
		$('#userPhone1').val('');
		$('#userDep1').val('');
		$('#userPos1').val('');
		$('#submitBtn1').click(function(){
			alert(3);
			var userName=$('#userName1').val();
			var userIdCard=$('#userIdCard1').val();
			var userPhone=$('#userPhone1').val();
			var jobDepartment = $('#departmentSelect1').find('option').not(
					function() {
						return !this.selected;
					}).val();
			var jobPosition = $('#positionSelect1').find('option').not(
					function() {
						return !this.selected;
					}).val();
			var gender=$('input[name="customRadioInline2"]:checked').val();
			if(userName==''||userName==null){
				//form-control is-invalid
				$('#userName1').attr('class','form-control is-invalid');
				return;
			}
			if(userIdCard==''||userIdCard==null){
				//form-control is-invalid
				$('#userIdCard1').attr('class','form-control is-invalid');
				return;
			}
			if(userPhone==''||userPhone==null){
				//form-control is-invalid
				$('#userPhone1').attr('class','form-control is-invalid');
				return;
			}
			//创建userInfo对象
			var userInfoStr={};
			//创建jobDepartment对象
			var jobDepartmentStr={};
			//创建jobPosition对象
			var jobPositionStr={};
			//赋值部门编号
			jobDepartmentStr.id=jobDepartment;
			//赋值职位编号
			jobPositionStr.id=jobPosition;
			//赋值用户名
			userInfoStr.name=userName;
			//性别
			userInfoStr.gender=gender;
			//身份证
			userInfoStr.idCard=userIdCard;
			//电话号码
			userInfoStr.phone=userPhone;
			
			//部门对象赋值
			userInfoStr.jobDepartment=jobDepartmentStr;
			//职位对象赋值
			userInfoStr.jobPosition=jobPositionStr;
			//权限
			userInfoStr.priority=1;
			var formData = new FormData();
			//以用户信息对象的形式传入
			formData.append('userInfoStr',JSON.stringify(userInfoStr));
			//发送请求
			$.ajax({
				url : addUserInfoUrl,
				type : 'POST',
				data : formData,
				contentType : false,
				processData : false,
				cache : false,
				success : function(data) {
					if(data.success){
						alert('添加成功！');
						self.location='/pssmsys/user/list';
					}
				}
			});
		});
	})
	showGoodsCategoryHTML(0);
	$('#submitBtn0').click(function(){
		var addGoodsUrl='/pssmsys/goodsadmin/addgoods';
		var goodsName0=$('#goodsName0').val();
		var inputPrice0=$('#inputPrice0').val();
		var outputPrice0=$('#outputPrice0').val();
		var stockNumber0=$('#stockNumber0').val();
		var supplierName0=$('#supplierName0').val();
		var goodsCategorySelect0 = $('#goodsCategorySelect0').find('option').not(
				function() {
					return !this.selected;
				}).val();
		if(goodsName0==''||inputPrice0==''||outputPrice0==''||stockNumber0==''||supplierName0==''){
			alert('请填写完整');
			return;
		}
		var formData = new FormData();
		formData.append('name',goodsName0);
		formData.append('inputPrice',inputPrice0);
		formData.append('outputPrice',outputPrice0);
		formData.append('stockNumber',stockNumber0);
		formData.append('supplierName',supplierName0);
		formData.append('categoryLevel2Id',goodsCategorySelect0);
		//发送请求
		$.ajax({
			url : addGoodsUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if(data.success){
					alert('添加成功！');
					self.location='/pssmsys/goods/list';
				}
			}
		});
	});
	function searchOperation(){
		var srContent=$('#searchInput').val();
		var viewHTML2='';
		if(srContent==''){
			self.location='/pssmsys/goods/list';
			return;
		}else{
			if(goodsObj!=null){
				goodsObj.map(function(item,data){
					if(item.name.indexOf(srContent)>-1){
						viewHTML2=viewHTML2+'<tr><th scope="row">'+item.id+'</th>'+
                        '<td>'+item.name+'</td>'+
                        '<td>'+item.inputPrice+'</td>'+
                        '<td>'+item.outputPrice+'</td>'+
                        '<td>'+item.stockNumber+'</td>'+
                        '<td>'+item.supplierName+'</td>'+
                        '<td><button onclick="editGoodsById('+item.id+',\''+item.name+'\',\''+item.inputPrice+'\',\''+item.outputPrice+'\',\''+item.stockNumber+'\',\''+item.supplierName+'\')" type="button" data-toggle="modal" data-target="#myModal1" class="btn btn-sm btn-warning">修改</button>&nbsp;<button type="button" data-toggle="modal" data-target="#myModal2" onclick="deleteGoodsByid('+item.id+')"  class="btn btn-sm btn-danger">删除</button></td>'+
                     '</tr>';
					}
				});
				$('#viewBody').html(viewHTML2);
			}
		}
	}
	$('#searchBtn').click(function(){
		//点击搜索
		searchOperation();
	});
	$('#searchInput').keyup(function(event){
		//回车
		if(event.keyCode ==13){
			searchOperation();
		  }
	});
});

function showGoodsCategoryHTML(id){
	//
	var getGCListUrl='/pssmsys/goodscateadmin/getgoodscategorylist';
	var gcObj={};
	var depHTML2='';
	$.ajaxSetup({async:false});
	$.getJSON(getGCListUrl,function(item,data){
		gcObj=item.goodsCategoryList;
	});
	gcObj.map(function(item,data){
		if(item.categoryLevel1>0){
			depHTML2=depHTML2+'<option value="'+item.categoryLevel1+'">'+item.name+'</option>';
		}
	});
	$('#goodsCategorySelect'+id).html(depHTML2);
	
}
function editGoodsById(id,name,inputPrice,outputPrice,stockNumber,supplierName){
	$('#goodsName1').val(name);
	$('#inputPrice1').val(inputPrice);
	$('#outputPrice1').val(outputPrice);
	$('#stockNumber1').val(stockNumber);
	$('#supplierName1').val(supplierName);
	showGoodsCategoryHTML('');
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
function deleteGoodsByid(id){
	$('#submitBtn2').click(function(){
		$.ajaxSetup({async:false});
		$.getJSON('/pssmsys/goodsadmin/deletegoodsbyid?id='+id,function(item,data){	
		})
		$('#myModal2').parent().remove();
		self.location='/pssmsys/goods/list';
	})
}

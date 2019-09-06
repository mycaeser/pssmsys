/**
 * 
 */
$(function(){
	var getUserinfoListAllUrl='/pssmsys/userinfoadmin/getuserinfolist';
	$.ajaxSetup({async:false});
	var userObj={};
	$.getJSON(getUserinfoListAllUrl,function(item,data){
		userObj=item.userInfoList;
		var viewHTML1='';
		var uId=1;
		userObj.map(function(item,data){
			var genderID=item.gender;
			var genserString='';
			if(genderID==1){
				genserString='男';
			}else if(genderID==0){
				genserString='女';
			}
			viewHTML1=viewHTML1+'<tr><th scope="row">'+uId+'</th>'+
                          '<td>'+item.name+'</td>'+
                          '<td>'+genserString+'</td>'+
                          '<td>'+item.jobDepartment.name+'</td>'+
                          '<td>'+item.jobPosition.name+'</td>'+
                          '<td><button type="button" onclick="showUserInfoById('+item.id+',\''+item.name+'\',\''+item.gender+'\',\''+item.jobDepartment.name+'\',\''+item.jobPosition.name+'\',\''+item.idCard+'\',\''+item.phone+'\')" data-toggle="modal" data-target="#myModal" class="btn btn-sm btn-info">查看</button>&nbsp;<button onclick="showUserInfoByIdA('+item.id+',\''+item.name+'\',\''+item.gender+'\',\''+item.jobDepartment.name+'\',\''+item.jobPosition.name+'\',\''+item.idCard+'\',\''+item.phone+'\')" type="button" data-toggle="modal" data-target="#myModal" class="btn btn-sm btn-warning">修改</button>&nbsp;<button type="button" data-toggle="modal" data-target="#myModal2" onclick="deleteUserinfoByid('+item.id+')"  class="btn btn-sm btn-danger">删除</button></td>'+
                       '</tr>';
			uId++;
		});
		$('#viewBody').html(viewHTML1);
	});
	$('#newUserItem').click(function(){
		//点击添加新用户
		//
		showDepPosHTML(1);
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
			var userName=$('#userName1').val();
			var userIdCard=$('#userIdCard1').val();
			//var userDep=$('#userDep1').val();
			//var userPos=$('#userPos1').val();
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
	});
	function searchOperation(){
		var srContent=$('#searchInput').val();
		var viewHTML2='';
		if(srContent==''){
			self.location='/pssmsys/user/list';
			return;
		}else{
			if(userObj!=null){
				userObj.map(function(item,data){
					if(item.name.indexOf(srContent)>-1){
						var genderID=item.gender;
						var genserString='';
						if(genderID==1){
							genserString='男';
						}else if(genderID==0){
							genserString='女';
						}
						viewHTML2=viewHTML2+'<tr><th scope="row">'+item.id+'</th>'+
                        '<td>'+item.name+'</td>'+
                        '<td>'+genserString+'</td>'+
                        '<td>'+item.jobDepartment.name+'</td>'+
                        '<td>'+item.jobPosition.name+'</td>'+
                        '<td><button type="button" onclick="showUserInfoById('+item.id+',\''+item.name+'\',\''+item.gender+'\',\''+item.jobDepartment.name+'\',\''+item.jobPosition.name+'\',\''+item.idCard+'\',\''+item.phone+'\')" data-toggle="modal" data-target="#myModal" class="btn btn-sm btn-info">查看</button>&nbsp;<button onclick="showUserInfoByIdA('+item.id+',\''+item.name+'\',\''+item.gender+'\',\''+item.jobDepartment.name+'\',\''+item.jobPosition.name+'\',\''+item.idCard+'\',\''+item.phone+'\')" type="button" data-toggle="modal" data-target="#myModal" class="btn btn-sm btn-warning">修改</button>&nbsp;<button type="button" data-toggle="modal" data-target="#myModal2" onclick="deleteUserinfoByid('+item.id+')"  class="btn btn-sm btn-danger">删除</button></td>'+
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

function showDepPosHTML(id){
	//
	var getDepListUrl='/pssmsys/depadmin/getdeplist';
	var depObj={};
	var getPosListUrl='/pssmsys/posadmin/getposlist';
	var posObj={};
	var depHTML1='<select name="departmentSelect'+id+'" id="departmentSelect1" class="form-control">';
	var depHTML2='';
	var depHTML3='<select name="positionSelect'+id+'" id="positionSelect1" class="form-control">';
	var depHTML4='';
	$.ajaxSetup({async:false});
	$.getJSON(getDepListUrl,function(item,data){
		depObj=item.jobDepartmentList;
	});
	$.getJSON(getPosListUrl,function(item,data){
		posObj=item.jobPositionList;
	});
	depObj.map(function(item,data){
		depHTML2=depHTML2+'<option value="'+item.id+'">'+item.name+'</option>';
	});
	posObj.map(function(item,data){
		depHTML4=depHTML4+'<option value="'+item.id+'">'+item.name+'</option>';
	});
	$('#depSpan1').html(depHTML1+depHTML2+'</select>');
	$('#posSpan1').html(depHTML3+depHTML4+'</select>');
}
function showUserInfoById(id,name,gender,dep,pos,idcard,phone){
	$('#userName').attr('disabled','');
	$('#userIdCard').attr('disabled','');
	$('#userPhone').attr('disabled','');
	$('#userDep').attr('disabled','');
	$('#userPos').attr('disabled','');
	$('#userName').val(name);
	$('#userIdCard').val(idcard);
	$('#userPhone').val(phone);
	$('#userDep').val(dep);
	$('#userPos').val(pos);
	var htmlGender='';
	if(gender==1){
		htmlGender='#customRadioInline1';
	}else{
		htmlGender='#customRadioInline2';
	}
	
	$(htmlGender).attr("checked","checked");
	$('#submitBtn').attr('disabled','');
}
function showUserInfoByIdA(id,name,gender,dep,pos,idcard,phone){
	$('#userName').attr('disabled',false);
	$('#userIdCard').attr('disabled',false);
	$('#userPhone').attr('disabled',false);
	$('#userDep').attr('disabled','');
	$('#userPos').attr('disabled','');
	$('#submitBtn1').attr('id','submitBtn');
	$('#submitBtn').attr('disabled',false);
	$('#userName').val(name);
	$('#userIdCard').val(idcard);
	$('#userPhone').val(phone);
	$('#userDep').val(dep);
	$('#userPos').val(pos);
	//
	showDepPosHTML('');
	var htmlGender='';
	if(gender==1){
		htmlGender='#customRadioInline1';
	}else{
		htmlGender='#customRadioInline2';
	}
	$(htmlGender).attr("checked","checked");
	$('#submitBtn').click(function(){
		var updateUserInfoUrl='/pssmsys/userinfoadmin/updateuserinfo';
		var userName=$('#userName').val();
		var userIdCard=$('#userIdCard').val();
		//var userDep=$('#userDep').val();
		//var userPos=$('#userPos').val();
		var userPhone=$('#userPhone').val();
		//var jobDepartment = $('#departmentSelect').find('option').not(
		//		function() {
		//			return !this.selected;
		//		}).val();
		//var jobPosition = $('#positionSelect').find('option').not(
		//		function() {
		//			return !this.selected;
		//		}).val();
		var gender=$('input[name="customRadioInline1"]:checked').val();
		if(userName==''||userName==null){
			//form-control is-invalid
			$('#userName').attr('class','form-control is-invalid');
			return;
		}
		if(userIdCard==''||userIdCard==null){
			//form-control is-invalid
			$('#userIdCard').attr('class','form-control is-invalid');
			return;
		}
		if(userPhone==''||userPhone==null){
			//form-control is-invalid
			$('#userPhone').attr('class','form-control is-invalid');
			return;
		}
		//创建userInfo对象
		var userInfoStr={};
		//创建jobDepartment对象
		//var jobDepartmentStr={};
		//创建jobPosition对象
		//var jobPositionStr={};
		//赋值部门编号
		//jobDepartmentStr.id=jobDepartment;
		//赋值职位编号
		//jobPositionStr.id=jobPosition;
		userInfoStr.id=id;
		//赋值用户名
		userInfoStr.name=userName;
		//性别
		userInfoStr.gender=gender;
		//身份证
		userInfoStr.idCard=userIdCard;
		//电话号码
		userInfoStr.phone=userPhone;
		
		//部门对象赋值
		//userInfoStr.jobDepartment=jobDepartmentStr;
		//职位对象赋值
		//userInfoStr.jobPosition=jobPositionStr;
		//权限
		userInfoStr.priority=1;
		var formData = new FormData();
		//以用户信息对象的形式传入
		formData.append('userInfoStr',JSON.stringify(userInfoStr));
		//发送请求
		$.ajax({
			url : updateUserInfoUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if(data.success){
					alert('修改成功！');
					//self.location='/pssmsys/user/list';
				}
			}
		});
	})
}
function deleteUserinfoByid(id){
	$('#submitBtn2').click(function(){
		$.ajaxSetup({async:false});
		$.getJSON('/pssmsys/userinfoadmin/deleteuserinfobyid?userId='+id,function(item,data){	
		})
		$('#myModal2').parent().remove();
		self.location='/pssmsys/user/list';
	})
}

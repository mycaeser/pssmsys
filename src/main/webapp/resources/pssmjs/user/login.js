/**
 * 
 */
$(function(){
	$('#submBtn').click(function(){
		var adminLoginCheckUrl='/pssmsys/local/logincheck';
		var accountString=$('#accountString').val();
		var passwrodString=$('#passwrodString').val();
		var verifyCodeActual = $('#j_captcha').val();
		if(accountString==''||passwrodString==''||verifyCodeActual==''){
			alert('请输入完整');
			return;
		}
		var formData = new FormData();
		formData.append('verifyCodeActual', verifyCodeActual);
		formData.append('accountString', accountString);
		formData.append('passwrodString', passwrodString);
		$.ajax({
            url : adminLoginCheckUrl,
            type : 'POST',
            data : formData,
            contentType : false,
			processData : false,
			cache : false,
            success : function(data) {
            	if(data.success){
            		
            		self.location='/pssmsys/front/index';
            		
            		
            	}else{
            		alert('账号或密码不正确');
            	}
            	
            }
        });
	})
})
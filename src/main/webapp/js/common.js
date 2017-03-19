function gfn_isNull(str) {
	if (str == null) return true;
	if (str == "NaN") return true;
	if (new String(str).valueOf() == "undefined") return true;    
    var chkStr = new String(str);
    if( chkStr.valueOf() == "undefined" ) return true;
    if (chkStr == null) return true;    
    if (chkStr.toString().length == 0 ) return true;   
    return false; 
}

function ComSubmit(opt_formId) {
	this.formId = gfn_isNull(opt_formId) == true ? "commonForm" : opt_formId;
	this.url = "";
	
	if(this.formId == "commonForm"){
		$("#commonForm")[0].reset();
	}
	
	this.setUrl = function setUrl(url){
		this.url = url;
	};
	
	this.addParam = function addParam(key, value){
		$("#"+this.formId).append($("<input type='hidden' name='"+key+"' id='"+key+"' value='"+value+"' >"));
	};
	
	this.submit = function submit(){
		var frm = $("#"+this.formId)[0];
		frm.action = this.url;
		frm.method = "post";
		frm.submit();	
	};
}

function procedure() {

	var uri = 'http://localhost:8080/servlet/advertise/advDeta'
	var width = 800;
	var height = 500;
	var top = (screen.availHeight - height) / 2;
	var left = (screen.availWidth - width) / 2;

	var strFeature;
	strFeature = 'height='
			+ height
			+ ',width='
			+ width
			+ ',menubar=no,toolbar=no,location=no,resizable=no,status=no,scrollbars=yes,top='
			+ top + ',left=' + left

	window.open("http://localhost:8080/servlet/advertise/advDeta",
			'DocAttach', strFeature);

}

function procedure2(search_key) {

	var uri = "http://www.bluemingo.xyz/servlet/seller/search?search_key="
			+ search_key + "&company_key=company_key";
	var width = 800;
	var height = 500;
	var top = (screen.availHeight - height) / 2;
	var left = (screen.availWidth - width) / 2;

	var strFeature;
	strFeature = 'height='
			+ height
			+ ',width='
			+ width
			+ ',menubar=no,toolbar=no,location=no,resizable=no,status=no,scrollbars=yes,top='
			+ top + ',left=' + left

	window.open(uri, 'DocAttach', strFeature);

}

function msg_parsing(purpose,from,status,value){
	var msg_object;
	var msg_from;
	var msg_title;
	var msg_body = '\n에러가 반복되면 관계자한테 문의하세요.';
	
	switch(from){
		case 'company' :
			msg_from = '판매자 데이터';
			break;
		case 'item' : 
			msg_from = '제품 데이터';
			break;
		case 'product' :
			msg_from = '묶음 데이터';
			break;
		case 'advertise' :
			msg_from = '광고 데이터';
			break;
	}
	
	switch(purpose){
		case 'create' :
			msg_object = ' 생성이';
			break;
		case 'read' : 
			msg_object = ' 조회가';
			break;
		case 'update' :
			msg_object = ' 수정이';
			break;
		case 'delete' :
			msg_object = ' 삭제가';
			break;
	}
	
	switch(status){
		case 'success' :
			msg_title = ' 성공했습니다.';
			swal(value, msg_from+msg_object+msg_title,"success")
			break;
		case 'fail' :
			msg_title = ' 실패했습니다.';
			swal(value, msg_from+msg_object+msg_title+msg_body,"error")
			break;
		case 'fail_option' :
			msg_title = ' 옵션부분만 실패했습니다.';
			swal(value, msg_from+msg_object+msg_title+msg_body,"error")
			break;
		case 'fail_no_data' :
			msg_title = ' 실패했습니다.\n존재하지 않는 데이터';
			swal(value, msg_from+msg_object+msg_title+msg_body,"error")
			break;
	}
	
}

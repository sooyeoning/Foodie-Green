$(document).ready(function() {
	
var naver_id_login = new naver_id_login("EalNl28PbnY3xzYe7CFV", "http://localhost:8080/callback");
        var state = naver_id_login.getUniqState();
        naver_id_login.setButton("white", 2,40);
        naver_id_login.setDomain("http://localhost:8080/callback");
        naver_id_login.setState(state);
        naver_id_login.setPopup();
        naver_id_login.init_naver_id_login();
  
});//ready end

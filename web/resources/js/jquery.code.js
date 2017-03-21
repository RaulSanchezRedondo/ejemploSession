/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {    
    jQuery("#botonLogin").click(function(){
        var login = $("#inputLogin").val();
        var password = $("#inputPwd").val();
        set_login(login, password);
    });

    jQuery("#botonLogout").click(function(){
        set_logout();
    });

 });

function set_login(login, password){
//Llama al Login
   jQuery.post("loginServlet",
    {
        login:login,
        password: password
    },
    function(data){
        jQuery("#miDiv").append(data);
    });

}

function set_logout(){

   jQuery.get("logoutServlet",
    function(data){
        jQuery("#miDiv").append(data);
    });

}



$("#submit-login").click(function(){

    var login = {
        "username" : $("#inputUsername").val(),
        "password" : $("#inputPassword").val()
    }

    var token = null;

    console.log("payload username : "+login.username);
    console.log("payload password : "+login.password);

   $.ajax({
           url: 'http://localhost:8889/api/pengguna/login',
           dataType: 'json',
           type: 'post',
           data: JSON.stringify(login),
           contentType: 'application/json; charset=utf-8',
           success: function(data){
               console.log(data);
               //save token
               token = data.data.token;
               console.log(token);
               alertify.success('Success Login !');
           },
           error: function(errMsg){
               console.log(errMsg);
               console.log(errMsg.responseJSON);
               console.log("message : ",errMsg.responseJSON.message);
               alertify.error(errMsg.responseJSON.message);
           }
       })
});

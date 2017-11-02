/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

Cadastro = function(){
    
    this._data = null;
    this._dataUrl = null;
    this._type = null;
    this._dataSource = null;
    this._handlerSuccess = null;
    this._handlerError = null; 
};

Cadastro.LoadCadastro = function(){

    var _dados = new Cadastro();

    _dados.initializeCadastro();
    
    return _dados;
};

Cadastro.LoadLogin = function(){

    var _dados = new Cadastro();

    _dados.initializeLogin();
    
    return _dados;
};


Cadastro.prototype = {
    
    initializeLogin: function(){

        this._validaautentica();   
    },
    initializeCadastro: function(){
        
        if($("#alterarCadastro").is(":checked")){
           this._atualiza(); 
        }else{
           this._insert();
        }
        
    },    
    _list: function(){ 
        
        this.executeBind("services/user/list","" , "GET",
                $createDelegate(this,this._insertSuccess),
                $createDelegate(this,this._erroInsert));
    },
    _listSuccess: function(value){
       
        var data_user = JSON.parse(value);
        
        if (data_user.success) {
            
            var table = '<table border="1">';
            table += '<tr>';
            table += '<td><b>Id</b></td>';
            table += '<td><b>Nome</b></td>';
            table += '<td><b>E-mail</b></td>';
            table += '</tr>';
            
            for (var i in data_user.data){
                table += '<tr>';
                table += '<td>'+data_user.data[i].id_user+'</td>';
                table += '<td>'+data_user.data[i].user_name+'</td>';
                table += '<td>'+data_user.data[i].email+'</td>';
                table += '</tr>';
            }
            
            table += '</table>';
            
           $('#listusers').html(table);

        };   
    },
    executeBind: function(dataUrl, data, type, handlerSuccess, handlerError){
                 
        this._type = type;
        this._dataUrl = dataUrl;
        this._data = data;
        this._handlerSuccess = handlerSuccess;
        this._handlerError = handlerError;
         
        this.DataBind();
        
    },
    DataBind: function(){ 
        
        $.ajax({
            type: this._type,
            cache: false,
            data: this._data,
            url: this._dataUrl,
            success: this._handlerSuccess,
            error: this._handlerError 
        });
        
    },
    _erroDados: function(value){
        
        alert("_erroDados: ");
    },
    _insert: function () {
        
        var radios = document.getElementsByName("radioAluno");
        var aluno;
        
        for (var i = 0; i < radios.length; i++) {
            if (radios[i].value === "true") {
                if (radios[i].checked) {
                    aluno=radios[i].value;
                }
            }
        }
        
        this.executeBind("services/user/insert",
                "user_name="+$("#inputName").val()+
                "&tel="+$("#inputTel").val()+
                "&email="+$("#inputEmail").val()+
                "&senha="+$("#inputPassword").val()+
                "&aluno="+aluno, "POST",
                $createDelegate(this,this._insertSuccess),
                $createDelegate(this,this._erroInsert));
   
    },
    _insertSuccess: function(value){
       
        var data_user = JSON.parse(value);
        
        if (data_user.success) {
            
            $('#msg').html(
                "<div class='alert alert-primary' role='alert'>"+
                    "<strong>Info: </strong> Usuário incluído com sucesso."+
                    "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"+
                        "<span aria-hidden='true'>&times;</span>"+
                    "</button>"+
                "</div>"
            );
            this._limpacampos();
            var url_atual = window.location.href;
            window.location.href = url_atual + data_user.load;
        }else{
            $('#msg').html(
                "<div class='alert alert-warning' role='alert'>"+
                    "<strong>Atenção: </strong> E-mail já cadastrado, entre com outro endereço eletrônico."+
                    "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"+
                        "<span aria-hidden='true'>&times;</span>"+
                    "</button>"+
                "</div>"
            );
        };
    },    
    _erroInsert: function(){
        
        $('#msg').html(
            "<div class='alert alert-danger' role='alert'>"+
                "<strong>Falha: </strong>A inclusão foi cancelada inesperadamente."+
                "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"+
                    "<span aria-hidden='true'>&times;</span>"+
                "</button>"+
            "</div>"
        );
    },
    _atualiza: function(){
          
        var radios = document.getElementsByName("radioAluno");
        var aluno;
        
        for (var i = 0; i < radios.length; i++) {
            if (radios[i].value === "true") {
                if (radios[i].checked) {
                    aluno=radios[i].value;
                }
            }
        }
        
        this.executeBind("services/user/update",
                "id_user="+$("#idUser").val()+
                "&user_name="+$("#inputName").val()+
                "&tel="+$("#inputTel").val()+
                "&email="+$("#inputEmail").val()+
                "&senha="+$("#inputPassword").val()+
                "&aluno="+aluno, "POST",
                $createDelegate(this,this._atualizaSuccess),
                $createDelegate(this,this._erroatualiza));
   
    },
    _atualizaSuccess: function(value){
       
        var data_user = JSON.parse(value);
        
        $("#alterarCadastro").prop("checked", false);
        
        if (data_user.success) {
            
            $('#msg').html(
                "<div class='alert alert-primary' role='alert'>"+
                    "<strong>Info: </strong> Cadastro alterado com sucesso."+
                    "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"+
                        "<span aria-hidden='true'>&times;</span>"+
                    "</button>"+
                "</div>"
            );
            this._limpacampos();
            
            var url_atual = window.location.href;
            window.location.href = url_atual + data_user.load;
        }else{
            $('#msg').html(
                "<div class='alert alert-warning' role='alert'>"+
                    "<strong>Atenção: </strong> Não foi possível alterar o cadastro."+
                    "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"+
                        "<span aria-hidden='true'>&times;</span>"+
                    "</button>"+
                "</div>"
            );
        };
    },
    _erroatualiza: function(){
        
        $('#msg').html(
            "<div class='alert alert-danger' role='alert'>"+
                "<strong>Falha: </strong>A inclusão foi cancelada inesperadamente."+
                "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"+
                    "<span aria-hidden='true'>&times;</span>"+
                "</button>"+
            "</div>"
        );
    },
    _validaautentica: function(){
        
        var email_send = $("#emailLogin").val();
        var senha_send = $("#senhaLogin").val();
        
        this._limpacampos();
        
        if (email_send.length > 0 && senha_send.length > 0 ){

            this._autentica();
        }else{
            
            $('#msg').html(
                "<div class='alert alert-warning' role='alert'>"+
                    "<strong>Atenção: </strong> Preencha os campos e-mail e senha corretamente e tente novamente."+
                    "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"+
                        "<span aria-hidden='true'>&times;</span>"+
                    "</button>"+
                "</div>"
            );
        }
    },
    _autentica: function(){ 
            
        this.executeBind(
                "services/user/autentica/",
                "email="+$("#emailLogin").val()+"&senha="+$("#senhaLogin").val(),
                "post",
                $createDelegate(this,this._autenticaSuccess),
                $createDelegate(this,this._erroAutentica)
        );
    },
    _autenticaSuccess: function(value){
        
        var data_user = JSON.parse(value);
      
        if (data_user.success) {  

            this._limpapequeisa();

            if($("#alterarCadastro").is(":checked")){

                $("#btnCadastro").attr("value","Salvar..."); 
            
                $("#idUser").val(data_user.data[0].id_user);
                $("#inputName").val(data_user.data[0].user_name);
                $("#inputTel").val(data_user.data[0].telefone);
                $("#inputEmail").val(data_user.data[0].email);
                var aluno = data_user.data[0].aluno;

                var radios = document.getElementsByName("radioAluno");

                for (var i = 0; i < radios.length; i++) {

                    if(aluno === true){
                        if (radios[i].value === "true") {
                            radios[i].checked = true;
                        }
                    }else{
                        if (radios[i].value === "false") {
                            radios[i].checked = true;
                        }
                    }
                }

                $('#msg').html(
                    "<div class='alert alert-success' role='alert'>"+
                        "<strong>Seja bem-vindo: </strong> Usuário autorizado."+
                        "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"+
                            "<span aria-hidden='true'>&times;</span>"+
                        "</button>"+
                    "</div>"
                );
            }else{
                var url_atual = window.location.href;
                window.location.href = url_atual + data_user.load;
            }

        }else{
            $("#alterarCadastro").prop("checked", false);
            
            $('#msg').html(
                "<div class='alert alert-warning' role='alert'>"+
                    "<strong>Atenção: </strong> Usuário bloqueado ou não cadastrado."+
                    "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"+
                        "<span aria-hidden='true'>&times;</span>"+
                    "</button>"+
                "</div>"
            );
        }
    },    
    _erroautentica: function(value){
        
        $("#alterarCadastro").prop("checked", false);
        
        $('#msg').html(
            "<div class='alert alert-danger' role='alert'>"+
                "<strong>Falha: </strong>Erro ao autenticar usuário."+
                "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"+
                    "<span aria-hidden='true'>&times;</span>"+
                "</button>"+
            "</div>"
        );
    },
    _limpacampos: function(){
 
        $("#idUser").val("");
        $("#inputName").val("");
        $("#inputTel").val("");
        $("#inputEmail").val("");
        $("#inputPassword").val("");
        $("#inputPasswordTest").val("");
    },    
    _limpapequeisa:function(){
    
        $("#emailLogin").val("");
        $("#senhaLogin").val("");   
    }   
};

/* Para designar para as páginas 'aluno' e 'professor' a depender
// do chekbox selecionado no cadastro
$('#cadastrar').click(function() {
    event.preventDefault();

    if ($('#inlineRadio1').is(':checked'))
        window.location.href = "aluno.html";
    if ($('#inlineRadio2').is(':checked'))
        window.location.href = "professor.html";
});

// Ir para página inicial
$('#titulo').click(function() {
    window.location.href = "index.jpg";
});
*/


$(document).ready(function(){
       
    $("form").submit(function() {
                
        $(this).submit(function() {
            return false;
        });
        return true;
    });
    
    $("#btnLogin").click(function() {

        Cadastro.LoadLogin();
        return false;
    });
    
    $("#btnCadastro").click(function() {

        Cadastro.LoadCadastro(); 
       
        return false;
    });
    
    return false;
});



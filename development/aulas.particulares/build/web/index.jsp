<%-- 
    Document   : index
    Created on : 29/10/2017, 02:11:42
    Author     : Sergio Pereira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="br">
    <head>
        <title>Aulas Particulares</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <nav class="navbar fixed-top navbar-dark bg-primary">
            <h1 class="display-4" id="titulo">Aulas Particulares</h1>
            <form class="form-inline">
                <div class="input-group login">
                    <span class="input-group-addon" id="basic-addon1">@</span>
                    <input id="emailLogin" type="text" class="form-control" placeholder="E-mail" aria-label="Email" aria-describedby="basic-addon1">
                </div>
                <div class="input-group login">
                    <span class="input-group-addon" id="basic-addon1">**</span>
                    <input id="senhaLogin" type="text" class="form-control" placeholder="Senha" aria-label="Password" aria-describedby="basic-addon1">
                </div>
                <button id="btnLogin" class="btn btn-light login">
                    <span class="glyphicon glyphicon-send"></span>
                    Login
                </button>
                <span>'   '</span>
                <input type="checkbox" id="alterarCadastro" value="false" class="form-control">Alterar Cadstro</>
            </form>
        </nav>
        </br></br></br></br></br>
        <div class="container corpo">
            <div class="row">
                <div class="container">  
                    <div id='msg' class="form-group">
                    </div>
                </div>
                <div if="imagem" class="container col"> 
                    <img src="imgs/study-icon.png" class="img-fluid" alt="Responsive image">
                </div>
                <div class="col">
                    <form id="addUser">
                        <div class="form-group">
                            <label for="inputName">Nome</label>
                            <input id="inputName" type="text" class="form-control" placeholder="Nome completo">
                        </div>
                        <div class="form-group">
                            <label for="inputTel">Telefone</label>
                            <input id="inputTel" type="text" class="form-control" placeholder="Telefone">
                        </div>
                        <div class="form-group">
                            <label for="inputEmail">E-mail</label>
                            <input id="inputEmail" type="email" class="form-control" placeholder="Endereço de e-mail">
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Senha</label>
                            <input id="inputPassword" type="password" class="form-control"  placeholder="Crie uma senha">
                        </div>
                        <div class="form-group">
                            <label for="inputPasswordTest">Confirmação</label>
                            <input id="inputPasswordTest" type="password" class="form-control" placeholder="Repita a senha">
                        </div>
                        <div class="form-group">
                            <input id="idUser" type="text" class="form-control" placeholder="id user">
                        </div>

                        <div class="form-group">
                            <form>
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label">
                                        <input class="form-check-input" type="radio" name="radioAluno" value="true"> Aluno
                                    </label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label">
                                        <input class="form-check-input" type="radio" name="radioAluno" value="false"> Professor
                                    </label>
                                </div>
                            </form>
                        </div>
                        

                        <button id="btnCadastro" class="btn btn-primary cadastro">Cadastrar-se</button>
                    </form>
                </div>
            </div>
        </div>

        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/jquery.mask.min.js" type="text/javascript"></script>
        <script src="js/popper.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        
        <script src="js/jsutil.js" type="text/javascript"></script>
        <script src="js/cadastro.js" type="text/javascript"></script>
        
        <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script> -->
    </body>
</html>

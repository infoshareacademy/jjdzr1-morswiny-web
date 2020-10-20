<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create an account</title>
    <link rel="apple-touch-icon" sizes="180x180" href="./favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="./favicon/favicon-16x16.png">
    <link rel="manifest" href="./favicon/site.webmanifest">
    <link rel="mask-icon" href="./favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/log-in.css">
</head>
<body>
<#include "header.ftlh">
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <img class="profile-img"
                     src="../Images/morswin.png" height="130" width="130"
                     alt="">
                <form class="form-signin" name="userRegistrationForm" method="post" action="createAccount" accept-charset="UTF-8">
                    <div class="form-group">
                        <center><h2>Create an account</h2></center>
                    </div>
                    <#if success??>
                        <h3>Account was created successfully. Click <a href="/login">here</a> to log in.</h3>
                    <#elseif accountExist??>
                        <h5 style="color:red">There is account associated with this email. Try to log in</h5>
                    <#elseif error??>
                        <h5 style="color:red">There was an error during registration process!</h5>
                    </#if>
                    <div class="form-group">
                        <label class="control-label" for="signupName">First Name</label>
                        <input id="signupName" name="name" type="text" maxlength="50" class="form-control">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupName">Last Name</label>
                        <input id="signupSurname" name="surname" type="text" maxlength="50" class="form-control">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupEmail">Address E-mail</label>
                        <input id="signupEmail" name="email" type="email" maxlength="50" class="form-control">
                    </div>
                    <div></div>
                    <div class="form-group">
                        <label class="control-label" for="signupPassword">Password</label>
                        <input id="signupPassword" name="password" type="password" maxlength="25" class="form-control"
                               placeholder="at least 6 characters" length="40">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupPasswordagain">Password verify</label>
                        <input id="signupPasswordagain" type="password" maxlength="25" class="form-control"
                               placeholder="at least 6 characters" length="40">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="signupPasswordagain">Accept</label>
                        <div class="input-group"><span class="input-group-addon"><input type="checkbox">
                        </span><input id="check_critiria" name="check_critiria" class="form-control" type="text"
                                      placeholder="I accept the criteria" required=""></div>
                    </div>
                    <div>
                            <input type="submit" value="Submit" class="btn btn-lg btn-primary btn-block">
                    </div>
                    <br>
                    <p class="form-group">By creating an account, you agree to our <a href="#">Terms of Use</a> and our
                        <a href="#">Privacy Policy</a>.</p>
                    <hr>
                    <p>Already have an account? <a href="/login">Sign in</a></p>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create an account</title>
    <link rel="apple-touch-icon" sizes="180x180" href="/HTML/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/HTML/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/HTML/favicon/favicon-16x16.png">
    <link rel="manifest" href="/HTML/favicon/site.webmanifest">
    <link rel="mask-icon" href="/HTML/favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/HTML/log-in.css">
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/add-user">

    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <div class="account-wall">
                    <img class="profile-img"
                         src="/HTML/morswin.png" height="130" width="130"
                         alt="">
                    <form class="form-signin">
                        <div class="form-group">
                            <center><h2>Create an account</h2></center>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="signupName">First Name</label>
                            <input id="signupName" type="text" name="signupName" maxlength="50" class="form-control">
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="signupSurname">Last Name</label>
                            <input id="signupSurname" type="text" name="signupSurname" maxlength="50"
                                   class="form-control">
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="signupLogin">Login</label>
                            <input id="signupLogin" type="text" name="signupLogin" maxlength="50" class="form-control">
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="signupEmail">Address E-mail</label>
                            <input id="signupEmail" type="text" name="signupEmail" maxlength="50" class="form-control">
                        </div>
                        <div></div>
                        <div class="form-group">
                            <label class="control-label" for="signupPassword">Password</label>
                            <input id="signupPassword" type="password" name="signupPassword" maxlength="25"
                                   class="form-control"
                                   placeholder="at least 6 characters" length="40">
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="signupPasswordagain">Password verify</label>
                            <input id="signupPasswordagain" type="password" maxlength="25" class="form-control"
                                   placeholder="at least 6 characters" length="40">
                        </div>


                        <div class="form-group">
                            <label class="control-label" for="signupGender">Gender</label><br>
                            <select id="signupGender" name="signupGender" class="form-control">
                                <option value="MALE">Male</option>
                                <option value="FEMALE">Female</option>
                            </select>
                        </div>


                        <div class="form-group">
                            <label class="control-label" for="country">Select your Country</label>
                            <select id="country" name="country" class="form-control">
                                <option value="Poland">Poland</option>
                                <option value="USA">USA</option>
                                <option value="UK">UK</option>
                                <option value="Germany">Germany</option>
                                <option value="France">France</option>
                            </select></div>

                        <div class="form-group">
                            <label class="control-label" for="signUserType">USER TYPE</label><br>
                            <select id="signUserType" name="signUserType" class="form-control">
                                <option value="ADMIN">ADMIN</option>
                                <option value="STANDARD_USER">STANDARD_USER</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label class="form-group" for="signupPasswordagain">Upload your profile picture</label>
                            <label for="exampleFormControlFile1"></label>
                            <input type="file" class="form-control-file" id="exampleFormControlFile1">
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="signupBirthday">Birthday</label>
                            <input id="signupBirthday" type="text" name="signupBirthday" maxlength="10"
                                   class="form-control">
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="signupPasswordagain">Accept</label>
                            <div class="input-group"><span class="input-group-addon"><input type="checkbox">
                        </span><input id="check_criteria" name="check_criteria" class="form-control" type="text"
                                      placeholder="I accept the criteria" required=""></div>
                        </div>
                        <div>
                            <a href="thank-you.html">
                                <button class="btn btn-lg btn-primary btn-block" type="submit">
                                    Register
                                </button>
                            </a></div>
                        <br>
                        <p class="form-group">By creating an account, you agree to our <a href="#">Terms of Use</a> and
                            our
                            <a href="#">Privacy Policy</a>.</p>
                        <hr>
                        <p>Already have an account? <a href="log-in.html">Sign in</a></p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
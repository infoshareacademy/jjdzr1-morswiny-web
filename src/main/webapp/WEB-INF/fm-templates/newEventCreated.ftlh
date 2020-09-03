<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Event </title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/log-in.css">
</head>
<body>
<#setting number_format="00000">
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall" style="text-align:center">
                <img class="profile-img"
                     src="/Images/morswin.png"  height="130" width="130"
                     alt="">
                        <h2> Thank you.</h2>
                        <p> New event has been created successfully.</p>
<#--                    <a href="/edit-event?id=${event.getId()}">Edit new event</a>-->
                    <br>
                    <div>
                        <p>Go back to the <a href="/event-list"> all events.</a></p>
                        <p>Go back to the <a href="main.html">main page</a>.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
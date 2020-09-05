<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Event </title><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker-standalone.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
<#setting number_format="00000">
<#--<#include "header.ftlh">-->
<div>
    <ol class="breadcrumb primary-color">
        <li class="breadcrumb-item"><a class="white-text" href="/HTML/main.html">Home</a></li>
        <li class="breadcrumb-item breadcrumb-active">New Event Created</li>
    </ol>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall" style="text-align:center">
                <img class="profile-img"
                     src="/Images/morswin.png"  height="130" width="130"
                     alt="">
                        <center><h2> Thank you </h2></center>
                        <center><p> New event has been created successfully.</p></center>
<#--                    <a href="/edit-event?id=${event.getId()}">Edit new event</a>-->
                    <br>
                    <div>
                        <p>Go back to <a href="/event-list"> all events.</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
<#--<#include "footer.ftlh">-->
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Event</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <img class="profile-img"
                     src="/Images/morswin.png" height="130" width="130"
                     alt="">
                <form class="form-create" action="/edit-event" method="POST">
                    <div class="form-group">
                        <center><h2>Edit Event</h2></center>
                    </div>
                    <div class="form-group">
                        <label class="control-label requiredField" for="eventName">Name</label>
                        <input id="eventName" type="text" maxlength="100" class="form-control" contenteditable="true" value="${event.getName()}" required/>
                    </div>
                    <div class="form-group">
                        <label class="control-label requiredField" for="eventPlace">Place</label>
                        <input id="eventPlace" type="text" maxlength="100" class="form-control" contenteditable="true" value="${event.getPlace().getName()}" required/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="organizer">Organizer</label>
                        <input id="organizer" type="text" maxlength="100" class="form-control" contenteditable="true" value="${event.getOrganizer().getDesignation()}" required/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="eventURL">URL</label>
                        <input id="eventURL" type="text" maxlength="100" class="form-control" contenteditable="true" value="${event.getUrls().getWww()}" required/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="startDate">Start Date</label>
                        <div class='input-group date' id='startDate'>
                            <input type='text' class="form-control" contenteditable="true" value=${event.getStartDate()} required/>
                            <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            <script type="text/javascript">
                                $(function () {
                                    $('#startDate').datetimepicker({
                                        format: 'DD MMMM YYYY H:mm'
                                    })
                                });
                            </script>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="endDate">End Date</label>
                        <div class='input-group date' id='endDate'>
                            <input type='text' class="form-control" contenteditable="true" value=${event.getEndDate()} required/>
                            <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            <script type="text/javascript">
                                $(function () {
                                    $('#endDate').datetimepicker ({
                                        format: 'DD MMMM YYYY H:mm'
                                    })
                                });
                            </script>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="description">Description</label>
                        <textarea id="description" cols="20" rows="10" class="form-control" required>${event.getDescLong()}</textarea>
                    </div>
<#--                    <div class="form-group">-->
<#--                        <label class="form-group" for="attachment">Attach event image</label>-->
<#--                        <label for="attachment"></label>-->
<#--                        <input type="file" class="form-control-file" id="attachment">-->
<#--                    </div>-->
                    <div>
                        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Apply"/>
                        <input class="btn btn-sm btn-secondary btn-block" type="reset" value="Reset"/>
                    </div>
                    <br>
                    <p class="form-group">By creating an event, you agree to our <a href="#">Terms of Use</a> and our
                        <a href="#">Privacy Policy</a>.</p>

                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
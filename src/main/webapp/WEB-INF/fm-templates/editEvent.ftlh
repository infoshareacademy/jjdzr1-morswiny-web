<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create new Event</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker-standalone.css">
    <link rel="stylesheet" type="text/css" href="../css/custom.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <img class="profile-img"
                     src="morswin.png" height="130" width="130"
                     alt="">
                <form class="form-create" action="/add-event" method="POST">
                    <div class="form-group">
                        <center><h2>Create new Event</h2></center>
                    </div>
                    <div class="form-group">
                        <label class="control-label requiredField" for="eventName">Name</label>
                        <input id="eventName" type="text" maxlength="100" class="form-control" value="<#if event.getName()?has_content>${event.getName()}</#if>">
                    </div>
                    <div class="form-group">
                        <label class="control-label requiredField" for="eventPlace">Place</label>
                        <input id="eventPlace" type="text" maxlength="100" class="form-control" value="<#if event.getPlace().getName?has_content>${event.getPlace().getName()}</#if>">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="organizer">Organizer</label>
                        <input id="organizer" type="text" maxlength="50" class="form-control" value="<#if event.getOrganizer().getDesignation?has_content>${event.getOrganizer().getDesignation()}</#if>">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="eventURL">URL</label>
                        <input id="eventURL" type="text" maxlength="50" class="form-control" value="<#if event.getEventURL().getWww()?has_content>${event.getEventURL().getWww()}</#if>">
                    </div>
                    <div class="form-group">
                        <label class="control-label requiredField" for="startDate">Start Date</label>
                        <div class='input-group date' id='startDate'>
                            <input type='text' class="form-control" value="<#if event.getStartDateLDT?has_content>${event.getStartDateLDT()}</#if>">
                            <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            <script type="text/javascript">
                                $(function () {
                                    $('#startDate').datetimepicker({
                                        format: 'DD MMMM YYYY hh:mm'
                                    })
                                });
                            </script>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label requiredField" for="endDate">End Date</label>
                        <div class='input-group date' id='endDate' value="<#if event.getEndDateLDT?has_content>${event.getEndDateLDT()}</#if>">
                            <input type='text' class="form-control" />
                            <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            <script type="text/javascript">
                                $(function () {
                                    $('#endDate').datetimepicker({
                                        format: 'DD MMMM YYYY hh:mm'
                                    })
                                });
                            </script>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="description">Description</label>
                        <textarea id="description" cols="20" rows="10" class="form-control" value="<#if event.getDescLong()?has_content>${event.getDescLong()}</#if>">></textarea>
                    </div>
<#--                    <div class="form-group">-->
<#--                        <label class="form-group" for="attachment">Attach event image</label>-->
<#--                        <label for="attachment"></label>-->
<#--                        <input type="file" class="form-control-file" id="attachment">-->
<#--                    </div>-->
                    <div>
                        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Create">
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
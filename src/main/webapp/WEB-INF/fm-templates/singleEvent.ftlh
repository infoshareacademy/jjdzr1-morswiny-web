<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
    <title>${event.getName()}</title>
    <link rel="apple-touch-icon" sizes="180x180" href="/./Images/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/./Images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/./Images/favicon/favicon-16x16.png">
    <link rel="manifest" href="/./Images/favicon/site.webmanifest">
    <link rel="mask-icon" href="/./Images/favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="media">
        <a href="/main-page"><img src="Images/morswin.png" height="80" width="80" class="mr-3" alt="..."></a>
    </div>
    <a class="navbar-brand" href="#"><b>Morświny Events</b></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
             aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Events <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="log-in.html">My Account</a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Filter
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="my-profile.html">Filter by Date</a>
                    <a class="dropdown-item" href="my-profile.html">Filter by Place</a>
                    <a class="dropdown-item" href="my-profile.html">Filter by Ticket Price</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contact</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="abous-us.html">About Us</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action ="/search-event?search=">
            <input class="form-control mr-sm-2" type="search" placeholder="Type here..." aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <div>
            <a href="/HTML/log-in.html"><button type="button" style = "position:relative; right:-5px;" class="btn btn-outline-primary">Log in</button>
            </a>
        </div>

    </div>
</nav>

<div>
    <ol class="breadcrumb primary-color bold-text">
        <li class="breadcrumb-item white-text"><a href="/main-page">Home</a></li>
        <li class="breadcrumb-item white-text"><a href="/search-events?search=">All events</a></li>
        <li class="breadcrumb-item breadcrumb-active white-text">${event.getName()}</li>
    </ol>
</div>
<div class="container">
    <div class="row event-info">
        <div class="col-4 thumbnail picture-singleevent">
            <picture>
                <#if picture??>
                    <source srcset="${picture}">
                </#if>
                <img src="Images/morswin.png" alt="Morświn events" class="rounded picture-singleevent" />
            </picture>
        </div>
            <div class="col-8">
                <h3 class="bold-text">${event.getName()}</h3>
                <h4>Place: ${event.getPlace().getName()}</h4>
                <#if event.getPlace().getSubname()??>
                    <h4>${event.getPlace().getSubname()}</h4>
                </#if>
                <h4>Start: ${event.getStartDate()}</h4>
                <h4>End: ${event.getEndDate()}</h4>
                <h6>Organised by: ${event.getOrganizer().getDesignation()}</h6>
            </div>
        </div>
    <div class="row">
        <div class="col">
            <p class="p-singleevent">${event.getDescLong()}</p>
        </div>
    </div>
        <div class="row d-flex justify-content-center buttons-for-event">
            <#if tickets??>
                <a href="${tickets}" class="button-singleevent" role="button">Tickets and more information</a>
            <#else>
                <button class="button-singleevent" type="button" disabled>Tickets and more information</button>
            </#if>
            <a href="/single-event?id=#{event.getId()}&addEvent=#{event.getId()}" class="button-singleevent" role="button">Add event to favourites</a>
            <a href="/edit-event?id=${event.getId()}" class="button-singleevent" role="button"> Edit event </a>
            <a href="/delete-event?id=${event.getId()}" class="button-singleevent" role="button"> Delete event </a>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</html>